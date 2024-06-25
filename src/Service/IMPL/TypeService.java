package Service.IMPL;

import Model.TypeDTO;
import Repository.ITypeRepository;
import Repository.entity.TypeEntity;
import Service.ITypeService;

import java.util.ArrayList;
import java.util.List;

public class TypeService implements ITypeService {
    private static TypeService typeService;
    private static ITypeRepository typeRepository;
    public static TypeService getTypeService(ITypeRepository typeRepo) {
        if(typeService == null) {
            typeRepository = typeRepo;
            typeService = new TypeService();
        }
        return typeService;
    }
    private TypeService() {
    }
    @Override
    public Long add(TypeDTO typeDTO) {
        List<TypeEntity> list = typeRepository.findAll();
        Long id = list.get(list.size() - 1).getId() + 1;
        TypeEntity typeEntity = new TypeEntity();
        typeEntity.setId(id);
        typeEntity.setName(typeDTO.getName());
        String code = String.join("-", typeDTO.getName().split("\\s+"));
        typeEntity.setCode(code);
        typeRepository.add(typeEntity);
        return id;
    }

    @Override
    public TypeDTO findById(Long id) {
        TypeDTO typeDTO = new TypeDTO();
        TypeEntity typeEntity = typeRepository.findById(id);
        typeDTO.setId(typeEntity.getId());
        typeDTO.setName(typeEntity.getName());
        return typeDTO;
    }

    @Override
    public TypeDTO findByName(String name) {
        TypeDTO typeDTO = new TypeDTO();
        TypeEntity typeEntity = typeRepository.findByName(name);
        typeDTO.setId(typeEntity.getId());
        typeDTO.setName(typeEntity.getName());
        return typeDTO;
    }

    @Override
    public List<TypeDTO> findAll() {
        List<TypeEntity> list = typeRepository.findAll();
        List<TypeDTO> result = new ArrayList<>();
        for(TypeEntity typeEntity : list) {
            TypeDTO typeDTO = new TypeDTO();
            typeDTO.setId(typeEntity.getId());
            typeDTO.setName(typeEntity.getName());
            result.add(typeDTO);
        }
        return result;
    }
}
