package tn.altenders.poc.service.controller.client;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import tn.altenders.poc.entities.Document;
import tn.altenders.poc.exception.EntitieNotFoundException;

public interface DocumentClient {
	
	 @GetMapping
	 List<Document> getDocuments();
	   
	 @GetMapping("id/{id}")
	 Document getDocumentById(@PathVariable(required = true) Long id) throws EntitieNotFoundException;
	 
	 @GetMapping(path =  "text/id/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	 String getDocumentTextById(@PathVariable(required = true) Long id) throws EntitieNotFoundException;
	 
	 @PostMapping
	 Document addDocument(@RequestBody(required = true) Document document);

}
