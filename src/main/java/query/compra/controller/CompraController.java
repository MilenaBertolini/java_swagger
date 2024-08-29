package query.compra.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import query.compra.entity.Compra;
import query.compra.service.CompraService;

@RestController
@RequestMapping("/compras")
public class CompraController {

    @Autowired
    CompraService compraService;

    @Operation(summary = "Salva as compras")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Salva as compras",
        content = {@Content(mediaType = "application/json", 
        schema = @Schema(implementation = Compra.class))}),
        @ApiResponse(responseCode = "400", description = "Algo de errado ocorreu ao salvar compras!")
    })
    @PostMapping
    public Compra create(@RequestBody Compra compras){

        Compra compra = compraService.create(compras);
        return compra;
    }


    @Operation(summary = "Busca todas as compras")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Compras encontradas",
                     content = {@Content(mediaType = "application/json", 
                     schema = @Schema(implementation = Compra.class))}),
        @ApiResponse(responseCode = "204", description = "Nenhum registro de compra encontrado")
    })
    @GetMapping
    public List<Compra> getAll(){

        List<Compra> compras = compraService.getAll();
        return compras;
    }

    @Operation(summary = "Busca compras por desconto exato")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Compras encontradas",
                     content = {@Content(mediaType = "application/json", 
                     schema = @Schema(implementation = Compra.class))}),
        @ApiResponse(responseCode = "204", description = "Nenhuma compra encontrada para o desconto")
    })
    @GetMapping("/desconto/{desconto}")
    public List<Compra> getComprasPorDesconto(@PathVariable int desconto) {
        List<Compra> compras = compraService.findByDesconto(desconto);
        if (compras.isEmpty()) {
            return null;
        }
        return compras;
    }

    @Operation(summary = "Busca compras com desconto maior que o desconto fornecido")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Compras encontradas",
                     content = {@Content(mediaType = "application/json", 
                     schema = @Schema(implementation = Compra.class))}),
        @ApiResponse(responseCode = "204", description = "Nenhuma compra encontrada com desconto maior")
    })
    @GetMapping("/desconto/maior/{desconto}")
    public List<Compra> getComprasComDescontoMaior(@PathVariable int desconto) {
        List<Compra> compras = compraService.comprasComDesconto(desconto);
        if (compras.isEmpty()) {
            return null;
        }
        return compras;
    }

    @Operation(summary = "Busca todas as compras ordenadas por valor")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Todas as compras retornadas",
                     content = {@Content(mediaType = "application/json", 
                     schema = @Schema(implementation = Compra.class))}),
        @ApiResponse(responseCode = "204", description = "Nenhuma compra encontrada")
    })
    @GetMapping("/valor")
    public List<Compra> getAllComprasPorValor() {
        List<Compra> compras = compraService.getAllItemsPorValor();
        if (compras.isEmpty()) {
            return null;
        }
        return compras;
    }

    @Operation(summary = "Busca o produto mais vendido")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Produto mais vendido retornado",
                     content = {@Content(mediaType = "application/json", 
                     schema = @Schema(implementation = String.class))}),
        @ApiResponse(responseCode = "204", description = "Nenhum produto encontrado")
    })
    @GetMapping("/produto")
    public String getProdutoMaisVendido() {
        String produtoMaisVendido = compraService.getProdutoMaisVendido();

        if (produtoMaisVendido == null || produtoMaisVendido.isEmpty()) {
            return null;
        }
        return produtoMaisVendido;
    }

    @Operation(summary = "Busca notas fiscais com quantidade de produto maior que um valor")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Notas fiscais retornadas",
                     content = {@Content(mediaType = "application/json", 
                     schema = @Schema(implementation = Compra.class))}),
        @ApiResponse(responseCode = "204", description = "Nenhuma nota fiscal encontrada")
    })
    @GetMapping("/nota/{quantidade}")
    public List<Compra> getNfComQuantidadeMaior(@PathVariable Long quantidade) {
        List<Compra> compras = compraService.getNfComQuantidadeProdutoMaior(quantidade);
        if (compras.isEmpty()) {
            return null;
        }
        return compras;
    }

    @Operation(summary = "Busca notas fiscais com valor total maior que o especificado")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Notas fiscais retornadas",
                     content = {@Content(mediaType = "application/json", 
                     schema = @Schema(implementation = Compra.class))}),
        @ApiResponse(responseCode = "204", description = "Nenhuma nota fiscal encontrada")
    })
    @GetMapping("/nota/{valor}")
    public List<Compra> getNfComValorMaior(@PathVariable Double valor) {
        List<Compra> compras = compraService.getNfComQuantidadeProdutoMaior(valor);
        if (compras.isEmpty()) {
            return null;
        }
        return compras;
    }
}
