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

import app.entity.Apartamento;
import app.entity.Cliente;
import app.repository.ClienteRepository;

@SpringBootTest
public class ClientecontrollerTest {

	@Autowired
	ClienteController contoller;
	
	@MockBean
	ClienteRepository repository;
	
	@BeforeEach
	void cenario21() {
		List<Cliente> list = new ArrayList<Cliente>();
		Cliente cliente = new Cliente();
		Apartamento apartamento = new Apartamento();
		cliente.setCpf(89l);
		cliente.setProfissao("gari");
		cliente.setId(1);
		cliente.setEntrada("entrada teste");
		cliente.setNascimento("8374");
		cliente.setRg(29293921l);
		cliente.setNome("Cliente teste");
		cliente.setTelefone(9190291l);
		apartamento.setAparnum(14);
		cliente.setAp(apartamento);
		
		Optional<Cliente> clienteId = Optional.of(cliente);
		list.add(cliente);
		
		ClienteRepository repositoryMock = spy(ClienteRepository.class);
		
		when(this.repository.findAll()).thenReturn(list);
		when(this.repository.save(cliente)).thenReturn(cliente);
		when(this.repository.findById(1l)).thenReturn(clienteId);
		when(this.repository.findByNome("Teste")).thenReturn(list);
		doNothing().when(repositoryMock).deleteById(1l);
		
	
	}
	
	@Test
	@DisplayName("Teste listAll")
	void testFndAll() {
		ResponseEntity<List<Cliente>> response = this.contoller.listAll();
		List<Cliente> lista = response.getBody();
		
		assertEquals(1, lista.size());
	}
/*		
	@Test
	@DisplayName("Teste save")
	void testSave() {
		Cliente cliente = new Cliente();
		Apartamento apartamento = new Apartamento();
		cliente.setCpf(89l);
		cliente.setProfissao("gari");
		cliente.setId(1l);
		cliente.setEntrada("entrada teste");
		cliente.setRg(29293921l);
		cliente.setNome("Cliente teste");
		cliente.setTelefone(9190291l);
		cliente.setNascimento("8374");
		apartamento.setAparnum(14);
		cliente.setAp(apartamento);
		
		list.add(cliente);
		ResponseEntity<String> response = this.contoller.save(cliente);
		String msg = response.getBody();
		
		assertEquals(cliente.getNome()+ " salvo", msg);
	}
	*/

	@Test
	@DisplayName("Teste findById")
	void testFindById() {
		ResponseEntity<Cliente> response = this.contoller.findById(1l);
		Cliente obj = response.getBody();
		
		assertEquals( 1, obj.getId());
	}
	
	@Test
	@DisplayName("Teste update")
	void testUpdate() {
		Cliente cliente = new Cliente();
		Apartamento apartamento = new Apartamento();
		cliente.setCpf(89l);
		cliente.setProfissao("gari");
		cliente.setId(1l);
		cliente.setEntrada("entrada teste");
		cliente.setRg(29293921l);
		cliente.setNome("Cliente teste");
		cliente.setTelefone(9190291l);
		cliente.setNascimento("8374");
		apartamento.setAparnum(14);
		cliente.setAp(apartamento);
		
		ResponseEntity<String> response = this.contoller.update(cliente, 1);
		String msg = response.getBody();
		
		assertEquals(cliente.getNome()+ "atualizações salvas", msg);
	}

	@Test
	@DisplayName("Teste delete")
	void testDelete() {
		ResponseEntity<String> response = this.contoller.delete(1l);
		String msg = response.getBody();
		
		assertEquals( "locatario deletado", msg);
	}
	
}

