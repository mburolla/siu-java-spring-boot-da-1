package com.xpanxion.java.springboot.da1.demo.controller.student9;

import com.xpanxion.java.springboot.da1.demo.model.student9.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ManagerController9 {
    @Autowired
    private DataAccessManager dataAccessManager;

    @GetMapping("student9/api/v1/managers")
    public List<Manager> getManagers(){
        var temp = dataAccessManager.getManagerList();
        return temp;
    }
}

@Service
class DataAccessManager {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private final String SELECT_ALL_MANAGERS = "SELECT * FROM manager";

    public DataAccessManager() {}

    public List<Manager> getManagerList() {
        List<Manager> managerList;
         managerList = jdbcTemplate.query(SELECT_ALL_MANAGERS, (row,rowNum) -> {
            var id = Integer.parseInt(row.getString("manager_id"));
            var full_name = row.getString("full_name");
            return new Manager(id,full_name);
        });
         return managerList;
    }

}
