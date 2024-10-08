package com.example.ASM_java4.respository;

import com.example.ASM_java4.config.HibanateConfig;
import com.example.ASM_java4.entity.chucvu;
import com.example.ASM_java4.entity.nhanvien;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ResponNhanVien {
    public List<nhanvien> getAll() {
        Session sessison = HibanateConfig.getFACTORY().openSession();
        List<nhanvien> lists = sessison.createQuery("FROM nhanvien").list();
        sessison.close();
        return lists;
    }
    //Get One
    public nhanvien getOne(int id) {
        Session session = HibanateConfig.getFACTORY().openSession();
        Query query = session.createQuery("FROM nhanvien c where c.id=:mssv");
        query.setParameter("mssv",id);
        nhanvien c1 = (nhanvien) query.getSingleResult();
        session.close();
        return c1;
    }


    public void add(nhanvien c) {
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

    public void detele(nhanvien c) {
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

    public void update(nhanvien c) {
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
