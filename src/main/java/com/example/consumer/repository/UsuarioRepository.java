package com.example.consumer.repository;

import com.example.consumer.model.UsuarioModel;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface UsuarioRepository  extends ReactiveMongoRepository<UsuarioModel, String> {
    
}
