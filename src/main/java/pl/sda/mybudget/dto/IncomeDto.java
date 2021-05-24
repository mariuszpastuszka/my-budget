package pl.sda.mybudget.dto;

import lombok.Value;

import java.time.LocalDate;

// DTO - Data Transfer Object
// dtos should be immutable
@Value
public class IncomeDto {
    Long id;
    long amountInPolishGrosz;
    LocalDate incomeDate;
    String incomeSource;
    String incomeType;
}
