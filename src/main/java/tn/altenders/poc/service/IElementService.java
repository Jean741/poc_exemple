package tn.altenders.poc.service;

import tn.altenders.poc.entities.Document;
import tn.altenders.poc.entities.Element;
import tn.altenders.poc.exception.EntitieNotFoundException;

public interface IElementService {
	
	public Element getElement(Long id) throws EntitieNotFoundException;

	public Element addElement(Element element);
	
	public Element addElement(Element element, Document document );

	public Element addElement(Element element, Document document, Element parentElement );
	
	public Element updateElement(Element element);
	
}
