package movementump.movementump;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service

public class TaskService {
    private List<Task> tasks;
    
    
    public TaskService() {
        this.tasks = new ArrayList<>();
    }
    
    
     
   
  

    //  tasks by status
    public List<String> getTasksByStatus(String status) {
        return tasks.stream()
                    .filter(task -> task.getStatus().equalsIgnoreCase(status))
                    .map(this::formatTaskString)
                    .collect(Collectors.toList());
    }

    //  based on priority
    //private String getPriorityString(Task task) {
      //  String priorityString = "!".repeat(Math.max(0, task.getPriority()));
        //return priorityString + task.getName();
    //}
    private String formatTaskString(Task task) {
        String priorityString = "!".repeat(Math.max(0, task.getPriority()));
        String dateString = task.getDate() != null ? task.getDate().toString() : "No Date";
        return priorityString + task.getName() + " - " + dateString;
    }

    // for add a new task
    public void addTask(Task task) {
        tasks.add(task);
    }

    // this is for updating task which you need to already have task remember!! I mean this not the creating part
    public void updateTask(Task updatedTask) {
        tasks = tasks.stream()
                     .map(task -> task.getName().equals(updatedTask.getName()) ? updatedTask : task)
                     .collect(Collectors.toList());
    }

    // tasks for debugging
    public List<Task> getAllTasks() {
        return new ArrayList<>(tasks);
    }

    //  find a task by name
    public Task findTaskByName(String name) {
        return tasks.stream()
                    .filter(task -> task.getName().equalsIgnoreCase(name))
                    .findFirst()
                    .orElse(null);
    }
}
