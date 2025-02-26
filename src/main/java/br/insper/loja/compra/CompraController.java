package br.insper.loja.compra;

import br.insper.loja.produto.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/compra")
public class CompraController {

    @Autowired
    private CompraService compraService;

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public List<Compra> getCompras() { return compraService.getCompras(); }

    @PostMapping
    public Compra salvarCompra(@RequestBody Compra compra) {
        return compraService.salvarCompra(compra);
    }
}