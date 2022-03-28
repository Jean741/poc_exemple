package tn.altenders.poc.service.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.altenders.poc.entities.Document;
import tn.altenders.poc.entities.Element;
import tn.altenders.poc.exception.EntitieNotFoundException;
import tn.altenders.poc.repository.ElementRepository;
import tn.altenders.poc.service.IElementService;

@Service
public class ElementServiceImpl implements IElementService {
	private static Logger logger = LoggerFactory.getLogger(ElementServiceImpl.class);

	ElementRepository elementRepository;

	@Autowired
	public ElementServiceImpl(ElementRepository elementRepository) {
		super();
		this.elementRepository = elementRepository;
	}

	@Override
	public Element getElement(Long id) throws EntitieNotFoundException {
		Optional<Element> element = elementRepository.findById(id);
		if (element.isPresent()) {
			return element.get();
		} else {
			logger.error("Element with id {} not found ", id);
			throw new EntitieNotFoundException(String.format("Element with id %d not found", id));
		}
	}

	@Override
	public Element addElement(Element element) {
		return elementRepository.save(element);
	}

	@Override
	public Element addElement(Element element, Document document) {
		element = addElement(element);
		element.setDocument(document);
		return elementRepository.saveAndFlush(element);
	}

	@Override
	public Element addElement(Element element, Document document, Element parentElement) {
		element = addElement(element);
		element.setDocument(document);
		element.setParentElement(parentElement);
		return elementRepository.saveAndFlush(element);
	}

	@Override
	public Element updateElement(Element element) {
		// TODO Auto-generated method stub
		return null;
	}

}
