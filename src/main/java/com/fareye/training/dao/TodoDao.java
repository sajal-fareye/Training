package com.fareye.training.dao;

import com.fareye.training.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoDao extends JpaRepository<Todo,Integer> {
}
