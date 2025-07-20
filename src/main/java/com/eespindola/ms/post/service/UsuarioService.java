package com.eespindola.ms.post.service;

import com.eespindola.ms.post.models.UsuarioML;
import com.eespindola.ms.post.models.dto.Result;
import com.eespindola.ms.post.models.dto.UsuarioRequest;

public interface UsuarioService {

    Result<Void> agregarUsuario(Result<UsuarioRequest> request);

}
