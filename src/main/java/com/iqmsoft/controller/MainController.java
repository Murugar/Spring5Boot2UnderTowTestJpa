package com.iqmsoft.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.iqmsoft.domain.Sample;
import com.iqmsoft.exception.ResponseMessage;
import com.iqmsoft.exception.SampleException;
import com.iqmsoft.service.SampleService;

@RestController
public class MainController {
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	@Autowired
	private SampleService todoService;
	
	
	@GetMapping("/")
	public ResponseEntity<List<Sample>> getInit(){
		logger.info("Returning all todo list");
		return new ResponseEntity<List<Sample>>(todoService.getAllToDo(),HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Sample>> getAllToDo(){
		logger.info("Returning all todo list");
		return new ResponseEntity<List<Sample>>(todoService.getAllToDo(),HttpStatus.OK);
	}
	
	@GetMapping("/todo/{id}")
	public ResponseEntity<Sample> getToDoById(@PathVariable Long id) throws SampleException{
		logger.info("Getting todo with id "+id);
		
		Optional<Sample> todo = todoService.getToDoById(id);
		
		if(!todo.isPresent()) {
			throw new SampleException("Todo not found");
		}
		
		return new ResponseEntity<Sample>(todo.get(), HttpStatus.OK);
	}
	
	
	@DeleteMapping("/todo/{id}")
	public ResponseEntity<ResponseMessage> removeTodoById(@PathVariable Long id) throws SampleException {
		logger.info("deleting todo with id "+id);
		
		Optional<Sample> todo = todoService.getToDoById(id);
		
		if(!todo.isPresent()) {
			throw new SampleException("Unable to delete. Todo not found");
		}
		
		todoService.deleteToDo(todo.get());
		return new ResponseEntity<ResponseMessage>(new ResponseMessage(HttpStatus.OK.value(),"Todo deleted"),HttpStatus.OK);
	}
	
	@PostMapping(value="/todo", consumes="application/json")
	public ResponseEntity<Sample> saveToDo(@RequestBody Sample todo){
		logger.info("Saving todo data");
		todoService.saveToDo(todo);
		return new ResponseEntity<Sample>(todo,HttpStatus.CREATED);
	}
	
	@PutMapping("/todo/5")
	public ResponseEntity<Sample> updateToDo(@RequestBody Sample todo){
		logger.info("Updating todo with id "+todo.getId());
		return new ResponseEntity<Sample>(todoService.saveToDo(todo),HttpStatus.OK);
		
	}
}
