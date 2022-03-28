package tn.altenders.poc.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.altenders.poc.entities.Element;
import tn.altenders.poc.exception.EntitieNotFoundException;
import tn.altenders.poc.service.IDocumentService;
import tn.altenders.poc.service.IElementService;
import tn.altenders.poc.service.controller.client.ElementClient;

@RestController
@RequestMapping("/api/elements")
@CrossOrigin("*")
public class ElementController implements ElementClient {

	IElementService elementService;
	IDocumentService documentService;
	
	@Autowired
	public ElementController(IElementService elementService,IDocumentService documentService) {
		super();
		this.elementService = elementService;
		this.documentService = documentService;
	}

	@Override
	public Element getElementById(Long id) throws EntitieNotFoundException {
		return elementService.getElement(id);
	}

	@Override
	public Element addElement(Element element) {
		return elementService.addElement(element);
	}

	@Override
	public Element addElement(Element element, Long documentId) throws EntitieNotFoundException {
		return elementService.addElement(element, documentService.getDocument(documentId));
	}

	@Override
	public Element addElement(Element element, Long documentId, Long parentElementId) throws EntitieNotFoundException {
		return elementService.addElement(element, documentService.getDocument(documentId), elementService.getElement(parentElementId));
	}

	

}
