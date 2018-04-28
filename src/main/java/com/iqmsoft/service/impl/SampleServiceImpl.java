package com.iqmsoft.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iqmsoft.domain.Sample;
import com.iqmsoft.repository.SampleRepository;
import com.iqmsoft.service.SampleService;

@Service
@Transactional
public class SampleServiceImpl implements SampleService{

	@Autowired
	private SampleRepository toDoRepository;
	
	@Override
	@Transactional(readOnly = true)
	public List<Sample> getAllToDo() {
		return toDoRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Sample> getToDoById(Long id) {
		return toDoRepository.findById(id);
	}

	@Override
	public Sample saveToDo(Sample todo) {
		return toDoRepository.save(todo);
	}

	@Override
	public void deleteToDo(Sample todo) {
		toDoRepository.delete(todo);
	}


}
