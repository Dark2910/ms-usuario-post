package com.eespindola.ms.post.controller;

import com.eespindola.ms.post.dao.imp.UsuarioImp;
import com.eespindola.ms.post.models.dto.Result;
import com.eespindola.ms.post.jpa.UsuarioRepository;
import com.eespindola.ms.post.models.UsuarioML;
import com.eespindola.ms.post.service.imp.UsuarioServiceImp;
import com.eespindola.ms.post.utils.FolioRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.MessageFormat;

@RestController
@RequestMapping("/usuarioAPI")
public class UsuarioRestController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioServiceImp usuarioServiceImplementation;

    @Autowired
    private UsuarioImp usuarioImp;

    @PostMapping("/post")
    public Result Post(@RequestHeader(value = "folioRequest", required = false) String folioRequest, @RequestBody Result<UsuarioML> usuarioML){

        folioRequest = (folioRequest == null || folioRequest.isEmpty() || folioRequest.isBlank())? FolioRequest.CrearFolioRequest() : folioRequest;

        Result result = new Result<>();

        try {
//            usuarioML.setFolio(usuarioServiceImplementation.CrearFolioId());
//            usuarioML.setStatus("1");
//
//            usuarioRepository.save(UsuarioMapper.Map(usuarioML));

            result = usuarioImp.UsuarioInsert(usuarioML.getObject());
            result.setFolio(usuarioML.getFolio());
            result.setIsCorrect(true);

        } catch (Exception e){
            result.setIsCorrect(false);
            result.setException(e);
            result.setMessage(e.getLocalizedMessage());
        }
        return result;
    }


}
