package br.com.andersonfariasdev.mvc.mudi.api;

import br.com.andersonfariasdev.mvc.mudi.interceptor.AccessInterceptor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/acessos")
@RestController
public class AcessosRest {

    @GetMapping
    public List<AccessInterceptor.Acesso> getAcessos() {
        return AccessInterceptor.acessos;
    }
}
