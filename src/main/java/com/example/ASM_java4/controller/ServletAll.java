package com.example.ASM_java4.controller;

import com.example.ASM_java4.entity.chitietsanpham;
import com.example.ASM_java4.entity.chucvu;
import com.example.ASM_java4.entity.cuahang;
import com.example.ASM_java4.entity.dongsanpham;
import com.example.ASM_java4.entity.khachhang;
import com.example.ASM_java4.entity.mausac;
import com.example.ASM_java4.entity.nhanvien;
import com.example.ASM_java4.entity.nhasanxuat;
import com.example.ASM_java4.entity.sanpham;
import com.example.ASM_java4.respository.ResPonMauSac;
import com.example.ASM_java4.respository.ResponChucvu;
import com.example.ASM_java4.respository.ResponCuaHang;
import com.example.ASM_java4.respository.ResponDongSp;
import com.example.ASM_java4.respository.ResponKhachHang;
import com.example.ASM_java4.respository.ResponNhaSanXuat;
import com.example.ASM_java4.respository.ResponNhanVien;
import com.example.ASM_java4.respository.ResponSanPham;
import com.example.ASM_java4.respository.ResposiroryChitietSp;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.ArrayStack;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ServletAll", value = {
        //Chi tiet san pham
        "/chi-tiet-san-pham/hien-thi-ct",
        "/chi-tiet-san-pham/add-ct",
        "/chi-tiet-san-pham/update-ct",
        "/chi-tiet-san-pham/view-update-ct",
        "/chi-tiet-san-pham/delete-ct",
        "/chi-tiet-san-pham/detail-ct",
        //Chuc vu
        "/chuc-vu/hien-thi-cv",
        "/chuc-vu/add-cv",
        "/chuc-vu/update-cv",
        "/chuc-vu/view-update-cv",
        "/chuc-vu/delete-cv",
        "/chuc-vu/detail-cv",

        //Cua hang
        "/cua-hang/hien-thi-ch",
        "/cua-hang/add-ch",
        "/cua-hang/update-ch",
        "/cua-hang/view-update-ch",
        "/cua-hang/delete-ch",
        "/cua-hang/detail-ch",

        //Dong san pham
        "/dong-san-pham/hien-thi-dsp",
        "/dong-san-pham/add-dsp",
        "/dong-san-pham/update-dsp",
        "/dong-san-pham/view-update-dsp",
        "/dong-san-pham/delete-dsp",
        "/dong-san-pham/detail-dsp",

        //Khach hang
        "/khach-hang/hien-thi-kh",
        "/khach-hang/add-kh",
        "/khach-hang/update-kh",
        "/khach-hang/view-update-kh",
        "/khach-hang/delete-kh",
        "/khach-hang/detail-kh",

        //Nhan vien
        "/nhan-vien/hien-thi-nv",
        "/nhan-vien/add-nv",
        "/nhan-vien/update-nv",
        "/nhan-vien/view-update-nv",
        "/nhan-vien/delete-nv",
        "/nhan-vien/detail-nv",

        //Mau sac
        "/mau-sac/hien-thi-ms",
        "/mau-sac/add-ms",
        "/mau-sac/update-ms",
        "/mau-sac/view-update-ms",
        "/mau-sac/delete-ms",
        "/mau-sac/detail-ms",

        //Nha san xuat
        "/nha-san-xuat/hien-thi-nsx",
        "/nha-san-xuat/add-nsx",
        "/nha-san-xuat/update-nsx",
        "/nha-san-xuat/view-update-nsx",
        "/nha-san-xuat/delete-nsx",
        "/nha-san-xuat/detail-nsx",

        //San Pham
        "/san-pham/hien-thi-sp",
        "/san-pham/add-sp",
        "/san-pham/update-sp",
        "/san-pham/view-update-sp",
        "/san-pham/delete-sp",
        "/san-pham/detail-sp",

        //Chuyen trang
        "/chuyen-trang/chi-tiet-sp",
        "/chuyen-trang/chuc-vu",
        "/chuyen-trang/cua-hang",
        "/chuyen-trang/dong-san-pham",
        "/chuyen-trang/khach-hang",
        "/chuyen-trang/mau-sac",
        "/chuyen-trang/nhan-vien",
        "/chuyen-trang/nha-san-xuat",
        "/chuyen-trang/san-pham"

})
public class ServletAll extends HttpServlet {
    ResposiroryChitietSp resCt = new ResposiroryChitietSp();
    ResponChucvu resCv = new ResponChucvu();
    ResponCuaHang resCh = new ResponCuaHang();
    ResponDongSp resDsp = new ResponDongSp();
    ResponKhachHang resKh = new ResponKhachHang();
    ResponNhanVien resNv = new ResponNhanVien();
    ResPonMauSac resMs = new ResPonMauSac();
    ResponNhaSanXuat resNsx = new ResponNhaSanXuat();
    ResponSanPham resSp = new ResponSanPham();

    List<sanpham> listSp = new ArrayList<>();
    List<nhasanxuat> listNsx = new ArrayList<>();
    List<mausac> listMs = new ArrayList<>();
    List<nhanvien> listNv = new ArrayList<>();
    List<khachhang> listKh = new ArrayList<>();
    List<dongsanpham> listDsp = new ArrayList<>();
    List<chucvu> listCv = new ArrayList<>();
    List<chitietsanpham> listCt = new ArrayList<>();
    List<cuahang> listCh = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        //chi tiet
        if (uri.contains("hien-thi-ct")) {
            this.hienThiChiTietSp(request,response);
        } else if (uri.contains("view-update-ct")) {
            this.viewUpdateChiTietSp(request,response);
        } else if (uri.contains("delete-ct")) {
            this.deteleChiTietSp(request,response);
        } else if (uri.contains("detail-ct")) {
            this.detailChiTietSp(request,response);
        }
        //Chuc vu
        else if (uri.contains("hien-thi-cv")) {
            this.hienThiChucVu(request,response);
        } else if (uri.contains("view-update-cv")) {
            this.vieUpdateChucVu(request,response);
        } else if (uri.contains("delete-cv")) {
            this.deleteChucVu(request,response);
        } else if (uri.contains("detail-cv")) {
            this.detailChucVu(request,response);
        }
        //Cua hang
        else if (uri.contains("hien-thi-ch")) {
            this.hienThiCuaHang(request,response);
        }else if (uri.contains("view-update-ch")) {
            this.viewUpdateCuaHang(request,response);
        }else if (uri.contains("delete-ch")) {
            this.deleteCuaHang(request,response);
        }else if (uri.contains("detail-ch")) {
            this.detailCuaHang(request,response);
        }

        //Dong san pham
        else if (uri.contains("hien-thi-dsp")) {
            this.hienThiDongSp(request,response);
        }else if (uri.contains("delete-dsp")) {
            this.deleteDongSp(request,response);
        }else if (uri.contains("detail-dsp")) {
            this.detailDongSp(request,response);
        }else if (uri.contains("view-update-dsp")) {
            this.viewUpdateDongSp(request,response);
        }

        //Khach hang
        else if (uri.contains("hien-thi-kh")) {
            this.hienThiKhachHang(request,response);
        }else if (uri.contains("view-update-kh")) {
            this.viewUpdKh(request,response);
        }else if (uri.contains("delete-kh")) {
            this.deleteKhachHang(request,response);
        }else if (uri.contains("detail-kh")) {
            this.detailKhachHang(request,response);
        }

        //Nhan vien
        else if (uri.contains("hien-thi-nv")) {
            this.hienThiNhanVien(request,response);
        }else if (uri.contains("view-update-nv")) {
            this.viewUdNhanVien(request,response);
        }else if (uri.contains("delete-nv")) {
            this.deleteNhanVien(request,response);
        }else if (uri.contains("detail-nv")) {
            this.detailNhanVien(request,response);
        }


        //Mau Sac
        else if (uri.contains("hien-thi-ms")) {
            this.hienThiMauSac(request,response);
        }else if (uri.contains("view-update-ms")) {
            this.viewUdmauSac(request,response);
        }else if (uri.contains("delete-ms")) {
            this.deleteMauSac(request,response);
        }else if (uri.contains("detail-ms")) {
            this.detailMauSac(request,response);
        }

        //Nha san xuat
        else if (uri.contains("hien-thi-nsx")) {
            this.hienThiNhaSanXuat(request,response);
        }else if (uri.contains("view-update-nsx")) {
            this.viewUdNhaSanXuat(request,response);
        }else if (uri.contains("delete-nsx")) {
            this.deleteNhaSanXuat(request,response);
        }else if (uri.contains("detail-nsx")) {
            this.detailNhaSanXuat(request,response);
        }

        //San pham
        else if (uri.contains("hien-thi-sp")) {
            this.hienThiSanPham(request,response);
        }else if (uri.contains("view-update-sp")) {
            this.viewUdSanPham(request,response);
        }else if (uri.contains("delete-sp")) {
            this.deleteSanPham(request,response);
        }else if (uri.contains("detail-sp")) {
            this.detailSanPham(request,response);
        }

        //Chuyen trang
        else if (uri.contains("chi-tiet-sp")) {
            this.chuyenTranChiTiet(request,response);
        } else if (uri.contains("chuc-vu")) {
            this.chuyenTrangChucVu(request,response);
        } else if (uri.contains("cua-hang")) {
            this.chuyenTrangCuaHang(request,response);
        } else if (uri.contains("khach-hang")) {
            this.chuyenTrangKhachHang(request,response);
        } else if (uri.contains("mau-sac")) {
            this.chuyenTrangMauSac(request,response);
        } else if (uri.contains("nhan-vien")) {
            this.chuyenTrangNhanVien(request,response);
        } else if (uri.contains("nha-san-xuat")) {
            this.chuyenTrangNhaSanXuat(request,response);
        } else if (uri.contains("san-pham")) {
            this.chuyenTrangSanPham(request,response);
        } else if (uri.contains("dong-san-pham")) {
            this.chuyenTrangDongSanPham(request,response);
        }
    }


    //San pham methods
    private void hienThiSanPham(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listSp = resSp.getAll();
        request.setAttribute("hienThiSp",listSp);
        request.getRequestDispatcher("/view/sanpham/sanpham.jsp").forward(request,response);
    }

    private void viewUdSanPham(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String getMct = request.getParameter("maSp");
        sanpham gv = resSp.getOne(Integer.parseInt(getMct));
        request.setAttribute("maId1",gv);
        request.getRequestDispatcher("/view/sanpham/updatesanpham.jsp").forward(request,response);
    }

    private void deleteSanPham(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String getMct = request.getParameter("maSp");
        sanpham gv = resSp.getOne(Integer.parseInt(getMct));
        resSp.detele(gv);
        listSp = resSp.getAll();
        request.setAttribute("hienThiSp",listSp);
        request.getRequestDispatcher("/view/sanpham/sanpham.jsp").forward(request,response);
    }

    private void detailSanPham(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String getMct = request.getParameter("maSp");
        sanpham gv = resSp.getOne(Integer.parseInt(getMct));
        request.setAttribute("maId",gv);
        listSp = resSp.getAll();
        request.setAttribute("hienThiSp",listSp);
        request.getRequestDispatcher("/view/sanpham/sanpham.jsp").forward(request,response);
    }

    //Nha san xuat methods
    private void hienThiNhaSanXuat(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listNsx = resNsx.getAll();
        request.setAttribute("hienThiNsx",listNsx);
        request.getRequestDispatcher("/view/nsx/nhasanxuat.jsp").forward(request,response);
    }

    private void viewUdNhaSanXuat(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String getMct = request.getParameter("maNsx");
        nhasanxuat gv = resNsx.getOne(Integer.parseInt(getMct));
        request.setAttribute("maId1",gv);
        request.getRequestDispatcher("/view/nsx/updatenhasanxuat.jsp").forward(request,response);
    }

    private void deleteNhaSanXuat(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String getMct = request.getParameter("maNsx");
        nhasanxuat gv = resNsx.getOne(Integer.parseInt(getMct));
        resNsx.detele(gv);
        listNsx = resNsx.getAll();
        request.setAttribute("hienThiNsx",listNsx);
        request.getRequestDispatcher("/view/nsx/nhasanxuat.jsp").forward(request,response);
    }

    private void detailNhaSanXuat(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String getMct = request.getParameter("maNsx");
        nhasanxuat gv = resNsx.getOne(Integer.parseInt(getMct));
        request.setAttribute("maId",gv);
        listNsx = resNsx.getAll();
        request.setAttribute("hienThiNsx",listNsx);
        request.getRequestDispatcher("/view/nsx/nhasanxuat.jsp").forward(request,response);
    }

    //Mau sac methods
    private void hienThiMauSac(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listMs = resMs.getAll();
        request.setAttribute("hienThiMs",listMs);
        request.getRequestDispatcher("/view/mausac/mausac.jsp").forward(request,response);
    }

    private void viewUdmauSac(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String getMct = request.getParameter("maMs");
        mausac gv = resMs.getOne(Integer.parseInt(getMct));
        request.setAttribute("maId1",gv);
        request.getRequestDispatcher("/view/mausac/updatemausac.jsp").forward(request,response);
    }

    private void deleteMauSac(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String getMct = request.getParameter("maMs");
        mausac gv = resMs.getOne(Integer.parseInt(getMct));
        resMs.detele(gv);
        listMs = resMs.getAll();
        request.setAttribute("hienThiMs",listMs);
        request.getRequestDispatcher("/view/mausac/mausac.jsp").forward(request,response);
    }

    private void detailMauSac(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String getMct = request.getParameter("maMs");
        mausac gv = resMs.getOne(Integer.parseInt(getMct));
        request.setAttribute("maId",gv);
        listMs = resMs.getAll();
        request.setAttribute("hienThiMs",listMs);
        request.getRequestDispatcher("/view/mausac/mausac.jsp").forward(request,response);
    }

    //Nhan vien methods
    private void hienThiNhanVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listNv = resNv.getAll();
        request.setAttribute("hienThiNv",listNv);
        request.getRequestDispatcher("/view/nhanvien/nhanvien.jsp").forward(request,response);
    }

    private void viewUdNhanVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String getMct = request.getParameter("maNv");
        nhanvien gv = resNv.getOne(Integer.parseInt(getMct));
        request.setAttribute("maId1",gv);
        request.getRequestDispatcher("/view/nhanvien/updatenhanvien.jsp").forward(request,response);
    }

    private void deleteNhanVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String getMct = request.getParameter("maNv");
        nhanvien gv = resNv.getOne(Integer.parseInt(getMct));
        resNv.detele(gv);
        listNv = resNv.getAll();
        request.setAttribute("hienThiNv",listNv);
        request.getRequestDispatcher("/view/nhanvien/nhanvien.jsp").forward(request,response);
    }
    private void detailNhanVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String getMct = request.getParameter("maNv");
        nhanvien gv = resNv.getOne(Integer.parseInt(getMct));
        request.setAttribute("maId",gv);
        listNv = resNv.getAll();
        request.setAttribute("hienThiNv",listNv);
        request.getRequestDispatcher("/view/nhanvien/nhanvien.jsp").forward(request,response);
    }

    //Khach Hang methods
    private void hienThiKhachHang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listKh = resKh.getAll();
        request.setAttribute("hienThiKh",listKh);
        request.getRequestDispatcher("/view/khachhang/khachhang.jsp").forward(request,response);
    }

    private void viewUpdKh(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String getMct = request.getParameter("maKh");
        khachhang gv = resKh.getOne(Integer.parseInt(getMct));
        request.setAttribute("maId1",gv);
        request.getRequestDispatcher("/view/khachhang/updatekhachhang.jsp").forward(request,response);
    }

    private void deleteKhachHang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String getMct = request.getParameter("maKh");
        khachhang gv = resKh.getOne(Integer.parseInt(getMct));
        resKh.detele(gv);
        listKh = resKh.getAll();
        request.setAttribute("hienThiKh",listKh);
        request.getRequestDispatcher("/view/khachhang/khachhang.jsp").forward(request,response);
    }

    private void detailKhachHang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String getMct = request.getParameter("maKh");
        khachhang gv = resKh.getOne(Integer.parseInt(getMct));
        request.setAttribute("maId",gv);
        listKh = resKh.getAll();
        request.setAttribute("hienThiKh",listKh);
        request.getRequestDispatcher("/view/khachhang/khachhang.jsp").forward(request,response);
    }

    //Dong san pham methods
    private void hienThiDongSp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listDsp = resDsp.getAll();
        request.setAttribute("hienThiDsp",listDsp);
        request.getRequestDispatcher("/view/dongsanpham/dongsanpham.jsp").forward(request,response);
    }

    private void deleteDongSp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String getMct = request.getParameter("maDsp");
        dongsanpham gv = resDsp.getOne(Integer.parseInt(getMct));
        resDsp.detele(gv);
        listDsp = resDsp.getAll();
        request.setAttribute("hienThiDsp",listDsp);
        request.getRequestDispatcher("/view/dongsanpham/dongsanpham.jsp").forward(request,response);
    }

    private void detailDongSp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String getMct = request.getParameter("maDsp");
        dongsanpham gv = resDsp.getOne(Integer.parseInt(getMct));
        request.setAttribute("maId",gv);
        listDsp = resDsp.getAll();
        request.setAttribute("hienThiDsp",listDsp);
        request.getRequestDispatcher("/view/dongsanpham/dongsanpham.jsp").forward(request,response);
    }

    private void viewUpdateDongSp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String getMct = request.getParameter("maDsp");
        dongsanpham gv = resDsp.getOne(Integer.parseInt(getMct));
        request.setAttribute("maId1",gv);
        request.getRequestDispatcher("/view/dongsanpham/dongsanphamupdate.jsp").forward(request,response);
    }

    //Cua Hang methods
    private void hienThiCuaHang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listCh = resCh.getAll();
        request.setAttribute("hienThiCh",listCh);
        request.getRequestDispatcher("/view/cuahang/cuahang.jsp").forward(request,response);
    }

    private void viewUpdateCuaHang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String getMct = request.getParameter("maCh");
        cuahang gv = resCh.getOne(Integer.parseInt(getMct));
        request.setAttribute("maId1",gv);
        request.getRequestDispatcher("/view/cuahang/updatecuahang.jsp").forward(request,response);
    }

    private void deleteCuaHang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String getMct = request.getParameter("maCh");
        cuahang gv = resCh.getOne(Integer.parseInt(getMct));
        resCh.detele(gv);
        listCh = resCh.getAll();
        request.setAttribute("hienThiCh",listCh);
        request.getRequestDispatcher("/view/cuahang/cuahang.jsp").forward(request,response);
    }

    private void detailCuaHang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String getMct = request.getParameter("maCh");
        cuahang gv = resCh.getOne(Integer.parseInt(getMct));
        request.setAttribute("maId",gv);
        listCh = resCh.getAll();
        request.setAttribute("hienThiCh",listCh);
        request.getRequestDispatcher("/view/cuahang/cuahang.jsp").forward(request,response);
    }




    //Chuc vu methods
    private void hienThiChucVu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listCv = resCv.getAll();
        request.setAttribute("hienThiCv",listCv);
        request.getRequestDispatcher("/view/chucvu/chucvu.jsp").forward(request,response);
    }

    private void vieUpdateChucVu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String getMct = request.getParameter("maId");
        chucvu gv = resCv.getOne(Integer.parseInt(getMct));
        request.setAttribute("maId1",gv);
        request.getRequestDispatcher("/view/chucvu/updatechucvu.jsp").forward(request,response);
    }

    private void deleteChucVu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String getMct = request.getParameter("maId");
        chucvu gv = resCv.getOne(Integer.parseInt(getMct));
        resCv.detele(gv);
        listCv = resCv.getAll();
        request.setAttribute("hienThiCv",listCv);
        request.getRequestDispatcher("/view/chucvu/chucvu.jsp").forward(request,response);
    }

    private void detailChucVu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String getMct = request.getParameter("maId");
        chucvu gv = resCv.getOne(Integer.parseInt(getMct));
        request.setAttribute("maId1",gv);
        listCv = resCv.getAll();
        request.setAttribute("hienThiCv",listCv);
        request.getRequestDispatcher("/view/chucvu/chucvu.jsp").forward(request,response);
    }


    //Chi tiet sp methods
    private void hienThiChiTietSp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listCt = resCt.getAll();
        request.setAttribute("hienThiCt",listCt);
        request.getRequestDispatcher("/view/chitietsanpham/chitietsanpham.jsp").forward(request,response);
    }

    private void viewUpdateChiTietSp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String getMct = request.getParameter("mct");
        chitietsanpham gv = resCt.getOne(Integer.parseInt(getMct));
        request.setAttribute("mct1",gv);
        request.setAttribute("hienThiCt",listCt);
        request.getRequestDispatcher("/view/chitietsanpham/updatechitietsanpham.jsp").forward(request,response);
    }

    private void deteleChiTietSp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String getMct = request.getParameter("mct");
        chitietsanpham gv = resCt.getOne(Integer.parseInt(getMct));
        resCt.detele(gv);
        listCt = resCt.getAll();
        request.setAttribute("hienThiCt",listCt);
        request.getRequestDispatcher("/view/chitietsanpham/chitietsanpham.jsp").forward(request,response);
    }

    private void detailChiTietSp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String getMct = request.getParameter("mct");
        chitietsanpham gv = resCt.getOne(Integer.parseInt(getMct));
        request.setAttribute("mct",gv);
        listCt = resCt.getAll();
        request.setAttribute("hienThiCt",listCt);
        request.getRequestDispatcher("/view/chitietsanpham/chitietsanpham.jsp").forward(request,response);
    }

    //Chuyen trang methods
    private void chuyenTranChiTiet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listCt = resCt.getAll();
        request.setAttribute("hienThiCt",listCt);
        request.getRequestDispatcher("/view/chitietsanpham/chitietsanpham.jsp").forward(request,response);
    }

    private void chuyenTrangChucVu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listCv = resCv.getAll();
        request.setAttribute("hienThiCv",listCv);
        request.getRequestDispatcher("/view/chucvu/chucvu.jsp").forward(request,response);
    }

    private void chuyenTrangCuaHang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listCh = resCh.getAll();
        request.setAttribute("hienThiCh",listCh);
        request.getRequestDispatcher("/view/cuahang/cuahang.jsp").forward(request,response);
    }

    private void chuyenTrangKhachHang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listKh = resKh.getAll();
        request.setAttribute("hienThiKh",listKh);
        request.getRequestDispatcher("/view/khachhang/khachhang.jsp").forward(request,response);
    }

    private void chuyenTrangMauSac(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listMs = resMs.getAll();
        request.setAttribute("hienThiMs",listMs);
        request.getRequestDispatcher("/view/mausac/mausac.jsp").forward(request,response);
    }

    private void chuyenTrangNhanVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listNv = resNv.getAll();
        request.setAttribute("hienThiNv",listNv);
        request.getRequestDispatcher("/view/nhanvien/nhanvien.jsp").forward(request,response);
    }

    private void chuyenTrangNhaSanXuat(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listNsx = resNsx.getAll();
        request.setAttribute("hienThiNsx",listNsx);
        request.getRequestDispatcher("/view/nsx/nhasanxuat.jsp").forward(request,response);
    }

    private void chuyenTrangSanPham(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listSp = resSp.getAll();
        request.setAttribute("hienThiSp",listSp);
        request.getRequestDispatcher("/view/sanpham/sanpham.jsp").forward(request,response);
    }

    private void chuyenTrangDongSanPham(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listDsp = resDsp.getAll();
        request.setAttribute("hienThiDsp",listDsp);
        request.getRequestDispatcher("/view/dongsanpham/dongsanpham.jsp").forward(request,response);
    }
    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        //Chi tiet sp
        if (uri.contains("update-ct")) {
            this.updateChiTietSp(request,response);
        } else if (uri.contains("add-ct")) {
            this.addChiTietSp(request,response);
        }

        //Chuc Vu
        else if (uri.contains("add-cv")) {
            this.addChucVu(request,response);
        }else if (uri.contains("update-cv")) {
            this.updateChucVu(request,response);
        }

        //Cua Hang
        else if (uri.contains("update-ch")) {
            this.updateCuaHang(request,response);
        }else if (uri.contains("add-ch")) {
            this.addCuaHang(request,response);
        }

        //Dong san pham
        else if (uri.contains("update-dsp")) {
            this.updateDongSp(request,response);
        }else if (uri.contains("add-dsp")) {
            this.addDongSp(request,response);
        }

        //Nhan vien
        else if (uri.contains("update-nv")) {
            this.updateNhanVien(request,response);
        }else if (uri.contains("add-nv")) {
            this.addNhanVien(request,response);
        }

        //Khach hang
        else if (uri.contains("update-kh")) {
            this.updateKh(request,response);
        }else if (uri.contains("add-kh")) {
            this.addKh(request,response);
        }

        //Mau sac
        else if (uri.contains("update-ms")) {
            this.updateMs(request,response);
        }else if (uri.contains("add-ms")) {
            this.addMs(request,response);
        }

        //Nha xuan xuat
        else if (uri.contains("update-nsx")) {
            this.updateNsx(request,response);
        }else if (uri.contains("add-nsx")) {
            this.addNsx(request,response);
        }

        //San pham
        else if (uri.contains("update-sp")) {
            this.updateSp(request,response);
        }else if (uri.contains("add-sp")) {
            this.addSp(request,response);
        }
    }

    //San pham methods
    private void updateSp(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, IOException {
        sanpham ct1 = new sanpham();
        BeanUtils.populate(ct1,request.getParameterMap());
        resSp.update(ct1);
        response.sendRedirect("/san-pham/hien-thi-sp");
    }

    private void addSp(HttpServletRequest request, HttpServletResponse response) throws IOException, InvocationTargetException, IllegalAccessException {
        sanpham ct = new sanpham();
        BeanUtils.populate(ct,request.getParameterMap());
        resSp.add(ct);
        response.sendRedirect("/san-pham/hien-thi-sp");
    }

    private void updateNsx(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, IOException {
        nhasanxuat ct = new nhasanxuat();
        BeanUtils.populate(ct,request.getParameterMap());
        resNsx.update(ct);
        response.sendRedirect("/nha-san-xuat/hien-thi-nsx");
    }

    private void addNsx(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, IOException {
        nhasanxuat ct = new nhasanxuat();
        BeanUtils.populate(ct,request.getParameterMap());
        resNsx.add(ct);
        response.sendRedirect("/nha-san-xuat/hien-thi-nsx");
    }

    private void updateMs(HttpServletRequest request, HttpServletResponse response) throws IOException, InvocationTargetException, IllegalAccessException {
        mausac ct = new mausac();
        BeanUtils.populate(ct,request.getParameterMap());
        resMs.update(ct);
        response.sendRedirect("/mau-sac/hien-thi-ms");
    }

    private void addMs(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, IOException {
        mausac ct = new mausac();
        BeanUtils.populate(ct,request.getParameterMap());
        resMs.update(ct);
        response.sendRedirect("/mau-sac/hien-thi-ms");
    }

    //NhanVien methods
    private void updateNhanVien(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, IOException {
        nhanvien ct = new nhanvien();
        BeanUtils.populate(ct,request.getParameterMap());
        resNv.update(ct);
        response.sendRedirect("/nhan-vien/hien-thi-nv");
    }

    private void addNhanVien(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, IOException {
        nhanvien ct = new nhanvien();
        BeanUtils.populate(ct,request.getParameterMap());
        resNv.add(ct);
        response.sendRedirect("/nhan-vien/hien-thi-nv");
    }

    //Khach hang methods
    private void updateKh(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, IOException {
         khachhang ct = new khachhang();
        BeanUtils.populate(ct,request.getParameterMap());
        resKh.update(ct);
        response.sendRedirect("/khach-hang/hien-thi-kh");
    }

    private void addKh(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, IOException {
        khachhang ct = new khachhang();
        BeanUtils.populate(ct,request.getParameterMap());
        resKh.add(ct);
        response.sendRedirect("/khach-hang/hien-thi-kh");
    }

    //Dong san pham methods
    private void updateDongSp(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, IOException {
        dongsanpham ct = new dongsanpham();
        BeanUtils.populate(ct,request.getParameterMap());
        resDsp.update(ct);
        response.sendRedirect("/dong-san-pham/hien-thi-dsp");
    }

    private void addDongSp(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, IOException {
        dongsanpham ct = new dongsanpham();
        BeanUtils.populate(ct,request.getParameterMap());
        resDsp.update(ct);
        response.sendRedirect("/dong-san-pham/hien-thi-dsp");
    }

    //Cua Hang methods
    private void updateCuaHang(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, IOException {
        cuahang ct = new cuahang();
        BeanUtils.populate(ct,request.getParameterMap());
        resCh.update(ct);
        response.sendRedirect("/cua-hang/hien-thi-ch");
    }

    private void addCuaHang(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, IOException {
        cuahang ct = new cuahang();
        BeanUtils.populate(ct,request.getParameterMap());
        resCh.add(ct);
        response.sendRedirect("/cua-hang/hien-thi-ch");
    }

    //Chuc vu methods
    private void addChucVu(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, IOException {
        chucvu ct = new chucvu();
        BeanUtils.populate(ct,request.getParameterMap());
        resCv.add(ct);
        response.sendRedirect("/chuc-vu/hien-thi-cv");
    }

    private void updateChucVu(HttpServletRequest request, HttpServletResponse response) throws IOException, InvocationTargetException, IllegalAccessException {
        chucvu ct = new chucvu();
        BeanUtils.populate(ct,request.getParameterMap());
        resCv.update(ct);
        response.sendRedirect("/chuc-vu/hien-thi-cv");
    }


    //Chi tiet methods
    private void updateChiTietSp(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, IOException {
        chitietsanpham ct = new chitietsanpham();
        BeanUtils.populate(ct,request.getParameterMap());
        resCt.update(ct);
        response.sendRedirect("/chi-tiet-san-pham/hien-thi-ct");
    }

    private void addChiTietSp(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, IOException {
        chitietsanpham ct = new chitietsanpham();
        BeanUtils.populate(ct,request.getParameterMap());
        resCt.add(ct);
        response.sendRedirect("/chi-tiet-san-pham/hien-thi-ct");
    }
}
