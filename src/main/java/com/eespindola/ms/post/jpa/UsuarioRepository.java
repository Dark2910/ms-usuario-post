package com.eespindola.ms.post.jpa;

import com.eespindola.ms.post.jpa.entities.UsuarioJPA;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<UsuarioJPA, Object> {
}
