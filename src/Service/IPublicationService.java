package Service;

import Model.PublicationDTO;

import java.util.List;

public interface IPublicationService {
    Long add(PublicationDTO publicationDTO);
    List<Long> findByBookId(Long id);
    void DeleteByBookId(Long id);
}
