package test;

import main.model.User;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;


public class UserTest {

    @Test
    public void gommaInstantiation () {
        User user = new User(0, "usernameTest", "passwordTest", "nomeTest", "cognomeTest", "telefonoTest", "mailTest", "partitaivaTest", "ruoloTest");
        assertNotNull(user);
        assertEquals(100, user.getIdutente());
        assertEquals("example", user.getUsername());
        assertEquals("example", user.getMail());
        assertEquals("example", user.getNome());
        assertEquals("example", user.getPartitaiva());
        assertEquals("example", user.getPassword());
        assertEquals("example", user.getRuolo());
        assertEquals("example", user.getTelefono());
        assertEquals("example", user.getCognome());
        
    }
}
