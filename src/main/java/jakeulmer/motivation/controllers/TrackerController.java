package jakeulmer.motivation.controllers;

import jakeulmer.motivation.models.data.UserDao;
import jakeulmer.motivation.models.data.TrackerDao;
import jakeulmer.motivation.models.data.TrackerItemDao;
import jakeulmer.motivation.models.data.CategoryDao;


import jakeulmer.motivation.models.forms.User;
import jakeulmer.motivation.models.forms.Tracker;
import jakeulmer.motivation.models.forms.TrackerItem;
import jakeulmer.motivation.models.forms.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("tracker")
public class TrackerController {

    @Autowired
    private UserDao userDao;

    @Autowired
    private TrackerDao trackerDao;

    @Autowired
    private TrackerItemDao trackerItemDao;

    @Autowired
    private CategoryDao categoryDao;

    @RequestMapping(value = "")
    public String index(Model model, @PathVariable int trackerId) {

        model.addAttribute("tracker", trackerDao.findOne(trackerId));
        model.addAttribute("title", "Motivation Tracker");

        return "tracker/index";
    }

    @RequestMapping(value = "create-tracker", method = RequestMethod.GET)
    public String displayCreateTrackerForm(Model model) {
        model.addAttribute("title", "Create a New Tracker");
        model.addAttribute(new Tracker());
        model.addAttribute("trackerItem", trackerItemDao.findAll());
        model.addAttribute("category", categoryDao.findAll());
        //model.addAttribute("tracker", trackerDao.findAll());

        return "tracker/create-tracker";
    }
    /*@RequestMapping(value="create-tracker", method = RequestMethod.POST)
    public String processCreateTrackerForm(Model model, @ModelAttribute @Valid Tracker tracker, Errors errors) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Create a New Tracker");

            return "tracker/create-tracker";

        }

        else {
            if (user.getPassword().equals(verify)) {
                model.addAttribute("title", "Current Users");
                userDao.save(user);

                return "redirect:";

            } else {
                model.addAttribute("title", "Register a New Motivation Account");
                model.addAttribute("passNoMatch", "!!Passwords do not match!!");
                return "user/add-user";

            }
        }

    }*/
}
