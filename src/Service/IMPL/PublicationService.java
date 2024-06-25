package Service.IMPL;

import Model.PublicationDTO;
import Repository.IPublicationRepository;
import Repository.entity.PublicationEntity;
import Service.IPublicationService;

import java.util.List;

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
}
