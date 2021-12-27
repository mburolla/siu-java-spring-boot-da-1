package com.xpanxion.java.springboot.da1.demo.controller.student1;

import com.xpanxion.java.springboot.da1.demo.model.student1.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("student1/api/v1/managers")
@RestController
public class ManagerController1 {

    @Autowired
    DataAccess1 dataAccess1;

    @GetMapping
    public List<Manager> getManagers() {
        var managersList = dataAccess1.getManagers();
        return managersList;
    }

    @PostMapping
    public void insertManager(@RequestBody Manager manager) {
        dataAccess1.insertManager(manager);
    }

    @PutMapping
    public void updateManager(@RequestBody Manager updateManager) {
        dataAccess1.updateManager(updateManager);

    }

    @Service
    public static class DataAccess1 {

        @Autowired
        private JdbcTemplate jdbcTemplate;
        private final String SELECT_MANAGERS = "select * from manager";
        private final String UPDATE_MANAGER = "update manager set full_name = ? where manager_id = ?";
        private final String INSERT_MANAGER = "insert into manager (full_name) values (?)";

        public List<Manager> getManagers() {
            List<Manager> managersList;
            managersList = jdbcTemplate.query(SELECT_MANAGERS, (row, rowNum) -> {
                var id = Integer.parseInt(row.getString("manager_id"));
                var fullName = row.getString("full_name");

                return new Manager(id, fullName);
            });
            return managersList;
        }

        public void updateManager(Manager manager) {
            jdbcTemplate.update(UPDATE_MANAGER, manager.getFullName(), manager.getManagerId());
        }

        public void insertManager(Manager manager) {
            jdbcTemplate.update(INSERT_MANAGER, manager.getFullName());
        }

    }

}
