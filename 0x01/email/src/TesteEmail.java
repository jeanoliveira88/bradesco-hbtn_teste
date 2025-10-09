package src;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TesteEmail {

    @Test
    public void testar_email_com_arroba() {
        String email = "email_teste@dominio.com.br";
        assertTrue(Pessoa.emailValid(email));
    }

    @Test
    public void testar_email_sem_arroba() {
        String email = "email_testedominio.com.br";
        assertFalse(Pessoa.emailValid(email));
    }

    @Test
    public void testar_email_mais_50_caracteres() {
        String email = "email_teste_muito_longo_nao_deve_ser_valido@dominio.com.br";
        assertEquals(false, Pessoa.emailValid(email));
    }
}

