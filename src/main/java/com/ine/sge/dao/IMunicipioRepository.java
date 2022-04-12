package com.ine.sge.dao;

import com.ine.sge.models.Municipio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMunicipioRepository extends PagingAndSortingRepository<Municipio, Long> {

	@Query(value="select * from fue_municipio where PROVINCIA = ?1 order by PROVINCIA \n-- #pageable\n",
			nativeQuery=true)
	Page<Municipio> findCountiesByProvince(Long id, Pageable pageable);
}
