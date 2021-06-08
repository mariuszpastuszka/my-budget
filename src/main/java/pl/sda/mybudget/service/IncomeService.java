package pl.sda.mybudget.service;

import pl.sda.mybudget.dto.IncomeDto;

import java.util.List;

public interface IncomeService {
    List<IncomeDto> findAllIncomes();

    IncomeDto findIncomeById(Long idik);

    IncomeDto saveIncome(IncomeDto incomeToSave);

    boolean deleteIncomeById(Long id);

    IncomeDto replaceIncome(IncomeDto incomeToReplace);
}
