package com.ceiba.usuario.adaptador.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.usuario.modelo.dto.DtoUsuario;
import org.springframework.jdbc.core.RowMapper;

public class MapeoUsuario implements RowMapper<DtoUsuario>, MapperResult {

    @Override
    public DtoUsuario mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        Long cedula = resultSet.getLong("cedula");
        String nombre = resultSet.getString("nombre");
        LocalDateTime fecha = extraerLocalDateTime(resultSet, "fecha_creacion");
        LocalDateTime fecha_nacimiento = extraerLocalDateTime(resultSet, "fecha_nacimiento");
        

        return new DtoUsuario(id,cedula,nombre,fecha,fecha_nacimiento);
    }

}
