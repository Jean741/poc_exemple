package tn.altenders.poc.service.controller.client;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import tn.altenders.poc.entities.Element;
import tn.altenders.poc.exception.EntitieNotFoundException;

public interface ElementClient {
	
	 //@GetMapping
	 //List<Element> getElements();
	   
	 @GetMapping("id/{id}")
	 Element getElementById(@PathVariable(required = true) Long id) throws EntitieNotFoundException;
	 
	 @PostMapping
	 Element addElement(@RequestBody(required = true) Element element);
	 
	 @PostMapping("addElementToDocument")
	 Element addElement(@RequestBody(required = true) Element element,@RequestParam(required = true) Long documentId) throws EntitieNotFoundException;
	 
	 @PostMapping("addElementToDocumentUnderElement")
	 Element addElement(@RequestBody(required = true) Element element,@RequestParam(required = true) Long documentId,@RequestParam(required = true) Long parentElementId) throws EntitieNotFoundException;

}
