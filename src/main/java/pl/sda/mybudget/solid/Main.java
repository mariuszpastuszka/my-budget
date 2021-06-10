package pl.sda.mybudget.solid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Repository {
    static void query() throws Throwable {

    }
}

class Service {
    static void performQuery() throws Throwable {
        Repository.query();
    }
}

class Controller {
    void userQuery() {
        try {
            Service.performQuery();
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        List<String> myStrings = new ArrayList<>();
        var list = Arrays.asList("one", "two", "three");
        addElementToList(list);
    }

    static void addElementToList(List<String> list) {
        list.add("four");
    }
}
