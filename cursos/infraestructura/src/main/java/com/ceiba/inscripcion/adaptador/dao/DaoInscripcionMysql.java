package com.ceiba.inscripcion.adaptador.dao;

import java.util.List;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.inscripcion.modelo.dto.DtoInscripcion;
import com.ceiba.inscripcion.puerto.dao.DaoInscripcion;

import org.springframework.stereotype.Component;


@Component
public class DaoInscripcionMysql implements DaoInscripcion{

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="inscripcion", value="listar")
    private static String sqlListar;

    public DaoInscripcionMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoInscripcion> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoInscripcion());
    }
}
