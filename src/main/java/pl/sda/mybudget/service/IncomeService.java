package pl.sda.mybudget.service;

import pl.sda.mybudget.model.Income;

import java.util.List;

public interface IncomeService {
    List<Income> findAllIncomes();

    Income findIncomeById(Long idik);

    Income saveIncome(Income incomeToSave);
}
