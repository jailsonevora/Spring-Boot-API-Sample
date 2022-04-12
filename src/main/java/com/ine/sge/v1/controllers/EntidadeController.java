package com.ine.sge.v1.controllers;

import com.ine.sge.dao.IEntidadeRepository;
import com.ine.sge.exception.ResourceNotFoundException;
import com.ine.sge.models.Entidade;
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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Optional;


@RestController("entidadeControllerV1")
@RequestMapping("/api/v1")
@Api(value = "entidades", description = "Entidade API")
public class EntidadeController implements com.ine.sge.interfaces.resource.IEntidade {

	@PersistenceContext
	private EntityManager entityManager;
	private final IEntidadeRepository entidadeRepository;

	@Autowired
	public EntidadeController(IEntidadeRepository entidadeRepository) {
		this.entidadeRepository = entidadeRepository;
	}

	@Transactional
	@RequestMapping(value = "/entidades/{keyword}/search", method = RequestMethod.GET, produces = "application/json")
	@ApiOperation(value = "Retrieves given keyword", response=Entidade.class)
	public ResponseEntity<Page<Entidade>> search(@Valid @PathVariable String keyword){
		// get the full text entity manager
		FullTextEntityManager fullTextEntityManager =
				org.hibernate.search.jpa.Search.
						getFullTextEntityManager(entityManager);

		// create the query using Hibernate Search query DSL
		QueryBuilder queryBuilder =
				fullTextEntityManager.getSearchFactory()
						.buildQueryBuilder().forEntity(Entidade.class).get();

		// a very basic query by keywords
		org.apache.lucene.search.Query query =
				queryBuilder
						.keyword()
						.onFields("naturalId", "nome", "abreviatura", "profissao", "pessoa", "idade", "volume_vendas", "instituicao", "num_funcionario", "num_funcionario_homem", "num_funcionario_mulher", "data_costituicao", "data_documento", "nif", "eliminado", "bi", "num_rge", "data_sge", "comentarioent", "datasituacaoactividade", "grupoholding", "codgrupo", "dataconstgrupo", "datafimgrupo", "nomegrupo", "nifgrupo", "nomerespgrupo", "telefoneindgrupo", "telefonegrupo", "faxgrupo", "faxindgrupo", "emailrespgrupo", "weburlgrupo", "comentariogrupo", "dataultimainsercao", "latitude", "longitude","gue", "siac", "weburl", "")
						.matching("*"+keyword+"*")
						.createQuery();

		// wrap Lucene query in an Hibernate Query object
		org.hibernate.search.jpa.FullTextQuery jpaQuery =
				fullTextEntityManager.createFullTextQuery(query, Entidade.class);

		// execute search and return results (sorted by relevance as default)
		final Page<Entidade> results = new PageImpl<>(jpaQuery.getResultList());

		return new ResponseEntity<> (results, HttpStatus.OK);
	}

	@RequestMapping(value = "/entidades/{id}", method = RequestMethod.GET, produces = "application/json")
	@ApiOperation(value = "Retrieves given entity", response=Entidade.class)
	public ResponseEntity<?> show(@Valid @PathVariable Long id){
		verify(id);
		return new ResponseEntity<> (entidadeRepository.findById(id), HttpStatus.OK);
	}

	@RequestMapping(value="/entidades", method=RequestMethod.GET, produces = "application/json")
	@ApiOperation(value = "Retrieves all the entities", response=Entidade.class, responseContainer="List")
	public ResponseEntity<Page<Entidade>> showall(@Valid Pageable pageable) {
		return new ResponseEntity<>(entidadeRepository.findAll(pageable), HttpStatus.OK);
	}

	@RequestMapping(value="/validaentidades{key}", method=RequestMethod.GET, produces = "application/json")
	@ApiOperation(value = "Validate entry entity")
	public ResponseEntity<?> validate(@Valid @PathVariable String key) {

		if (entidadeRepository.existsEntidadeByNaturalId(key))
			return new ResponseEntity<String>(HttpStatus.OK);
		else
			throw new ResourceNotFoundException("Entity with validation code " + key + " not found");
	}

	@Transactional
	@RequestMapping(value = "/entidades", method = RequestMethod.POST, produces = "application/json")
	@ApiOperation(value = "Creates a new entity", notes="The newly created entity Id will be sent in the location response header")
	public ResponseEntity<Void> create(@Valid @RequestBody Entidade newEntity){

			// Set the location header for the newly created resource*/
			return new ResponseEntity <>(null, getHttpHeaders(entidadeRepository.save(newEntity)), HttpStatus.CREATED);

	}

	@Transactional
	@RequestMapping(value = "/entidades/{id}", method = RequestMethod.PUT, produces = "application/json")
	@ApiOperation(value = "Updates given entity")
	public ResponseEntity<Void> update(@PathVariable Long id, @Valid @RequestBody Entidade toUpdate){

		Optional<Entidade> updatedOptionalClass = entidadeRepository.findById(id);
		if (updatedOptionalClass.isPresent()){

			Entidade afterIsPresent = updatedOptionalClass.get();
			afterIsPresent.setEstado(toUpdate.getEstado());
			//afterIsPresent.setCae(toUpdate.getCasa());
			afterIsPresent.setContacto(toUpdate.getContacto());
			afterIsPresent.setSocio(toUpdate.getSocio());

			afterIsPresent.setEstabelecimento(toUpdate.getEstabelecimento());
			afterIsPresent.setAbreviatura(toUpdate.getAbreviatura());

			afterIsPresent.setActi_comercial(toUpdate.getActi_comercial());
			afterIsPresent.setWeburlgrupo(toUpdate.getWeburlgrupo());
			afterIsPresent.setVolumenegociogrupo(toUpdate.getVolumenegociogrupo());
			afterIsPresent.setVolume_vendas(toUpdate.getVolume_vendas());

			afterIsPresent.setTipo(toUpdate.getTipo());
			afterIsPresent.setTipo(toUpdate.getTipo());
			afterIsPresent.setTelefoneindgrupo(toUpdate.getTelefoneindgrupo());

			afterIsPresent.setTelefonegrupo(toUpdate.getTelefonegrupo());
			afterIsPresent.setState(toUpdate.getState());

			afterIsPresent.setSituacaoactivgrupo(toUpdate.getSituacaoactivgrupo());

			afterIsPresent.setSituacao_empresa(toUpdate.getSituacao_empresa());
			afterIsPresent.setSiac(toUpdate.getSiac());
			afterIsPresent.setSexo(toUpdate.getSexo());

			afterIsPresent.setSector(toUpdate.getSector());
			afterIsPresent.setProfissao(toUpdate.getProfissao());

			afterIsPresent.setPessoa(toUpdate.getPessoa());
			afterIsPresent.setPais_origem(toUpdate.getPais_origem());
			afterIsPresent.setOrigemdocgrupo(toUpdate.getOrigemdocgrupo());
			afterIsPresent.setOrigem_doc(toUpdate.getOrigem_doc());

			afterIsPresent.setNumpessoasservgrupo(toUpdate.getNumpessoasservgrupo());
			afterIsPresent.setNumempresasnacgrupo(toUpdate.getNumempresasnacgrupo());
			afterIsPresent.setNumempresasestgrupo(toUpdate.getNumempresasestgrupo());

			afterIsPresent.setNum_rge(toUpdate.getNum_rge());
			afterIsPresent.setNum_funcionario_mulher(toUpdate.getNum_funcionario_mulher());
			afterIsPresent.setNum_funcionario_m_nac(toUpdate.getNum_funcionario_m_nac());
			afterIsPresent.setNum_funcionario_m_est(toUpdate.getNum_funcionario_m_est());

			afterIsPresent.setNum_funcionario_m_est(toUpdate.getNum_funcionario_m_est());
			afterIsPresent.setNum_funcionario_homem(toUpdate.getNum_funcionario_homem());
			afterIsPresent.setNum_funcionario_h_nac(toUpdate.getNum_funcionario_h_nac());
			afterIsPresent.setNum_funcionario_h_est(toUpdate.getNum_funcionario_h_est());

			afterIsPresent.setNum_func_rem_nac(toUpdate.getNum_func_rem_nac());
			afterIsPresent.setNum_func_rem_est(toUpdate.getNum_func_rem_est());
			afterIsPresent.setNum_func_nrem_nac(toUpdate.getNum_func_nrem_nac());

			afterIsPresent.setNum_func_nrem_est(toUpdate.getNum_func_nrem_est());
			afterIsPresent.setNum_func_nac(toUpdate.getNum_func_nac());

			afterIsPresent.setNum_func_mulher_rem(toUpdate.getNum_func_mulher_rem());
			afterIsPresent.setNum_func_mulher_nrem(toUpdate.getNum_func_mulher_nrem());
			afterIsPresent.setNum_func_m_rem_nac(toUpdate.getNum_func_m_rem_nac());
			afterIsPresent.setNum_func_m_rem_est(toUpdate.getNum_func_m_rem_est());

			afterIsPresent.setNum_func_m_nrem_nac(toUpdate.getNum_func_m_nrem_nac());
			afterIsPresent.setNum_func_m_nrem_est(toUpdate.getNum_func_m_nrem_est());
			afterIsPresent.setNum_func_homem_rem(toUpdate.getNum_func_homem_rem());

			afterIsPresent.setNum_func_homem_nrem(toUpdate.getNum_func_homem_nrem());
			afterIsPresent.setNum_func_h_rem_nac(toUpdate.getNum_func_h_rem_nac());
			afterIsPresent.setNum_func_h_rem_est(toUpdate.getNum_func_h_rem_est());
			afterIsPresent.setNum_func_h_nrem_nac(toUpdate.getNum_func_h_nrem_nac());

			afterIsPresent.setNum_func_h_nrem_est(toUpdate.getNum_func_h_nrem_est());
			afterIsPresent.setNum_func_est(toUpdate.getNum_func_est());
			afterIsPresent.setNum_estabs_total(toUpdate.getNum_estabs_total());

			afterIsPresent.setNum_estabelecimentos(toUpdate.getNum_estabelecimentos());
			afterIsPresent.setNum_doc(toUpdate.getNum_doc());

			afterIsPresent.setNomerespgrupo(toUpdate.getNomerespgrupo());
			afterIsPresent.setNomegrupo(toUpdate.getNomegrupo());
			afterIsPresent.setNifgrupo(toUpdate.getNifgrupo());
			afterIsPresent.setNaturezajurgrupo(toUpdate.getNaturezajurgrupo());

			afterIsPresent.setNaturalId(toUpdate.getNaturalId());
			afterIsPresent.setMeses_actividade(toUpdate.getMeses_actividade());
			afterIsPresent.setLongitude(toUpdate.getLongitude());

			afterIsPresent.setLatitude(toUpdate.getLatitude());
			afterIsPresent.setInstituicao(toUpdate.getInstituicao());
			afterIsPresent.setIdade(toUpdate.getIdade());
			afterIsPresent.setGue(toUpdate.getGue());

			afterIsPresent.setGrupoholding(toUpdate.getGrupoholding());
			afterIsPresent.setForma_juridica(toUpdate.getForma_juridica());
			afterIsPresent.setFaxindgrupo(toUpdate.getFaxindgrupo());

			afterIsPresent.setFaxgrupo(toUpdate.getFaxgrupo());
			afterIsPresent.setEstado_aprovacao(toUpdate.getEstado_aprovacao());

			afterIsPresent.setEmailrespgrupo(toUpdate.getEmailrespgrupo());
			afterIsPresent.setEliminado(toUpdate.getEliminado());
			afterIsPresent.setDataultimainsercao(toUpdate.getDataultimainsercao());
			afterIsPresent.setDatasituacaoactividade(toUpdate.getDatasituacaoactividade());

			afterIsPresent.setDatainitactgrupo(toUpdate.getDatainitactgrupo());
			afterIsPresent.setDatafimgrupo(toUpdate.getDatafimgrupo());
			afterIsPresent.setDatafimactgrupo(toUpdate.getDatafimactgrupo());

			afterIsPresent.setDataconstgrupo(toUpdate.getDataconstgrupo());
			afterIsPresent.setData_sge(toUpdate.getData_sge());
			afterIsPresent.setData_documento(toUpdate.getData_documento());
			afterIsPresent.setData_costituicao(toUpdate.getData_costituicao());


			afterIsPresent.setContabilidade(toUpdate.getContabilidade());
			afterIsPresent.setComentariogrupo(toUpdate.getComentariogrupo());
			afterIsPresent.setComentarioent(toUpdate.getComentarioent());

			afterIsPresent.setCodgrupo(toUpdate.getCodgrupo());
			afterIsPresent.setCapital_social(toUpdate.getCapital_social());

			afterIsPresent.setCap_publico(toUpdate.getCap_publico());
			afterIsPresent.setCap_privado(toUpdate.getCap_privado());
			afterIsPresent.setCap_estrang(toUpdate.getCap_estrang());
			afterIsPresent.setCanal(toUpdate.getCanal());

			afterIsPresent.setCaeprincipalgrupo(toUpdate.getCaeprincipalgrupo());
			afterIsPresent.setBi(toUpdate.getBi());
			afterIsPresent.setAno_eliminacao(toUpdate.getAno_eliminacao());

			afterIsPresent.setAno_actividade(toUpdate.getAno_actividade());
			afterIsPresent.setActi_eco_principal(toUpdate.getActi_eco_principal());
			afterIsPresent.setLastModifiedBy(toUpdate.getLastModifiedBy());

			entidadeRepository.save(afterIsPresent);

			return new ResponseEntity<>(HttpStatus.OK);
		}
		else
			throw new ResourceNotFoundException("Entity with id " + id + " not found");
	}

	@Transactional
	@RequestMapping(value = "/entidades/{id}", method = RequestMethod.DELETE, produces = "application/json")
	@ApiOperation(value = "Deletes given entity")
	public ResponseEntity<Void> delete(@Valid @PathVariable Long id, @Valid @RequestBody String lastModifiedBy){

		Optional<Entidade> softDelete = entidadeRepository.findById(id);
		if (softDelete.isPresent()) {
			Entidade afterIsPresent = softDelete.get();
			afterIsPresent.setEstado(0);
			afterIsPresent.setLastModifiedBy(lastModifiedBy);
			entidadeRepository.save(afterIsPresent);
		}
		else
			throw new ResourceNotFoundException("Entity with id " + id + " not found");
		return new ResponseEntity<>(HttpStatus.OK);
	}

	// region private
	private HttpHeaders getHttpHeaders(@Valid @RequestBody Entidade newObject) {
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.setLocation(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObject.getId()).toUri());
		return responseHeaders;
	}

	private void verify(Long id) throws ResourceNotFoundException {
		entidadeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Country with id " + id + " not found"));
	}
	// endregion
}
