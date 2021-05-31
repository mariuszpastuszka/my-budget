package pl.sda.mybudget.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.sda.mybudget.service.IncomeService;

@RequestMapping("/income")
@Controller
public class IncomeController {

    private final IncomeService incomeService;

    public IncomeController(final IncomeService incomeService) {
        this.incomeService = incomeService;
    }

    @GetMapping("/all-incomes")
    public String allIncomes(Model model) {
        // I - find required data
        var allIncomes = incomeService.findAllIncomes();
        // II - add data to model
        model.addAttribute("incomes", allIncomes);

        // III - template engine takes data and template name and produces html
        return "income/all-incomes";
    }
}
