package com.ine.sge.dao;

import com.ine.sge.models.TituloAcademico;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITituloAcademicoRepository extends PagingAndSortingRepository<TituloAcademico, Long> {
}
