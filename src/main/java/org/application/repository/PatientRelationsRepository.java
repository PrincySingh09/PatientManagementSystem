package org.application.repository;
import org.application.entity.PatientRelations;

import org.springframework.stereotype.Repository;

@Repository
public interface PatientRelationsRepository extends org.springframework.data.jpa.repository.JpaRepository<PatientRelations, Long> {

}
