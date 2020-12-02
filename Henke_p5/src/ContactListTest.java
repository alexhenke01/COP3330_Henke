import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactListTest {
    @Test
    public void addingItemsIncreasesSize(){
        ContactList contacts = new ContactList();
        ContactItem c = new ContactItem ("First", "Last", "123-456-7890", "em@i.l");
        contacts.add(c);
        assertEquals(1, contacts.size());
    }
    /*@Test
    public void editingItemsFailsWithAllBlankValues(){
        ContactList contacts = new ContactList();
        ContactItem c = new ContactItem ("First", "Last", "123-456-7890", "em@i.l");
        contacts.add(c);
        ContactItem edited = new ContactItem("", "", "", "");
        assertThrows(IllegalArgumentException.class, ()-> contacts.get(0).setContact("", "", "", ""));
    }*/
    @Test
    public void editingItemsFailsWithInvalidIndex(){
        ContactList contacts = new ContactList();
        ContactItem c = new ContactItem ("First", "Last", "123-456-7890", "em@i.l");
        contacts.add(c);
        ContactItem edited = new ContactItem("Alex", "Henke", "111-111-1111", "m@i.l");
        assertThrows(IndexOutOfBoundsException.class, ()-> contacts.replace(1, edited));
    }
    @Test
    public void editingItemsSucceedsWithBlankFirstName(){
        ContactList contacts = new ContactList();
        ContactItem c = new ContactItem ("First", "Last", "123-456-7890", "em@i.l");
        contacts.add(c);
        ContactItem edited = new ContactItem("", "Henke", "111-111-1111", "m@i.l");
        contacts.replace(0, edited);
        assertEquals("", contacts.get(0).getFirst());
    }
    @Test
    public void editingItemsSucceedsWithBlankLastName(){
        ContactList contacts = new ContactList();
        ContactItem c = new ContactItem ("First", "Last", "123-456-7890", "em@i.l");
        contacts.add(c);
        ContactItem edited = new ContactItem("Alex", "", "111-111-1111", "m@i.l");
        contacts.replace(0, edited);
        assertEquals("", contacts.get(0).getLast());
    }
    @Test
    public void editingItemsSucceedsWithBlankPhone(){
        ContactList contacts = new ContactList();
        ContactItem c = new ContactItem ("First", "Last", "123-456-7890", "em@i.l");
        contacts.add(c);
        ContactItem edited = new ContactItem("Alex", "Henke", "", "m@i.l");
        contacts.replace(0, edited);
        assertEquals("", contacts.get(0).getPhone());
    }
    @Test
    public void editingItemsSucceedsWithBlankEmail(){
        ContactList contacts = new ContactList();
        ContactItem c = new ContactItem ("First", "Last", "123-456-7890", "em@i.l");
        contacts.add(c);
        ContactItem edited = new ContactItem("Alex", "Henke", "111-111-1111", "");
        contacts.replace(0, edited);
        assertEquals("", contacts.get(0).getEmail());
    }
    @Test
    public void editingItemsSucceedsWithNonBlankValues(){
        ContactList contacts = new ContactList();
        ContactItem c = new ContactItem ("First", "Last", "123-456-7890", "em@i.l");
        contacts.add(c);
        ContactItem edited = new ContactItem("Alex", "Henke", "111-111-1111", "m@i.l");
        contacts.replace(0, edited);
        assertEquals("m@i.l", contacts.get(0).getEmail());
    }
    @Test
    public void newListIsEmpty(){
        ContactList contacts = new ContactList();
        assertEquals(0, contacts.size());
    }
    @Test
    public void removingItemsDecreasesSize(){
        ContactList contacts = new ContactList();
        ContactItem c = new ContactItem ("First", "Last", "123-456-7890", "em@i.l");
        contacts.add(c);
        contacts.remove(0);
        assertEquals(0, contacts.size());
    }
    @Test
    public void removingItemsFailsWithInvalidIndex(){
        ContactList contacts = new ContactList();
        ContactItem c = new ContactItem ("First", "Last", "123-456-7890", "em@i.l");
        contacts.add(c);
        assertThrows(IndexOutOfBoundsException.class, ()-> contacts.remove(1));
    }
    @Test
    public void savedContactListCanBeLoaded(){
        ContactList contacts = new ContactList();
        ContactItem c = new ContactItem ("First", "Last", "123-456-7890", "em@i.l");
        contacts.add(c);
        ContactItem d = new ContactItem("Alex", "Henke", "111-111-1111", "m@i.l");
        contacts.add(d);
        contacts.write("test.txt");
        contacts.read("test.txt");
        assertEquals(c, contacts.get(0));
    }
}