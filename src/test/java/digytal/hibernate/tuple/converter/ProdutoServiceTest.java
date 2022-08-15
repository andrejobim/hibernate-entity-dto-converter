package digytal.hibernate.tuple.converter;

import digytal.hibernate.tuple.converter.dto.MarcaDTO;
import digytal.hibernate.tuple.converter.dto.ProdutoDTO;
import digytal.hibernate.tuple.converter.service.ProdutoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class ProdutoServiceTest {

    private final ProdutoService produtoService;
    private static ProdutoDTO produto = null;

    @Autowired
    public ProdutoServiceTest(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @BeforeEach
    public void init(){
        MarcaDTO marca = new MarcaDTO();
        marca.setNome("Nome Marca");

        produto = new ProdutoDTO();
        produto.setNome("Nome Produto");
        produto.setMarca(marca);

        produtoService.save(produto);
    }

    @Test
    void shouldFindlAllWithProjector(){
        assertEquals(produtoService.findAllProdutoUsingProjector().get(0).getNome(), produto.getNome());
        assertEquals(produtoService.findAllProdutoUsingProjector().get(0).getMarcaNome(), produto.getMarca().getNome());
    }

    @Test
    void shouldFindlAllWithCriteria(){
        assertEquals(produtoService.findAllProdutoUsingCriteria().get(0).getProdutoNome(), produto.getNome());
        assertEquals(produtoService.findAllProdutoUsingCriteria().get(0).getMarcaNome(), produto.getMarca().getNome());
    }

    @Test
    void shouldFindlAllWithNative(){
        assertEquals(produtoService.findAllProdutoUsingNative().get(0).getNome(), produto.getNome());
        assertEquals(produtoService.findAllProdutoUsingNative().get(0).getMarca().getNome(), produto.getMarca().getNome());
    }

}
