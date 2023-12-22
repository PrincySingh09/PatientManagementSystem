package org.application.repository;
import org.application.entity.Contact;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

}
