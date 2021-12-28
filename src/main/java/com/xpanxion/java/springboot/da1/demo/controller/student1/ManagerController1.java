package com.xpanxion.java.springboot.da1.demo.controller.student1;

import com.xpanxion.java.springboot.da1.demo.model.student1.Manager;
import com.xpanxion.java.springboot.da1.demo.service.student1.DataService1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("student1/api/v1/managers")
@RestController
public class ManagerController1 {

    @Autowired
    DataService1 dataService1;

    @GetMapping
    public List<Manager> getManagers() {
        var managersList = dataService1.getManagers();
        return managersList;
    }

    @PostMapping
    public void insertManager(@RequestBody Manager manager) {
        dataService1.insertManager(manager);
    }

    @PutMapping
    public void updateManager(@RequestBody Manager updateManager) {
        dataService1.updateManager(updateManager);

    }

}
