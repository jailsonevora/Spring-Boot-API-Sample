package com.ine.sge.v1.controllers;

import com.ine.sge.exception.ResourceNotFoundException;
import com.ine.sge.models.Contacto;
import com.ine.sge.dao.IContactoRepository;
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

@RestController("ContactoV1")
@RequestMapping("/api/v1")
@Api(value = "contactos", description = "Contacto API")
public class ContactoController implements com.ine.sge.interfaces.resource.IContacto {

	@PersistenceContext
	private EntityManager entityManager;
	private final IContactoRepository contactoRepository;

	@Autowired
	public ContactoController(IContactoRepository contactoRepository) {
		this.contactoRepository = contactoRepository;
	}

	@Transactional
	@RequestMapping(value = "/contactos/{keyword}/search", method = RequestMethod.GET, produces = "application/json")
	@ApiOperation(value = "Retrieves given keyword", response=Contacto.class)
	public ResponseEntity<Page<Contacto>> search(@Valid @PathVariable String keyword){

		// get the full text entity manager
		FullTextEntityManager fullTextEntityManager =
				org.hibernate.search.jpa.Search.
						getFullTextEntityManager(entityManager);

		// create the query using Hibernate Search query DSL
		QueryBuilder queryBuilder =
				fullTextEntityManager.getSearchFactory()
						.buildQueryBuilder().forEntity(Contacto.class).get();

		// a query by keywords
		org.apache.lucene.search.Query query =
				queryBuilder
						.keyword()
						.wildcard()
						.onFields("email", "morada", "cod_postal", "telefone_ind", "telefone", "telemovel_ind",
						"telemovel", "fax", "fax_ind", "porta", "casa", "piso", "portapiso", "weburl")
						.matching("*"+keyword+"*")
						.createQuery();

		// wrap Lucene query in an Hibernate Query object
		org.hibernate.search.jpa.FullTextQuery jpaQuery =
				fullTextEntityManager.createFullTextQuery(query, Contacto.class);

		// execute search and return results (sorted by relevance as default)

		final Page<Contacto> results  = new PageImpl<>(jpaQuery.getResultList());

		return new ResponseEntity<> (results, HttpStatus.OK);
	}

	@RequestMapping(value = "/contactos/{id}", method = RequestMethod.GET, produces = "application/json")
	@ApiOperation(value = "Retrieves given address", response= Contacto.class)
	public ResponseEntity<?> show(@Valid @PathVariable Long id){
		verify(id);
		return new ResponseEntity<> (contactoRepository.findById(id), HttpStatus.OK);
	}

	@RequestMapping(value="/contactos", method=RequestMethod.GET, produces = "application/json")
	@ApiOperation(value = "Retrieves all the addresses", response=Contacto.class, responseContainer="List")
	public ResponseEntity<Page<Contacto>> showall(Pageable pageable) {
		return new ResponseEntity<>(contactoRepository.findAll(pageable), HttpStatus.OK);
	}


	@Transactional
	@RequestMapping(value = "/contactos", method = RequestMethod.POST, produces = "application/json")
	@ApiOperation(value = "Creates a new address", notes="The newly created address Id will be sent in the location response header")
	public ResponseEntity<Void> create(@Valid @RequestBody Contacto newContact){

		newContact = contactoRepository.save(newContact);

		// Set the location header for the newly created resource
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.setLocation(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newContact.getId()).toUri());

		return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);

	}

	@Transactional
	@RequestMapping(value = "/contactos/{id}", method = RequestMethod.PUT, produces = "application/json")
	@ApiOperation(value = "Updates given address")
	public ResponseEntity<Void> update(@Valid @PathVariable Long id, @Valid @RequestBody Contacto toUpdate){

		Optional<Contacto> updatedOptionalClass = contactoRepository.findById(id);
		if (updatedOptionalClass.isPresent()){

			Contacto afterIsPresent = updatedOptionalClass.get();
			afterIsPresent.setEstado(toUpdate.getEstado());
			afterIsPresent.setCasa(toUpdate.getCasa());
			afterIsPresent.setCod_postal(toUpdate.getCod_postal());

			afterIsPresent.setEmail(toUpdate.getEmail());
			afterIsPresent.setFax(toUpdate.getFax());
			afterIsPresent.setFax_ind(toUpdate.getFax_ind());

			afterIsPresent.setMorada(toUpdate.getMorada());
			afterIsPresent.setPais(toUpdate.getPais());
			afterIsPresent.setPiso(toUpdate.getPiso());

			afterIsPresent.setPorta(toUpdate.getPorta());
			afterIsPresent.setPortapiso(toUpdate.getPortapiso());
			afterIsPresent.setTelefone(toUpdate.getTelefone());

			afterIsPresent.setTelefone_ind(toUpdate.getTelefone_ind());
			afterIsPresent.setTelemovel(toUpdate.getTelemovel());
			afterIsPresent.setTelemovel_ind(toUpdate.getTelemovel_ind());
			afterIsPresent.setWeburl(toUpdate.getWeburl());
			afterIsPresent.setLastModifiedBy(toUpdate.getLastModifiedBy());

			afterIsPresent.setComuna(toUpdate.getComuna());
			afterIsPresent.setMunicipio(toUpdate.getMunicipio());
			afterIsPresent.setProvincia(toUpdate.getProvincia());

			contactoRepository.save(afterIsPresent);

			return new ResponseEntity<>(HttpStatus.OK);
		}
		else
			throw new ResourceNotFoundException("Address with id " + id + " not found");
	}

	@Transactional
	@RequestMapping(value = "/contactos/{id}", method = RequestMethod.DELETE, produces = "application/json")
	@ApiOperation(value = "Deletes given address")
	public ResponseEntity<Void> delete(@Valid @PathVariable Long id, @Valid @RequestBody String lastModifiedBy){
//		verify(id);
// 		contactoRepository.deleteById(id);

		Optional<Contacto> softDelete = contactoRepository.findById(id);
		if (softDelete.isPresent()) {
			Contacto afterIsPresent = softDelete.get();
			afterIsPresent.setEstado(0);
			afterIsPresent.setLastModifiedBy(lastModifiedBy);

			contactoRepository.save(afterIsPresent);
		}
		else
			throw new ResourceNotFoundException("Entity with id " + id + " not found");
		return new ResponseEntity<>(HttpStatus.OK);
	}

	// region private
	private void verify(Long id) throws ResourceNotFoundException {
		contactoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Address with id " + id + " not found"));
	}
	// endregion


}
