package Service.IMPL;

import Model.PublicationDTO;
import Repository.IPublicationRepository;
import Repository.entity.PublicationEntity;
import Service.IPublicationService;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class PublicationService implements IPublicationService {
    private static PublicationService publicationService;
    private static IPublicationRepository publicationRepository;
    private PublicationService() {

    }
    public static PublicationService getPublicationService(IPublicationRepository publicationRepo) {
        if(publicationService == null) {
            publicationRepository = publicationRepo;
            publicationService = new PublicationService();
        }
        return publicationService;
    }
    @Override
    public Long add(PublicationDTO publicationDTO) {
        PublicationEntity publicationEntity = new PublicationEntity();
        publicationEntity.setBookId(publicationDTO.getBookId());
        publicationEntity.setAuthorId(publicationDTO.getAuthorId());
        publicationEntity.setPublicationDate(publicationDTO.getDatePublication());
        List<PublicationEntity> list = publicationRepository.findAll();
        Long id = list.get(list.size() - 1).getId() + 1;
        publicationEntity.setId(id);
        publicationRepository.add(publicationEntity);
        return id;
    }

    @Override
    public List<Long> findByBookId(Long id) {
        return publicationRepository.findAll().stream()
                                                .filter(item -> Objects.equals(item.getBookId(), id))
                                                .map(PublicationEntity::getAuthorId)
                                                .collect(Collectors.toList());
    }

    @Override
    public void DeleteByBookId(Long id) {
        // Lấy các thực thể
        List<PublicationEntity> list = publicationRepository.findByBookId(id);

        // Xoá các thực thể
        for(PublicationEntity publicationEntity : list) {
            publicationRepository.Delete(publicationEntity);
        }
    }


}
