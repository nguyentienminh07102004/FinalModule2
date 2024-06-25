package Repository.mapper;

import Repository.entity.AuthorEntity;

import java.util.StringTokenizer;

public class AuthorMapper implements IRowMapper<AuthorEntity> {
    @Override
    public AuthorEntity Mapper(String data) {
        AuthorEntity authorEntity = new AuthorEntity();
        StringTokenizer st = new StringTokenizer(data, ",");
        authorEntity.setId(Long.parseLong(st.nextToken()));
        authorEntity.setName(st.nextToken());
        authorEntity.setPenName(st.nextToken());
        return authorEntity;
    }

    @Override
    public String writeToFile(AuthorEntity authorEntity) {
        return authorEntity.getId() + ", " + authorEntity.getName() + ", " + authorEntity.getPenName();
    }

    @Override
    public Boolean equal(AuthorEntity t1, AuthorEntity t2) {
        return t1.getId() == t2.getId();
    }
}
