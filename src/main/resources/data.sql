INSERT INTO Income(AMOUNT_IN_POLISH_GROSZ, INCOME_DATE, INCOME_SOURCE, INCOME_TYPE)
VALUES (10000, '2021-05-19', 'testiowa', 'MOPS');
-- TODO: check red errors:)

-- mails
INSERT INTO email_receiver(email)
VALUES ('majg.tychy@gmail.com');

INSERT INTO email_receiver(email)
VALUES ('drikszajd@gmail.com');

-- messages to send
INSERT INTO emails_to_send(body, title, odbiorca_id)
VALUES('Witaj na zajęciach z Javy', 'Message from Duke', select id from email_receiver where email = 'majg.tychy@gmail.com');

INSERT INTO emails_to_send(body, title, odbiorca_id)
VALUES('Witaj na zajęciach z Javy', 'Message from Duke', select id from email_receiver where email = 'drikszajd@gmail.com');
