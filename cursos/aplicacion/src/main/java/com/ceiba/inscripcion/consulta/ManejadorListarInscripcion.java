package com.ceiba.inscripcion.consulta;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ceiba.inscripcion.modelo.dto.DtoInscripcion;
import com.ceiba.inscripcion.puerto.dao.DaoInscripcion;

@Component
public class ManejadorListarInscripcion {

    private final DaoInscripcion daoInscripcion;

    public ManejadorListarInscripcion(DaoInscripcion daoInscripcion){
        this.daoInscripcion = daoInscripcion;
    }

    public List<DtoInscripcion> ejecutar(){ return this.daoInscripcion.listar(); }
    
    public List<DtoInscripcion> listarBy(Long id){ return this.daoInscripcion.listarBy(id); }
    
    
    public List<DtoInscripcion> listarByUser(Long id){ return this.daoInscripcion.listarByUser(id); }
}
