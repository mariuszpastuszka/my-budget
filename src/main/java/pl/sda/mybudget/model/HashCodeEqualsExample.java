package pl.sda.mybudget.model;

import java.util.HashSet;
import java.util.Set;

public class HashCodeEqualsExample {

    public static void main(String[] args) {
        var me = new Person("Mariusz", "P.", 18);
        var meAgain = new Person("Mariusz", "P.", 18);

        System.out.println("me.equals(meAgain) = " + (me.equals(meAgain)));
        System.out.println("me.equals(me) = " + (me.equals(me)));

        Set<Person> personSet = new HashSet<>();
        personSet.add(me);
        personSet.add(meAgain);

        System.out.println("set size: " + personSet.size());

        // sets
        // kubełek - ma id = hashCode
    }
}
