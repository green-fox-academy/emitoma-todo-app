package todo_app;

public class Task {
    private String name;
    private boolean completed;

    public Task(String name) {
        this.name = name;
    }
    public void complete(){
        this.completed = true;
    }
    public String toString() {
        return (completed ? "[x] " : "[ ] ") + name;
    }
}
