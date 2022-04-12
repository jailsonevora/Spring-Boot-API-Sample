package com.ine.sge.dao;

import com.ine.sge.models.Entidade;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEntidadeRepository extends PagingAndSortingRepository<Entidade, Long> {

	boolean existsEntidadeByNaturalId(String key);
}
