import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

public class ContactTest {

    private ArrayList<Contact> contacts;

    @BeforeEach
    void setup() {
        contacts = new ArrayList<>();
        contacts.add(new Contact("Ada Lovelace", "+1 617 555 0101"));
        contacts.add(new Contact("Grace Hopper", "555-0000"));
        contacts.add(new Contact("Alan Turing", "555-0001"));
        contacts.add(new Contact("Katherine Johnson", "555-0002"));
        contacts.add(new Contact("Katherine Johnson", "555-0003"));
    }

    @Test
    void constructor_setsNameCorrectly() {
        assertEquals("Ada Lovelace", contacts.get(0).getName());
    }

    @Test
    void constructor_setsPhoneCorrectly() {
        assertEquals("+1 617 555 0101", contacts.get(0).getPhone());
    }

    @Test
    void getName_returnsExactString_notTransformed() {
        assertEquals("Grace Hopper", contacts.get(1).getName());
    }

    @Test
    void toString_containsName() {
        assertTrue(contacts.get(2).toString().contains("Alan Turing"));
    }

    @Test
    void toString_containsPhone() {
        assertTrue(contacts.get(2).toString().contains("555-0001"));
    }

    @Test
    void contacts_withSameName_areIndependent() {
        assertEquals("Katherine Johnson", contacts.get(3).getName());
        assertEquals("555-0003", contacts.get(4).getPhone());
    }

}