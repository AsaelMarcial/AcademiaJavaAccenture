package com.academy.springmvc.controllers;

import com.academy.springmvc.entities.Personas;
import com.academy.springmvc.services.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/personas")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @GetMapping("/list")
    public String listPersonas(Model model) {
        List<Personas> personas = personaService.getPersonas();

        model.addAttribute("personas", personas);
        return "list-personas";
    }

    @GetMapping("/addPersonaForm")
    public String addPersonaForm(Model model) {
        Personas persona = new Personas();
        model.addAttribute("persona", persona);
        return "add-persona-form";
    }

    @PostMapping("/savePersona")
    public String savePersona(@ModelAttribute("personas") Personas persona) {
        personaService.savePersona(persona);
        return "redirect:/personas/list";
    }

    @GetMapping("/updatePersona")
    public String updatePersona(@RequestParam("id") int id, Model model) {
        Personas persona = personaService.getPersona(id);
        model.addAttribute("persona", persona);
        return "add-persona-form";
    }

    @GetMapping("/delete")
    public String deletePersona(@RequestParam("id") int id) {
        personaService.deletePersona(id);
        return "redirect:/personas/list";
    }
}
