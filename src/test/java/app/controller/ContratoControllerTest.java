package app.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import app.entity.Contrato;
import app.repository.ContratoRepository;

@SpringBootTest
public class ContratoControllerTest {

	@Autowired
	ContratoController controller;
	
	@MockBean
	ContratoRepository repository;
	
	@BeforeEach
	void setup() {
		List<Contrato> lista= new ArrayList<Contrato>();
		Contrato contrato= new Contrato();
		contrato.setId(1L);
		contrato.setIdentificador("indenti");
		
		Optional<Contrato> contratoid= Optional.of(contrato);
		lista.add(contrato);
		
		ContratoRepository repositoryMock = spy(ContratoRepository.class); 
		
		when(this.repository.findAll()).thenReturn(lista);
		when(this.repository.save(contrato)).thenReturn(contrato);
		when(this.repository.findById(1l)).thenReturn(contratoid);
		doNothing().when(repositoryMock).deleteById(1l);
	}
	
	@Test
	@DisplayName("Teste save")
	void testSave() {
		Contrato contrato= new Contrato();
		contrato.setId(1L);
		contrato.setIdentificador("indenti");
		
		ResponseEntity<String> response = this.controller.save(contrato);
		String msg = response.getBody();		
		
		assertEquals(contrato.getId() + "contrato salvo", msg);
	}

	@Test
	@DisplayName("Teste findById")
	void testFindById() {
		ResponseEntity<Contrato> response = this.controller.findById(1l);
		Contrato obj = response.getBody();
		
		assertEquals( 1, obj.getId());
	}
	
	@Test
	@DisplayName("Teste listAll")
	void testFndAll() {
		ResponseEntity<List<Contrato>> response = this.controller.listAll();
		List<Contrato> lista = response.getBody();
		
		assertEquals(1, lista.size());
	}
	
	@Test
	@DisplayName("Teste delete")
	void testDelete() {
		ResponseEntity<String> response = this.controller.delete(1l);
		String msg = response.getBody();
		
		assertEquals( "contrato deletado", msg);
	}
	
	@Test
	@DisplayName("Teste update")
	void testUpdate() {
		Contrato contrato= new Contrato();
		contrato.setId(1L);
		contrato.setIdentificador("indenti");
		
		ResponseEntity<String> response = this.controller.update(contrato, 1);
		String msg = response.getBody();
		
		assertEquals( contrato.getId()+ "atualizações salvas", msg);
	}
	
}

