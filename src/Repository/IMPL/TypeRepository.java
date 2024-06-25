package Repository.IMPL;

import Repository.ITypeRepository;
import Repository.entity.TypeEntity;
import Repository.mapper.TypeMapper;

import java.util.List;

public class TypeRepository extends AbstractRepository<TypeEntity> implements ITypeRepository {
    private final String source = "src\\Data\\TypeData.csv";
    private static TypeRepository typeRepository;
    private TypeRepository(){}
    public static TypeRepository getTypeRepository() {
        if(typeRepository == null) typeRepository = new TypeRepository();
        return typeRepository;
    }
    @Override
    public TypeEntity findById(Long id) {
        List<TypeEntity> list = query(source, new TypeMapper());
        if(list != null) return list.get(0);
        return null;
    }

    @Override
    public TypeEntity findByName(String name) {
        List<TypeEntity> list = query(source, new TypeMapper());
        if(list != null && !list.isEmpty()) return list.get(0);
        return null;
    }

    @Override
    public void add(TypeEntity typeEntity) {
        insert(source, new TypeMapper(), typeEntity);
    }

    @Override
    public List<TypeEntity> findAll() {
        return query(source, new TypeMapper());
    }
}
