package Repository;

import java.util.List;

import Repository.entity.BookEntity;

public interface IBookRepository {
    List<BookEntity> findAll();
    void add(BookEntity bookEntity);
    void Update(BookEntity bookEntity);
    void Delete(BookEntity bookEntity);
}
