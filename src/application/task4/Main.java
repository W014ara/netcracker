package application.task4;

public class Main {
    public static void main(String[] args) {
        CatImpl cat = new CatImpl();
        cat.hungry();
        cat.feed();
        cat.hungry();
        CatImpl cat1 = new CatImpl();
        cat1.hungry();
    }
}
