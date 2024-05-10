package br.com.descomplica.springBoot.openapi;

import br.com.descomplica.springBoot.entity.Categoria;
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

@Tag(name = "Categorias")
public interface CategoriaControllerOpenApi {

    @Operation(summary = "Lista todas as categorias") // define um título para os protocolos
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ok", content = @Content(schema = @Schema(implementation = Categoria.class))),
            @ApiResponse(responseCode = "500", description = "Internal Server Error",
                    content = @Content(schema = @Schema(example = "{\"error\": \"Erro ao listar Categorias\"}")))})
    List<Categoria> getAll();

    @Operation(summary = "Lista todos os produtos com base em uma categoria")
    List<Produto> getAllByCategoryId(@PathVariable String id);

    @Operation(summary = "Busca categoria por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ok", content = @Content(schema = @Schema(implementation = Categoria.class))),
            @ApiResponse(responseCode = "404", description = "Not Found",
                    content = @Content(schema = @Schema(example = "{\"message\": \"Categoria não localizada\"}"))),
            @ApiResponse(responseCode = "500", description = "Internal Server Error",
                    content = @Content(schema = @Schema(example = "{\"error\": \"Erro ao buscar Categorias\"}")))})
    Categoria getById(@PathVariable String id);


    @Operation(summary = "Cadastra Categoria")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Created",
                    content = @Content(schema = @Schema(implementation = Categoria.class))),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content(schema = @Schema(example = "{\"message\": \"Verifique se os dados foram preenchidos corretamente\"}"))),
            @ApiResponse(responseCode = "500", description = "Internal Server Error",
                    content = @Content(schema = @Schema(example = "{\"error\": \"Erro ao cadastrar Categoria\"}")))})
    Categoria create(@RequestBody Categoria categoria);


    @Operation(summary = "Atualiza um categoria com base no ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ok", content = @Content(schema = @Schema(implementation = Categoria.class))),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content(schema = @Schema(example = "{\"message\": \"Verifique se os dados foram preenchidos corretamente\"}"))),
            @ApiResponse(responseCode = "404", description = "Not Found",
                    content = @Content(schema = @Schema(example = "{\"message\": \"Categoria não localizado\"}"))),
            @ApiResponse(responseCode = "500", description = "Internal Server Error",
                    content = @Content(schema = @Schema(example = "{\"error\": \"Erro ao atualizar Categoria\"}")))})
    Categoria updateCategoria(@PathVariable String id, @RequestBody Categoria categoria);


    @Operation(summary = "Exclui um categoria com base no ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "No Content"),
            @ApiResponse(responseCode = "404", description = "Not Found",
                    content = @Content(schema = @Schema(example = "{\"message\": \"Categoria não localizado\"}"))),
            @ApiResponse(responseCode = "500", description = "Internal Server Error",
                    content = @Content(schema = @Schema(example = "{\"message\": \"Erro ao excluir Categoria\"}")))})
    void deleteCategoria(String id);

}
