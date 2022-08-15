package digytal.hibernate.tuple.converter.dto;

public class ProdutoCriteriaDTO {

    private Integer produtoId;
    private String  produtoNome;
    private Integer marcaId;
    private String  marcaNome;

    public ProdutoCriteriaDTO() {
    }

    public ProdutoCriteriaDTO(Integer produtoId, String produtoNome, Integer marcaId, String marcaNome) {
        this.produtoId = produtoId;
        this.produtoNome = produtoNome;
        this.marcaId = marcaId;
        this.marcaNome = marcaNome;
    }

    public Integer getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Integer produtoId) {
        this.produtoId = produtoId;
    }

    public String getProdutoNome() {
        return produtoNome;
    }

    public void setProdutoNome(String produtoNome) {
        this.produtoNome = produtoNome;
    }

    public Integer getMarcaId() {
        return marcaId;
    }

    public void setMarcaId(Integer marcaId) {
        this.marcaId = marcaId;
    }

    public String getMarcaNome() {
        return marcaNome;
    }

    public void setMarcaNome(String marcaNome) {
        this.marcaNome = marcaNome;
    }
}
