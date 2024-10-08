package com.example.ASM_java4.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ChiTietSP")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class chitietsanpham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;

    @Column(name = "IdSP")
    private int idSp;

    @Column(name = "IdNsx")
    private int idNsx;

    @Column(name = "IdMauSac")
    private  int idMauSac;

    @Column(name = "IdDongSP")
    private  int idDongSp;

    @Column(name = "NamBH")
    private  int namBh;

    @Column(name = "MoTa")
    private String moTa ;

    @Column(name = "SoLuongTon")
    private  int soLuongTon;

    @Column(name = "GiaNhap")
    private  float giaNhap;

    @Column(name = "GiaBan")
    private  float giaBan;
}
