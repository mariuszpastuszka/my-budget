package pl.sda.mybudget.stream;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExample {

    public static void main(String[] args) {
        List<String> colours = List.of("white", "blue", "red", "green");
        // zamień kolor -> długość stringu
        // filtruj -> tylko liczby większe niż 4
        // zbierz do listy
        List<Integer> filtered = Collections.emptyList();
                colours
                .stream()
                .map(s -> {
                    System.out.println(String.format("Colour [%s] has length: [%d]", s, s.length()));
//                    System.out.println(String.format("Colour [${s}] has length: [%d]", s, s.length()));
                    return s.length();
                })
                .filter(integer -> integer > 4)
                .findFirst();
//                .collect(Collectors.toList());

        // operacje terminalne:
        // - collect
        // find...
        // - foreach
        // bez nich streamy są wpełni leniwe;)
                filtered.forEach(filteredValue -> System.out.println("value: " + filteredValue));

    }
}
