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
@Table(name = "NhanVien")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class nhanvien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;

    @Column(name = "Ma")
    private String ma;

    @Column(name = "Ten")
    private String ten;

    @Column(name = "TenDem")
    private String tenDem;

    @Column(name = "Ho")
    private String ho;

    @Column(name = "GioiTinh")
    private String gioiTinh;

    @Column(name = "NgaySinh")
    private String ngaySinh;

    @Column(name = "DiaChi")
    private String diaChi;

    @Column(name = "Sdt")
    private String sdt;

    @Column(name = "MatKhau")
    private String matKhau;

    @Column(name = "IdCH")
    private Integer idCh;

    @Column(name = "IdCv")
    private Integer idCv;

    @Column(name = "IdGuiBC")
    private Integer idGuiBc;

    @Column(name = "TrangThai")
    private Integer trangThai;

}
