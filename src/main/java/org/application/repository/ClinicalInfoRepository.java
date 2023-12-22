package org.application.repository;
import org.application.entity.ClinicalInfo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ClinicalInfoRepository extends JpaRepository<ClinicalInfo, Long> {

}