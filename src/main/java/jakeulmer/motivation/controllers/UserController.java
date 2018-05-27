package jakeulmer.motivation.controllers;

import jakeulmer.motivation.models.data.UserDao;
import jakeulmer.motivation.models.forms.User;
import jakeulmer.motivation.models.data.TrackerDao;
import jakeulmer.motivation.models.data.CheckListsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserDao userDao;

    @Autowired
    private TrackerDao trackerDao;

    @Autowired
    private CheckListsDao checkListsDao;

    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("users", userDao.findAll());
        model.addAttribute("title", "Motivation Users");

        return "user/index";
    }

    @RequestMapping(value="/{userId}")
    public String userInfo(Model model, @PathVariable int userId) {
        model.addAttribute("user", userDao.findOne(userId));

        return "user/info";

    }

    @RequestMapping(value = "add-user", method = RequestMethod.GET)
    public String displayAddUserForm(Model model) {
        model.addAttribute("title", "Register a New Motivation Account");
        model.addAttribute(new User());
        model.addAttribute("users", userDao.findAll());

        return "user/add-user";
    }
    @RequestMapping(value="add-user", method = RequestMethod.POST)
    public String processAddUserForm(Model model, @ModelAttribute @Valid User user, Errors errors, @RequestParam String verify) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Register a New Motivation Account");

            return "user/add-user";

        }

        //if (userDao.findAll(user.getUsername())) {
           // model.addAttribute("title", "Register a New Motivation Account");
           //model.addAttribute("usernameInUse", "Username Already Exists.  Please Try Again.");
            //return "user/add-user";

        //}



        else {
            if (user.getPassword().equals(verify)) {
                model.addAttribute("title", "Current Users");
                /*Enter user hash here*/
                userDao.save(user);

                return "redirect:";

            } else {
                model.addAttribute("title", "Register a New Motivation Account");
                model.addAttribute("passNoMatch", "!!Passwords do not match!!");
                return "user/add-user";

            }
        }

    }

    @RequestMapping(value = "user-sign-in", method = RequestMethod.GET)
    public String displayUserSignInForm(Model model) {
        model.addAttribute("title", "Welcome Back!  Please Sign In.");
        model.addAttribute(new User());
        model.addAttribute("users", userDao.findAll());

        return "user/user-sign-in";
    }
}
