package Repository.mapper;

import Repository.entity.TypeEntity;

import java.util.StringTokenizer;

public class TypeMapper implements IRowMapper<TypeEntity> {
    @Override
    public TypeEntity Mapper(String data) {
        TypeEntity typeEntity = new TypeEntity();
        StringTokenizer st = new StringTokenizer(data, ",");
        typeEntity.setId(Long.parseLong(st.nextToken().trim()));
        typeEntity.setName(st.nextToken().trim());
        typeEntity.setCode(st.nextToken().trim());
        return typeEntity;
    }

    @Override
    public String writeToFile(TypeEntity typeEntity) {
        return typeEntity.getId() + ", " + typeEntity.getName() + ", " + typeEntity.getCode();
    }

    @Override
    public Boolean equal(TypeEntity t1, TypeEntity t2) {
        return t1.getId() == t2.getId();
    }
}
