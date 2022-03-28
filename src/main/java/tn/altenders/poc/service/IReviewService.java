package tn.altenders.poc.service;

import java.util.List;

import tn.altenders.poc.dto.ReviewStatType;
import tn.altenders.poc.entities.Element;
import tn.altenders.poc.entities.Review;
import tn.altenders.poc.entities.User;
import tn.altenders.poc.exception.EntitieNotFoundException;

public interface IReviewService {
	
	public List<Review> getAllReviews();
	
	public Review getReview(Long id) throws EntitieNotFoundException;

	public Review addReview(Review review);

	public Review addReview(Review review,Element element, User user) throws EntitieNotFoundException;
	
	public Review updateReview(Review review);

	public List<Review> getReviewsByElement(Element element);

	public List<ReviewStatType> getNombreDeRevuesParStatut(Long elementId);
	
}
