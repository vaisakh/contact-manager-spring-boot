package com.cm.contactmanagerspringboot.dao;

import com.cm.contactmanagerspringboot.entity.Contact;

import javax.inject.Named;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author vaisakhvm
 */
@Named
public class ContactDao {
    private Map<UUID, Contact> contacts = new HashMap<>(); {
        UUID idOne = UUID.randomUUID();
        UUID idTwo = UUID.randomUUID();
        UUID idThree = UUID.randomUUID();
        contacts.put(idOne, new Contact(idOne, "Sachin", "Tendulkar", "cricket"));
        contacts.put(idTwo, new Contact(idTwo, "Saurav", "Ganguly", "cricket"));
        contacts.put(idThree, new Contact(idThree, "Saina", "Nehwal", "badminton"));
    }

    public Collection<Contact> getAll() {
        return contacts.values();
    }

    public Contact getOne(UUID id) {
       return contacts.get(id);
    }

    public void add(Contact contact) {
        UUID id = UUID.randomUUID();
        contact.setId(id);
        contacts.put(id, contact);
    }
}
