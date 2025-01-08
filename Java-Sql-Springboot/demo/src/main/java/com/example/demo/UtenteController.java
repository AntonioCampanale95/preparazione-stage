package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/utenti")
public class UtenteController {

    @Autowired
    private UtenteService utenteService;

    @GetMapping
    public List<Utente> getAllUtenti() {
        return utenteService.getAllUtenti();
    }

    @PostMapping
    public Utente addUtente(@RequestBody Utente utente) {
        return utenteService.addUtente(utente);
    }

    @PutMapping("/{id}")
    public Utente aggiornaUtente(@PathVariable Long id, @RequestBody Utente nuovoUtente) {
        return utenteService.aggiornaUtente(id, nuovoUtente);
    }

    @DeleteMapping("/{id}")
    public String deleteUtente(@PathVariable Long id) {
        utenteService.deleteUtente(id);
        return "Utente cancellato";
    }
}
