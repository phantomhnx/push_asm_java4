package com.example.ASM_java4.respository;

import com.example.ASM_java4.config.HibanateConfig;
import com.example.ASM_java4.entity.khachhang;
import com.example.ASM_java4.entity.mausac;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ResPonMauSac {
    public List<mausac> getAll() {
        Session sessison = HibanateConfig.getFACTORY().openSession();
        List<mausac> lists = sessison.createQuery("FROM mausac ").list();
        sessison.close();
        return lists;
    }
    //Get One
    public mausac getOne(int id) {
        Session session = HibanateConfig.getFACTORY().openSession();
        Query query = session.createQuery("FROM mausac c where c.id=:mssv");
        query.setParameter("mssv",id);
        mausac c1 = (mausac) query.getSingleResult();
        session.close();
        return c1;
    }


    public void add(mausac c) {
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

    public void detele(mausac c) {
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

    public void update(mausac c) {
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
