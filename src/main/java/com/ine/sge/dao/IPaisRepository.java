package com.ine.sge.dao;

import com.ine.sge.models.Pais;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPaisRepository extends PagingAndSortingRepository<Pais, Long> {
}
