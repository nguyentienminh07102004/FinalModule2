package Repository.IMPL;

import Repository.IAuthorRepository;
import Repository.IPublicationRepository;
import Repository.entity.AuthorEntity;
import Repository.entity.PublicationEntity;
import Repository.mapper.AuthorMapper;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class AuthorRepository extends AbstractRepository<AuthorEntity> implements IAuthorRepository {
    private static AuthorRepository authorRepository;
    private static IPublicationRepository publicationRepository;
    private AuthorRepository() {

    }
    public static AuthorRepository getAuthorRepository(IPublicationRepository publicationRepo) {
        if(authorRepository == null) {
            publicationRepository = publicationRepo;
            authorRepository = new AuthorRepository();
        }
        return authorRepository;
    }
    private final String source = "src\\Data\\Author.csv";

    @Override
    public List<AuthorEntity> findAll() {
        return query(source, new AuthorMapper());
    }

    @Override
    public List<String> findNameByBookId(Long id) {
        List<AuthorEntity> list = query(source, new AuthorMapper());
        List<PublicationEntity> publicationEntityList = publicationRepository.findByBookId(id);
        List<Long> authorIdList = publicationEntityList.stream()
                                .filter(item -> Objects.equals(item.getBookId(), id))
                                .map(PublicationEntity::getAuthorId)
                                .collect(Collectors.toList());
        return list.stream()
                    .filter(item -> authorIdList.contains(item.getId()))
                    .map(AuthorEntity::getName)
                    .collect(Collectors.toList());
    }

    @Override
    public AuthorEntity findByName(String name) {
        List<AuthorEntity> list = query(source, new AuthorMapper());
        List<AuthorEntity> result = list.stream().filter(item -> item.getName().trim().equalsIgnoreCase(name)).collect(Collectors.toList());
        if(!result.isEmpty()) {
            return result.get(0);
        }
        return null;
    }

    @Override
    public void add(AuthorEntity authorEntity) {
        insert(source, new AuthorMapper(), authorEntity);
    }
}
