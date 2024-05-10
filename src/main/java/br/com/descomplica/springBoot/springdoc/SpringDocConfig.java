package br.com.descomplica.springBoot.springdoc;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.tags.Tag;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class SpringDocConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("CRUD de Produto e Categoria")
                        .version("v1")
                        .description("Trata de uma API REST desenvolvida " +
                                "como parte avaliativa da disciplina Prática Integradora" +
                                "Tecnologias Disruptivas do curso de ADS. O objetivo principal" +
                                " da atividade está na documentação do projeto por meio do springdoc.")
                        .contact(new Contact()
                                .name("Vitor Hugo")
                                .email("vitor.2333313@aluno.faculdadedescomplica.com.br"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("https:springdoc.org"))
                ).externalDocs(new ExternalDocumentation()
                        .description("Github (repositório do projeto):")
                        .url("https://github.com/ViHugo21/")
                ).tags(
                        Arrays.asList(
                                new Tag().name("Produtos").description(""),
                                new Tag().name("Categorias").description("")
                        )
                );
    }


}
