package br.com.andersonfariasdev.mvc.mudi.api;

import br.com.andersonfariasdev.mvc.mudi.dto.RequisicaoOferta;
import br.com.andersonfariasdev.mvc.mudi.model.Oferta;
import br.com.andersonfariasdev.mvc.mudi.model.Pedido;
import br.com.andersonfariasdev.mvc.mudi.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/ofertas")
public class OfertaRest {

    @Autowired
    private PedidoRepository pedidoRepository;

    @PostMapping
    public Oferta criaOferta(@RequestBody RequisicaoOferta requisicao) {
        Optional<Pedido> pedidoBuscado = pedidoRepository.findById(requisicao.getPedidoId());
        if(pedidoBuscado.isEmpty()) {
            return null;
        }

        Pedido pedido = pedidoBuscado.get();

        Oferta nova = requisicao.toOferta();
        nova.setPedido(pedido);
        pedido.getOfertas().add(nova);
        pedidoRepository.save(pedido);

        return nova;
    }
}
