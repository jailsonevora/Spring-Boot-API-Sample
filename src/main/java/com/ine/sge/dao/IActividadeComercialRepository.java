package com.ine.sge.dao;

import com.ine.sge.models.ActividadeComercial;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IActividadeComercialRepository extends PagingAndSortingRepository<ActividadeComercial, Long> {
}
