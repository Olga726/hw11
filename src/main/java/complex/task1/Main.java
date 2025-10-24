package complex.task1;

public class Main {
    public static void main(String[] args) {
        EntityManager<User> manager = new EntityManager<>();
        manager.addItem(new User("Ann", 17, true));
        manager.addItem(new User("Den", 60, true));
        manager.addItem(new User("Bob", 5, false));
        manager.addItem(new User("John", 33, true));

        //System.out.println(manager.removeItem(n->n.getName().equalsIgnoreCase("Ann")));
        //System.out.println(manager.getAll());
        //System.out.println(manager.filter(n->n.getName().equalsIgnoreCase("den")));
        //System.out.println(manager.filter(n->n.getAge()>30 && n.getAge()<=60));
        System.out.println(manager.filter(n->n.isActive()==false));

    }


}
