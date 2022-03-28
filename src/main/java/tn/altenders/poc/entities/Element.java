package tn.altenders.poc.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@JsonIgnoreProperties(value = {"reviews","document","childElements"})
public class Element implements Serializable{
  
	public Element(String content) {
		super();
		this.content = content;
	}

	private static final long serialVersionUID = -1751370777905219455L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;

	@ManyToOne
	Element parentElement;

	@ManyToOne
	Document document;
	
	String content;

	@OneToMany(mappedBy = "element", fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
	List<Review> reviews;
	@OneToMany(mappedBy = "parentElement", fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
	List<Element> childElements;
}
