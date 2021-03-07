package com.ceiba.inscripcion.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.inscripcion.modelo.entidad.Inscripcion;
import com.ceiba.inscripcion.puerto.repositorio.RepositorioInscripcion;
import com.ceiba.usuario.modelo.entidad.Usuario;

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
    
    @SqlStatement(namespace="inscripcion", value="numeroInscritos")
    private static String sqlNumeroInscritos;
    
    @SqlStatement(namespace="inscripcion", value="actualizarCreditos") 
    private static String actualizarCreditos;
    
    @SqlStatement(namespace="inscripcion", value="retornarCreditos") 
    private static String retornarCreditos;


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

	@Override
	public int numeroInscritos(Long curso) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("curso", curso);
		
		return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlNumeroInscritos,paramSource, Integer.class);
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

}
