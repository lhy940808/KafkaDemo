package com.lhy.boot.service;

import java.util.List;

import com.lhy.boot.entity.Entity;

public interface CityESService {
	
	void saveEntity(Entity entity);
	
	void saveEntity(List<Entity> entityList);
	
	List<Entity> searchEntity(String searchContent);
}
