import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springdoc.core.models.GroupedOpenApi;

@Configuration
public class OpenApiConfig {

    @Bean
    public GroupedOpenApi ProdutoApi() {
        return GroupedOpenApi.builder()
                .group("Produtos")
                .pathsToMatch("/produtos/**")
                .build();
    }

    @Bean
    public GroupedOpenApi UsuarioApi() {
        return GroupedOpenApi.builder()
                .group("Usuario")
                .pathsToMatch("/usuarios/**")
                .build();
    }

    @Bean
    public GroupedOpenApi VendasApi() {
        return GroupedOpenApi.builder()
                .group("Vendas")
                .pathsToMatch("/vendas/**")
                .build();
    }
}
