package com.example.ASM_java4.respository;

import com.example.ASM_java4.config.HibanateConfig;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import com.example.ASM_java4.entity.chitietsanpham;
public class ResposiroryChitietSp {
    private Session se;

    public ResposiroryChitietSp(){
        se = HibanateConfig.getFACTORY().openSession();
    }

    public List<chitietsanpham> getAll() {
        Session sessison = HibanateConfig.getFACTORY().openSession();
        List<chitietsanpham> lists = sessison.createQuery("FROM chitietsanpham").list();
        sessison.close();
        return lists;
    }
    //Get One
    public chitietsanpham getOne(int idCtSp) {
        Session session = HibanateConfig.getFACTORY().openSession();
        Query query = session.createQuery("FROM chitietsanpham c where c.id=:idct");
        query.setParameter("idct",idCtSp);
        chitietsanpham c1 = (chitietsanpham) query.getSingleResult();
        session.close();
        return c1;
    }


    public void add(chitietsanpham c) {
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

    public void detele(chitietsanpham c) {
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

    public void update(chitietsanpham c){
        try {
            se.getTransaction().begin();
            se.saveOrUpdate(c);
            se.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
