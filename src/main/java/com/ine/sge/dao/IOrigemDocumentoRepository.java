package com.ine.sge.dao;

import com.ine.sge.models.OrigemDocumento;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrigemDocumentoRepository extends PagingAndSortingRepository<OrigemDocumento, Long> {
}
