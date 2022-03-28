package tn.altenders.poc.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import tn.altenders.poc.enums.ReviewStatus;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Review implements Serializable {

	private static final long serialVersionUID = 1811663947081601052L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	@Enumerated(EnumType.STRING)
	ReviewStatus status;

	@ManyToOne
	User user;
	
	@ManyToOne
	Element element;
	
	public Review(ReviewStatus status) {
		super();
		this.status = status;
	}

	public Review(ReviewStatus status, User user, Element element) {
		super();
		this.status = status;
		this.user = user;
		this.element = element;
	}
	
}
