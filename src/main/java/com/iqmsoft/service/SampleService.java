package com.iqmsoft.service;

import java.util.List;
import java.util.Optional;

import com.iqmsoft.domain.Sample;

public interface SampleService {
	List<Sample> getAllToDo();
	Optional<Sample> getToDoById(Long id);
	Sample saveToDo(Sample todo);
	void deleteToDo(Sample todo);
}
