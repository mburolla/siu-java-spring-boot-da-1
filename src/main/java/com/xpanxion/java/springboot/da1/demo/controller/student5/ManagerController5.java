package com.xpanxion.java.springboot.da1.demo.controller.student5;

import com.xpanxion.java.springboot.da1.demo.model.student5.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("student5/api/v1/managers")
@RestController
public class ManagerController5 {

    @Autowired
    private ManagerDataAccess dataAccess;

    @GetMapping
    public List<Manager> getManagers() {
        return dataAccess.getManagers();
    }

    @PostMapping
    public void insertManager(String fullName) {
        dataAccess.insertManagers(fullName);
    }

    @PutMapping
    public void updateManager(String fullName, int managerID) {
        dataAccess.updateManager(fullName, managerID);
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
    private final String INSERT_MANAGER = "INSERT INTO manager (full_name) VALUES (?)";
    private final String UPDATE_MANAGER = "UPDATE manager SET full_name = (?) WHERE manager_id = (?)";

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

    public void updateManager(String newManagerName, int managerID) {
        jdbcTemplate.update(UPDATE_MANAGER, newManagerName, managerID);
    }

    public void insertManagers(String fullName) {
        jdbcTemplate.update(INSERT_MANAGER, fullName);
    }
}