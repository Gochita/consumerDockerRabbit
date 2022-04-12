package com.example.consumer.service;


import com.example.consumer.model.UsuarioModel;
import com.example.consumer.repository.UsuarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;
    ModelMapper mapper;

    public Mono<UsuarioModel> saveUser(UsuarioModel usuarioModel) {
        return this.usuarioRepository.save(usuarioModel);
    }
    public Mono<UsuarioModel> actualizarUsuario(String id, UsuarioModel usuarioModel){
        String palabra=usuarioModel.getPalabra();
        StringBuilder strb= new StringBuilder(palabra);
        palabra= strb.reverse().toString();
        String finalPalabra = palabra;
        return this.usuarioRepository.findById(id)
                .flatMap(c -> {
                    c.setPalabra(finalPalabra);
                    return saveUser(c);
                })
                .switchIfEmpty(Mono.empty());
    }
}
