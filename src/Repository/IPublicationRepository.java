package Repository;

import Repository.entity.PublicationEntity;

import java.util.List;

public interface IPublicationRepository {
    PublicationEntity findByAuthorId(Long id);
    List<PublicationEntity> findByBookId(Long id);
    void add(PublicationEntity publicationEntity);
    List<PublicationEntity> findAll();
    void Delete(PublicationEntity publicationEntity);
}
