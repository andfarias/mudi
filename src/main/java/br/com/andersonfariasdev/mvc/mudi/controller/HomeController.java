package br.com.andersonfariasdev.mvc.mudi.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.andersonfariasdev.mvc.mudi.model.Pedido;

@Controller
public class HomeController {
	@GetMapping("/home")
	public String home(Model model) {
		Pedido pedido = new Pedido();
		pedido.setNomeProduto("Monitor gamer AOC G2 27G2HE5 led 27");
		pedido.setDescricao("Monitor");
		pedido.setUrlImagem("https://http2.mlstatic.com/D_NQ_NP_2X_604119-MLA47584909551_092021-F.webp");
		pedido.setUrlProduto("https://www.mercadolivre.com.br/monitor-gamer-aoc-g2-27g2he5-led-27-preto-e-vermelho-100v240v/p/MLB18333881?pdp_filters=category:MLB99245#searchVariation=MLB18333881&position=5&search_layout=grid&type=product&tracking_id=462aaedf-9aa9-4ddf-94ff-4803ad5345d4");
		
		List<Pedido> pedidos = Arrays.asList(pedido);
		model.addAttribute("pedidos", pedidos);
		
		return "home";
	}
}
