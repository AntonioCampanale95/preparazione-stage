package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UtenteService {

    @Autowired
    private UtenteRepository repo;

    public List<Utente> getAllUtenti() {
        return repo.findAll();
    }

    public Utente addUtente(Utente utente) {
        return repo.save(utente);
    }

    public Utente aggiornaUtente(Long id, Utente nuovoUtente) {
        Optional<Utente> utenteOpt = repo.findById(id);
        if (utenteOpt.isPresent()) {
            Utente utente = utenteOpt.get();
            utente.setNome(nuovoUtente.getNome());
            utente.setEmail(nuovoUtente.getEmail());
            return repo.save(utente);
        } else {
            throw new RuntimeException("Utente non trovato");
        }
    }

    public void deleteUtente(Long id) {
        repo.deleteById(id);
    }
}
