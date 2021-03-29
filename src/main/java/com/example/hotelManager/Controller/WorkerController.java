package com.example.hotelManager.Controller;

import com.example.hotelManager.Result.Result;
import com.example.hotelManager.Service.WorkerService;
import com.example.hotelManager.pojo.Manager;
import com.example.hotelManager.pojo.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class WorkerController {
    @Autowired
    WorkerService workerService;
    @CrossOrigin
    @ResponseBody
    @RequestMapping("/api/getAllWorkers")
    public Result<List<Worker>> getAllWorkers()
    {
        return new Result<>(workerService.getAllWorkers());
    }
    @CrossOrigin
    @ResponseBody
    @RequestMapping("/api/SaveOrUpdateWorker")
    public void  SaveOrUpdateWorker(@RequestBody Worker worker)
    {
        workerService.UpdateOrAddWorker(worker);
    }
    @CrossOrigin
    @ResponseBody
    @RequestMapping("/api/DeleteWorkerByWorkerID")
    public void  DeleteWorkerByWorkerID(@RequestBody Worker worker)
    {
        workerService.DeleteWorkerByWorkerID(worker);
    }
}
