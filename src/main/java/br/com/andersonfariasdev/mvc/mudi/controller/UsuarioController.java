package br.com.andersonfariasdev.mvc.mudi.controller;

import br.com.andersonfariasdev.mvc.mudi.enumerator.StatusPedido;
import br.com.andersonfariasdev.mvc.mudi.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @GetMapping("pedido")
    public String home(Model model, Principal principal) {
        model.addAttribute("pedidos", pedidoRepository.findAllByUsuario(principal.getName()));
        return "usuario/home";
    }

    @GetMapping("pedido/{status}")
    public String status(@PathVariable("status") String status, Model model, Principal principal) {
        model.addAttribute("pedidos",
                pedidoRepository.findByStatusAndUsuario(StatusPedido.valueOf(status.toUpperCase()), principal.getName()));
        model.addAttribute("status", status);
        return "usuario/home";
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public String onError() {
        return "redirect:/usuario/home";
    }
}
