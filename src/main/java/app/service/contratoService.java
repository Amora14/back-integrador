package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Contrato;
import app.repository.ContratoRepository;

@Service
public class contratoService {

	@Autowired
	private ContratoRepository repository;
	
	public String save (Contrato contrato) {
		this.repository.save(contrato);
		return contrato.getId()+ "contrato salvo";
	}
	
	public String update(Contrato contrato, Long id) {
		contrato.setId(id);
		this.repository.save(contrato);
		return contrato.getId()+ "atualizações salvas";
	}
	
	public String delete (long id) {
		this.repository.deleteById(id);
		return "contrato deletado";
	}
	
	public List<Contrato> listAll(){
		return this.repository.findAll();
	}
	
	public 	Contrato findById(long id) {
		Contrato contrato = this.repository.findById(id).get();
		return contrato;
	}
	
	public List<Contrato> findByIdentificador(String identificador) {
		return this.repository.findByIdentificador(identificador);
		
	}
	
}
