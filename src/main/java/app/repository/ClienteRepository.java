package app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import app.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	public List<Cliente> findByNome(String nome);
}
