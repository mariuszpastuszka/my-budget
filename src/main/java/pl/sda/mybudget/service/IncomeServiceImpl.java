package pl.sda.mybudget.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.sda.mybudget.converter.IncomeConverter;
import pl.sda.mybudget.dto.IncomeDto;
import pl.sda.mybudget.repository.IncomeRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@Slf4j
public class IncomeServiceImpl implements IncomeService {

    private final IncomeRepository incomeRepository;
    private final IncomeConverter incomeConverter;

    public IncomeServiceImpl(final IncomeRepository incomeRepository, final IncomeConverter incomeConverter) {
        this.incomeRepository = incomeRepository;
        this.incomeConverter = incomeConverter;
    }

    @Override
    public List<IncomeDto> findAllIncomes() {
        log.info("finding all incomes");
        return incomeRepository.findAll()
                .stream()
//                .map(income -> incomeConverter.fromEntity(income))
                .map(incomeConverter::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public IncomeDto findIncomeById(Long idik) {
        log.info("trying to find income with id: [{}]", idik);
        return incomeRepository.findById(idik)
//                .map(income -> incomeConverter.fromEntity(income))
                .map(incomeConverter::fromEntity)
                .orElseThrow(()-> new NoSuchElementException("No income with id: " + idik));
    }

    @Override
    public IncomeDto saveIncome(IncomeDto incomeToSave) {
        log.info("trying to save: [{}]", incomeToSave);
        var entityToSave = incomeConverter.fromDto(incomeToSave);
        return incomeConverter.fromEntity(incomeRepository.save(entityToSave));
    }

    @Override
    @Transactional // only for databases
    public boolean deleteIncomeById(Long id) {
        log.info("trying to delete income with id: [{}]", id);

        boolean result = false;
        if (incomeRepository.existsById(id)) {
            incomeRepository.deleteById(id);
            result = true;
        }

        return result;
    }
}
