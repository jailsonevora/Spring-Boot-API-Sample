package com.ine.sge.dao;

import com.ine.sge.models.Estabelecimento;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEstabelecimentoRepository extends PagingAndSortingRepository<Estabelecimento, Long> {
}
