package com.ceiba.inscripcion.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.inscripcion.comando.ComandoInscripcion;
import com.ceiba.inscripcion.comando.manejador.ManejadorActualizarInscripcion;
import com.ceiba.inscripcion.comando.manejador.ManejadorCrearInscripcion;
import com.ceiba.inscripcion.comando.manejador.ManejadorEliminarInscripcion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/inscripcion")
@Api(tags = { "Controlador comando inscripcion"})
public class ComandoControladorInscripcion{

    private final ManejadorCrearInscripcion manejadorCrearInscripcion;
	private final ManejadorEliminarInscripcion manejadorEliminarInscripcion;
	private final ManejadorActualizarInscripcion manejadorActualizarInscripcion;

    @Autowired
    public ComandoControladorInscripcion(ManejadorCrearInscripcion manejadorCrearInscripcion,
    									ManejadorEliminarInscripcion manejadorEliminarInscripcion,
    									ManejadorActualizarInscripcion manejadorActualizarInscripcion) {
        this.manejadorCrearInscripcion = manejadorCrearInscripcion;
		this.manejadorEliminarInscripcion = manejadorEliminarInscripcion;
		this.manejadorActualizarInscripcion = manejadorActualizarInscripcion;
    }

    @PostMapping
    @ApiOperation("Crear inscripcion")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoInscripcion comandoInscripcion) {
        return manejadorCrearInscripcion.ejecutar(comandoInscripcion);
    }

    @DeleteMapping(value="/{id}")
	@ApiOperation("Eliminar inscripcion")
	public void eliminar(@PathVariable Long id) {
    	manejadorEliminarInscripcion.ejecutar(id);
	}

	@PutMapping(value="/{id}")
	@ApiOperation("Actualizar inscripcion")
	public void actualizar(@RequestBody ComandoInscripcion comandoInscripcion,@PathVariable Long id) {
		comandoInscripcion.setId(id);
		manejadorActualizarInscripcion.ejecutar(comandoInscripcion);
	}
}
