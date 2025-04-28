package com.eespindola.ms.post.dao.imp;

import com.eespindola.ms.post.dao.UsuarioDAO;
import com.eespindola.ms.post.models.UsuarioML;
import com.eespindola.ms.post.service.UsuarioService;
import com.eespindola.ms.post.utils.Constantes;
import com.eespindola.ms.post.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.CallableStatementCallback;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;

@Repository
public class UsuarioImp implements UsuarioDAO {

    @Autowired
    @Qualifier(Constantes.HIKARI_CONNECTION)
    private JdbcTemplate jdbcTemplate;

    @Autowired
    UsuarioService usuarioService;

    @Override
    public Result<?> UsuarioInsert(UsuarioML usuario) throws SQLException {

        Result<?> result = new Result<>();

        String query = Constantes.USUARIO_INSERT;

        Integer rowAffected = jdbcTemplate.execute(query, (CallableStatementCallback<Integer>) callableStatementCallback ->{

            callableStatementCallback.setString(1, usuarioService.CrearFolioId());
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

        if(rowAffected != null && rowAffected != 0){
            result.isCorrect = true;
        } else {
            throw new SQLException();
        }

        return result;
    }

}
