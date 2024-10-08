package com.example.ASM_java4.respository;

import com.example.ASM_java4.config.HibanateConfig;
import com.example.ASM_java4.entity.chucvu;
import com.example.ASM_java4.entity.cuahang;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ResponCuaHang {
    public List<cuahang> getAll() {
        Session sessison = HibanateConfig.getFACTORY().openSession();
        List<cuahang> lists = sessison.createQuery("FROM cuahang ").list();
        sessison.close();
        return lists;
    }
    //Get One
    public cuahang getOne(int id) {
        Session session = HibanateConfig.getFACTORY().openSession();
        Query query = session.createQuery("FROM cuahang c where c.id=:mssv");
        query.setParameter("mssv",id);
        cuahang c1 = (cuahang) query.getSingleResult();
        session.close();
        return c1;
    }


    public void add(cuahang c) {
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

    public void detele(cuahang c) {
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

    public void update(cuahang c) {
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
