package lab.controller;

import lab.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import java.io.UnsupportedEncodingException;

@Controller
public class SubjectController {

    @Autowired
    @Qualifier(value = "subjectService")
    private SubjectService subjectService;

    public SubjectService getSubjectService() {
        return subjectService;
    }

    public void setSubjectService(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @RequestMapping(value="/edit",method=RequestMethod.GET)
    public String getEditPage(@RequestParam(value="week", required=true) String day,@RequestParam(value="studClass", required=true) String studClass,@RequestParam(value="subjId", required=true) String id,@RequestParam(value="value", required=true) String value,@RequestParam(value="action", required=true) String action,Model model) throws UnsupportedEncodingException {
        model.addAttribute("week",new String(day.getBytes("ISO-8859-1"),"UTF-8") );
        model.addAttribute("cl", studClass+" класс");
        model.addAttribute("subject", subjectService.getSubject(Integer.parseInt(id)));
        model.addAttribute("value",new String(value.getBytes("ISO-8859-1"),"UTF-8"));
        model.addAttribute("edit",action);
        return "editMarkAndHomeWorkPage";
    }

    @RequestMapping(value="/edit",method=RequestMethod.POST)
    public String edit(@RequestParam(value="action", required=true) String action,@RequestParam(value="id", required=true) String id,@RequestParam(value="value", required=true) String value,Model model)
    {
        String type = "student";
        if(action.equalsIgnoreCase("mark")){
            subjectService.updateMark(Integer.parseInt(id),Integer.parseInt(value));
            type="teacher";
        }else {
            subjectService.updateHomework(Integer.parseInt(id),value);
        }
        model.addAttribute("type",type);
        return "viewPage";
    }
}
