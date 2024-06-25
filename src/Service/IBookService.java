package Service;

import java.util.List;

import Model.BookDTO;

public interface IBookService {
    List<BookDTO> findAll();
    void add(BookDTO bookDTO);
    void update(BookDTO bookDTO);
    void delete(Long id);
}
