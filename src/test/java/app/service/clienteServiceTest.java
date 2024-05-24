package app.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import app.entity.Cliente;
@SpringBootTest
public class clienteServiceTest {
  @Autowired
  clienteService meuClienteService;

  @BeforeEach
  void limpaDB(){
    List<Cliente> lixo = meuClienteService.listAll();
    for(Cliente c : lixo){
      meuClienteService.delete(c.getId());
    }
  }
  public void criarFreds(int tamanho){
    for(int i = 0; i< tamanho; i++){
      Cliente c = new Cliente();
      c.setNome("fred"+ i);
      c.setCpf(i);
      c.setTelefone(9000 - i);
      c.setEntrada("500.000");
      c.setNascimento("01/01/1970");
      meuClienteService.save(c);
    }
  }

  @Test
  @DisplayName("testa se salva e recupera")
  void testSaVeFind(){
    criarFreds(100);
    assertEquals(100, meuClienteService.listAll().size());
  }

  @Test
  @DisplayName("testa que update não modifica número de clientes")
  void testClientesNaoModificado(){
    criarFreds(50);
    List<Cliente> data = meuClienteService.listAll();
  
    for(Cliente fred : data){
      meuClienteService.update(data.get(0),fred.getId());
    }
    assertEquals(50,meuClienteService.listAll().size());
  }
}
