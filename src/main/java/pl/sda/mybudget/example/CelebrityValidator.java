package pl.sda.mybudget.example;

public class CelebrityValidator {

    void checkCandidate(Celebrity checker, Person toCheck) {
        if (checker.isStar(toCheck)) {
            System.out.println("This will be new star: " + toCheck.getName());
        }
    }


    public static void main(String[] args) {
        CelebrityValidator celebrityValidator = new CelebrityValidator();
        celebrityValidator.checkCandidate(person -> person.getName().equals("Brajanek"),
                new Person("Brajanek", "Kowalski", 17));
    }
}
