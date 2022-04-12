package com.ine.sge.dao;

import com.ine.sge.models.Situacao;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISituacaoRepository extends PagingAndSortingRepository<Situacao, Long> {
}
