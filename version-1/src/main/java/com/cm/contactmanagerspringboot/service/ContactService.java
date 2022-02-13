package com.cm.contactmanagerspringboot.service;

import com.cm.contactmanagerspringboot.dao.ContactDao;
import com.cm.contactmanagerspringboot.entity.Contact;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Collection;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author vaisakhvm
 */
@Named
public class ContactService {
    @Inject
    private ContactDao contactDao;

    public Collection<Contact> getAllContacts() {
        return contactDao.getAll();
    }

    public Contact get(UUID id) {
       return contactDao.getOne(id);
    }

    public void add(Contact contact) {
        if(contact.getFirstName() != null && contact.getLastName() != null && contact.getProfession() != null) {
            contactDao.add(contact);
        }
    }

    public Collection<Contact> getAllContactsByProfession(String profession, String firstNameLike) {
        System.out.println(firstNameLike);
        return contactDao.getAll()
                .stream()
                .filter(c -> c.getProfession().equals(profession))
                .filter(c -> c.getFirstName().contains(firstNameLike))
                .collect(Collectors.toList());
    }
}
