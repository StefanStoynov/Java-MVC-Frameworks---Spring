package sstoynov.exodia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sstoynov.exodia.domain.entities.Document;

@Repository
public interface DocumentRepository extends JpaRepository<Document, String> {

}
