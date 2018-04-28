package com.iqmsoft.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

import com.iqmsoft.domain.Sample;
import com.iqmsoft.domain.SampleType;
import com.iqmsoft.repository.SampleRepository;
import com.iqmsoft.repository.SampleTypeRepository;
import com.iqmsoft.service.impl.SampleServiceImpl;
import com.iqmsoft.service.impl.SampleTypeServiceImpl;

@RunWith(SpringRunner.class)
public class SampleServiceTest {
	@Mock
	private SampleRepository toDoRepository;
	
	@Mock
	private SampleTypeRepository samRepository;
	
	@InjectMocks
	private SampleServiceImpl toDoServiceImpl;
	
	@InjectMocks
	private SampleTypeServiceImpl typeServiceImpl;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	
	@Test
	public void getAllTypeTest() {
		List<SampleType> list = new ArrayList<>();
		list.add(new SampleType("list id 10"));
		list.add(new SampleType("list id 11"));
		
		when(samRepository.findAll()).thenReturn(list);
		
		List<SampleType> result = typeServiceImpl.getAllToDo();
		assertEquals(result, list);
	}
	
	
	
	@Test
	public void getAllTodoTest() {
		List<Sample> list = new ArrayList<>();
		list.add(new Sample((long) 10, "list id 10",false, 10));
		list.add(new Sample((long) 11, "list id 11",true, 11));
		list.add(new Sample((long) 12, "list id 12",false, 12));
		list.add(new Sample((long) 13, "list id 13",true, 13));
		when(toDoRepository.findAll()).thenReturn(list);
		
		List<Sample> result = toDoServiceImpl.getAllToDo();
		assertEquals(result, list);
	}
	
	@Test
	public void getTodoByIdTest() {
		Sample todo = new Sample(10L, "list id 10", false);
		when(toDoRepository.findById(10L)).thenReturn(Optional.of(todo));
		Optional<Sample> result = toDoServiceImpl.getToDoById(10L);
		assertEquals(Long.valueOf(10), result.get().getId());
		assertEquals("list id 10", result.get().getText());
		assertEquals(false, result.get().isCompleted());
	}
	
	@Test
	public void saveToDoTest() {
		Sample todo = new Sample(100L,"list id 100", true);
		when(toDoRepository.save(todo)).thenReturn(todo);
		Sample result = toDoServiceImpl.saveToDo(todo);
		assertEquals(Long.valueOf(100), result.getId());
		assertEquals("list id 100",result.getText());
		assertEquals(true, result.isCompleted());
	}
	
	@Test
	public void deleteToDoTest() {
		Sample todo = new Sample(100L, "list id 100", true);
		toDoServiceImpl.deleteToDo(todo);
		verify(toDoRepository, times(1)).delete(todo);
	}
}
