package com.xpanxion.java.springboot.da1.demo.controller.student8;

import com.xpanxion.java.springboot.da1.demo.model.student8.Manager;
import com.xpanxion.java.springboot.da1.demo.service.student8.DataService8;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ManagerController8 {

    @Autowired
    private DataService8 dataService8;

    @GetMapping("student8/api/v1/managers")
    public List<Manager> getManager() {
        var managers = dataService8.getAllManagers();
        return managers;
    }

    @PostMapping("student8/api/v1/managers")
    public void createManager(@RequestBody Manager manager) {
        dataService8.createManager(manager);
    }

    @PutMapping("student8/api/v1/managers")
    public void updateManager(@RequestBody Manager manager) {
        dataService8.updateManager(manager);
    }

}

