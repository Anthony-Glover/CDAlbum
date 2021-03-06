package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.faces.bean.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;

import com.qa.business.CDService;
import com.qa.persistence.domain.CD;

@Transactional(SUPPORTS)
@ApplicationScoped
@Default
public class CDDBRepository implements CDRepository 
{
	private static final Logger LOGGER = Logger.getLogger(CDDBRepository.class);

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	public CDDBRepository() {}
	
	public Collection<CD> getAllCDs() 
	{
		LOGGER.info("In CDServiceImpl getAllCDs ");
		Query query = manager.createQuery("Select a FROM CD a");
		LOGGER.info(query.toString());
		return (Collection<CD>) query.getResultList();
	}

	@Transactional(REQUIRED)
	public String createCD(CD cd)
	{
		LOGGER.info(cd.toString());
		manager.persist(cd);
		return "{\"message\": \"CD has been sucessfully added\"}";
	}

	@Transactional(REQUIRED)
	public String updateCD(Long id, CD cd) 
	{
		CD cdFromDB = findCD(id);
		if (cd != null) {
			cdFromDB = cd;
			manager.merge(cdFromDB);
		}
		return "{\"message\": \"CD sucessfully updated\"}";
	}

	@Transactional(REQUIRED)
	public String deleteCD(Long id) 
	{
		CD cdInDB = findCD(id);
		if (cdInDB != null) {
			manager.remove(cdInDB);
		}
		return "{\"message\": \"CD sucessfully deleted\"}";
	}
	
	private CD findCD(Long id) {
		return manager.find(CD.class, id);
	}



}
