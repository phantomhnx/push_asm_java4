package com.example.ASM_java4.respository;

import com.example.ASM_java4.config.HibanateConfig;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.example.ASM_java4.entity.chucvu;

import java.util.List;

public class ResponChucvu {
    public List<chucvu> getAll() {
        Session sessison = HibanateConfig.getFACTORY().openSession();
        List<chucvu> lists = sessison.createQuery("FROM chucvu").list();
        sessison.close();
        return lists;
    }
    //Get One
    public chucvu getOne(int id) {
        Session session = HibanateConfig.getFACTORY().openSession();
        Query query = session.createQuery("FROM chucvu c where c.id=:mssv");
        query.setParameter("mssv",id);
        chucvu c1 = (chucvu) query.getSingleResult();
        session.close();
        return c1;
    }


    public void add(chucvu c) {
        Transaction tra = null;
        try {
            Session s = HibanateConfig.getFACTORY().openSession();
            tra = s.beginTransaction();
            s.persist(c); //Add
            tra.commit();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void detele(chucvu c) {
        Transaction tra = null;
        try {
            Session s = HibanateConfig.getFACTORY().openSession();
            tra = s.beginTransaction();
            s.delete(c); //Detele
            tra.commit();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(chucvu c) {
        Transaction tra = null;
        try {
            Session s = HibanateConfig.getFACTORY().openSession();
            tra = s.beginTransaction();
            s.merge(c); //Update
            tra.commit();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
