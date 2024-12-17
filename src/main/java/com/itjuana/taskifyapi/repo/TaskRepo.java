package com.itjuana.taskifyapi.repo;

import java.util.ArrayList;
import java.util.List;

import com.itjuana.taskifyapi.model.Task;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepo extends JpaRepository<Task, Integer> {

}
