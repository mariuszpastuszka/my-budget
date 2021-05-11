package pl.sda.mybudget.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/income")
@Controller
public class IncomeController {

    @GetMapping("/all-incomes")
    public String allIncomes() {
        return "income/all-incomes";
    }
}
