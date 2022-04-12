package com.ine.sge.dao;

import com.ine.sge.models.Genero;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGeneroRepository extends PagingAndSortingRepository<Genero, Long> {
}
