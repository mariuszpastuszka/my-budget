package pl.sda.mybudget.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.sda.mybudget.converter.IncomeConverter;
import pl.sda.mybudget.dto.IncomeDto;
import pl.sda.mybudget.exception.ReplaceIncomeException;
import pl.sda.mybudget.repository.IncomeRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

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
        log.info("trying to save dto: [{}]", incomeToSave);
        var entityToSave = incomeConverter.fromDto(incomeToSave);
        log.info("converted entity to save: [{}]", entityToSave);
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

    @Override
    @Transactional
    public IncomeDto replaceIncome(IncomeDto incomeToReplace) {
        log.info("trying to replace income with object: [{}]", incomeToReplace);

        Long incomeId = incomeToReplace.getId();
        if (isNull(incomeId) || !incomeRepository.existsById(incomeId)) {
            throw new ReplaceIncomeException(String.format("Cannot replace income with given id: [%d]!!!", incomeId));
        }

        return saveIncome(incomeToReplace);
    }
}
