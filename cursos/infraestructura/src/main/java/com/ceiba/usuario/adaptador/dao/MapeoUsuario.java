package com.ceiba.usuario.adaptador.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.usuario.modelo.dto.DtoUsuario;
import org.springframework.jdbc.core.RowMapper;

public class MapeoUsuario implements RowMapper<DtoUsuario>, MapperResult {

    @Override
    public DtoUsuario mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        Long cedula = resultSet.getLong("cedula");
        String nombre = resultSet.getString("nombre");
        LocalDate fecha = extraerLocalDate(resultSet, "fecha_creacion");
        LocalDate fechaNacimiento = extraerLocalDate(resultSet, "fecha_nacimiento");
        float creditos = resultSet.getFloat("creditos");
        

        return new DtoUsuario(id,cedula,nombre,creditos,fecha,fechaNacimiento);
    }

}
