package tn.altenders.poc.service.controller.client;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import tn.altenders.poc.dto.ReviewStatType;
import tn.altenders.poc.entities.Review;
import tn.altenders.poc.exception.EntitieNotFoundException;

public interface ReviewClient {
	
	 @GetMapping
	 List<Review> getReviews();
	   
	 @GetMapping("id/{id}")
	 Review getReviewById(@PathVariable(required = true) Long id) throws EntitieNotFoundException;
	 
	 @GetMapping("element/{elementId}")
	 List<Review> getReviewsByElement(@PathVariable(required = true) Long elementId) throws EntitieNotFoundException;
	 
	 @GetMapping("statReview/element/{elementId}")
	 List<ReviewStatType> getNombreDeRevuesParStatut(@PathVariable(required = true) Long elementId);
	 
	 @PostMapping
	 Review addReview(@RequestBody(required = true) Review Review);
	 
	 @PostMapping("addReviewToElement")
	 Review addReview(@RequestBody(required = true) Review Review,@RequestParam(required = true) Long userId,@RequestParam(required = true) Long elementId) throws EntitieNotFoundException;

}
