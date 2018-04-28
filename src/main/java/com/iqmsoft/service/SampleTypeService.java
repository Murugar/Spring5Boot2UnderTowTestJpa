package com.iqmsoft.service;

import java.util.List;
import java.util.Optional;

import com.iqmsoft.domain.SampleType;

public interface SampleTypeService {

	List<SampleType> getAllToDo();
	Optional<SampleType> getToDoById(Long id);
	SampleType saveToDo(SampleType todo);
	void deleteToDo(SampleType todo);

}