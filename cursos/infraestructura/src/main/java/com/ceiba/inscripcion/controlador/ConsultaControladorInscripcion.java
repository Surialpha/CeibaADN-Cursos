package com.ceiba.inscripcion.controlador;

import java.util.List;

import com.ceiba.inscripcion.consulta.ManejadorListarInscripcion;
import com.ceiba.inscripcion.modelo.dto.DtoInscripcion;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/inscripcion")
@Api(tags={"Controlador consulta usuario"})
public class ConsultaControladorInscripcion {

    private final ManejadorListarInscripcion manejadorListarInscripcion;

    public ConsultaControladorInscripcion(ManejadorListarInscripcion manejadorListarInscripcion) {
        this.manejadorListarInscripcion = manejadorListarInscripcion;
    }

    @GetMapping
    @ApiOperation("Listar inscripcion")
    public List<DtoInscripcion> listar() {
        return this.manejadorListarInscripcion.ejecutar();
    }
    
    @GetMapping(value="usuario/{id}")
    @ApiOperation("Listar inscripcion")
    public List<DtoInscripcion> listarByUser(@PathVariable Long id) {
        return this.manejadorListarInscripcion.listarByUser(id);
    }
    @GetMapping(value="/{id}")
    @ApiOperation("Listar inscripcion")
    public List<DtoInscripcion> listarBy(@PathVariable Long id) {
    	return this.manejadorListarInscripcion.listarBy(id);
    }


}
