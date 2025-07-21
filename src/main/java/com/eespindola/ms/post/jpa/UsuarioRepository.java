package com.eespindola.ms.post.jpa;

import com.eespindola.ms.post.jpa.entities.UsuarioJpa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<UsuarioJpa, Object> {
}
