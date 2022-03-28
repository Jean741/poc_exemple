package tn.altenders.poc.service;

import java.util.List;

import tn.altenders.poc.entities.Document;
import tn.altenders.poc.exception.EntitieNotFoundException;

public interface IDocumentService {
	
	public List<Document> getAllDocuments();
	
	public Document getDocument(Long id) throws EntitieNotFoundException;
	
	public Document addDocument(Document document);
	
	public Document updateDocument(Document document);

	String getDocumentContent(Long id) throws EntitieNotFoundException;
}
