package com.cm.contactmanagerspringboot.entity;

import java.util.UUID;

/**
 * @author vaisakhvm
 */
public class Contact {
    private UUID id;
    private String firstName;
    private String lastName;
    private String profession;

    public Contact(UUID id, String firstName, String lastName, String profession) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.profession = profession;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }
}
