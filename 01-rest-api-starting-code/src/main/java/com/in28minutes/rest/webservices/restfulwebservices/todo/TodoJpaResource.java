package com.in28minutes.rest.webservices.restfulwebservices.todo;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoJpaResource {
	
	
	private TodoService todoService;
	
	
	private TodoRepository todoRepository;
	
	public TodoJpaResource(TodoService todoService, TodoRepository todoRepository) {
		this.todoRepository = todoRepository;
		this.todoService = todoService;
	}
	
	@GetMapping("user/{username}/todos")
	public List<Todo> retrieveTodos(@PathVariable String username) {
		return todoService.findByUsername(username);
//		return todoRepository.findByUsername(username);
	}
	
	@GetMapping("user/{username}/todo/{id}")
	public Todo retrieveTodo(@PathVariable String username, @PathVariable int id ) {
		return todoService.findById(id);
//		return todoRepository.findById(id).get();
	}
	
	@DeleteMapping("user/{username}/deleteTodo/{id}")
	public void deleteTodo(@PathVariable String username, @PathVariable int id) {
		todoService.deleteById(id);
//		return todoService.noContent().build();
	}
	
	@PutMapping("user/{username}/todo/{id}")
	public Todo updateTodo(@PathVariable String username, @PathVariable int id, @RequestBody Todo todo) {
		todoService.updateTodo(todo);
//		todoRepository.save(todo);
		return todo;
	}
	
	@PostMapping("user/{username}/todo")
	public Todo createTodo(@PathVariable String username, @RequestBody Todo todo) {
		todo.setUsername(username);
		todo.setId(0);
		return todoRepository.save(todo);
//		return todoService.addTodo(username, todo.getDescription(), todo.getTargetDate(), todo.isDone());
	}
}
