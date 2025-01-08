package com.itjuana.taskifyapi.repo;

import com.itjuana.taskifyapi.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepo extends JpaRepository<Task, Integer> {

}
