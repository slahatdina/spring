package kz.kaznitu.dancer.controllers;

import kz.kaznitu.dancer.models.Club;
import kz.kaznitu.dancer.repositories.ClubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class
ClubController {

    @Autowired
    ClubRepository clubRepository;

    @RequestMapping(value = "/clubs", method = RequestMethod.GET)
    public String clubList(Model model) {
        model.addAttribute("clubs", clubRepository.findAll());
        model.addAttribute("club", new Club());
        return "clubs";
    }

    @RequestMapping(value = "/saveclub", method = RequestMethod.POST)
    public String saveClub(@ModelAttribute Club club) {
        clubRepository.save(club);
        return "redirect:/clubs";
    }
}
