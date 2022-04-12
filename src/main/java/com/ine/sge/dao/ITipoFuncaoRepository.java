package com.ine.sge.dao;

import com.ine.sge.models.TipoFuncao;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITipoFuncaoRepository extends PagingAndSortingRepository<TipoFuncao, Long> {
}
