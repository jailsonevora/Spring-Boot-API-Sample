package com.ine.sge.dao;

import com.ine.sge.models.EmpresaParticipada;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmpresaParticipadaRepository extends PagingAndSortingRepository<EmpresaParticipada, Long> {
}
