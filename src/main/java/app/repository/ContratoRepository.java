package app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

import app.entity.Contrato;

public interface ContratoRepository extends JpaRepository<Contrato, Long>{

	public List<Contrato> findByIdentificador (String identificador);
	
}
