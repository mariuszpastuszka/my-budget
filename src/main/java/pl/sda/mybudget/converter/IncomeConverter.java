package pl.sda.mybudget.converter;

import pl.sda.mybudget.dto.IncomeDto;
import pl.sda.mybudget.model.Income;
import pl.sda.mybudget.model.enumeration.IncomeType;

public class IncomeConverter implements DataConverter<Income, IncomeDto> {
    @Override
    public IncomeDto fromEntity(Income entity) {
        return new IncomeDto(entity.getId(),
                entity.getAmountInPolishGrosz(),
                entity.getIncomeDate(),
                entity.getIncomeSource(),
                entity.getIncomeType().name());
    }

    @Override
    public Income fromDto(IncomeDto dto) {
        return new Income(dto.getId(),
                dto.getAmountInPolishGrosz(),
                dto.getIncomeDate(),
                dto.getIncomeSource(),
                IncomeType.valueOf(dto.getIncomeType()));
    }
}
