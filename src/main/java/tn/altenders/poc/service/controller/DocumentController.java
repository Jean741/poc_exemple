package tn.altenders.poc.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.altenders.poc.entities.Document;
import tn.altenders.poc.exception.EntitieNotFoundException;
import tn.altenders.poc.service.IDocumentService;
import tn.altenders.poc.service.controller.client.DocumentClient;

@RestController
@RequestMapping("/api/documents")
@CrossOrigin("*")
public class DocumentController implements DocumentClient {

	IDocumentService  documentService;
	
	@Autowired
	public DocumentController(IDocumentService documentService) {
		super();
		this.documentService = documentService;
	}

	@Override
	public List<Document> getDocuments() {
		List<Document> allDocuments = documentService.getAllDocuments();
		return allDocuments;
	}

	@Override
	public Document getDocumentById(Long id) throws EntitieNotFoundException {
		return documentService.getDocument(id);
	}

	@Override
	public Document addDocument(Document document) {
		return documentService.addDocument(document);
	}

	@Override
	public String getDocumentTextById(Long id) throws EntitieNotFoundException {
		return documentService.getDocumentContent(id);
	}
	

}
