package com.xpanxion.java.springboot.da1.demo.controller.student7;

import com.xpanxion.java.springboot.da1.demo.model.student7.Book;
import com.xpanxion.java.springboot.da1.demo.model.student7.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ManagerController7 {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private final String SELECT_MANAGERS = "select * from manager";
    private final String INSERT_MANAGER = "insert into student7_da.manager(full_name) Values (?)";
    private final String UPDATE_MANAGER = "UPDATE manager SET full_name= ? WHERE manager_id= ?";

    @GetMapping("student7/api/v1/managers")
    public List<Manager> getManagers() {
        List<Manager> managers;
        managers = jdbcTemplate.query(SELECT_MANAGERS, (rs, rowNum) -> {
            var managerId = Integer.parseInt(rs.getString("manager_id"));
            var managerName = rs.getString("full_name");
            return new Manager(managerId, managerName);
        });
        return managers;
    }

    @PostMapping("student7/api/v1/managers")
    public Manager insertManager(@RequestBody Manager manager) {
        jdbcTemplate.update(INSERT_MANAGER, manager.getFullName());
        return manager;
    }

    @PutMapping("student7/api/v1/managers")
    public Manager updateManager(@RequestBody Manager manager) {
        jdbcTemplate.update(UPDATE_MANAGER, manager.getFullName(), manager.getId());
                return manager;
    }



}