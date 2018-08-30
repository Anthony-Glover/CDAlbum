package com.qa.business;

import java.util.Collection;

import com.qa.persistence.domain.CD;

public interface CDService 
{

	Collection<CD> getAllCDs();

	String addCD(CD cd);

	String updateCD(Long id, CD cd);

	String deleteCD(Long id);

}
