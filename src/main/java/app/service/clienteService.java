package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Apartamento;
import app.entity.Cliente;
import app.repository.ApartamentoRepository;
import app.repository.ClienteRepository;

@Service
public class clienteService {
	
	@Autowired
	private ClienteRepository repository;
	@Autowired
	private ApartamentoRepository aprepository;

	
	public String save (Cliente cliente) {
		
		Apartamento ap= aprepository.findById(cliente.getAp().getAparnum()).get();
		ap.setStatus(cliente.getNome());
		aprepository.save(ap);		
		cliente.setAp(ap);
		
		this.repository.save(cliente);
		return cliente.getNome()+ " salvo";
	}
	
	public String update(Cliente cliente, Long id) {
		cliente.setId(id);
		this.repository.save(cliente);
		return cliente.getNome()+ "atualizações salvas";
	}
	
	public String delete (long id) {
		this.repository.deleteById(id);
		return "locatario deletado";
	}
	
	public List<Cliente> listAll(){
		return this.repository.findAll();
	}
	
	public Cliente findById(long idCliente) {
		Cliente cliente = this.repository.findById(idCliente).get();
		return cliente;
	}
	
	public List<Cliente> findByNome(String nome){
		return this.repository.findByNome(nome);
	}
	
}
