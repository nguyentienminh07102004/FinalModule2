package Repository.IMPL;

import Repository.IPublicationRepository;
import Repository.entity.PublicationEntity;
import Repository.mapper.PublicationMapper;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class PublicationRepository extends AbstractRepository<PublicationEntity> implements IPublicationRepository {
    private static PublicationRepository publicationRepository;

    private PublicationRepository() {

    }

    public static PublicationRepository getPublicationRepository() {
        if(publicationRepository == null) publicationRepository = new PublicationRepository();
        return publicationRepository;
    }

    private final String source = "src\\Data\\Publication.csv";
    @Override
    public List<PublicationEntity> findByAuthorId(Long id) {
        List<PublicationEntity> list = query(source, new PublicationMapper());
        return list.stream().filter(item -> Objects.equals(item.getAuthorId(), id)).collect(Collectors.toList());
    }

    @Override
    public List<PublicationEntity> findByBookId(Long id) {
        List<PublicationEntity> list = query(source, new PublicationMapper());
        return list.stream().filter(item -> Objects.equals(item.getBookId(), id)).collect(Collectors.toList());
    }

    @Override
    public void add(PublicationEntity publicationEntity) {
        insert(source, new PublicationMapper(), publicationEntity);
    }

    @Override
    public List<PublicationEntity> findAll() {
        return query(source, new PublicationMapper());
    }
}
