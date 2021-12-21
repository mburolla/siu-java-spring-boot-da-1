package com.xpanxion.java.springboot.da1.demo.controller.student2;

import com.xpanxion.java.springboot.da1.demo.model.student2.Manager;
import com.xpanxion.java.springboot.da1.demo.service.student2.DataAccessStudent2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ManagerController2 {

    @Autowired
    private DataAccessStudent2 dataAccess;

    @GetMapping("student2/api/v1/managers")
    public List<Manager> getManager() {
        var managerList = dataAccess.getManagers();
        return managerList;
    }
}
