package br.com.andersonfariasdev.mvc.mudi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.andersonfariasdev.mvc.mudi.model.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
