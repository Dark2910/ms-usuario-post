package com.eespindola.ms.post.dao;

import com.eespindola.ms.post.models.UsuarioML;

import java.sql.SQLException;

public interface UsuarioDao {

    void usuarioInsert(UsuarioML usuario) throws SQLException;

}
