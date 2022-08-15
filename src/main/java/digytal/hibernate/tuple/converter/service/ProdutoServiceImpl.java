package digytal.hibernate.tuple.converter.service;

import digytal.hibernate.tuple.converter.entity.ProdutoEntity;
import digytal.hibernate.tuple.converter.dto.ProdutoCriteriaDTO;
import digytal.hibernate.tuple.converter.dto.ProdutoDTO;
import digytal.hibernate.tuple.converter.repository.ProdutoConverterRepository;
import digytal.hibernate.tuple.converter.repository.ProdutoRepository;
import digytal.hibernate.tuple.converter.repository.projector.ProdutoProjector;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    private static final ModelMapper modelMapper = new ModelMapper();

    private final ProdutoRepository repository;
    private final ProdutoConverterRepository produtoConverterRepository;

    public ProdutoServiceImpl(ProdutoRepository repository, ProdutoConverterRepository produtoConverterRepository) {
        this.repository = repository;
        this.produtoConverterRepository = produtoConverterRepository;
    }

    @Override
    public void save(ProdutoDTO produto){
        repository.save(modelMapper.map(produto, ProdutoEntity.class));
    }

    @Override
    public List<ProdutoProjector> findAllProdutoUsingProjector(){
        return repository.findAllProdutoUsingProjector();
    }

    @Override
    public List<ProdutoCriteriaDTO> findAllProdutoUsingCriteria(){
        return produtoConverterRepository.findAllProdutoUsingCriteria();
    }

    @Override
    public List<ProdutoEntity> findAllProdutoUsingNative() {
        return produtoConverterRepository.findAllProdutoUsingNative();
    }


}
