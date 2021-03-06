package com.ceiba.inscripcion.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.inscripcion.modelo.entidad.Inscripcion;
import com.ceiba.inscripcion.puerto.repositorio.RepositorioInscripcion;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioInscripcionMysql implements RepositorioInscripcion {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="inscripcion", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace="inscripcion", value="actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace="inscripcion", value="eliminar")
    private static String sqlEliminar;


    public RepositorioInscripcionMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Inscripcion inscripcion) {
        return this.customNamedParameterJdbcTemplate.crear(inscripcion, sqlCrear);
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, paramSource);
    }


    @Override
    public void actualizar(Inscripcion inscripcion) {
        this.customNamedParameterJdbcTemplate.actualizar(inscripcion, sqlActualizar);
    }

   

}
