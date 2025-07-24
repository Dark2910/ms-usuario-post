package com.eespindola.ms.post.service;

import com.eespindola.ms.post.models.dto.Result;
import com.eespindola.ms.post.models.dto.UsuarioDto;

public interface UsuarioService {

    Result<Void> agregarUsuario(Result<UsuarioDto> request);

}
