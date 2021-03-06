package com.ceiba.configuracion;

import com.ceiba.inscripcion.puerto.repositorio.RepositorioInscripcion;
import com.ceiba.inscripcion.servicio.ServicioCrearInscripcion;
import com.ceiba.inscripcion.servicio.ServicioEliminarInscripcion;
import com.ceiba.inscripcion.servicio.ServicioActualizarInscripcion;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.usuario.servicio.ServicioActualizarUsuario;
import com.ceiba.usuario.servicio.ServicioCederCreditos;
import com.ceiba.usuario.servicio.ServicioCrearUsuario;
import com.ceiba.usuario.servicio.ServicioEliminarUsuario;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {

    @Bean
    public ServicioCrearUsuario servicioCrearUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioCrearUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioEliminarUsuario servicioEliminarUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioEliminarUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioActualizarUsuario servicioActualizarUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioActualizarUsuario(repositorioUsuario);
    }
    
    @Bean
    public ServicioCederCreditos servicioCederCreditos(RepositorioUsuario repositorioUsuario) {
        return new ServicioCederCreditos(repositorioUsuario);
    }
    
    @Bean
    public ServicioCrearInscripcion servicioCrearInscripcion(RepositorioInscripcion repositorioInscripcion) {
        return new ServicioCrearInscripcion(repositorioInscripcion);
    }
    @Bean
    public ServicioEliminarInscripcion servicioEliminarInscripcion(RepositorioInscripcion repositorioInscripcion) {
        return new ServicioEliminarInscripcion(repositorioInscripcion);
    }
    @Bean
    public ServicioActualizarInscripcion servicioActualizarInscripcion(RepositorioInscripcion repositorioInscripcion) {
        return new ServicioActualizarInscripcion(repositorioInscripcion);
    }
    
}
