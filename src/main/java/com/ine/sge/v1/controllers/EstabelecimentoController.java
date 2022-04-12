package com.ine.sge.v1.controllers;

import com.ine.sge.dao.IEstabelecimentoRepository;
import com.ine.sge.exception.ResourceNotFoundException;
import com.ine.sge.models.Estabelecimento;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;
import java.util.Optional;

@RestController("EstabelecimentoV1")
@RequestMapping("/api/v1")
@Api(value = "estabelecimentos", description = "Estabelecimento API")
public class EstabelecimentoController implements com.ine.sge.interfaces.resource.IEstabelecimento {

	@PersistenceContext
	private EntityManager entityManager;
	private final IEstabelecimentoRepository estabelecimentoRepository;

	@Autowired
	public EstabelecimentoController(IEstabelecimentoRepository estabelecimentoRepository) {
		this.estabelecimentoRepository = estabelecimentoRepository;
	}

	@Transactional
	@RequestMapping(value = "/estabelecimentos/{keyword}/search", method = RequestMethod.GET, produces = "application/json")
	@ApiOperation(value = "Retrieves given keyword", response=Estabelecimento.class)
	public ResponseEntity<Page<Estabelecimento>> search(@Valid @PathVariable String keyword){

		// get the full text entity manager
		FullTextEntityManager fullTextEntityManager =
				org.hibernate.search.jpa.Search.
						getFullTextEntityManager(entityManager);

		// create the query using Hibernate Search query DSL
		QueryBuilder queryBuilder =
				fullTextEntityManager.getSearchFactory()
						.buildQueryBuilder().forEntity(Estabelecimento.class).get();

		// a query by keywords
		org.apache.lucene.search.Query query =
				queryBuilder
						.keyword()
						.wildcard()
						.onFields("data_constituicao", "num_func", "num_func_homem", "num_func_mulher", "sede", "classname", "num_estabelecimento", "decoutras", "latitude", "longitude", "comentarios", "volume_vendas", "nome", "data_criacao", "data_documento", "data_situacao_atividade", "data_ultima_insercao")
						.matching("*"+keyword+"*")
						.createQuery();

		// wrap Lucene query in an Hibernate Query object
		org.hibernate.search.jpa.FullTextQuery jpaQuery =
				fullTextEntityManager.createFullTextQuery(query, Estabelecimento.class);

		// execute search and return results (sorted by relevance as default)

		final Page<Estabelecimento> results  = new PageImpl<>(jpaQuery.getResultList());

		return new ResponseEntity<> (results, HttpStatus.OK);
	}

	@RequestMapping(value = "/estabelecimentos/{id}", method = RequestMethod.GET, produces = "application/json")
	@ApiOperation(value = "Retrieves given establishment", response= Estabelecimento.class)
	public ResponseEntity<?> show(@Valid @PathVariable Long id){
		verify(id);
		return new ResponseEntity<> (estabelecimentoRepository.findById(id), HttpStatus.OK);
	}

	@RequestMapping(value="/estabelecimentos", method=RequestMethod.GET, produces = "application/json")
	@ApiOperation(value = "Retrieves all the establishment", response=Estabelecimento.class, responseContainer="List")
	public ResponseEntity<Page<Estabelecimento>> showall(Pageable pageable) {
		return new ResponseEntity<>(estabelecimentoRepository.findAll(pageable), HttpStatus.OK);
	}


	@Transactional
	@RequestMapping(value = "/estabelecimentos", method = RequestMethod.POST, produces = "application/json")
	@ApiOperation(value = "Creates a new establishment", notes="The newly created establishment ID will be sent in the location response header")
	public ResponseEntity<Void> create(@Valid @RequestBody Estabelecimento newEstablishment){

		newEstablishment = estabelecimentoRepository.save(newEstablishment);

		// Set the location header for the newly created resource
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.setLocation(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newEstablishment.getId()).toUri());

		return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);

	}

	@Transactional
	@RequestMapping(value = "/estabelecimentos/{id}", method = RequestMethod.PUT, produces = "application/json")
	@ApiOperation(value = "Updates given establishment")
	public ResponseEntity<Void> update(@Valid @PathVariable Long id, @Valid @RequestBody Estabelecimento toUpdate){

		Optional<Estabelecimento> updatedOptionalClass = estabelecimentoRepository.findById(id);

		if (updatedOptionalClass.isPresent()){

			Estabelecimento afterIsPresent = updatedOptionalClass.get();

			afterIsPresent.setLastModifiedBy(toUpdate.getLastModifiedBy());

			afterIsPresent.setClassname(toUpdate.getClassname());
			afterIsPresent.setEstado(toUpdate.getEstado());
			afterIsPresent.setSede(toUpdate.getSede());
			afterIsPresent.setSituacao_empresa(toUpdate.getSituacao_empresa());
			afterIsPresent.setVolume_vendas(toUpdate.getVolume_vendas());
			afterIsPresent.setActi_eco_principal(toUpdate.getActi_eco_principal());
			afterIsPresent.setCae(toUpdate.getCae());
			afterIsPresent.setComentarios(toUpdate.getComentarios());
			afterIsPresent.setContacto(toUpdate.getContacto());
			afterIsPresent.setDecoutras(toUpdate.getDecoutras());
			afterIsPresent.setEntidade(toUpdate.getEntidade());
			afterIsPresent.setLatitude(toUpdate.getLatitude());
			afterIsPresent.setLongitude(toUpdate.getLongitude());
			afterIsPresent.setNum_estabelecimento(toUpdate.getNum_estabelecimento());

			afterIsPresent.setData_constituicao(toUpdate.getData_constituicao());
			afterIsPresent.setData_criacao(toUpdate.getData_criacao());
			afterIsPresent.setData_situacao_atividade(toUpdate.getData_situacao_atividade());
			afterIsPresent.setData_ultima_insercao(toUpdate.getData_ultima_insercao());
			afterIsPresent.setData_documento(toUpdate.getData_documento());

			afterIsPresent.setNum_func_nac(toUpdate.getNum_func_nac());
			afterIsPresent.setNum_func_rem_nac(toUpdate.getNum_func_rem_nac());

			afterIsPresent.setNum_func_nrem(toUpdate.getNum_func_nrem());
			afterIsPresent.setNum_func_nrem_est(toUpdate.getNum_func_nrem_est());

			afterIsPresent.setNum_func(toUpdate.getNum_func());
			afterIsPresent.setNum_func_est(toUpdate.getNum_func_est());
			afterIsPresent.setNum_func_rem_est(toUpdate.getNum_func_rem_est());


			afterIsPresent.setNum_func_homem(toUpdate.getNum_func_homem());
			afterIsPresent.setNum_func_homem_rem(toUpdate.getNum_func_homem_rem());
			afterIsPresent.setNum_func_homem_nrem(toUpdate.getNum_func_homem_nrem());

			afterIsPresent.setNum_func_h_nrem_est(toUpdate.getNum_func_h_nrem_est());
			afterIsPresent.setNum_func_h_nrem_nac(toUpdate.getNum_func_h_nrem_nac());
			afterIsPresent.setNum_func_h_rem_nac(toUpdate.getNum_func_h_rem_nac());
			afterIsPresent.setNum_func_h_rem_est(toUpdate.getNum_func_h_rem_est());

			afterIsPresent.setNum_funcionario_h_nac(toUpdate.getNum_funcionario_h_nac());
			afterIsPresent.setNum_funcionario_h_est(toUpdate.getNum_funcionario_h_est());


			afterIsPresent.setNum_func_mulher(toUpdate.getNum_func_mulher());
			afterIsPresent.setNum_func_mulher_rem(toUpdate.getNum_func_mulher_rem());
			afterIsPresent.setNum_func_mulher_nrem(toUpdate.getNum_func_mulher_nrem());


			afterIsPresent.setNum_func_m_nrem_est(toUpdate.getNum_func_m_nrem_est());
			afterIsPresent.setNum_func_m_nrem_nac(toUpdate.getNum_func_m_nrem_nac());
			afterIsPresent.setNum_func_m_rem_nac(toUpdate.getNum_func_m_rem_nac());
			afterIsPresent.setNum_func_m_rem_est(toUpdate.getNum_func_m_rem_est());

			afterIsPresent.setNum_funcionario_m_nac(toUpdate.getNum_funcionario_m_nac());
			afterIsPresent.setNum_funcionario_m_est(toUpdate.getNum_funcionario_m_est());


			estabelecimentoRepository.save(afterIsPresent);

			return new ResponseEntity<>(HttpStatus.OK);
		}else{
			throw new ResourceNotFoundException("Establishment with id " + id + " not found");

		}//endif
	}

	@Transactional
	@RequestMapping(value = "/estabelecimentos/{id}", method = RequestMethod.DELETE, produces = "application/json")
	@ApiOperation(value = "Deletes given establishment")
	public ResponseEntity<Void> delete(@Valid @PathVariable Long id, @Valid @RequestBody String lastModifiedBy){
//		verify(id);
//		estabelecimentoRepository.deleteById(id);

		Optional<Estabelecimento> softDelete = estabelecimentoRepository.findById(id);
		if (softDelete.isPresent()) {
			Estabelecimento afterIsPresent = softDelete.get();
			afterIsPresent.setEstado(0);
			afterIsPresent.setLastModifiedBy(lastModifiedBy);

			estabelecimentoRepository.save(afterIsPresent);
		}
		else
			throw new ResourceNotFoundException("Entity with id " + id + " not found");
		return new ResponseEntity<>(HttpStatus.OK);
	}

	// region private
	private void verify(Long id) throws ResourceNotFoundException {
		estabelecimentoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Establishment with id " + id + " not found"));
	}
	// endregion
}
