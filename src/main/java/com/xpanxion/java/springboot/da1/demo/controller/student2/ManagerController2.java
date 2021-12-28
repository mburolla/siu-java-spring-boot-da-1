package com.xpanxion.java.springboot.da1.demo.controller.student2;

import com.xpanxion.java.springboot.da1.demo.model.student2.Manager;
import com.xpanxion.java.springboot.da1.demo.service.student2.DataService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ManagerController2 {

    @Autowired
    private DataService2 dataAccess;

    @GetMapping("student2/api/v1/managers")
    public List<Manager> getManager() {
        var managerList = dataAccess.getManagers();
        return managerList;
    }

    @PostMapping("student2/api/v1/managers")
    public void postManager(@RequestBody String full_name) {
        dataAccess.postManagers(full_name);
    }

    @PutMapping("student2/api/v1/managers")
    public void putManager(@RequestBody Manager manager) {
        dataAccess.putManagers(manager.getFull_name(), manager.getId());
    }
}
