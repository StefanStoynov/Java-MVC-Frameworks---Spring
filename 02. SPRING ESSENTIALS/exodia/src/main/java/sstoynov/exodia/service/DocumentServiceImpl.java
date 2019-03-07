package sstoynov.exodia.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sstoynov.exodia.domain.entities.Document;
import sstoynov.exodia.domain.models.service.DocumentServiceModel;
import sstoynov.exodia.repository.DocumentRepository;

@Service
public class DocumentServiceImpl implements DocumentService {

    private final DocumentRepository documentRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public DocumentServiceImpl(DocumentRepository documentRepository, ModelMapper modelMapper) {
        this.documentRepository = documentRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public DocumentServiceModel scheduleDocument(DocumentServiceModel documentServiceModel) {
        Document document = this.modelMapper.map(documentServiceModel, Document.class);
        try {
            this.documentRepository.saveAndFlush(document);
            return this.modelMapper.map(document, DocumentServiceModel.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public DocumentServiceModel findDocumentByID(String id) {
        Document document = this.documentRepository.findById(id).orElse(null);

        if (document == null) {
            return null;
        }

        return this.modelMapper.map(document,DocumentServiceModel.class);
    }
}
