package complex.task1;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class EntityManager<T> {
    private List<T> list = new CopyOnWriteArrayList<>();

    public synchronized void addItem(T item) {
        list.add(item);
    }

    public synchronized boolean removeItem(Predicate<T> condition) {
        return list.removeIf(condition);
    }

    public List<T> getAll() {
        return new CopyOnWriteArrayList<>(list);
    }

    public List<T> filter(Predicate<T> condition) {
        return list.stream()
                .filter(condition)
                .collect(Collectors.toList());
    }


}
