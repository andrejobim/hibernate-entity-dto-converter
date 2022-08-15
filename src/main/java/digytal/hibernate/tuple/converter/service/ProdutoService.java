package digytal.hibernate.tuple.converter.service;

import digytal.hibernate.tuple.converter.entity.ProdutoEntity;
import digytal.hibernate.tuple.converter.dto.ProdutoCriteriaDTO;
import digytal.hibernate.tuple.converter.dto.ProdutoDTO;
import digytal.hibernate.tuple.converter.repository.projector.ProdutoProjector;

import java.util.List;

public interface ProdutoService {

    void save(ProdutoDTO produto);

    List<ProdutoProjector> findAllProdutoUsingProjector();

    List<ProdutoCriteriaDTO> findAllProdutoUsingCriteria();

    List<ProdutoEntity> findAllProdutoUsingNative();
}
