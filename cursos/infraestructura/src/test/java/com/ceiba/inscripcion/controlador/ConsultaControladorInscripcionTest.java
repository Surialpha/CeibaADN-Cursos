package com.ceiba.inscripcion.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.usuario.controlador.ConsultaControladorUsuario;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes= ApplicationMock.class)
@WebMvcTest(ConsultaControladorUsuario.class)
public class ConsultaControladorInscripcionTest {

    @Autowired
    private MockMvc mocMvc;

    @Test
    public void listar() throws Exception {
        // arrange

        // act - assert
        mocMvc.perform(get("/inscripcion")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].usuario", is(1)))
                .andExpect(jsonPath("$[0].curso", is(1)))
                .andExpect(jsonPath("$[0].valor", is(100.0)))
                .andExpect(jsonPath("$[0].fechaInscripcion", is(LocalDate.now().toString())));
    }
    
    @Test
    public void listarBy() throws Exception {
        // arrange
    	Long id = 1L;
        // act - assert
        mocMvc.perform(get("/inscripcion/{id}",id)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].usuario", is(1)))
                .andExpect(jsonPath("$[0].curso", is(1)))
                .andExpect(jsonPath("$[0].valor", is(100.0)))
                .andExpect(jsonPath("$[0].fechaInscripcion", is(LocalDate.now().toString())));
    }



}
