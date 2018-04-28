package com.iqmsoft.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iqmsoft.domain.Sample;
import com.iqmsoft.domain.SampleType;
import com.iqmsoft.repository.SampleRepository;
import com.iqmsoft.repository.SampleTypeRepository;
import com.iqmsoft.service.SampleService;
import com.iqmsoft.service.SampleTypeService;

@Service
@Transactional
public class SampleTypeServiceImpl implements SampleTypeService {

	@Autowired
	private SampleTypeRepository toDoRepository;
	

	@Transactional(readOnly = true)
	@Override
	public List<SampleType> getAllToDo() {
		return toDoRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<SampleType> getToDoById(Long id) {
		return toDoRepository.findById(id);
	}

	@Override
	public SampleType saveToDo(SampleType todo) {
		return toDoRepository.save(todo);
	}

	@Override
	public void deleteToDo(SampleType todo) {
		toDoRepository.delete(todo);
	}


}

