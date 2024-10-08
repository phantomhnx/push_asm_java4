package com.example.ASM_java4.respository;

import com.example.ASM_java4.config.HibanateConfig;
import com.example.ASM_java4.entity.cuahang;
import com.example.ASM_java4.entity.dongsanpham;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ResponDongSp {
    public List<dongsanpham> getAll() {
        Session sessison = HibanateConfig.getFACTORY().openSession();
        List<dongsanpham> lists = sessison.createQuery("FROM dongsanpham ").list();
        sessison.close();
        return lists;
    }
    //Get One
    public dongsanpham getOne(int id) {
        Session session = HibanateConfig.getFACTORY().openSession();
        Query query = session.createQuery("FROM dongsanpham c where c.id=:mssv");
        query.setParameter("mssv",id);
        dongsanpham c1 = (dongsanpham) query.getSingleResult();
        session.close();
        return c1;
    }


    public void add(dongsanpham c) {
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

    public void detele(dongsanpham c) {
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

    public void update(dongsanpham c) {
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
