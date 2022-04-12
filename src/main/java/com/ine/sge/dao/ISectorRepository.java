package com.ine.sge.dao;

import com.ine.sge.models.Sector;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISectorRepository extends PagingAndSortingRepository<Sector, Long> {
}


