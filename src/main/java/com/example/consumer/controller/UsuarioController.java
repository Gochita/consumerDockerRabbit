package com.example.consumer.controller;

import com.example.consumer.config.Config;
import com.example.consumer.model.DTO.UsuarioDTO;
import com.example.consumer.model.UsuarioModel;
import com.example.consumer.service.UsuarioService;
import org.modelmapper.ModelMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/usuariosReversos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioController {


    @Autowired
    ModelMapper mapper;
    @Autowired
    UsuarioService usuarioService;
    @Autowired
    private RabbitTemplate rabbitTemplate;


    @PutMapping("/revertirPalabra/{id}")
    public Mono<UsuarioModel> update(@PathVariable("id") String id, @RequestBody UsuarioDTO usuarioDTO) {
        var cliente = mapper.map(usuarioDTO, UsuarioModel.class);
        rabbitTemplate.convertAndSend(Config.EXCHANGE, Config.ROUTING_KEY, "Palabra reversada");
        return this.usuarioService.actualizarUsuario(id, cliente);

    }

}
