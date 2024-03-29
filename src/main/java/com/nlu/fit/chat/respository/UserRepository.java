package com.nlu.fit.chat.respository;

import com.nlu.fit.chat.documents.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
