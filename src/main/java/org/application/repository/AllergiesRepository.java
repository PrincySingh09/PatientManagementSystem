package org.application.repository;
import org.application.entity.Allergies;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AllergiesRepository extends JpaRepository<Allergies, Long> {
    
}

