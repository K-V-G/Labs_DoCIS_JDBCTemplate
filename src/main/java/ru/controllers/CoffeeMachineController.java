package ru.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.dao.CoffeeMachineDAO;
import ru.models.CoffeeMachine;

import javax.validation.Valid;

@Controller
@RequestMapping("/coffeeMachine")
public class CoffeeMachineController {

    private final CoffeeMachineDAO coffeeMachineDAO;

    @Autowired
    public CoffeeMachineController(CoffeeMachineDAO coffeeMachineDAO){
        this.coffeeMachineDAO = coffeeMachineDAO;
    }

    @GetMapping()
    public String index(Model model){
        model.addAttribute("coffeeMachine", coffeeMachineDAO.index());
        return "coffeeMachine/index";
    }
    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("coffeeMachine", coffeeMachineDAO.show(id));
        return "coffeeMachine/show";
    }

    @GetMapping("/new")
    public String newPerson(@ModelAttribute("coffeeMachine") CoffeeMachine coffeeMachine) {
        return "coffeeMachine/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("coffeeMachine") @Valid CoffeeMachine coffeeMachine,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "coffeeMachine/new";

        coffeeMachineDAO.save(coffeeMachine);
        return "redirect:/coffeeMachine";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("coffeeMachine", coffeeMachineDAO.show(id));
        return "coffeeMachine/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("coffeeMachine") @Valid CoffeeMachine coffeeMachine,
                         BindingResult bindingResult,
                         @PathVariable("id") int id) {
        if (bindingResult.hasErrors())
            return "coffeeMachine/edit";

        coffeeMachineDAO.update(id, coffeeMachine);
        return "redirect:/coffeeMachine";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        coffeeMachineDAO.delete(id);
        return "redirect:/coffeeMachine";
    }

}
