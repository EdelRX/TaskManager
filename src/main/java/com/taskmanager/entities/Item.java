package com.taskmanager.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.data.annotation.Id;

import com.microsoft.azure.spring.data.cosmosdb.core.mapping.Document;

import lombok.Data;

@Document(collection = "Tasks")
@Data
public class Item {

    @Id
    private String id;
    private String category;
    private String name;
    private String description;
    private Boolean isComplete;
    
}