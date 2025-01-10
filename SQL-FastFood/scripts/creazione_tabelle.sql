
CREATE TABLE Ristoranti (
id_ristorante INT AUTO_INCREMENT PRIMARY KEY,
nome VARCHAR(255) NOT NULL,
indirizzo VARCHAR(255) NOT NULL,
telefono VARCHAR(20) NOT NULL,
tipologia VARCHAR(100) );

CREATE TABLE Menu (
id_pietanza INT AUTO_INCREMENT PRIMARY KEY,
id_ristorante INT NOT NULL,
nome VARCHAR(255) NOT NULL,
prezzo DECIMAL(10, 2) NOT NULL,
FOREIGN KEY (id_ristorante) REFERENCES Ristoranti(id_ristorante));

CREATE TABLE Clienti (
id_cliente INT AUTO_INCREMENT PRIMARY KEY,
nome VARCHAR(255) NOT NULL,
email VARCHAR(255),
indirizzo VARCHAR(255) NOT NULL,
telefono VARCHAR(20));

CREATE TABLE Ordini (
id_ordine INT AUTO_INCREMENT PRIMARY KEY,
id_cliente INT NOT NULL,
id_ristorante INT NOT NULL,
data_ordine DATETIME DEFAULT CURRENT_TIMESTAMP,
status VARCHAR(50) DEFAULT 'in preparazione',
FOREIGN KEY (id_cliente) REFERENCES Clienti(id_cliente),
FOREIGN KEY (id_ristorante) REFERENCES Ristoranti(id_ristorante));

CREATE TABLE PietanzeOrdine (
id_pietanza_ordine INT AUTO_INCREMENT PRIMARY KEY,
id_ordine INT NOT NULL,
id_pietanza INT NOT NULL,
quantita INT NOT NULL,
FOREIGN KEY (id_ordine) REFERENCES Ordini(id_ordine),
FOREIGN KEY (id_pietanza) REFERENCES Menu(id_pietanza));

CREATE TABLE Corrieri (
id_corriere INT AUTO_INCREMENT PRIMARY KEY,
nome VARCHAR(255) NOT NULL,
telefono VARCHAR(20),
veicolo VARCHAR(50));

CREATE TABLE Consegne (
id_consegna INT AUTO_INCREMENT PRIMARY KEY,
id_ordine INT NOT NULL,
id_corriere INT NOT NULL,
data_consegna DATETIME DEFAULT CURRENT_TIMESTAMP,
stato_consegna VARCHAR(50) DEFAULT 'in corso',
FOREIGN KEY (id_ordine) REFERENCES Ordini(id_ordine),
FOREIGN KEY (id_corriere) REFERENCES Corrieri(id_corriere));


-- Aggiungo una colonna saldo alla tabella Clienti

ALTER TABLE Clienti
ADD COLUMN saldo DECIMAL(10, 2) DEFAULT 50.00;