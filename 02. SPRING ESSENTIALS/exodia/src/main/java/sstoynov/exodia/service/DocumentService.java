package sstoynov.exodia.service;

import sstoynov.exodia.domain.models.service.DocumentServiceModel;

import java.util.List;

public interface DocumentService {

    DocumentServiceModel scheduleDocument (DocumentServiceModel documentServiceModel);

    DocumentServiceModel findDocumentByID(String id);

    List<DocumentServiceModel> findAllDocuments();

    boolean printDocument(String id);
}
