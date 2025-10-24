package complex.task1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class EntityManagerChecker {
    private EntityManager<User> manager;
    private User user1;
    private User user2;
    private User user3;
    private User user4;

    @BeforeEach
    void setUp() {
        manager = new EntityManager<>();
        user1 = new User("Sam", 47, false);
        user2 = new User("Sam", 47, false);
        user3 = new User("Fed", 4, true);
        user4 = new User("Elice", 1, true);
    }

    @Test
    @DisplayName("Проверка метода добавления")
    public void addItemChecker() {
        manager.addItem(user1);
        assertEquals(1, manager.getAll().size());
        assertTrue(manager.getAll().contains(user1));
    }

    @Test
    @DisplayName("Проверка метода удаления с условием по возрасту и по имени")
    public void removeItemCheckerAgeCondition() {
        manager.addItem(user1);
        manager.addItem(user2);
        assertFalse(manager.removeItem(n -> n.isActive()));     //возвращает false если элементы не найдены - по активности
        assertFalse(manager.removeItem(n -> n.getAge() == 11));    //возвращает false если элементы не найдены - по возрасту
        assertTrue(manager.removeItem(n -> n.getName().equals("Sam")));    //возвращаем true если удалены
        assertTrue(manager.getAll().isEmpty());    //удалены все элементы по условию
    }

    @Test
    @DisplayName("Проверка метода getAll")
    public void getAllChecker() {
        manager.addItem(user1);
        manager.addItem(user3);
        assertNotEquals(manager, manager.getAll()); //проверка что возвращает копию
        assertTrue(manager.getAll().size() == 2);  //проверка кол-ва элементов
        assertTrue(manager.getAll().contains(user1) && manager.getAll().contains(user3)); //проверка что есть добавленные объекты

        //проверка что действия с копией не меняют сам объект manager:
        List<User> copy = manager.getAll();
        copy.add(user4);
        assertTrue(copy.contains(user4));
        assertFalse(manager.removeItem(n -> n.getName().equals(user4.getName())));
    }

    @Test
    @DisplayName("Проверка метода фильтрации")
    public void filterChecker() {
        manager.addItem(user1);
        manager.addItem(user3);

        //фильтр по активности
        assertTrue(manager.filter(n -> n.isActive() == false).contains(user1));
        assertTrue(manager.filter(n -> n.isActive() == false).size() == 1);

        //фильтр по возрасту
        assertTrue(manager.filter(n -> n.getAge() > 3 && n.getAge() < 47).contains(user3));
        assertTrue(manager.filter(n -> n.getAge() > 3 && n.getAge() < 47).size() == 1);

        //фильтр по имени
        assertTrue(manager.filter(n -> n.getName().equals(user3.getName())).contains(user3));
        assertEquals(1, manager.filter(n -> n.getName().equals(user3.getName())).size());
    }

    @Test
    @DisplayName("Проверка работы addItem при многопоточности")
    public void checkConcurrentAddItem() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                manager.addItem(new User("UserT1-" + i, 1 + i, true));
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                manager.addItem(new User("UserT2-" + i, 10 + i, false));
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        assertEquals(2000, manager.getAll().size());
    }

    @Test
    @DisplayName("Проверка removeItem при многопоточности")
    public void checkConcurrentRemoveItem() throws InterruptedException {
        Thread adder = new Thread(() -> {
            for (int i = 0; i < 500; i++) {
                manager.addItem(new User("User" + i, i, true));
            }
        });

        Thread remover = new Thread(() -> {
            for (int i = 0; i < 500; i++) {
                int j = i;
                manager.removeItem(u -> u.getName().equals("User" + j));
            }
        });

        adder.start();
        remover.start();

        adder.join();
        remover.join();

        assertNotNull(manager.getAll());

    }

}
