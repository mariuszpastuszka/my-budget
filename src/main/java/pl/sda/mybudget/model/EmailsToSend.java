package pl.sda.mybudget.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.sda.mybudget.model.enumeration.MailSendStatus;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailsToSend {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "odbiorca_id", referencedColumnName = "id")
    private EmailReceiver receiver;

    private String body;

    private String title;

    private LocalDateTime sendTime;

    @Enumerated(EnumType.STRING)
    private MailSendStatus deliveryStatus;
}
