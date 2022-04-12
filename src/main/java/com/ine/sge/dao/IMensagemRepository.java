package com.ine.sge.dao;

import com.ine.sge.models.Mensagem;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMensagemRepository extends PagingAndSortingRepository<Mensagem, Long> {
}
