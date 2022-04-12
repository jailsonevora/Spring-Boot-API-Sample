package com.ine.sge.dao;

import com.ine.sge.models.Comuna;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IComunaRepository extends PagingAndSortingRepository<Comuna, Long> {

	@Query(value="select * from fue_comuna where MUNICIPIO = ?1 order by MUNICIPIO \n-- #pageable\n",
			nativeQuery=true)
	Page<Comuna> findComunasByCounty(Long id, Pageable pageable);
}
