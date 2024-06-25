package Repository;

import Repository.entity.AuthorEntity;

import java.util.List;

public interface IAuthorRepository {
    List<AuthorEntity> findAll();
    List<String> findNameByBookId(Long id);
    AuthorEntity findByName(String name);
    void add(AuthorEntity authorEntity);
}
