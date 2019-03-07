package sstoynov.exodia.service;

import sstoynov.exodia.domain.models.service.DocumentServiceModel;

public interface DocumentService {

    DocumentServiceModel scheduleDocument (DocumentServiceModel documentServiceModel);

    DocumentServiceModel findDocumentByID(String id);
}
