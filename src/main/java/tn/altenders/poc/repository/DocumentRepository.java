package tn.altenders.poc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.altenders.poc.entities.Document;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Long> {
}
