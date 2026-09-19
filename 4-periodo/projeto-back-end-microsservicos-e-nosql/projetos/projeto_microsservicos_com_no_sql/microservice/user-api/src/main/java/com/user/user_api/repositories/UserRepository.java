package com.user.user_api.repositories;

import com.user.user_api.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    
    Optional<User> findByCpf(String cpf);
    
    @Query("{'nome': {$regex: ?0, $options: 'i'}}")
    List<User> findByNomeContainingIgnoreCase(String nome);
    
    @NonNull
    Page<User> findAll(@NonNull Pageable pageable);
}
