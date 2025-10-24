package complex.task6;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class TaskService<T> {
    private Set<Task<T>> set = new HashSet<>();

    public synchronized void addTask(Task<T> task){
        if(set.stream()
                .anyMatch(i ->i.getId().equalsIgnoreCase(task.getId()))){
            System.out.println("Такой ID уже существует");
        } else {
            set.add(task);
        }
    }
    public synchronized void removeTask(String id){
        set.removeIf(i ->i.getId().equalsIgnoreCase(id));
    }

    public List<Task<T>> filterByStatus(Status status){
        return set.stream()
                .filter(s -> s.getStatus().equals(status))
                .collect(Collectors.toList());
    }

    public List<Task<T>> filterByPriority(Priority priority){
        return set.stream()
                .filter(s -> s.getPriority().equals(priority))
                .collect(Collectors.toList());
    }

    public List<Task<T>> sortByDate(){
        return set.stream()
                .sorted(Comparator.comparing(Task::getDate))
                .collect(Collectors.toList());
    }



}
