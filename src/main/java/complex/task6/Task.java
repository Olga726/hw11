package complex.task6;

import java.time.LocalDate;
import java.util.Objects;

public class Task<T> {
    private final String id;
    private Status status;
    private Priority priority;
    private LocalDate date;

    public Task(LocalDate date, Status status, Priority priority, String id) {
        this.date = date;
        this.status = status;
        this.priority = priority;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public Status getStatus() {
        return status;
    }

    public Priority getPriority() {
        return priority;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id='" + id + '\'' +
                ", status=" + status +
                ", priority=" + priority +
                ", date=" + date +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Task<?> task = (Task<?>) o;
        return Objects.equals(id, task.id) && status == task.status && priority == task.priority && Objects.equals(date, task.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, status, priority, date);
    }
}
