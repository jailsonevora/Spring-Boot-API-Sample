package com.ine.sge.dao;

import com.ine.sge.models.CAE;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICAERepository extends PagingAndSortingRepository<CAE, Long> {
}
