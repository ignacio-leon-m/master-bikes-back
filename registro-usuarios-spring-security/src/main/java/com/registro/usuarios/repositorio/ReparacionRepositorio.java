package com.registro.usuarios.repositorio;

import com.registro.usuarios.modelo.Reparacion;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by ignac on 22-06-2023.
 */
public interface ReparacionRepositorio extends JpaRepository<Reparacion, Long> {
}
