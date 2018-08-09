package lab.dao;

import lab.models.SchoolDay;
import lab.models.Subject;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Repository
public class SchoolDayDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void addSchoolDay(SchoolDay day){
        getSessionFactory().getCurrentSession().save(day);
    }

    @SuppressWarnings("unchecked")
    public List<SchoolDay> list(){
        return getSessionFactory().getCurrentSession().createQuery("from SchoolDay").list();
    }

    @SuppressWarnings("unchecked")
    public SchoolDay getDay(int cl, String day){
        Session session= getSessionFactory().getCurrentSession();
        Query query = session.createQuery("from SchoolDay as s where s.studClass = :cl and s.day= :day");
        query.setParameter("cl", cl);
        query.setParameter("day", day);
        return (SchoolDay) query.uniqueResult();
    }

    @SuppressWarnings("unchecked")
    public Subject getLesson(int id, int num){
        Session session= getSessionFactory().getCurrentSession();
        Query query = session.createQuery("from Subject as s where s.schoolday = :id and s.numlesson = :num ");
        query.setParameter("id", id);
        query.setParameter("num", num);
        if(query.uniqueResult()!=null){
            return (Subject) query.uniqueResult();}
        else{
            return null;
        }
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}

