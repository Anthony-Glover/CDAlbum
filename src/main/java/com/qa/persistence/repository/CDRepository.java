package com.qa.persistence.repository;

import java.util.Collection;

import com.qa.persistence.domain.CD;

public interface CDRepository {

	Collection<CD> getAllCDs();

	String createCD(CD cd);

	String updateCD(Long id, CD cd);

	String deleteCD(Long id);

}
