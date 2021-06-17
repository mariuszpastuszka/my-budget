package pl.sda.mybudget.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.sda.mybudget.model.EmailsToSend;

import java.util.List;

public interface EmailsToSendRepository extends JpaRepository<EmailsToSend, Long> {

    List<EmailsToSend> findAllBySendTimeIsNull();

    @Query(nativeQuery = false,
            value = """
         select emts
         from EmailsToSend emts
         where emts.sendTime is null
         """)
    List<EmailsToSend> findMailsToSend();
}
