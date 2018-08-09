package lab.controller;

import lab.models.HomeWork;
import lab.models.SchoolDay;
import lab.models.Subject;
import lab.service.SchoolDayService;
import lab.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.ArrayList;

@Controller
public class SchoolDayController {

    @Autowired
    @Qualifier(value = "schoolDayService")
    private SchoolDayService dayService;

    @Autowired
    @Qualifier(value = "subjectService")
    private SubjectService subjectService;

    public SubjectService getSubjectService() {
        return subjectService;
    }

    public void setSubjectService(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    public SchoolDayService getDayService() {
        return dayService;
    }

    public void setDayService(SchoolDayService dayService) {
        this.dayService = dayService;
    }

    @RequestMapping(value="/view",method=RequestMethod.POST)
    public String viewJournalFromViewPage(@RequestParam(value="type", required=true) String type, @RequestParam(value="day", required=true) String day,@RequestParam(value="studClass", required=true) String studClass,Model model)
    {
        SchoolDay s = dayService.getDay(Integer.parseInt(studClass), day);
        if(s!=null) {
            int id = s.getId();
            ArrayList<Subject> list = new ArrayList<>();
            for (int i=1; i<=6; i++){
                if (dayService.getLesson(id,i) != null) {
                    list.add(dayService.getLesson(id,i));
                }
            }
            model.addAttribute("schoolday", list);
        }
        model.addAttribute("day", day);
        model.addAttribute("cl",studClass);
        model.addAttribute("type",type);
        return "viewPage";
    }

    @RequestMapping(value="/addSchoolDay",method=RequestMethod.POST)
    public String addSchoolDay(@ModelAttribute("homework") HomeWork homeWork, Model model)
    {
        SchoolDay day = dayService.getDay(Integer.parseInt(homeWork.getStudClass()),homeWork.getDay());
        if(day==null){
            day = new SchoolDay();
            day.setStudClass(Integer.parseInt(homeWork.getStudClass()));
            day.setDay(homeWork.getDay());
            dayService.addDay(day);
            day = dayService.getDay(Integer.parseInt(homeWork.getStudClass()),homeWork.getDay());
        }
        Subject firstlesson = dayService.getLesson(day.getId(),1);
        Subject secondlesson = dayService.getLesson(day.getId(),2);
        Subject thirdlesson = dayService.getLesson(day.getId(),3);
        Subject fourthlesson = dayService.getLesson(day.getId(),4);
        Subject fifthlesson = dayService.getLesson(day.getId(),5);
        Subject sixthlesson = dayService.getLesson(day.getId(),6);
        if(firstlesson !=null){
            subjectService.update(firstlesson.getId(),homeWork.getFirstlesson(),homeWork.getFirstHomework());
        }else{
            firstlesson = new Subject(homeWork.getFirstlesson(),homeWork.getFirstHomework(), day.getId(),1);
            subjectService.addSubject(firstlesson);
        }
        if(secondlesson !=null){
            subjectService.update(secondlesson.getId(),homeWork.getSecondlesson(),homeWork.getSecondHomework());
        }else{
            subjectService.addSubject(new Subject(homeWork.getSecondlesson(),homeWork.getSecondHomework(), day.getId(),2));
        }
        if(thirdlesson !=null){
            subjectService.update(thirdlesson.getId(),homeWork.getThirdlesson(),homeWork.getThirdHomework());
        }else{
            subjectService.addSubject(new Subject(homeWork.getThirdlesson(),homeWork.getThirdHomework(), day.getId(),3));
        }
        if(fourthlesson !=null){
            subjectService.update(fourthlesson.getId(),homeWork.getFourthlesson(),homeWork.getFourthHomework());
        }else{
            subjectService.addSubject(new Subject(homeWork.getFourthlesson(),homeWork.getFourthHomework(), day.getId(),4));
        }
        if(fifthlesson !=null){
            subjectService.update(fifthlesson.getId(),homeWork.getFifthlesson(),homeWork.getFifthHomework());
        }else{
            subjectService.addSubject(new Subject(homeWork.getFifthlesson(),homeWork.getFifthHomework(), day.getId(),5));
        }
        if(sixthlesson !=null){
            subjectService.update(sixthlesson.getId(),homeWork.getSixthlesson(), homeWork.getSixthHomework());
        }else{
            subjectService.addSubject(new Subject(homeWork.getSixthlesson(), homeWork.getSixthHomework(), day.getId(),6));
        }
        model.addAttribute("type", "student");
        return "mainPage";
    }
}