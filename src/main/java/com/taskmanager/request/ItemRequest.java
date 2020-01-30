package com.taskmanager.request;

import lombok.Data;

@Data
public class ItemRequest {

	private String id;
    private String category;
    private String name;
    private String description;
    private Boolean isComplete;
}
