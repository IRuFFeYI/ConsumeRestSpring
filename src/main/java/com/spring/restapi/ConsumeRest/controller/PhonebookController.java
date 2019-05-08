package com.spring.restapi.ConsumeRest.controller;

import com.spring.restapi.ConsumeRest.model.PhonebookEntry;
import com.spring.restapi.ConsumeRest.service.PhonebookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PhonebookController {

    @Autowired
    PhonebookService service;

    @GetMapping()
    public String getAllEntries(Model model){
        model.addAttribute("phonebook", service.getAllEntries());
        model.addAttribute("entry", new PhonebookEntry());
        return "index";
    }

    @PostMapping("/createEntry")
    public String createEntry(Model model, @ModelAttribute("entry")PhonebookEntry entry){
        service.createEntry(entry);
        return "redirect:/";
    }

    @PostMapping("/deleteEntry/{id}")
    public String deleteEntry(Model model, @PathVariable int id){
        service.deleteEntry(id);
        return "redirect:/";
    }
}
