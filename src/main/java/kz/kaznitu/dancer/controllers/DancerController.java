package kz.kaznitu.dancer.controllers;

import kz.kaznitu.dancer.models.Club;
import kz.kaznitu.dancer.models.Dancer;
import kz.kaznitu.dancer.repositories.ClubRepository;
import kz.kaznitu.dancer.repositories.DancerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DancerController {
    @Autowired
    private DancerRepository dancerRepository;

    @Autowired
    private ClubRepository clubRepository;

    @RequestMapping(value = "/dancers", method = RequestMethod.GET)
    public String dancersList(Model model){
        model.addAttribute("dancers", dancerRepository.findAll());
        model.addAttribute("clubs", clubRepository.findAll());
        return "dancers";
    }

    @RequestMapping(value = "/dancers",method = RequestMethod.POST)
    public String addDancer(@RequestParam Long clubIId,
                            @RequestParam String firstName,
                            @RequestParam String lastName,
                            Model model) {
        Club club = clubRepository.findById(clubIId).get();
        Dancer newDancer = new Dancer();
        newDancer.setClub(club);
        newDancer.setFirstName(firstName);
        newDancer.setLastName(lastName);
        dancerRepository.save(newDancer);

        return "redirect:/dancers";
    }

    @RequestMapping(value = "/remove", method = RequestMethod.GET)
    public String remove(@RequestParam("id") Long id){
        dancerRepository.deleteById(id);
        return "redirect:/dancers";
    }

}
