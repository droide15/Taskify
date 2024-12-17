package com.itjuana.taskifyapi;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TaskifyapiApplicationTests {
	@Mock
	TaskService service;

	@Rule public MockitoRule rule = MockitoJUnit.rule();

	@Test
	public void testGetAllTasks() {
		List<Task> tasks = new ArrayList<>();
		tasks.add(new Task(1, "Prepare infraestructure", "Prepare the infraestructure", "Completed"));
		tasks.add(new Task(2, "Install equipement", "Install the equipement", "Pending"));

		when(service.getAllTasks()).thenReturn(tasks);
		assertArrayEquals(tasks, service.getAllTasks());
		assertEquals(task, service.getTask(1));
	}

	@Test
	public void testGetTask() {
		Task task = new Task(1, "Prepare infraestructure", "Prepare the infraestructure", "Completed");

		when(service.getTask()).thenReturn(task);
		assertEquals(task, service.getTask(1));
	}
}
