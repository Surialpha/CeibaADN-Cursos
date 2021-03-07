package com.ceiba.usuario.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;

import java.time.LocalDateTime;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioUsuarioMysql implements RepositorioUsuario {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="usuario", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace="usuario", value="actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace="usuario", value="eliminar")
    private static String sqlEliminar;

    @SqlStatement(namespace="usuario", value="existe")
    private static String sqlExiste;

    @SqlStatement(namespace="usuario", value="existeExcluyendoId") 
    private static String sqlExisteExcluyendoId;
    
    @SqlStatement(namespace="usuario", value="actualizarCreditos") 
    private static String actualizarCreditos;
    
    @SqlStatement(namespace="usuario", value="ingresoDia") 
    private static String sqlingresoDia;
    
    @SqlStatement(namespace="usuario", value="retornarCreditos") 
    private static String retornarCreditos;

    public RepositorioUsuarioMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Usuario usuario) {
        return this.customNamedParameterJdbcTemplate.crear(usuario, sqlCrear);
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, paramSource);
    }

    @Override
    public boolean existe(Long cedula) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("cedula", cedula);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste,paramSource, Boolean.class);
    }

    @Override
    public void actualizar(Usuario usuario) {
        this.customNamedParameterJdbcTemplate.actualizar(usuario, sqlActualizar);
    }

    @Override
    public boolean existeExcluyendoId(Long id, Long cedula) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        paramSource.addValue("cedula", cedula);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteExcluyendoId,paramSource, Boolean.class);
    }

	@Override
	public Long existeDia(LocalDateTime fecha) {
		 MapSqlParameterSource paramSource = new MapSqlParameterSource();
	     paramSource.addValue("fecha_creacion", fecha);
	     return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlingresoDia,paramSource,Long.class);
	}

	@Override
	public void cederCreditos(Usuario usuario) {
		 this.customNamedParameterJdbcTemplate.actualizar(usuario, actualizarCreditos);
	}

	@Override
	public float retornarCreditos(Long id) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(retornarCreditos, paramSource ,Float.class);
	}

	@Override
	public void sumarCreditos(Long id, float creditos) {
		Usuario usuario = new Usuario(id,creditos);
        this.customNamedParameterJdbcTemplate.actualizar(usuario, actualizarCreditos);
	}
}
