package com.ine.sge.dao;

import com.ine.sge.models.Classificacao;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClassificacaoRepository extends PagingAndSortingRepository<Classificacao, Long> {
}
