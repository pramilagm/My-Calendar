package com.pramila.javaproject.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.pramila.javaproject.model.Calendar;

public interface CalendarEventRepository extends CrudRepository <Calendar,Long> {
	List<Calendar> findAll();

}
