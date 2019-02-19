package com.maz.eventpp.eventapp.repository;

import com.maz.eventpp.eventapp.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {


}