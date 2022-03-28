package tn.altenders.poc.dto;

import java.io.Serializable;


public class ReviewStat implements ReviewStatType , Serializable {

	private static final long serialVersionUID = 1811663947081601052L;
	public String status;
	public int numberOfReview;
	@Override
	public String getStatus() {
		return status;
	}
	@Override
	public int getNumberOfReview() {
		return numberOfReview;
	}	
	
}
