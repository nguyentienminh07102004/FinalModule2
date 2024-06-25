package Repository.mapper;

import Repository.entity.PublicationEntity;

import java.util.Objects;
import java.util.StringTokenizer;

public class PublicationMapper implements IRowMapper<PublicationEntity> {

    @Override
    public PublicationEntity Mapper(String data) {
        StringTokenizer st = new StringTokenizer(data, ",");
        PublicationEntity publicationEntity = new PublicationEntity();
        publicationEntity.setId(Long.parseLong(st.nextToken().trim()));
        publicationEntity.setAuthorId(Long.parseLong(st.nextToken().trim()));
        publicationEntity.setBookId(Long.parseLong(st.nextToken().trim()));
        publicationEntity.setPublicationDate(st.nextToken().trim());
        return publicationEntity;
    }

    @Override
    public String writeToFile(PublicationEntity publicationEntity) {
        return publicationEntity.getId() + ", " + publicationEntity.getAuthorId() + ", "
                + publicationEntity.getBookId() + ", " + publicationEntity.getPublicationDate();
    }

    @Override
    public Boolean equal(PublicationEntity t1, PublicationEntity t2) {
        return t1.getId() == t1.getId();
    }
}