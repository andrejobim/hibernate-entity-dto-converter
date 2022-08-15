package digytal.hibernate.tuple.converter.entity;

import javax.persistence.*;

@Entity
@Table(name = "tab_produto")
public class ProdutoEntity {

    private Integer id;
    private String nome;
    private MarcaEntity marca;

    public ProdutoEntity() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(length = 80,nullable = false)
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    public MarcaEntity getMarca() {
        return marca;
    }

    public void setMarca(MarcaEntity marca) {
        this.marca = marca;
    }
}
