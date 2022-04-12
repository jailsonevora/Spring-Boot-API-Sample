package com.ine.sge.dao;

import com.ine.sge.models.Contabilidade;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IContabilidadeRepository extends PagingAndSortingRepository<Contabilidade, Long> {
}
