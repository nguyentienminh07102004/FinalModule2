package Service;

import Model.AuthorDTO;

import java.util.List;

public interface IAuthorService {
    List<String> findNameByBookId(Long id);
    List<Long> findIdByNames(String[] name);
    Long add(AuthorDTO authorDTO);
}
