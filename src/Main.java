import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Model.BookDTO;
import Repository.IMPL.AuthorRepository;
import Repository.IMPL.BookRepository;
import Repository.IMPL.PublicationRepository;
import Repository.IMPL.TypeRepository;
import Service.IMPL.AuthorService;
import Service.IMPL.BookService;
import Service.IMPL.PublicationService;
import Service.IMPL.TypeService;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BookService bookService = BookService.getBookService(BookRepository.getBookRepository(), TypeService.getTypeService(TypeRepository.getTypeRepository()),
                AuthorService.getAuthorService(AuthorRepository.getAuthorRepository(PublicationRepository.getPublicationRepository())), PublicationService.getPublicationService(PublicationRepository.getPublicationRepository()));
        int choise = 10;
        do {
            System.out.println("1. Hiển thị tất cả quyển sách");
            System.out.println("2. Thêm sách");
            System.out.println("3. Sửa sách");
            System.out.println("4. Xoá sách");
            System.out.println("0. Thoát");
            choise = Integer.parseInt(sc.nextLine());
            if(choise == 1) {
                List<BookDTO> list = bookService.findAll();
                for(BookDTO bookDTO : list) {
                    System.out.println(bookDTO.toString());
                }
            } else if(choise == 2) {
                BookDTO bookDTO = new BookDTO();;
                System.out.println("Nhập vào tên sách: ");
                String name = sc.nextLine();
                bookDTO.setName(name);
                System.out.println("Nhập vào năm xuất bản: ");
                Integer publicationYear = Integer.parseInt(sc.nextLine());
                bookDTO.setPublicationYear(publicationYear);
                System.out.println("Nhập vào số lượng tác giả: ");
                int numberOfAuthor = Integer.parseInt(sc.nextLine());
                List<String> authorNames = new ArrayList<>();
                for(int i = 0; i < numberOfAuthor; i++) {
                    String authorName = sc.nextLine();
                    authorNames.add(authorName);
                }
                String author = String.join(",", authorNames);
                bookDTO.setAuthorName(author);
                System.out.println("Nhập loại sách: ");
                String type = sc.nextLine();
                bookDTO.setType(type);
                System.out.println("Nhập số lượng sách: ");
                Integer stock = Integer.parseInt(sc.nextLine());
                bookDTO.setStock(stock);
                System.out.println("Nhập giá sách: ");
                Double price = Double.parseDouble(sc.nextLine());
                bookDTO.setPrice(price);
                System.out.println("Nhập số tái bản: ");
                Integer reprint = Integer.parseInt(sc.nextLine());
                bookDTO.setReprint(reprint);
                bookService.add(bookDTO);
            } else if(choise == 3) {
                BookDTO bookDTO = new BookDTO();
                System.out.println("Nhập id sách cần sửa: ");
                Long id = Long.parseLong(sc.nextLine());
                bookDTO.setId(id);
                System.out.println("Nhập vào tên sách: ");
                String name = sc.nextLine();
                bookDTO.setName(name);
                System.out.println("Nhập vào năm xuất bản: ");
                Integer publicationYear = Integer.parseInt(sc.nextLine());
                bookDTO.setPublicationYear(publicationYear);
                System.out.println("Nhập vào số lượng tác giả: ");
                int numberOfAuthor = Integer.parseInt(sc.nextLine());
                List<String> authorNames = new ArrayList<>();
                for(int i = 0; i < numberOfAuthor; i++) {
                    String authorName = sc.nextLine();
                    authorNames.add(authorName);
                }
                String author = String.join(",", authorNames);
                bookDTO.setAuthorName(author);
                System.out.println("Nhập loại sách: ");
                String type = sc.nextLine();
                bookDTO.setType(type);
                System.out.println("Nhập số lượng sách: ");
                Integer stock = Integer.parseInt(sc.nextLine());
                bookDTO.setStock(stock);
                System.out.println("Nhập giá sách: ");
                Double price = Double.parseDouble(sc.nextLine());
                bookDTO.setPrice(price);
                System.out.println("Nhập số tái bản: ");
                Integer reprint = Integer.parseInt(sc.nextLine());
                bookDTO.setReprint(reprint);
                bookService.update(bookDTO);
            } else if(choise == 4) {
                Long id = Long.parseLong(sc.nextLine());
                bookService.delete(id);
            }
        } while(choise > 0);
        sc.close();
    }
}