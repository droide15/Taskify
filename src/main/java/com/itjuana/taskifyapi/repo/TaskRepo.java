package com.itjuana.taskifyapi.repo;

import java.util.List;

import com.itjuana.taskifyapi.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class TaskRepo {

    @Autowired
    private JdbcTemplate jdbc;

    public void save(Task t) {
        String sql="insert into task(id,title,description,status) values(?,?,?,?)";

        int rows=jdbc.update(sql,t.getId(),t.getTitle(),t.getDescription(),t.getStatus());
        System.out.println(rows +" rows affected");
    }

    public List<Task> findAll() {

        String sql="select * from task";

        RowMapper<Task> mapper=(rt, rowNum) ->
        {
            Task t=new Task();
            t.setId(rt.getInt("id"));
            t.setTitle(rt.getString("title"));
            t.setDescription(rt.getString("description"));
            t.setStatus(rt.getString("status"));
            return t;
        };

        return jdbc.query(sql, mapper);
    }

    public Task getTask(int id) {
        String sql="select * from task where id=?";

        RowMapper<Task> mapper=(rt, rowNum) ->
        {
            Task t=new Task();
            t.setId(rt.getInt("id"));
            t.setTitle(rt.getString("title"));
            t.setDescription(rt.getString("description"));
            t.setStatus(rt.getString("status"));
            return t;
        };

        List<Task> tasks = jdbc.query(sql, mapper, id);

        if (!tasks.isEmpty()) {
            return tasks.getFirst();
        }

        return null;
    }

    public void updateTask(Task t) {
        String sql="update task set title=?, description=?,status=? where id=?";

        int rows=jdbc.update(sql,t.getTitle(),t.getDescription(),t.getStatus(),t.getId());
        System.out.println(rows +" rows affected");
    }

    public void deleteTask(int id) {
        String sql="delete from task where id=?";

        int rows=jdbc.update(sql,id);
        System.out.println(rows +" rows affected");
    }
}
