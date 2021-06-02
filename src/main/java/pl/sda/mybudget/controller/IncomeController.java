package pl.sda.mybudget.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.sda.mybudget.dto.IncomeDto;
import pl.sda.mybudget.service.IncomeService;

@RequestMapping("/incomes")
@Controller
@Slf4j
// TODO: error checking
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

    @GetMapping("/delete/{id}")
    public String deleteIncomeById(@PathVariable("id") Long id) {
        log.info("trying to delete income by id: [{}]", id);

        incomeService.deleteIncomeById(id);

        return "redirect:/incomes/all-incomes";
    }

    @GetMapping("/add-form")
    public String showAddForm() {
        log.info("showing income add form");

        return "income/new-income-form";
    }

    @PostMapping("/save")
    public String saveIncome(IncomeDto incomeToSave) {
        log.info("saving new income: [{}]", incomeToSave);

        incomeService.saveIncome(incomeToSave);
        return "redirect:/incomes/all-incomes";
    }
}
