package com.eespindola.ms.post.mapper;

import com.eespindola.ms.post.jpa.entities.UsuarioJpa;
import com.eespindola.ms.post.models.UsuarioMl;
import com.eespindola.ms.post.models.dto.UsuarioDto;
import com.eespindola.ms.post.utils.ConstantesUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UsuarioMapper {

    public static UsuarioJpa toUsuarioJpa(UsuarioDto usuarioRequest) throws ParseException {
        UsuarioJpa usuarioJpa = new UsuarioJpa();

        usuarioJpa.setIdUsuario(usuarioRequest.getIdUsuario());
        usuarioJpa.setFolio(usuarioRequest.getFolioId());
        usuarioJpa.setNombre(usuarioRequest.getNombre());
        usuarioJpa.setApellidoPaterno(usuarioRequest.getApellidoPaterno());
        usuarioJpa.setApellidoMaterno(usuarioRequest.getApellidoMaterno());
        usuarioJpa.setFechaNacimiento(getFechaNacimiento(usuarioRequest.getFechaNacimiento()));
        usuarioJpa.setUsername(usuarioRequest.getUsername());
        usuarioJpa.setEmail(usuarioRequest.getEmail());
        usuarioJpa.setPassword(usuarioRequest.getPassword());
        usuarioJpa.setStatus(usuarioRequest.getStatus());

        return usuarioJpa;
    }
    private static Date getFechaNacimiento(String fecha) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(ConstantesUtils.DATE_FORMAT);
        return simpleDateFormat.parse(fecha);
    }

    public static UsuarioMl toUsuarioMl(UsuarioDto usuarioRequest) {
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
