USE ConsegneFastFood;

INSERT INTO Ristoranti (nome, indirizzo, telefono, tipologia)
VALUES
('Pizza pazza', 'Via Francia 10', '1338118383', 'Italiano'),
('Koun Sushi', 'Via Martiri 20', '319193319', 'Giapponese');

INSERT INTO Menu (id_ristorante, nome, prezzo)
VALUES
(1, 'Margherita', 8.50),
(1, 'Capricciosa', 10.00),
(2, 'Sushi roll', 12.00), 
(2, 'Gunkan', 15.00);


INSERT INTO Clienti (nome, email, indirizzo, telefono)
VALUES
('Mario Gianluchi', 'mario.gianluchi@eafae.com', 'Via Napoli 5', '133133113'),
('Giulia Luciani', 'giulia.luciani@eageag.com', 'Via stizzi 10', '34141511');

INSERT INTO Corrieri (nome, telefono, veicolo)
VALUES
('Mohamed Rossi', '141414141', 'Automobile'),
('Marco Baglio', '133141441551', 'Bicicletta');