package com.ine.sge.dao;

import com.ine.sge.models.Canal;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICanalRepository extends PagingAndSortingRepository<Canal, Long> {
}
