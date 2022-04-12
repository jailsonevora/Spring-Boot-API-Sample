package com.ine.sge.dao;

import com.ine.sge.models.Seccao;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISeccaoRepository extends PagingAndSortingRepository<Seccao, Long> {
}
