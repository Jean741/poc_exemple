package tn.altenders.poc.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
//@JsonIgnoreProperties(value = {"elements"})
public class Document implements Serializable{

	private static final long serialVersionUID = 7179990861334877573L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
    String name;
    
	@OneToMany(mappedBy = "document",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	List<Element> elements;
	
	public Document(String name) {
		super();
		this.name = name;
	}
}
