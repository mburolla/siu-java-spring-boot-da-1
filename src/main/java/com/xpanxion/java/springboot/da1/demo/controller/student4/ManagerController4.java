package com.xpanxion.java.springboot.da1.demo.controller.student4;
import com.xpanxion.java.springboot.da1.demo.model.student4.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class ManagerController4 {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final String SELECT_MANAGER = "select * from manager";
    private final String INSERT_MANAGER = "insert into manager (full_name) values (?)";

    @GetMapping("student4/api/v1/managers")
    public List<Manager> getManager() {
        List<Manager> managerList;
        managerList = jdbcTemplate.query(SELECT_MANAGER, (row, rowNum) -> {
            int id = Integer.parseInt(row.getString("manager_id"));
            String name= row.getString("full_name");
            return new Manager(id, name);
        });
        return managerList;
    }

    @PostMapping("student4/api/v1/managers")
    public Manager insertManager(@RequestBody Manager manager) {
        jdbcTemplate.update(INSERT_MANAGER,manager.getName());
        return manager;
    }
}
