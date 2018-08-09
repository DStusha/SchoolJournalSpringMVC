package lab.service;

import lab.dao.SchoolDayDAO;
import lab.models.SchoolDay;
import lab.models.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SchoolDayService {
    @Autowired
    private SchoolDayDAO schoolDayDAO;

    @Transactional
    public void addDay(SchoolDay day) {
        getSchoolDayDAO().addSchoolDay(day);
    }

    @Transactional
    public SchoolDay getDay(int cl, String day) {
        return schoolDayDAO.getDay(cl, day);
    }
    @Transactional
    public Subject getLesson(int id, int num){
        return schoolDayDAO.getLesson(id,num);
    }

    public SchoolDayDAO getSchoolDayDAO() {
        return schoolDayDAO;
    }

    public void setSchoolDayDAO(SchoolDayDAO schoolDayDAO) {
        this.schoolDayDAO = schoolDayDAO;
    }
}
