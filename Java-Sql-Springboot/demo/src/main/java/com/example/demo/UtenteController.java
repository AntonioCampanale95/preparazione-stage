package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/api/utenti")
public class UtenteController {

    @Autowired
    private UtenteRepository repo;

    @GetMapping
    public List<Utente> getAllUtenti() {
        return repo.findAll();
    }


    @PostMapping
    public Utente addUtente(@RequestBody Utente utente) {
        return repo.save(utente);
    }


    @PutMapping("/{id}")
    public Utente aggiornaUtente(@PathVariable Long id, @RequestBody Utente nuovoUtente) {
        return repo.findById(id).map(utente -> {
            utente.setNome(nuovoUtente.getNome());
            utente.setEmail(nuovoUtente.getEmail());
            return repo.save(utente);
        }).orElseThrow(() -> new RuntimeException("Utente non trovato"));
    }


    @DeleteMapping("/{id}")
    public String deleteUtente(@PathVariable Long id) {
        repo.deleteById(id);
        return "Utente cancellato";
    }

    
    
}
