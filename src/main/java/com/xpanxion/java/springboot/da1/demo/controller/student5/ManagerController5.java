package com.xpanxion.java.springboot.da1.demo.controller.student5;

import com.xpanxion.java.springboot.da1.demo.model.student5.Manager;
import com.xpanxion.java.springboot.da1.demo.service.student5.DataService5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("student5/api/v1/managers")
@RestController
public class ManagerController5 {

    @Autowired
    private DataService5 dataAccess;

    @GetMapping
    public List<Manager> getManagers() {
        return dataAccess.getManagers();
    }

    @PostMapping
    public void insertManager(@RequestBody Manager manager) {
        dataAccess.insertManagers(manager);
    }

    @PutMapping
    public void updateManager(@RequestBody Manager manager) {
        dataAccess.updateManager(manager);
    }
}
