package tn.altenders.poc.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import tn.altenders.poc.dto.ReviewStatType;
import tn.altenders.poc.entities.Element;
import tn.altenders.poc.entities.Review;
import tn.altenders.poc.entities.User;
import tn.altenders.poc.enums.ReviewStatus;
import tn.altenders.poc.exception.EntitieNotFoundException;
import tn.altenders.poc.repository.ElementRepository;
import tn.altenders.poc.repository.ReviewRepository;
import tn.altenders.poc.repository.UserRepository;
import tn.altenders.poc.service.IReviewService;
import tn.altenders.poc.service.utils.ReviewUtils;

@Service
public class ReviewServiceImpl implements IReviewService {

	private static Logger logger = LoggerFactory.getLogger(ReviewServiceImpl.class);

	UserRepository userRepository;
	ReviewRepository reviewRepository;
	ElementRepository elementRepository;

	@Autowired
	public ReviewServiceImpl(ElementRepository elementRepository, UserRepository userRepository,
			ReviewRepository reviewRepository) {
		super();
		this.elementRepository = elementRepository;
		this.userRepository = userRepository;
		this.reviewRepository = reviewRepository;
	}

	@Override
	public List<Review> getAllReviews() {
		return reviewRepository.findAll();
	}

	@Override
	public Review getReview(Long id) throws EntitieNotFoundException {
		Optional<Review> review = reviewRepository.findById(id);
		if (review.isPresent()) {
			return review.get();
		} else {
			logger.error("Review with id {} not found ", id);
			throw new EntitieNotFoundException(String.format("Review with id %d not found", id));
		}
	}

	@Override
	public Review addReview(Review review) {
		return reviewRepository.save(review);
	}

	@Override
	public Review addReview(Review review, Element element, User user) throws EntitieNotFoundException {
		Review reviewToSave = Review.builder().build();
		if (ReviewStatus.YES.equals(review.getStatus())) {
			reviewToSave.setStatus(ReviewStatus.YES);
			reviewToSave.setElement(element);
			reviewToSave.setUser(user);
		} else if (ReviewStatus.NO.equals(review.getStatus())) {
			reviewToSave.setStatus(ReviewStatus.NO);
			reviewToSave.setElement(element);
			reviewToSave.setUser(user);
		} else {
			logger.error("Review with id Status {} is not expected ", review.getStatus());
			throw new EntitieNotFoundException(
					String.format("Review with id Status %s is not expected", review.getStatus()));
		}
		return reviewRepository.save(reviewToSave);
	}

	@Override
	public Review updateReview(Review review) {
		return null;
	}

	@Override
	public List<Review> getReviewsByElement(Element element) {

		List<Review> reviews = new ArrayList<>();
		List<Element> childElements = new ArrayList<>();
		ReviewUtils.getAllChildElements(element, childElements);
		childElements.forEach(elmt -> {
			reviews.addAll(elmt.getReviews());
		});
		return reviews;
	}

	@Override
	public List<ReviewStatType> getNombreDeRevuesParStatut(Long elementId) {
		List<ReviewStatType> reviewStats = reviewRepository.getNombreDeRevuesParStatut(elementId.intValue());
		return CollectionUtils.isEmpty(reviewStats) ? new ArrayList<>() : reviewStats;
	}
}
