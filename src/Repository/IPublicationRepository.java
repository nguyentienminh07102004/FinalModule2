package Repository;

import Repository.entity.PublicationEntity;

import java.util.List;

public interface IPublicationRepository {
    List<PublicationEntity> findByAuthorId(Long id);
    List<PublicationEntity> findByBookId(Long id);
    void add(PublicationEntity publicationEntity);
    List<PublicationEntity> findAll();
}
