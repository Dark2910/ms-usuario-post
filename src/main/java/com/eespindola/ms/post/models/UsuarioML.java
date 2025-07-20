package com.eespindola.ms.post.models;

import com.eespindola.ms.post.models.dto.UsuarioRequest;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UsuarioML {

    private int idUsuario;
    private String folioId;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String fechaNacimiento;
    private String username;
    private String email;
    private String password;
    private String status;

}
