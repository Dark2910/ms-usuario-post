package com.eespindola.ms.post.dao.imp;

import com.eespindola.ms.post.dao.UsuarioDao;
import com.eespindola.ms.post.models.UsuarioML;
import com.eespindola.ms.post.utils.ConstantesUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.CallableStatementCallback;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;

@Repository
public class UsuarioDaoImp implements UsuarioDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UsuarioDaoImp(
            @Qualifier(ConstantesUtil.HIKARI_CONNECTION) JdbcTemplate jdbc
    ){
        this.jdbcTemplate = jdbc;
    }

    @Override
    public void usuarioInsert(UsuarioML usuario) throws SQLException {

        String query = ConstantesUtil.USUARIO_INSERT;

        Integer rowAffected = jdbcTemplate.execute(query, (CallableStatementCallback<Integer>) callableStatementCallback ->{

            callableStatementCallback.setString(1, usuario.getFolioId());
            callableStatementCallback.setString(2, usuario.getNombre());
            callableStatementCallback.setString(3, usuario.getApellidoPaterno());
            callableStatementCallback.setString(4, usuario.getApellidoMaterno());
            callableStatementCallback.setString(5, usuario.getFechaNacimiento());
            callableStatementCallback.setString(6, usuario.getUsername());
            callableStatementCallback.setString(7, usuario.getEmail());
            callableStatementCallback.setString(8, usuario.getPassword());

            callableStatementCallback.execute();

            return callableStatementCallback.getUpdateCount();
        });

        if (rowAffected == null || rowAffected == 0) {
            throw new SQLException("No se pudo insertar el usuario");
        }

    }

}
