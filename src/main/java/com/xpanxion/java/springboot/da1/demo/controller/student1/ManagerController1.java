package com.xpanxion.java.springboot.da1.demo.controller.student1;

import com.xpanxion.java.springboot.da1.demo.model.student1.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ManagerController1 {

    @Autowired
    DataAccess1 dataAccess1;

    @GetMapping("student{id}/api/v1/managers")
    public List<Manager> getManagers(@PathVariable("id") Integer id) {
        var managersList = dataAccess1.getManagers();
        return managersList;
    }

    @Service
    public static class DataAccess1 {

        @Autowired
        private JdbcTemplate jdbcTemplate;
        private final String SELECT_MANAGERS = "select * from manager";

        public List<Manager> getManagers() {
            List<Manager> managersList;
            managersList = jdbcTemplate.query(SELECT_MANAGERS, (row, rowNum) -> {
                var id = Integer.parseInt(row.getString("manager_id"));
                var fullName = row.getString("full_name");

                return new Manager(id, fullName);
            });
            return managersList;
        }

    }

}
