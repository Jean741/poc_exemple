package tn.altenders.poc.service.impl;

import static tn.altenders.poc.contants.PocConstants.INDEX_TAB_START;
import static tn.altenders.poc.contants.PocConstants.NEW_LINE;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import tn.altenders.poc.entities.Document;
import tn.altenders.poc.entities.Element;
import tn.altenders.poc.exception.EntitieNotFoundException;
import tn.altenders.poc.repository.DocumentRepository;
import tn.altenders.poc.repository.ElementRepository;
import tn.altenders.poc.service.IDocumentService;
import tn.altenders.poc.service.utils.DocumentUtils;

@Service
public class DocumentServiceImpl implements IDocumentService {

	private static Logger logger = LoggerFactory.getLogger(DocumentServiceImpl.class);

	DocumentRepository documentRepository;
	ElementRepository elementRepository;
	
	@Autowired
	public DocumentServiceImpl(DocumentRepository DocumentRepository,ElementRepository elementRepository) {
		super();
		this.documentRepository = DocumentRepository;
		this.elementRepository = elementRepository;
	}

	@Override
	public List<Document> getAllDocuments() {
		List<Document> findAll = documentRepository.findAll();
		return findAll;
	}

	@Override
	public Document getDocument(Long id) throws EntitieNotFoundException {
		Optional<Document> document = documentRepository.findById(id);
		if (document.isPresent()) {
			return document.get();
		}else {
			logger.error("Document with id {} not found ", id);
			throw new EntitieNotFoundException(String.format("Document with id %d not found", id));
		}
	}

	@Override
	public Document addDocument(Document Document) {
		return documentRepository.save(Document);
	}
	
	@Override
	public String getDocumentContent(Long id) throws EntitieNotFoundException {
		Document  document= getDocument(id);
		StringBuilder documentText = new StringBuilder();
		List<Element> firstElements = elementRepository.findByDocumentAndParentElementIsNull(document);
		
		if (!CollectionUtils.isEmpty(firstElements)) {
			int elementCompteur = 0;
			for (elementCompteur = 0; elementCompteur < firstElements.size()-1; elementCompteur++) {
				String elementContent = DocumentUtils.getElementContent(firstElements.get(elementCompteur),INDEX_TAB_START);
				documentText.append(elementContent+NEW_LINE);
			}
			documentText.append(DocumentUtils.getElementContent(firstElements.get(elementCompteur),INDEX_TAB_START));
		}
		return documentText.toString();
	}

	@Override
	public Document updateDocument(Document Document) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
