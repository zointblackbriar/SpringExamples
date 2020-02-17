package org.tu_dresden.de.internal.app.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin; //for remote requests
import org.tu_dresden.de.internal.entities.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{}