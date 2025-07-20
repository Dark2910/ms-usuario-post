package com.eespindola.ms.post.controller;

import com.eespindola.ms.post.models.dto.Result;
import com.eespindola.ms.post.models.dto.UsuarioRequest;
import com.eespindola.ms.post.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarioAPI")
public class UsuarioRestController {

    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioRestController(
            UsuarioService service
    ) {
        this.usuarioService = service;
    }

    @PostMapping("/post")
    public Result<Void> post(@RequestHeader(value = "folioRequest", required = false) String folioRequest, @RequestBody Result<UsuarioRequest> request){

//        folioRequest = (folioRequest == null || folioRequest.isEmpty() || folioRequest.isBlank())? FolioRequest.CrearFolioRequest() : folioRequest;

        return usuarioService.agregarUsuario(request);
    }


}
