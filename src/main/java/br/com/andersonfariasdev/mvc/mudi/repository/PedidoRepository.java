package br.com.andersonfariasdev.mvc.mudi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.andersonfariasdev.mvc.mudi.enumerator.StatusPedido;
import br.com.andersonfariasdev.mvc.mudi.model.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

	List<Pedido> findByStatus(StatusPedido aguardando);

	@Query("select p from Pedido p join p.user u where u.username = :username")
	List<Pedido> findAllByUsuario(@Param("username") String username);
}
