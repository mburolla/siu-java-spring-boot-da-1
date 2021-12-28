package com.xpanxion.java.springboot.da1.demo.controller.student4;
import com.xpanxion.java.springboot.da1.demo.model.student4.Manager;
import com.xpanxion.java.springboot.da1.demo.service.student4.DataServiceStudent4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class ManagerController4 {
    @Autowired
    private DataServiceStudent4 dataAccessManager;

    @GetMapping("student4/api/v1/manager")
    public List<Manager> getManagers(){
        return dataAccessManager.getManager();
    }

    @PostMapping("student4/api/v1/managers")
    public Manager insertManager(@RequestBody Manager manager){
        dataAccessManager.insertManager(manager);
        return manager;
    }
    @PutMapping("student4/api/v1/managers")
    public Manager updateManager(@RequestBody Manager manager){
        dataAccessManager.updateManager(manager);
        return manager;
    }
}
