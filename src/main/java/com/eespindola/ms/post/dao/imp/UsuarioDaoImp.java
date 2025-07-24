package com.eespindola.ms.post.dao.imp;

import com.eespindola.ms.post.dao.UsuarioDao;
import com.eespindola.ms.post.models.UsuarioMl;
import com.eespindola.ms.post.utils.ConstantesUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.CallableStatementCallback;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.SQLException;

@Repository
public class UsuarioDaoImp implements UsuarioDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UsuarioDaoImp(
            @Qualifier(ConstantesUtils.HIKARI_DATA_SOURCE) DataSource dataSource
//            @Qualifier(ConstantesUtil.HIKARI_CONNECTION) JdbcTemplate jdbc
    ){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
//        this.jdbcTemplate = jdbc;
    }

    @Override
    public void usuarioInsert(UsuarioMl usuario) throws SQLException {

        String query = ConstantesUtils.USUARIO_INSERT;

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
