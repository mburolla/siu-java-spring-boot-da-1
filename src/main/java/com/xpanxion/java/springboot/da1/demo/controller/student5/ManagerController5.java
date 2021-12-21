package com.xpanxion.java.springboot.da1.demo.controller.student5;

import com.xpanxion.java.springboot.da1.demo.model.student5.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ManagerController5 {

    @Autowired
    private ManagerDataAccess dataAccess;

    @GetMapping("student5/api/v1/managers")
    public List<Manager> getManagers() {
        var managers = dataAccess.getManagers();
        return managers;
    }
}

@Service
class ManagerDataAccess {

    //
    // Data Members
    //

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private final String SELECT_MANAGER = "select * from manager";

    //
    // Constructors
    //

    public ManagerDataAccess() {
    }

    //
    // Methods
    //
    public List<Manager> getManagers() {
        List<Manager> managerList;
        managerList = jdbcTemplate.query(SELECT_MANAGER, (row, rowNum) -> {
            var id = Integer.parseInt(row.getString("manager_id"));
            var fullName =  row.getString("full_name");
            return new Manager(id, fullName);
        });
        return managerList;
    }
}