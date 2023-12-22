package org.application.repository;
import org.application.entity.Prescription;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {
    
}

