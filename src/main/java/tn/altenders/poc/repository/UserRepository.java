package tn.altenders.poc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.altenders.poc.entities.User;

@Repository
public interface UserRepository extends JpaRepository< User, Long>{

}
