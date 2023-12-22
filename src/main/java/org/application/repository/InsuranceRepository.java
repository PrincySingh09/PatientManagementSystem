package org.application.repository;
import org.application.entity.Insurance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface InsuranceRepository extends JpaRepository<Insurance, Long> {

}