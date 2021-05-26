package pl.sda.mybudget.controller.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.sda.mybudget.dto.IncomeDto;
import pl.sda.mybudget.service.IncomeService;

import java.net.URI;
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
    List<IncomeDto> getAllIncomes() {
        return incomeService.findAllIncomes();
    }

    // Select by id
    // /rest/incomes/1
    // /rest/incomes/2
    // /rest/incomes/n - id of income goes here
    @GetMapping("/{id}")
    IncomeDto findById(@PathVariable("id") Long idik) {
        return incomeService.findIncomeById(idik);
    }

    // send json to save inside request body
    @PostMapping
    ResponseEntity<IncomeDto> createNewIncome(@RequestBody IncomeDto incomeToSave) {
        var created = incomeService.saveIncome(incomeToSave);
        return ResponseEntity.created(URI.create("/rest/incomes/" + created.getId()))
                .body(created);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteIncomeById(@PathVariable("id") Long id) {
        boolean deleted = incomeService.deleteIncomeById(id);

        ResponseEntity<Void> result = ResponseEntity.notFound().build();
        if (deleted) {
            result = ResponseEntity.noContent().build();
        }

        return result;
    }
}
