package com.eespindola.ms.post.mapper;

import com.eespindola.ms.post.jpa.entities.UsuarioJpa;
import com.eespindola.ms.post.models.UsuarioMl;
import com.eespindola.ms.post.models.dto.UsuarioRequest;
import com.eespindola.ms.post.utils.ConstantesUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UsuarioMapper {

    public static UsuarioJpa toUsuarioJPA(UsuarioRequest usuarioRequest) throws ParseException {
        UsuarioJpa usuarioJPA = new UsuarioJpa();

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
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(ConstantesUtil.DATE_FORMAT);
        return simpleDateFormat.parse(fecha);
    }

    public static UsuarioMl toUsuarioML(UsuarioRequest usuarioRequest){
        UsuarioMl usuarioML = new UsuarioMl();

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
