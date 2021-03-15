package com.ceiba.inscripcion.adaptador.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.inscripcion.modelo.dto.DtoInscripcion;
import org.springframework.jdbc.core.RowMapper;

public class MapeoInscripcion implements RowMapper<DtoInscripcion>, MapperResult {

    @Override
    public DtoInscripcion mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        Long usuario = resultSet.getLong("usuario");
        Long curso = resultSet.getLong("curso");
        Float valor = resultSet.getFloat("valor");
        LocalDate fechaInscripcion = extraerLocalDate(resultSet, "fecha_inscripcion");
        Float creditos = resultSet.getFloat("creditos");
        String nombre = resultSet.getString("nombre");

        return new DtoInscripcion(id,usuario,curso,valor,fechaInscripcion,nombre,creditos);
    }

}
