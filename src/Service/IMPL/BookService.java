package Service.IMPL;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Model.AuthorDTO;
import Model.BookDTO;
import Model.PublicationDTO;
import Model.TypeDTO;
import Repository.IBookRepository;
import Repository.entity.BookEntity;
import Service.IAuthorService;
import Service.IBookService;
import Service.IPublicationService;
import Service.ITypeService;
import Utils.GetAuthorsPenName;

public class BookService implements IBookService {
    private static IBookRepository bookRepository;
    private static ITypeService typeService;
    private static IAuthorService authorService;
    private static IPublicationService publicationService;
    private static BookService bookService;
    public static BookService getBookService(IBookRepository bookRepo, ITypeService typeSer, IAuthorService authorSer, IPublicationService publicationSer) {
        bookRepository = bookRepo;
        typeService = typeSer;
        authorService = authorSer;
        publicationService = publicationSer;
        if(bookService == null) bookService = new BookService();
        return bookService;
    }
    private BookService() {

    }

    @Override
    public List<BookDTO> findAll() {
        List<BookEntity> bookEntityList = bookRepository.findAll();
        List<BookDTO> result = new ArrayList<>();
        for(BookEntity bookEntity : bookEntityList) {
            BookDTO bookDTO = new BookDTO();
            bookDTO.setId(bookEntity.getId());
            bookDTO.setName(bookEntity.getName());
            bookDTO.setPrice(bookEntity.getPrice());
            bookDTO.setPublicationYear(bookEntity.getPublicationYear());
            bookDTO.setReprint(bookEntity.getReprint());
            bookDTO.setStock(bookEntity.getStock());
            bookDTO.setType(typeService.findById(bookEntity.getTypeId()).getName());
            String authorName = String.join(", ", authorService.findNameByBookId(bookEntity.getId()));
            bookDTO.setAuthorName(authorName);
            result.add(bookDTO);
        }
        return result;
    }

    @Override
    public void add(BookDTO bookDTO) {
        List<BookDTO> list = findAll();
        BookEntity bookEntity = new BookEntity();
        bookEntity.setId(list.get(list.size() - 1).getId() + 1);
        bookEntity.setPrice(bookDTO.getPrice());
        bookEntity.setPublicationYear(bookDTO.getPublicationYear());
        bookEntity.setStock(bookDTO.getStock());
        bookEntity.setReprint(bookDTO.getReprint());
        bookEntity.setName(bookDTO.getName());
        String type = bookDTO.getType();
        TypeDTO typeDTO = typeService.findByName(type);
        if(typeDTO != null) {
            bookEntity.setTypeId(typeDTO.getId());
        } else {
            TypeDTO newType = new TypeDTO();
            newType.setName(type);
            Long id = typeService.add(newType);
            bookEntity.setTypeId(id);
        }
        String[] authors = bookDTO.getAuthorName().split(",");
        List<Long> ids = authorService.findIdByNames(authors);
        for(int i = 0; i < ids.size(); i++) {
            Long id = ids.get(i);
            if(id == null) {
                // Chưa có tác giả có tên này nên cần thêm
                AuthorDTO authorDTO = new AuthorDTO();
                authorDTO.setName(authors[i]);
                authorDTO.setPenName(GetAuthorsPenName.getAuthorPenName(authors[i]));
                id = authorService.add(authorDTO);
            }
            PublicationDTO publicationDTO = new PublicationDTO();
            publicationDTO.setBookId(bookEntity.getId());
            publicationDTO.setAuthorId(id);
            publicationDTO.setDatePublication(new Date().toString());
            publicationService.add(publicationDTO);
        }
        bookRepository.add(bookEntity);
    }

    @Override
    public void update(BookDTO bookDTO) {
        
    }

    @Override
    public void delete(Long id) {
        
    }

}
