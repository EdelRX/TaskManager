package com.taskmanager.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.taskmanager.entities.Item;
import com.taskmanager.repositories.TaskRepository;
import com.taskmanager.request.ItemRequest;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/task-manager")
@Slf4j
public class TaskController {
	
	@Autowired 
	TaskRepository taskRepository;
	
	@PostMapping("item-add")
	public ResponseEntity<String> addItem(@RequestBody ItemRequest itemRequest){
		Item item = new Item();
		item.setId(itemRequest.getId());
		item.setCategory(itemRequest.getCategory());
		item.setName(itemRequest.getName());
		item.setDescription(itemRequest.getDescription());
		item.setIsComplete(itemRequest.getIsComplete());
		taskRepository.save(item);
		return null;
	}
	
	@GetMapping("item-get-all")
	public ResponseEntity<List<Item>> getItems() {
		
		try {
		final List<Item> items = (List<Item>) taskRepository.findAll();
		return new ResponseEntity<>(items,
			      HttpStatus.OK);
		}catch(Exception e) {
		return new ResponseEntity<>(new ArrayList<Item>(),
			      HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
