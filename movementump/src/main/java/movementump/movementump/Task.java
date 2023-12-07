package movementump.movementump;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;


public class Task {
	
	private String name;
    private LocalDate date;
    private int priority; // 0, 1, 2, or 3
    private String status; // "Done", "Doing", "Will Do"

    // Default constructor remeber bilgehan this is necessary 
    public Task() {
    }

    
    public Task(String name, LocalDate date, int priority, String status) {
        this.name = name;
        this.date = date;
        this.priority = priority;
        this.status = status;
    }

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    
    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                ", date=" + date +
                ", priority=" + priority +
                ", status='" + status + '\'' +
                '}';
    }
}
