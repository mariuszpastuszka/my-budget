package pl.sda.mybudget.example;

@FunctionalInterface
interface Celebrity {
    boolean isStar(Person celebrity);
    default boolean isFamous() {
        return false;
    }
}
