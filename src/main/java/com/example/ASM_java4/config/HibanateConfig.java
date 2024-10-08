package com.example.ASM_java4.config;

import com.example.ASM_java4.entity.chitietsanpham;
import com.example.ASM_java4.entity.chucvu;
import com.example.ASM_java4.entity.cuahang;
import com.example.ASM_java4.entity.dongsanpham;
import com.example.ASM_java4.entity.khachhang;
import com.example.ASM_java4.entity.mausac;
import com.example.ASM_java4.entity.nhanvien;
import com.example.ASM_java4.entity.nhasanxuat;
import com.example.ASM_java4.entity.sanpham;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class HibanateConfig {
    private static final SessionFactory FACTORY;

    static {
        Configuration conf = new Configuration();

        Properties properties = new Properties();
        properties.put(Environment.DIALECT, "org.hibernate.dialect.SQLServerDialect");
        properties.put(Environment.DRIVER, "com.microsoft.sqlserver.jdbc.SQLServerDriver");
        properties.put(Environment.URL, "jdbc:sqlserver://localhost:1433;databaseName=FINALASS_FPOLYSHOP_FA22_SOF205__SOF2041;encrypt=true;trustServerCertificate=true;");
        properties.put(Environment.USER, "sa");
        properties.put(Environment.PASS, "123");
        properties.put(Environment.SHOW_SQL, "true");

        conf.setProperties(properties);
        conf.addAnnotatedClass(mausac.class);
        conf.addAnnotatedClass(chucvu.class);
        conf.addAnnotatedClass(cuahang.class);
        conf.addAnnotatedClass(dongsanpham.class);
        conf.addAnnotatedClass(khachhang.class);
        conf.addAnnotatedClass(nhanvien.class);
        conf.addAnnotatedClass(nhasanxuat.class);
        conf.addAnnotatedClass(sanpham.class);
        conf.addAnnotatedClass(chitietsanpham.class);
        ServiceRegistry registry = new StandardServiceRegistryBuilder()
                .applySettings(conf.getProperties()).build();
        FACTORY = conf.buildSessionFactory(registry);

    }

    public static SessionFactory getFACTORY() {
        return FACTORY;
    }

    public static void main(String[] args) {
        System.out.println(getFACTORY());;
    }
}
