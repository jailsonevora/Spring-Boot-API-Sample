package com.ine.sge.dao;

import com.ine.sge.models.ObjectivoClassificacao;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IObjectivoClassificacaoRepository extends PagingAndSortingRepository<ObjectivoClassificacao, Long> {
}
