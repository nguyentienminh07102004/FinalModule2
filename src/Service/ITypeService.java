package Service;

import Model.TypeDTO;

import java.util.List;

public interface ITypeService {
    Long add(TypeDTO typeDTO);
    TypeDTO findById(Long id);
    TypeDTO findByName(String name);
    List<TypeDTO> findAll();
}
