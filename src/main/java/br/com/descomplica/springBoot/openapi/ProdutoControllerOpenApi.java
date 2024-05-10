package br.com.descomplica.springBoot.openapi;

import br.com.descomplica.springBoot.entity.Produto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

// Atribui tag ("título") ao controller
@Tag(name = "Produtos")
public interface ProdutoControllerOpenApi {

    // Métodos do ProdutoController (assinaturas)

    @Operation(summary = "Lista todos os produtos") // define um título para os protocolos
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ok", content = @Content(schema = @Schema(implementation = Produto.class))),
            @ApiResponse(responseCode = "500", description = "Internal Server Error",
                    content = @Content(schema = @Schema(example = "{\"error\": \"Erro ao listar Produtos\"}")))})
    public List<Produto> getAll();

    @Operation(summary = "Busca produto por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ok", content = @Content(schema = @Schema(implementation = Produto.class))),
            @ApiResponse(responseCode = "404", description = "Not Found",
                    content = @Content(schema = @Schema(example = "{\"message\": \"Produto não localizado\"}"))),
            @ApiResponse(responseCode = "500", description = "Internal Server Error",
                    content = @Content(schema = @Schema(example = "{\"error\": \"Erro ao buscar Produtos\"}")))})
    Produto getById(@PathVariable String id);

    @Operation(summary = "Cadastra produtos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Created",
                    content = @Content(schema = @Schema(implementation = Produto.class))),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content(schema = @Schema(example = "{\"message\": \"Verifique se os dados foram preenchidos corretamente\"}"))),
            @ApiResponse(responseCode = "500", description = "Internal Server Error",
                    content = @Content(schema = @Schema(example = "{\"error\": \"Erro ao cadastrar Produto\"}")))})
    Produto create(@RequestBody Produto produto);

    @Operation(summary = "Atualiza um produto com base no ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ok", content = @Content(schema = @Schema(implementation = Produto.class))),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content(schema = @Schema(example = "{\"message\": \"Verifique se os dados foram preenchidos corretamente\"}"))),
            @ApiResponse(responseCode = "404", description = "Not Found",
                    content = @Content(schema = @Schema(example = "{\"message\": \"Produto não localizado\"}"))),
            @ApiResponse(responseCode = "500", description = "Internal Server Error",
                    content = @Content(schema = @Schema(example = "{\"error\": \"Erro ao atualizar Produto\"}")))})
    Produto updateProduto(@PathVariable String id, @RequestBody Produto produto);

    @Operation(summary = "Exclui um produto com base no ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "No Content"),
            @ApiResponse(responseCode = "404", description = "Not Found",
                    content = @Content(schema = @Schema(example = "{\"message\": \"Produto não localizado\"}"))),
            @ApiResponse(responseCode = "500", description = "Internal Server Error",
                    content = @Content(schema = @Schema(example = "{\"message\": \"Erro ao excluir Produto\"}")))})
    void deleteProduto(@PathVariable String id);

}
