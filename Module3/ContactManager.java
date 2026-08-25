import java.util.*;

public class ContactManager {

    public static void main(String[] args) {

        HashMap<String, Contact> contacts = new HashMap<>();

        // adding contacts to HashMap
        contacts.put("Lisa", new Contact("Lisa", "+1 571 436 7773"));
        contacts.put("John", new Contact("John", "+1 571 436 4444"));
        contacts.put("Mike", new Contact("Mike", "+1 571 436 5555"));
        contacts.put("Kate", new Contact("Kate", "+1 571 436 6666"));
        contacts.put("Dave", new Contact("Dave", "+1 571 436 8888"));

        // look up a contact (With non-existing key in contacts)
        String searchKey = "Alex";
        Contact foundContact = contacts.get(searchKey);
        if (foundContact != null) {
            System.out.println("Contact found: " + foundContact.toString());
        } else {
            System.out.println("Contact not found for key: [" + searchKey + "]");
        }

        // lookup a contact (with key existing in contacts)
        searchKey = "Lisa";
        foundContact = contacts.get(searchKey);
        if (foundContact != null) {
            System.out.println("Contact found for key[" + searchKey + "]: " + foundContact.toString());
        } else {
            System.out.println("Contact not found for key: [" + searchKey + "]");
        }

        // print sorted list
        ArrayList<Contact> sorted = new ArrayList<>(contacts.values());
        sorted.sort((a, b) -> a.getName().compareTo(b.getName()));

        System.out.println("============ All Contacts ============");
        for (Contact contact : sorted) {
            System.out.println(contact.toString());
        }

        System.out.println(); // Added for readability in output

        // Remove a contact via calling removeContact Method
        removeContact("Dave", contacts);
        System.out.println(); // Added for readability in output


        //Reprint the sorted list after deleting a contact
        sorted = new ArrayList<>(contacts.values());
        sorted.sort((a, b) -> a.getName().compareTo(b.getName()));

        System.out.println("============ All Contacts ============");
        for (Contact contact : sorted) {
            System.out.println(contact.toString());
        }
    }

    // remove contact from HashMap
    private static boolean removeContact(String key, HashMap<String, Contact> contacts) {
        Contact contact = contacts.get(key);
        if (contact != null) {
            contacts.remove(key);
            System.out.println("Contact deleted successfully for key [" + key + "]");
            return true;
        } else {
            System.out.println("Contact not available for key [" + key + "] to delete.");
            return false;
        }
    }
}