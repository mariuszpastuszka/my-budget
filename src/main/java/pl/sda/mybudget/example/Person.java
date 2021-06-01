package pl.sda.mybudget.example;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

@Data
@AllArgsConstructor
public class Person {
    private String name;
    private String surname;
    private int age;

    public static void main(String[] args) {
        var surName = "ala";
        var number = 4l; // don't do it:)
        var persons = List.of(new Person("Maria", "P.", 5),
                new Person("Eryk", "W.", 35),
                new Person("Henryk", "S", 55));

        persons.stream() // Stream<Person> -- all persons
//                .filter(new Predicate<Person>() {
//                    @Override
//                    public boolean test(Person person) {
//                        return person.getAge() > 18;
//                    }
//                })
//        .filter((Person person) -> { return person.getAge() > 18; })
        .filter(person -> person.getAge() > 18) // Stream<Person> - only adults
//        .map(new Function<Person, String>() {
//            @Override
//            public String apply(Person person) {
//                return person.getName();
//            }
//        }) // Person -> name (String)
        .map(person -> person.getName()) // Stream<String>
        .forEach(name -> System.out.println("Name: " + name));
    }
}
