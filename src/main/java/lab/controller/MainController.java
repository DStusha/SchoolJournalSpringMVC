package lab.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController
{
    @RequestMapping(value="/welcome",method=RequestMethod.GET)
    public String welcome()
    {
        return "startPage";
    }

    @RequestMapping(value="/check-user",method=RequestMethod.POST)
    public String getUserType(@RequestParam(value="usertype", required=true) String type, Model model)
    {
        model.addAttribute("type",type);
        return "mainPage";
    }

    @RequestMapping(value="/tomain",method=RequestMethod.POST)
    public String toMain(@RequestParam(value="type", required=true) String type, Model model)
    {
        model.addAttribute("type",type);
        return "mainPage";
    }

    @RequestMapping(value="/view",method=RequestMethod.GET)
    public String viewJournalFromMainPage(@RequestParam(value="type", required=true) String type, Model model)
    {
        model.addAttribute("type",type);
        return "viewPage";
    }

    @RequestMapping(value="/addSchoolDay",method=RequestMethod.GET)
    public String getAddSchoolDayPage()
    {
        return "addSchoolDayPage";
    }

}
