package com.taskmanager.repositories;

import org.springframework.stereotype.Repository;

import com.microsoft.azure.spring.data.cosmosdb.repository.CosmosRepository;
import com.taskmanager.entities.Item;

@Repository
public interface TaskRepository extends CosmosRepository<Item, String> {
	
}
