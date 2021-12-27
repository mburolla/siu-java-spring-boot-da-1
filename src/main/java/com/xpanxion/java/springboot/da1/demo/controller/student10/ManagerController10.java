package com.xpanxion.java.springboot.da1.demo.controller.student10;

import com.xpanxion.java.springboot.da1.demo.model.student10.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ManagerController10 {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private final String SELECT_MANAGER = "select * from manager";
    private final String INSERT_MANAGER = "insert into manager (full_name) values (?)";
    private final String UPDATE_MANAGER = "update manager set full_name = ? where manager_id = ?";


    @GetMapping("student10/api/v1/managers")
    public List<Manager> getManagers () {
        List<Manager> managerList;
        managerList = jdbcTemplate.query(SELECT_MANAGER, (row, rowNum) -> {
            var id = Integer.parseInt(row.getString("manager_id"));
            var name =  row.getString("full_name");
            return new Manager(id, name);
        });
        return managerList;
    }

    @PostMapping("student10/api/v1/managers")
    public Manager addManager (@RequestBody Manager manager) {
        jdbcTemplate.update(INSERT_MANAGER, (manager.getFull_name()));
        return manager;
    }

    @PutMapping("student10/api/v1/managers")
    public Manager updateManager (@RequestBody Manager manager){
        jdbcTemplate.update(UPDATE_MANAGER, manager.getFull_name(), manager.getManager_id());
        return manager;
    }

}
