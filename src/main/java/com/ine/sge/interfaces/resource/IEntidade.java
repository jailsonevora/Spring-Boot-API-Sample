package com.ine.sge.interfaces.resource;

import com.ine.sge.models.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

public interface IEntidade {

	ResponseEntity<Page<Entidade>> search(@Valid @PathVariable String keyword);

	ResponseEntity<?> show(@Valid @PathVariable Long id);

	ResponseEntity<Page<Entidade>> showall(Pageable pageable);

	ResponseEntity<Void> create(@Valid @RequestBody Entidade newEntity);

	ResponseEntity<Void> update(@Valid @PathVariable Long id, @Valid @RequestBody Entidade toUpdate);

	ResponseEntity<Void> delete(@Valid @PathVariable Long id, @Valid @RequestBody String lastModifiedBy);
}
