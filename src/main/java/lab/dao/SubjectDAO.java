package lab.dao;

import lab.models.Subject;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SubjectDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public void addSubject(Subject subject){
        getSessionFactory().getCurrentSession().save(subject);
    }

    @SuppressWarnings("unchecked")
    public List<Subject> list(){
        return getSessionFactory().getCurrentSession().createQuery("from Subject").list();
    }

    @SuppressWarnings("unchecked")
    public Subject getSubject(int id){
        Session session= getSessionFactory().getCurrentSession();
        Query query = session.createQuery("from Subject as s where s.id = :id ");
        query.setParameter("id", id);
        return (Subject) query.list().get(0);
    }

    public void updateMark(int id, int mark){
        Session session= getSessionFactory().getCurrentSession();
        Query query = session.createNativeQuery("UPDATE subjects SET mark = ? WHERE idsubject = ? ");
        query.setParameter(1, mark);
        query.setParameter(2, id);
        Transaction transaction = sessionFactory.getCurrentSession().beginTransaction();
        query.executeUpdate();
        transaction.commit();
    }

    public void updateSubject(int id, String subject){
        Session session= getSessionFactory().getCurrentSession();
        Query query = session.createQuery("update Subject set name = :subject where id = :id ");
        query.setParameter("id", id);
        query.setParameter("subject", subject);
        Transaction transaction = sessionFactory.getCurrentSession().beginTransaction();
        query.executeUpdate();
        transaction.commit();
    }


    public void updateHomework(int id, String work){
        Session session= getSessionFactory().getCurrentSession();
        Query query = session.createQuery("update Subject set homework = :work where id = :id ");
        query.setParameter("id", id);
        query.setParameter("work", work);
        Transaction transaction = sessionFactory.getCurrentSession().beginTransaction();
        query.executeUpdate();
        transaction.commit();
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
