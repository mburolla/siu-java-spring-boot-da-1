package com.xpanxion.java.springboot.da1.demo.controller.student9;

import com.xpanxion.java.springboot.da1.demo.model.student9.Manager;
import com.xpanxion.java.springboot.da1.demo.service.student9.DataServiceStudent9;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("student9/api/v1/managers")
@RestController
public class ManagerController9 {

    @Autowired
    private DataServiceStudent9 dataAccessManager;

    @GetMapping()
    public List<Manager> getManagers(){
        var temp = dataAccessManager.getManagerList();
        return temp;
    }

    @PostMapping
    public void insertManager(@RequestBody Manager manager){
       dataAccessManager.addManager(manager);
    }

    @PutMapping
    public void updateManager(@RequestBody Manager manager){
        dataAccessManager.updateManager(manager);
    }


}

