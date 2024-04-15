package br.easy.parking.configure;

import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * Classe responsável por configurar o Swagger.
 * Acesso padrão com configuração de desenvolvimento: http://localhost:{PORT}/swagger-ui/
 */
public class Swagger2Configuration {
    /**
     * Método responsável por retornar o nome do contexto da API para ser inserido no layout.
     * @return Mensagem que aparece na tela inicial do swagger.
     */
    public String getApiContext(){
        boolean isDebug = java.lang.management.ManagementFactory.getRuntimeMXBean().
                getInputArguments().toString().contains("-agentlib:jdwp");
        if (isDebug) {
            return "Debug Version. " +  new String(Character.toChars(0x1F41E));
        } else {
            return "Release Version. " +  new String(Character.toChars(0x1F407));
        }
    }

    /**
     * Método responsável por preencher os dados do layout do swagger.
     * @return usado por ferramenta interna do projeto.
     */
    public ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Easy Parking API" + new String(Character.toChars(0x1F36D)))
                .description(getApiContext())
                .license("MIT")
                .licenseUrl("https://pt.wikipedia.org/wiki/Licen%C3%A7a_MIT")
                .termsOfServiceUrl("")
                .version("1.0.0")
                .build();
    }
    /**
     * Método responsável por definir caminhos a serem incluídos por meio do swagger.
     * @return usado por ferramenta interna do projeto.
     */
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("br.easy.parking"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }
}
