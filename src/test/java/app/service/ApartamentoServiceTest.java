/*package app.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import app.entity.Apartamento;

@SpringBootTest
public class ApartamentoServiceTest {
	@Autowired
	ApartamentoService apartamentoService;
	
	
	@Test
	@DisplayName("test verifica Status ocupado")
	void testVerificaStatusOcupado() {
		Apartamento apartamento = new Apartamento();
		apartamento.setStatus("OCUPADO");
		apartamento.setValorAluguel((double) 100);
		
	//	Apartamento retorno = this.apartamentoService.verificaStatus(apartamento);
		
	//	assertEquals("OCUPADO", retorno.getStatus());
	}
	
	
	@Test
	@DisplayName("Testa se o status do apartamento é livre")
	void testVerificaStatusLivre() {
	    Apartamento apartamento = new Apartamento();
	    apartamento.setStatus("LIVRE");
	 //   Apartamento retorno = this.apartamentoService.verificaStatus(apartamento);

	//    assertEquals("LIVRE", retorno.getStatus());
	}
	
	@Test
	@DisplayName("test verifica status exception")
	void testVerificaStatusException() {
		Apartamento apartamento = new Apartamento();
		apartamento.setStatus("");
		
	//	assertThrows(Exception.class, () ->{ Apartamento obj = this.apartamentoService.verificaStatus(apartamento);
	//	});
	}
	

    @Test
    @DisplayName("aparnum exception")
    void testFindByAparnumException() {
  //  		    assertThrows(RuntimeException.class, () -> apartamentoService.findByAparnum(0));
  //  	}

}
*/