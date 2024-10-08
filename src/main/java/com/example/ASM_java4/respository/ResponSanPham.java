package com.example.ASM_java4.respository;

import com.example.ASM_java4.config.HibanateConfig;
import com.example.ASM_java4.entity.chucvu;
import com.example.ASM_java4.entity.sanpham;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ResponSanPham {
    public List<sanpham> getAll() {
        Session sessison = HibanateConfig.getFACTORY().openSession();
        List<sanpham> lists = sessison.createQuery("FROM sanpham").list();
        sessison.close();
        return lists;
    }
    //Get One
    public sanpham getOne(int id) {
        Session session = HibanateConfig.getFACTORY().openSession();
        Query query = session.createQuery("FROM sanpham c where c.id=:mssv");
        query.setParameter("mssv",id);
        sanpham c1 = (sanpham) query.getSingleResult();
        session.close();
        return c1;
    }


    public void add(sanpham c) {
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

    public void detele(sanpham c) {
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

    public void update(sanpham c) {
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
