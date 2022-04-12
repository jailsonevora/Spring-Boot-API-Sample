package com.ine.sge.dao;

import com.ine.sge.models.FormaJuridica;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFormaJuridicaRepository extends PagingAndSortingRepository<FormaJuridica, Long> {
}
