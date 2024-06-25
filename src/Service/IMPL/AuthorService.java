package Service.IMPL;

import Model.AuthorDTO;
import Repository.IAuthorRepository;
import Repository.entity.AuthorEntity;
import Service.IAuthorService;
import java.util.ArrayList;
import java.util.List;

public class AuthorService implements IAuthorService {
    private static AuthorService authorService;
    private static IAuthorRepository authorRepository;
    private AuthorService() {}

    public static AuthorService getAuthorService(IAuthorRepository authorRepo) {
        if(authorService == null) {
            authorRepository = authorRepo;
            authorService = new AuthorService();
        }
        return authorService;
    }

    @Override
    public List<String> findNameByBookId(Long id) {
        return authorRepository.findNameByBookId(id);
    }

    @Override
    public List<Long> findIdByNames(String[] name) {
        List<Long> result = new ArrayList<>();
        for (String s : name) {
            AuthorEntity authorEntity = authorRepository.findByName(s);
            if (authorEntity != null) {
                result.add(authorEntity.getId());
            } else {
                result.add(null);
            }
        }
        return result;
    }

    @Override
    public Long add(AuthorDTO authorDTO) {
        List<AuthorEntity> list = authorRepository.findAll();
        AuthorEntity authorEntity = new AuthorEntity();
        authorEntity.setName(authorDTO.getName());
        authorEntity.setPenName(authorDTO.getPenName());
        Long id = list.get(list.size() - 1).getId() + 1;
        authorEntity.setId(list.get(list.size() - 1).getId() + 1);
        authorRepository.add(authorEntity);
        return id;
    }
}
