package com.eespindola.ms.post.dao;

import com.eespindola.ms.post.models.UsuarioML;
import com.eespindola.ms.post.utils.Result;

import java.sql.SQLException;

public interface UsuarioDAO {

    Result UsuarioInsert(UsuarioML usuario) throws SQLException;

}
