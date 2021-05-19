package pl.sda.mybudget.controller.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.mybudget.model.Income;
import pl.sda.mybudget.model.enumeration.IncomeType;
import pl.sda.mybudget.service.IncomeService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/rest/incomes")
public class IncomeRestController {

    private final IncomeService incomeService;

    public IncomeRestController(final IncomeService incomeService) {
        this.incomeService = incomeService;
    }

    // Select all
    @GetMapping
    List<Income> getAllIncomes() {
        return incomeService.findAllIncomes();
    }

    // Select by id
    // /rest/incomes/1
    // /rest/incomes/2
    // /rest/incomes/n - id of income goes here
    @GetMapping("/{id}")
    Income findById(@PathVariable("id") Long idik) {
        return null;
    }
}
