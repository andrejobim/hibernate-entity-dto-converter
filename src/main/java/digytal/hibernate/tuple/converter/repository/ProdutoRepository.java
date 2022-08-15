package digytal.hibernate.tuple.converter.repository;

import digytal.hibernate.tuple.converter.entity.ProdutoEntity;
import digytal.hibernate.tuple.converter.repository.projector.ProdutoProjector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoEntity, Integer> {

    @Query(value = "SELECT p.id as id, p.nome as nome, m.id as marcaId, m.nome as marcaNome " +
            " FROM tab_produto p " +
            " INNER JOIN tab_marca m ON p.marca_id = m.id", nativeQuery = true)
    List<ProdutoProjector> findAllProdutoUsingProjector();



}
