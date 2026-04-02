package model;

import java.util.Date;

public class SinhVien {
    private String maSV;
    private String tenSV;
    private String diaChi;
    private String gioiTinh;
    private Date ngaySinh;
    private String maLop;

    // Constructor
    public SinhVien() {}

    public SinhVien(String maSV, String tenSV, String diaChi, String gioiTinh,
                    Date ngaySinh, String maLop) {
        this.maSV = maSV;
        this.tenSV = tenSV;
        this.diaChi = diaChi;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.maLop = maLop;
    }

    // Getters & Setters
    public String getMaSV() { return maSV; }
    public void setMaSV(String maSV) { this.maSV = maSV; }

    public String getTenSV() { return tenSV; }
    public void setTenSV(String tenSV) { this.tenSV = tenSV; }

    public String getDiaChi() { return diaChi; }
    public void setDiaChi(String diaChi) { this.diaChi = diaChi; }

    public String getGioiTinh() { return gioiTinh; }
    public void setGioiTinh(String gioiTinh) { this.gioiTinh = gioiTinh; }

    public Date getNgaySinh() { return ngaySinh; }
    public void setNgaySinh(Date ngaySinh) { this.ngaySinh = ngaySinh; }

    public String getMaLop() { return maLop; }
    public void setMaLop(String maLop) { this.maLop = maLop; }

    @Override
    public String toString() {
        return "SinhVien{" +
                "maSV='" + maSV + '\'' +
                ", tenSV='" + tenSV + '\'' +
                ", maLop='" + maLop + '\'' +
                '}';
    }
}
