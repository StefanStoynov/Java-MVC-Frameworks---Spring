package sstoynov.exodia.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sstoynov.exodia.domain.entities.Document;
import sstoynov.exodia.domain.models.service.DocumentServiceModel;
import sstoynov.exodia.repository.DocumentRepository;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public List<DocumentServiceModel> findAllDocuments() {
        List<DocumentServiceModel> documents = this.documentRepository
                .findAll()
                .stream()
                .map(d-> this.modelMapper.map(d, DocumentServiceModel.class))
                .collect(Collectors.toList());

        return documents;
    }

    @Override
    public boolean printDocument(String id) {
        try{
            this.documentRepository.deleteById(id);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
