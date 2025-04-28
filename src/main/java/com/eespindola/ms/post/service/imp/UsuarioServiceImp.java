package com.eespindola.ms.post.service.imp;

import com.eespindola.ms.post.service.UsuarioService;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Service
public class UsuarioServiceImp implements UsuarioService {

    @Override
    public String CrearFolioId() {

        //Long milis = System.currentTimeMillis();
        //Date date = new Date(milis);

        UUID uuid = UUID.randomUUID();

        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String text = date.format(formatter);
        LocalDateTime parsedDate = LocalDateTime.parse(text, formatter);

        String folio = MessageFormat.format("{0}-{1}", uuid, parsedDate);

        return folio;
    }
}
