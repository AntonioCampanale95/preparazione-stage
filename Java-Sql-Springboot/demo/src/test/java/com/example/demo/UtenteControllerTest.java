package com.example.demo;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UtenteControllerTest {

    @Mock
    private UtenteRepository utenteRepo;

    @InjectMocks
    private UtenteController utenteController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAggiungiUtente() {
        Utente utente = new Utente();
        utente.setNome("Massimo");
        utente.setEmail("max@email.com");

        when(utenteRepo.save(any(Utente.class))).thenReturn(utente);
        
        Utente output = utenteController.addUtente(utente);

        assertEquals("Massimo", output.getNome());
        assertEquals("max@email.com", output.getEmail());

        verify(utenteRepo, times(1)).save(utente);
    }


}
