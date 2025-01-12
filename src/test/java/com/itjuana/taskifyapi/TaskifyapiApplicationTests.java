package com.itjuana.taskifyapi;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itjuana.taskifyapi.model.Task;
import com.itjuana.taskifyapi.repo.TaskRepo;
import com.itjuana.taskifyapi.service.TaskService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class TaskifyapiApplicationTests {
	@Mock
	TaskRepo repo;

	@InjectMocks
	TaskService service;

	// This is a unit test for the getAllTasks function of the service layer,
	// which should return a list of tasks
	// For it we need to mock the getAllTasks function of the repository layer,
	// which is called from inside the function being tested
	@Test
	void testGetAllTasks() {

		List<Task> expectedTasks = new ArrayList<>();
		expectedTasks.add(new Task(1, "test title 1", "test description 1", "test status 1"));
		expectedTasks.add(new Task(2, "test title 2", "test description 2", "test status 2"));

		when(repo.findAll()).thenReturn(expectedTasks);

		List<Task> actualTasks = service.getAllTasks();

		ObjectMapper objectMapper = new ObjectMapper();
		String expectedArrayJson = null;
		String actualArrayJson = null;

		try {
			expectedArrayJson = objectMapper.writeValueAsString(expectedTasks);
			actualArrayJson = objectMapper.writeValueAsString(actualTasks);

			System.out.println(expectedArrayJson);
			System.out.println(actualArrayJson);
		}
		catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		if (expectedArrayJson != null && actualArrayJson != null) {
			assertEquals(expectedArrayJson, actualArrayJson);
		}
	}

	// This is a unit test for the getTask function of the service layer,
	// which should return a task object
	// For it we need to mock the getTask function of the repository layer,
	// which is called from inside the function being tested
	@Test
	void testGetTask() {

		Task expectedTask = new Task(1, "test title", "test description", "test status");

		when(repo.findById(1)).thenReturn(Optional.of(expectedTask));

		Task actualTask = service.getTask(1);

		ObjectMapper objectMapper = new ObjectMapper();
		String expectedObjectJson = null;
		String actualObjectJson = null;

		try {
			expectedObjectJson = objectMapper.writeValueAsString(expectedTask);
			actualObjectJson = objectMapper.writeValueAsString(actualTask);

			System.out.println(expectedObjectJson);
			System.out.println(actualObjectJson);
		}
		catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		if (expectedObjectJson != null && actualObjectJson != null) {
			assertEquals(expectedObjectJson, actualObjectJson);
		}
	}
}
