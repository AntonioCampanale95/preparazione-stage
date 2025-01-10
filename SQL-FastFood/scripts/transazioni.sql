USE ConsegneFastFood;

-- Transazione per aggiungere un nuovo ordine

START TRANSACTION;

INSERT INTO Ordini (id_cliente, id_ristorante, status)
VALUES (1, 1, 'in preparazione');

SET @ultimo_id_ordine = LAST_INSERT_id();

INSERT INTO PietanzeOrdine (id_ordine, id_pietanza, quantita)
VALUES
(@ultimo_id_ordine, 1, 2), -- 2 margherite
(@ultimo_id_ordine, 2, 1); -- 1 capricciosa

COMMIT;



-- Transazione per aggiornare stato ordine e saldo cliente

CREATE DEFINER=`root`@`localhost` PROCEDURE `aggiorna_ordine`()
BEGIN
    DECLARE totale_ordine DECIMAL(10,2);

    START TRANSACTION;

    SELECT SUM(po.quantita * m.prezzo)
    INTO totale_ordine
    FROM Ordini o
    JOIN PietanzeOrdine po ON o.id_ordine = po.id_ordine
    JOIN menu m ON po.id_pietanza = m.id_pietanza
    WHERE o.id_ordine = 1;

    IF totale_ordine IS NOT NULL THEN
        UPDATE Ordini
        SET status = 'partito'
        WHERE id_ordine = 1;

        UPDATE Clienti
        SET saldo = saldo - totale_ordine
        WHERE id_cliente = 1;

        COMMIT;
    ELSE
        ROLLBACK;
    END IF;
END

