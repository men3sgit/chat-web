package com.nlu.fit.chat.respository;

import com.nlu.fit.chat.documents.token.Token;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TokenRepository extends MongoRepository<Token,Long> {
    Optional<Token> findByToken(String token);
}
