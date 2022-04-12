package com.ine.sge.dao;

import com.ine.sge.models.Contacto;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IContactoRepository extends PagingAndSortingRepository<Contacto, Long> {
}
