package digytal.hibernate.tuple.converter.controller;

import digytal.hibernate.tuple.converter.entity.ProdutoEntity;
import digytal.hibernate.tuple.converter.dto.ProdutoCriteriaDTO;
import digytal.hibernate.tuple.converter.dto.ProdutoDTO;
import digytal.hibernate.tuple.converter.repository.projector.ProdutoProjector;
import digytal.hibernate.tuple.converter.service.ProdutoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping
    public void save(@RequestBody ProdutoDTO produto){
        produtoService.save(produto);
    }

    @GetMapping(value = "/projection")
    public List<ProdutoProjector> findAllProjection(){
        return  produtoService.findAllProdutoUsingProjector();
    }

    @GetMapping(value = "/criteria")
    public List<ProdutoCriteriaDTO> findAllCriteria(){
        return  produtoService.findAllProdutoUsingCriteria();
    }

    @GetMapping(value = "/native")
    public List<ProdutoEntity> findAllNative(){
        return produtoService.findAllProdutoUsingNative();
    }
}
