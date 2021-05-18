package pl.sda.mybudget.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.mybudget.model.Income;

public interface IncomeRepository extends JpaRepository<Income, Long> {
}
