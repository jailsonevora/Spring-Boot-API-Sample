package com.ine.sge.dao;

import com.ine.sge.models.Provincia;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProvinciaRepository extends PagingAndSortingRepository<Provincia, Long> {

	@Query(value="select * from fue_provincia where PAIS = ?1 order by PAIS",
			nativeQuery=true)
	Page<Provincia> findProvincesByCountry(Long id, Pageable pageable);
}
