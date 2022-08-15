package digytal.hibernate.tuple.converter.entity;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tab_marca")
public class MarcaEntity {

    private Integer id;
    private String nome;
    private List<ProdutoEntity> produtos;

    public MarcaEntity() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(length = 50,nullable = false)
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="produto_id", referencedColumnName = "id")
    public List<ProdutoEntity> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ProdutoEntity> produtos) {
        this.produtos = produtos;
    }


}
