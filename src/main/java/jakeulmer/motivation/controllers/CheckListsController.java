package jakeulmer.motivation.controllers;

import jakeulmer.motivation.models.forms.CheckLists;
import jakeulmer.motivation.models.data.CheckListsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("check_lists")
public class CheckListsController {

    @Autowired
    private CheckListsDao checkListsDao;

    @RequestMapping(value = "")
    public String index(Model model){
        model.addAttribute("checkListItems", checkListsDao.findAll());

        return "check_lists/index";
    }
}
