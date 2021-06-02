package pl.sda.mybudget.example;

public class MyFilter {

    static boolean isChild(Person person) {
        return person.getAge() < 18;
    }
}
