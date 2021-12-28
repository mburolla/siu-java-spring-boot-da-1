package com.xpanxion.java.springboot.da1.demo.controller.student10;

import com.xpanxion.java.springboot.da1.demo.model.student10.Manager;
import com.xpanxion.java.springboot.da1.demo.service.student10.DataService10;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ManagerController10 {

    @Autowired
    private DataService10 dataService;


    @GetMapping("student10/api/v1/managers")
    public List<Manager> getManagers () {
        return dataService.getManagers();
    }

    @PostMapping("student10/api/v1/managers")
    public Manager addManager (@RequestBody Manager manager) {
        return dataService.addManager(manager);
    }

    @PutMapping("student10/api/v1/managers")
    public Manager updateManager (@RequestBody Manager manager){
        return dataService.updateManager(manager);
    }

}
