package digytal.hibernate.tuple.converter.repository;

import digytal.hibernate.tuple.converter.entity.MarcaEntity;
import digytal.hibernate.tuple.converter.entity.ProdutoEntity;
import digytal.hibernate.tuple.converter.dto.ProdutoCriteriaDTO;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.List;

@Repository
public class ProdutoConverterRepository {

    @PersistenceContext
    public EntityManager em;

    public List<ProdutoCriteriaDTO> findAllProdutoUsingCriteria(){
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<ProdutoCriteriaDTO> criteriaQuery = criteriaBuilder.createQuery(ProdutoCriteriaDTO.class);
        Root<ProdutoEntity> root = criteriaQuery.from(ProdutoEntity.class);
        Join<ProdutoEntity, MarcaEntity> marca = root.join("marca",JoinType.LEFT);

        Path<Integer> produtoId = root.get("id");
        Path<String> produtoNome = root.get("nome");
        Path<Integer> marcaId = marca.get("id");
        Path<String> marcaNome = marca.get("nome");

        criteriaQuery.multiselect(produtoId, produtoNome, marcaId, marcaNome);

        TypedQuery<ProdutoCriteriaDTO> query = em.createQuery(criteriaQuery);
        return query.getResultList();
    }


    public List<ProdutoEntity> findAllProdutoUsingNative(){
        String sql = "SELECT * FROM tab_produto p INNER JOIN tab_marca m ON p.marca_id = m.id";
        Query query = em.createNativeQuery(sql, ProdutoEntity.class);
        return query.getResultList();
    }


}
