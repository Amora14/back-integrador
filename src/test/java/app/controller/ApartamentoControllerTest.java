package app.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

import app.entity.Apartamento;
import app.entity.Cliente;
import app.repository.ApartamentoRepository;

@SpringBootTest
public class ApartamentoControllerTest {
	@Autowired
	ApartamentoController apartamentoController;
	
	@MockBean
	ApartamentoRepository apartamentoRepository;
	
	@BeforeEach
	void setup() {
		List<Apartamento> lista = new ArrayList<>();
		Apartamento ap = new Apartamento();
			ap.setAparnum(110);
			ap.setFotos("listagem");
			ap.setStatus("livre");
			ap.setValorAluguel(1500.00);
			lista.add(new Apartamento());
			lista.add(new Apartamento());
			lista.add(new Apartamento());
			lista.add(new Apartamento());
			lista.add(new Apartamento());
		
			Optional<Apartamento> apId = Optional.of(ap);
			lista.add(ap);
			
		when(this.apartamentoRepository.findAll()).thenReturn(lista);
		when(this.apartamentoRepository.save(new Apartamento())).thenReturn(lista.get(1));
		when(this.apartamentoRepository.findById(1)).thenReturn(apId);
	}
	
	@Test
	@DisplayName("test de Integração com mokito no listAll ap")
	void mokitoApartamentoListAll() {
		ResponseEntity<List<Apartamento>> response = this.apartamentoController.listAll();
		List<Apartamento> lista = response.getBody();
		
		assertEquals(6, lista.size());
	}
	
	@Test
	@DisplayName("Teste findById ap")
	void testFindById() {
		ResponseEntity<Apartamento> response = this.apartamentoController.findById(1);
		Apartamento obj = response.getBody();
		
		assertEquals( 110, obj.getAparnum());
	}
	
	@Test
	@DisplayName("Teste save ap")
	void testSave() {
		Apartamento ap = new Apartamento();
		ap.setAparnum(110);
		ap.setFotos("listagem");
		ap.setStatus("livre");
		ap.setValorAluguel(1500.00);
		
		ResponseEntity<String> response = this.apartamentoController.save(ap);
		String msg = response.getBody();
		
		assertEquals(ap.getAparnum()+" Salvo com sucesso" + ap.getStatus(), msg);
			
	}
	
	@Test
	@DisplayName("Teste delete ap")
	void testDelete() {
		ResponseEntity<String> response = this.apartamentoController.delete(1);
		String msg = response.getBody();
		
		assertEquals( " Apartamento deletado com sucesso", msg);
	}
	
	@Test
	@DisplayName("Teste update")
	void testUpdate() {
		Apartamento ap = new Apartamento();
		ap.setAparnum(110);
		ap.setFotos("listagem");
		ap.setStatus("livre");
		ap.setValorAluguel(1500.00);
		
		ResponseEntity<String> response = this.apartamentoController.update(ap, 110);
		String msg = response.getBody();
		
		assertEquals(" Apartamento alterado com sucesso", msg);
		}

}