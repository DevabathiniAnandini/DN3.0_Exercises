class Task {
    private String taskId;
    private String taskName;
    private String status;

    public Task(String taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
    }

    public String getTaskId() {
        return taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Task{" +
               "taskId='" + taskId + '\'' +
               ", taskName='" + taskName + '\'' +
               ", status='" + status + '\'' +
               '}';
    }
}
class TaskNode {
    Task task;
    TaskNode next;

    public TaskNode(Task task) {
        this.task = task;
        this.next = null;
    }
}

public class Exercise5 {
    private TaskNode head;

    public Exercise5() {
        this.head = null;
    }

    public void addTask(Task task) {
        TaskNode newNode = new TaskNode(task);
        if (head == null) {
            head = newNode;
        } else {
            TaskNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public Task searchTask(String taskId) {
        TaskNode current = head;
        while (current != null) {
            if (current.task.getTaskId().equals(taskId)) {
                return current.task;
            }
            current = current.next;
        }
        return null; 
    }

    public void traverseTasks() {
        TaskNode current = head;
        while (current != null) {
            System.out.println(current.task);
            current = current.next;
        }
    }

    public boolean deleteTask(String taskId) {
        if (head == null) {
            return false; 
        }

        if (head.task.getTaskId().equals(taskId)) {
            head = head.next; 
            return true;
        }

        TaskNode current = head;
        while (current.next != null && !current.next.task.getTaskId().equals(taskId)) {
            current = current.next;
        }

        if (current.next == null) {
            return false; 
        }

        current.next = current.next.next; 
        return true;
    }

    public static void main(String[] args) {
        Exercise5 tms = new Exercise5();

        tms.addTask(new Task("T001", "Design UI", "Pending"));
        tms.addTask(new Task("T002", "Develop Backend", "In Progress"));
        tms.addTask(new Task("T003", "Testing", "Pending"));

        System.out.println("All Tasks:");
        tms.traverseTasks();

        System.out.println("\nSearch for Task T002:");
        System.out.println(tms.searchTask("T002"));

        System.out.println("\nDelete Task T003:");
        tms.deleteTask("T003");

        System.out.println("\nAll Tasks After Deletion:");
        tms.traverseTasks();
    }
}


