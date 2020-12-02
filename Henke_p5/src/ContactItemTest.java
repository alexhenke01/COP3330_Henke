import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactItemTest {
    @Test
    public void creationFailsWithAllBlankValues(){
        assertThrows(IllegalArgumentException.class, () -> new ContactItem("", "", "", ""));
    }
    @Test
    public void creationSucceedsWithBlankEmail(){
        assertDoesNotThrow(() -> new ContactItem("First", "Last", "123-456-7890", ""));
    }
    @Test
    public void creationSucceedsWithBlankFirstName(){
        assertDoesNotThrow(() -> new ContactItem("", "Last", "123-456-7890", "em@i.l"));
    }
    @Test
    public void creationSucceedsWithBlankLastName(){
        assertDoesNotThrow(() -> new ContactItem("First", "", "123-456-7890", "em@i.l"));
    }
    @Test
    public void creationSucceedsWithBlankPhone(){
        assertDoesNotThrow(() -> new ContactItem("First", "Last", "", "em@i.l"));
    }
    @Test
    public void creationSucceedsWithNonBlankValues(){
        assertDoesNotThrow(() -> new ContactItem("First", "Last", "123-456-7890", "em@i.l"));
    }
    @Test
    public void editingFailsWithAllBlankValues(){
        ContactItem c = new ContactItem("First", "Last", "123-456-7890", "em@i.l");
        assertThrows(IllegalArgumentException.class, () -> c.setContact("", "", "", ""));
    }
    @Test
    public void editingSucceedsWithBlankEmail(){
        ContactItem c = new ContactItem("First", "Last", "123-456-7890", "em@i.l");
        assertEquals("Alex Henke 111-111-1111 ", c.setContact("Alex", "Henke", "111-111-1111", ""));
    }
    @Test
    public void editingSucceedsWithBlankFirstName(){
        ContactItem c = new ContactItem("First", "Last", "123-456-7890", "em@i.l");
        assertEquals(" Henke 111-111-1111 em@i.l", c.setContact("", "Henke", "111-111-1111", "em@i.l"));
    }
    @Test
    public void editingSucceedsWithBlankLastName(){
        ContactItem c = new ContactItem("First", "Last", "123-456-7890", "em@i.l");
        assertEquals("Alex  111-111-1111 em@i.l", c.setContact("Alex", "", "111-111-1111", "em@i.l"));
    }
    @Test
    public void editingSucceedsWithBlankPhone(){
        ContactItem c = new ContactItem("First", "Last", "123-456-7890", "em@i.l");
        assertEquals("Alex Henke  em@i.l", c.setContact("Alex", "Henke", "", "em@i.l"));
    }
    @Test
    public void editingSucceedsWithNonBlankValues(){
        ContactItem c = new ContactItem("First", "Last", "123-456-7890", "em@i.l");
        assertEquals("Alex Henke 111-111-1111 em@i.l", c.setContact("Alex", "Henke", "111-111-1111", "em@i.l"));
    }
}