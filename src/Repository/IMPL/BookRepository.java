package Repository.IMPL;

import java.util.List;

import Repository.IBookRepository;
import Repository.entity.BookEntity;
import Repository.mapper.BookMapper;

public class BookRepository extends AbstractRepository<BookEntity> implements IBookRepository {
    private static BookRepository bookRepository;
    private final String source = "src\\Data\\BookData.csv";
    private BookRepository() {

    }
    public static BookRepository getBookRepository() {
        if(bookRepository == null) {
            bookRepository = new BookRepository();
        }
        return bookRepository;
    }
    @Override
    public List<BookEntity> findAll() {
        return query(source, new BookMapper());
    }

    @Override
    public void add(BookEntity bookEntity) {
        insert(source, new BookMapper(), bookEntity);
    }

    @Override
    public void Update(BookEntity bookEntity) {
        update(source, new BookMapper(), bookEntity);
    }

    @Override
    public void Delete(BookEntity bookEntity) {
        delete(source, new BookMapper(), bookEntity);
    }

}
