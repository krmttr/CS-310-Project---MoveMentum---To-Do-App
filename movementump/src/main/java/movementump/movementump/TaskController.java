package movementump.movementump;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    // Constructor for dependency injection
    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    
    @GetMapping("/done")
    public List<String> getDoneTasks() {
        return taskService.getTasksByStatus("Done");
    }

    // for status "Doing" for json
    @GetMapping("/doing")
    public List<String> getDoingTasks() {
        return taskService.getTasksByStatus("Doing");
    }

    // will do list for json
    @GetMapping("/willdo")
    public List<String> getWillDoTasks() {
        return taskService.getTasksByStatus("Will Do");
    }

    // adding in list
    @PostMapping("/add")
    public String addTask(@RequestBody Task task) {
        taskService.addTask(task);
        return "Task added successfully";
    }

    //last thursday mustafa added this part remember
    @PostMapping("/update")
    public String updateTask(@RequestBody Task task) {
        taskService.updateTask(task);
        return "Task updated successfully";
    }

    
}
