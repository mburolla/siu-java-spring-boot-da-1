package com.xpanxion.java.springboot.da1.demo.controller.student8;

import com.xpanxion.java.springboot.da1.demo.model.student8.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ManagerController8 {

    @Autowired
    private DataAccess8 dataAccess;


    @GetMapping("student8/api/v1/managers")
    public List<Manager> getManager() {
        var managers = dataAccess.getAllManagers();
        return managers;
    }

    @Service
    static class DataAccess8 {

        // DATA

        @Autowired
        private JdbcTemplate jdbcTemplate;
        private final String SELECT_All_MANAGERS = "select * from manager";

        // CONSTRUCTOR

        public DataAccess8() {

        }

        // METHODS

        public List<Manager> getAllManagers() {
            List<Manager> listOfManagers;
            listOfManagers = jdbcTemplate.query(SELECT_All_MANAGERS, (row, rowNum) -> {
                int id = Integer.parseInt(row.getString("manager_id"));
                String name = row.getString("full_name");
                return new Manager(id, name);
            });
            return listOfManagers;
        }

    }

}
