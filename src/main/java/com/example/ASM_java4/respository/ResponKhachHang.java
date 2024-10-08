package com.example.ASM_java4.respository;

import com.example.ASM_java4.config.HibanateConfig;
import com.example.ASM_java4.entity.cuahang;
import com.example.ASM_java4.entity.khachhang;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ResponKhachHang {
    public List<khachhang> getAll() {
        Session sessison = HibanateConfig.getFACTORY().openSession();
        List<khachhang> lists = sessison.createQuery("FROM khachhang ").list();
        sessison.close();
        return lists;
    }
    //Get One
    public khachhang getOne(int id) {
        Session session = HibanateConfig.getFACTORY().openSession();
        Query query = session.createQuery("FROM khachhang c where c.id=:mssv");
        query.setParameter("mssv",id);
        khachhang c1 = (khachhang) query.getSingleResult();
        session.close();
        return c1;
    }


    public void add(khachhang c) {
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

    public void detele(khachhang c) {
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

    public void update(khachhang c) {
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
