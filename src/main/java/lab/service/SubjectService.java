package lab.service;

import lab.dao.SubjectDAO;
import lab.models.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SubjectService {
    @Autowired
    private SubjectDAO subjectDAO;

    @Transactional
    public void addSubject(Subject subject) {
        getSubjectDAO().addSubject(subject);
    }

    @Transactional
    public void updateMark(int id,int mark) {
        getSubjectDAO().updateMark(id,mark);
    }

    @Transactional
    public void update(int id,String subject,String homework) {

        getSubjectDAO().updateSubject(id, subject);
        getSubjectDAO().updateHomework(id,homework);
    }

    @Transactional
    public void updateHomework(int id,String homework) {
        getSubjectDAO().updateHomework(id,homework);
    }

    @Transactional
    public Subject getSubject(int id){
        return getSubjectDAO().getSubject(id);
    }

    public SubjectDAO getSubjectDAO() {
        return subjectDAO;
    }

    public void setSubjectDAO(SubjectDAO subjectDAO) {
        this.subjectDAO = subjectDAO;
    }
}
