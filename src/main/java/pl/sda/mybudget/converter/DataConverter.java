package pl.sda.mybudget.converter;

// TODO: use mapstruct
// TODO: check Jackson version changes
public interface DataConverter<E, D> {
    D fromEntity(E entity);
    E fromDto(D dto);

//    List<Income> incomes; - generic type is template one;)
//    List incomes(); - the same as below
//    List<Object> incomes();
}
