package model;

import java.util.Date;

public class GiangVien {
    private String maGV;
    private String tenGV;
    private String diaChi;
    private String gioiTinh;
    private Date ngaySinh;
    private String chuyenNganh;
    private String sdt;

    // Constructor
    public GiangVien() {}

    public GiangVien(String maGV, String tenGV, String diaChi, String gioiTinh,
                     Date ngaySinh, String chuyenNganh, String sdt) {
        this.maGV = maGV;
        this.tenGV = tenGV;
        this.diaChi = diaChi;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.chuyenNganh = chuyenNganh;
        this.sdt = sdt;
    }

    // Getters & Setters
    public String getMaGV() { return maGV; }
    public void setMaGV(String maGV) { this.maGV = maGV; }

    public String getTenGV() { return tenGV; }
    public void setTenGV(String tenGV) { this.tenGV = tenGV; }

    public String getDiaChi() { return diaChi; }
    public void setDiaChi(String diaChi) { this.diaChi = diaChi; }

    public String getGioiTinh() { return gioiTinh; }
    public void setGioiTinh(String gioiTinh) { this.gioiTinh = gioiTinh; }

    public Date getNgaySinh() { return ngaySinh; }
    public void setNgaySinh(Date ngaySinh) { this.ngaySinh = ngaySinh; }

    public String getChuyenNganh() { return chuyenNganh; }
    public void setChuyenNganh(String chuyenNganh) { this.chuyenNganh = chuyenNganh; }

    public String getSdt() { return sdt; }
    public void setSdt(String sdt) { this.sdt = sdt; }

    @Override
    public String toString() {
        return "GiangVien{" + "maGV='" + maGV + "', tenGV='" + tenGV + "'}";
    }
}
