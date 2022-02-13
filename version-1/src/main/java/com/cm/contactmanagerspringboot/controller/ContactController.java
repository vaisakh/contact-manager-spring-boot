package com.cm.contactmanagerspringboot.controller;

import com.cm.contactmanagerspringboot.entity.Contact;
import com.cm.contactmanagerspringboot.service.ContactService;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.net.URI;
import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

/**
 * @author vaisakhvm
 */
@RequestMapping("contact")
@RestController()
public class ContactController {
    @Inject
    private ContactService contactService;

    @GetMapping
    public Collection<Contact> getAll() {
        return contactService.getAllContacts();
    }

    @GetMapping("/{id}")
    public Contact getContact(@PathVariable("id") UUID id) {
        return contactService.get(id);
    }

    @GetMapping("/search/{profession}")
    public Collection<Contact> searchByProfession(@PathVariable("profession") String profession,
                                                  @RequestParam("firstName") Optional<String> optional) {
        return contactService.getAllContactsByProfession(profession, optional.orElse(""));
    }

    @PostMapping
    public ResponseEntity<String> addContact(@RequestBody Contact contact) {
        contactService.add(contact);
        if(contact.getId() != null) {
            URI uri = URI.create("/contact/" + contact.getId());
            return ResponseEntity.accepted().location(uri).build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}
