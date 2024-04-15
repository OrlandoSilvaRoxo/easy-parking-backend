package br.easy.parking.controller;

import br.easy.parking.utils.SwaggerExamples;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

/**
 * Classe responsável por implementar o Controller de uma página de redirecionamento na raiz da porta.
 */
@Configuration
@RestController
@ApiIgnore //Anotação do swagger para ignorar este controller.
public class HomeController {

    /**
     * Método responsável por retornar uma página html que redireciona a raiz da porta ao url do swagger.
     */
    @RequestMapping("/")
    public String index() {
        return SwaggerExamples.REDIRECTPAGE;
    }
}
