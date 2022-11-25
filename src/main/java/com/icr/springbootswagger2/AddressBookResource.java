package com.icr.springbootswagger2;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;


@RestController
@RequestMapping("/api")
public class AddressBookResource {


    public static ConcurrentMap<String, Contact> allContacts = new ConcurrentHashMap<>();



        @GetMapping("/{id}")
    public Contact getContact(@PathVariable String id){

            allContacts.get(id);

        return allContacts.get(id);
        }

    @GetMapping("/")
    public List<Contact> getAllContacts(){
            return new ArrayList<Contact>(allContacts.values());

    }

    @PostMapping("/")
    public Contact addContact(@RequestBody Contact contact){
            allContacts.put(contact.getId(), contact);
            return contact;
    }
}
