package com.eespindola.ms.post.service.imp;

import com.eespindola.ms.post.dao.UsuarioDao;
import com.eespindola.ms.post.jpa.UsuarioRepository;
import com.eespindola.ms.post.mapper.UsuarioMapper;
import com.eespindola.ms.post.models.UsuarioMl;
import com.eespindola.ms.post.models.dto.Result;
import com.eespindola.ms.post.models.dto.UsuarioDto;
import com.eespindola.ms.post.service.UsuarioService;
import com.eespindola.ms.post.utils.FolioUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UsuarioServiceImp implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioDao usuarioDAO;

    @Autowired
    public UsuarioServiceImp(
      UsuarioRepository repository,
      UsuarioDao dao
    ){
        this.usuarioRepository = repository;
        this.usuarioDAO = dao;
    }

    @Override
    public Result<Void> agregarUsuario(Result<UsuarioDto> request) {

        Result<Void> response = new Result<>();
        response.setFolioRequest(Objects.requireNonNullElse(request.getFolioRequest(), FolioUtils.createFolioRequest()));

        try {
//            UsuarioJPA usuarioJPA = UsuarioMapper.toUsuarioJPA(request.getObject());
//            usuarioJPA.setFolio(FolioUtil.createFolioId());
//
//            usuarioRepository.save(usuarioJPA);

            UsuarioMl usuarioML = UsuarioMapper.toUsuarioMl(request.getObject());
            usuarioML.setFolioId(FolioUtils.createFolioId());

            usuarioDAO.usuarioInsert(usuarioML);

            response.setIsCorrect(true);
            response.setMessage("Usuario insertado correctamente");
        } catch (Exception e){
            response.setIsCorrect(false);
            response.setException(e);
            response.setMessage(e.getMessage());
        }

        return response;
    }

}
