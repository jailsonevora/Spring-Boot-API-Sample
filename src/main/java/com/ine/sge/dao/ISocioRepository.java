package com.ine.sge.dao;

import com.ine.sge.models.Socio;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISocioRepository extends PagingAndSortingRepository<Socio, Long> {
}
