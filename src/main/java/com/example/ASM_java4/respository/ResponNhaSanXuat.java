package com.example.ASM_java4.respository;

import com.example.ASM_java4.config.HibanateConfig;
import com.example.ASM_java4.entity.chucvu;
import com.example.ASM_java4.entity.nhasanxuat;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ResponNhaSanXuat {
    public List<nhasanxuat> getAll() {
        Session sessison = HibanateConfig.getFACTORY().openSession();
        List<nhasanxuat> lists = sessison.createQuery("FROM nhasanxuat").list();
        sessison.close();
        return lists;
    }
    //Get One
    public nhasanxuat getOne(int id) {
        Session session = HibanateConfig.getFACTORY().openSession();
        Query query = session.createQuery("FROM nhasanxuat c where c.id=:mssv");
        query.setParameter("mssv",id);
        nhasanxuat c1 = (nhasanxuat) query.getSingleResult();
        session.close();
        return c1;
    }


    public void add(nhasanxuat c) {
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

    public void detele(nhasanxuat c) {
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

    public void update(nhasanxuat c) {
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
