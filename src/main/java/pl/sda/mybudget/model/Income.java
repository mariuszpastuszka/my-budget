package pl.sda.mybudget.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import pl.sda.mybudget.model.enumeration.IncomeType;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Income {

    private long amountInPolishGrosz;
    private LocalDate incomeDate;
    private String incomeSource;
    private IncomeType incomeType;
}
