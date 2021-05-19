package pl.sda.mybudget.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.sda.mybudget.model.Income;
import pl.sda.mybudget.repository.IncomeRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Slf4j
public class IncomeServiceImpl implements IncomeService {

    private final IncomeRepository incomeRepository;

    public IncomeServiceImpl(final IncomeRepository incomeRepository) {
        this.incomeRepository = incomeRepository;
    }

    @Override
    public List<Income> findAllIncomes() {
        log.info("finding all incomes");
        return incomeRepository.findAll();
    }

    @Override
    public Income findIncomeById(Long idik) {
        log.info("trying to find income with id: [{}]", idik);
        return incomeRepository.findById(idik)
                .orElseThrow(()-> new NoSuchElementException("No income with id: " + idik));
    }

    @Override
    public Income saveIncome(Income incomeToSave) {
        log.info("trying to save: [{}]", incomeToSave);
        return incomeRepository.save(incomeToSave);
    }
}
