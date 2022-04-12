package com.ine.sge.dao;

import com.ine.sge.models.Nivel;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface INivelRepository extends PagingAndSortingRepository<Nivel, Long> {
}
