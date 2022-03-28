package tn.altenders.poc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.altenders.poc.dto.ReviewStatType;
import tn.altenders.poc.entities.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
	// Récupération agrégée par type des revues du contenu
	@Query(value = "select   review.status as status ,count(distinct review.id) as numberOfReview from review review inner join element e on review.element_id = e.id " +
			" where e.parent_element_id = ?1  or e.id = ?1 "+
			" group by 1 ", nativeQuery = true)
	List<ReviewStatType> getNombreDeRevuesParStatut(@Param("elementId") int elementId);
}
