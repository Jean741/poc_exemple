package tn.altenders.poc.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.altenders.poc.dto.ReviewStatType;
import tn.altenders.poc.entities.Review;
import tn.altenders.poc.exception.EntitieNotFoundException;
import tn.altenders.poc.service.IElementService;
import tn.altenders.poc.service.IReviewService;
import tn.altenders.poc.service.IUserService;
import tn.altenders.poc.service.controller.client.ReviewClient;

@RestController
@RequestMapping("/api/reviews")
@CrossOrigin("*")
public class ReviewController implements ReviewClient {

	IUserService userService;
	IReviewService reviewService;
	IElementService elementService;
	
	@Autowired
	public ReviewController(IUserService userService, IReviewService reviewService,
			IElementService elementService) {
		super();
		this.userService = userService;
		this.reviewService = reviewService;
		this.elementService = elementService;
	}

	@Override
	public List<Review> getReviews() {
		return reviewService.getAllReviews();
	}

	@Override
	public Review getReviewById(Long id) throws EntitieNotFoundException {
		return reviewService.getReview(id);
	}

	@Override
	public Review addReview(Review Review) {
		return reviewService.addReview(Review);
	}

	@Override
	public Review addReview(Review Review, Long userId, Long elementId) throws EntitieNotFoundException {
		return reviewService.addReview(Review, elementService.getElement(elementId), userService.getUser(userId));
	}

	@Override
	public List<Review> getReviewsByElement(Long elementId) throws EntitieNotFoundException {
		return reviewService.getReviewsByElement(elementService.getElement(elementId));
	}

	@Override
	public List<ReviewStatType> getNombreDeRevuesParStatut(Long elementId) {
		return reviewService.getNombreDeRevuesParStatut(elementId);
	}

	 

}
