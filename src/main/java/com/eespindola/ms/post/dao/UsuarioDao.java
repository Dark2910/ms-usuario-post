package com.eespindola.ms.post.dao;

import com.eespindola.ms.post.models.UsuarioMl;

import java.sql.SQLException;

public interface UsuarioDao {

    void usuarioInsert(UsuarioMl usuario) throws SQLException;

}
