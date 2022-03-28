package tn.altenders.poc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.altenders.poc.entities.Document;
import tn.altenders.poc.entities.Element;

@Repository
public interface ElementRepository extends JpaRepository<Element, Long >{
	List<Element> findByDocumentAndParentElementIsNull(Document document);
	List<Element> findByParentElement(Element parentElement);
}
