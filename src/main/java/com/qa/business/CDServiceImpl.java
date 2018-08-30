package com.qa.business;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.qa.persistence.domain.CD;
import com.qa.persistence.repository.CDRepository;

@Default
public class CDServiceImpl implements CDService {

	private static final Logger LOGGER = Logger.getLogger(CDService.class);

	@Inject
	private CDRepository repo;
	
	public CDServiceImpl() {}

	public Collection<CD> getAllCDs() {
		LOGGER.info("In CDServiceImpl getAllCDs ");
		return repo.getAllCDs();
	}

	public String addCD(CD cd) {
		return repo.createCD(cd);
	}

	public String updateCD(Long id, CD cd) {
		return repo.updateCD(id, cd);
	}

	public String deleteCD(Long id) {
		return repo.deleteCD(id);

	}

	public void setRepo(CDRepository repo) {
		this.repo = repo;
	}
}
