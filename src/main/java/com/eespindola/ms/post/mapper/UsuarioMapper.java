package com.eespindola.ms.post.mapper;

import com.eespindola.ms.post.jpa.entities.UsuarioJPA;
import com.eespindola.ms.post.models.UsuarioML;
import com.eespindola.ms.post.models.dto.UsuarioRequest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UsuarioMapper {

    public static UsuarioJPA toUsuarioJPA(UsuarioRequest usuarioRequest) throws ParseException {
        UsuarioJPA usuarioJPA = new UsuarioJPA();

        usuarioJPA.setIdUsuario( usuarioRequest.getIdUsuario() );
        usuarioJPA.setFolio( usuarioRequest.getFolioId() );
        usuarioJPA.setNombre( usuarioRequest.getNombre() );
        usuarioJPA.setApellidoPaterno( usuarioRequest.getApellidoPaterno() );
        usuarioJPA.setApellidoMaterno( usuarioRequest.getApellidoMaterno() );
        usuarioJPA.setFechaNacimiento(getFechaNacimiento(usuarioRequest.getFechaNacimiento()));
        usuarioJPA.setUsername( usuarioRequest.getUsername() );
        usuarioJPA.setEmail( usuarioRequest.getEmail() );
        usuarioJPA.setPassword( usuarioRequest.getPassword() );
        usuarioJPA.setStatus( usuarioRequest.getStatus() );

        return usuarioJPA;
    }

    private static Date getFechaNacimiento(String fecha) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.parse(fecha);
    }

    public static UsuarioML toUsuarioML(UsuarioRequest usuarioRequest){
        UsuarioML usuarioML = new UsuarioML();

        usuarioML.setIdUsuario(usuarioRequest.getIdUsuario());
        usuarioML.setFolioId(usuarioRequest.getFolioId());
        usuarioML.setNombre(usuarioRequest.getNombre());
        usuarioML.setApellidoPaterno(usuarioRequest.getApellidoPaterno());
        usuarioML.setApellidoMaterno(usuarioRequest.getApellidoMaterno());
        usuarioML.setFechaNacimiento(usuarioRequest.getFechaNacimiento());
        usuarioML.setUsername(usuarioRequest.getUsername());
        usuarioML.setEmail(usuarioRequest.getEmail());
        usuarioML.setPassword(usuarioRequest.getPassword());
        usuarioML.setStatus(usuarioRequest.getStatus());

        return usuarioML;
    }

}
