package Repository;

import Repository.entity.TypeEntity;

import java.util.List;

public interface ITypeRepository {
    TypeEntity findById(Long id);
    TypeEntity findByName(String name);
    void add(TypeEntity typeEntity);
    List<TypeEntity> findAll();
}
