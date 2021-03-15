package com.ceiba.inscripcion.adaptador.dao;

import java.util.List;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.inscripcion.modelo.dto.DtoInscripcion;
import com.ceiba.inscripcion.puerto.dao.DaoInscripcion;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;


@Component
public class DaoInscripcionMysql implements DaoInscripcion{

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="inscripcion", value="listar")
    private static String sqlListar;
    
    @SqlStatement(namespace="inscripcion", value="listarBy")
    private static String sqlListarBy;
    
    @SqlStatement(namespace="inscripcion", value="listarByUser")
    private static String sqlListarByUser;

    public DaoInscripcionMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoInscripcion> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoInscripcion());
    }

	@Override
	public List<DtoInscripcion> listarBy(Long id) {
			 MapSqlParameterSource paramSource = new MapSqlParameterSource();
		     paramSource.addValue("id", id);
		     return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query( sqlListarBy ,paramSource ,new MapeoInscripcion() );

	}

	@Override
	public List<DtoInscripcion> listarByUser(Long usuario) {
			 MapSqlParameterSource paramSource = new MapSqlParameterSource();
		     paramSource.addValue("usuario", usuario);
		     return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query( sqlListarByUser ,paramSource ,new MapeoInscripcion() );
		
	}
}
