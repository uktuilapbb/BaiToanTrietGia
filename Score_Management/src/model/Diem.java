package model;

public class Diem {
    private String maSV;
    private String maMon;
    private double dqt;      // Điểm quá trình
    private double ktgk;     // Kiểm tra giữa kỳ
    private double ktck;     // Kiểm tra cuối kỳ
    private double diemTB;   // Điểm trung bình
    private String xepLoai;  // Xuất sắc/Giỏi/Khá/TB

    // Constructor
    public Diem() {}

    public Diem(String maSV, String maMon, double dqt, double ktgk, double ktck) {
        this.maSV = maSV;
        this.maMon = maMon;
        this.dqt = dqt;
        this.ktgk = ktgk;
        this.ktck = ktck;
        this.diemTB = tinhDiemTB();
        this.xepLoai = tinhXepLoai();
    }

    // Tính điểm TB = (DQT + 2*KTGK + 3*KTCK)/6
    private double tinhDiemTB() {
        return Math.round((dqt + 2 * ktgk + 3 * ktck) / 6.0 * 10) / 10.0;
    }

    // Xếp loại tự động
    private String tinhXepLoai() {
        if (diemTB >= 8.5) return "Xuất sắc";
        if (diemTB >= 7.0) return "Giỏi";
        if (diemTB >= 5.5) return "Khá";
        if (diemTB >= 4.0) return "Trung bình";
        return "Yếu";
    }

    // Getters & Setters
    public String getMaSV() { return maSV; }
    public void setMaSV(String maSV) { this.maSV = maSV; }

    public String getMaMon() { return maMon; }
    public void setMaMon(String maMon) { this.maMon = maMon; }

    public double getDqt() { return dqt; }
    public void setDqt(double dqt) {
        this.dqt = dqt;
        this.diemTB = tinhDiemTB();
        this.xepLoai = tinhXepLoai();
    }

    public double getKtgk() { return ktgk; }
    public void setKtgk(double ktgk) {
        this.ktgk = ktgk;
        this.diemTB = tinhDiemTB();
        this.xepLoai = tinhXepLoai();
    }

    public double getKtck() { return ktck; }
    public void setKtck(double ktck) {
        this.ktck = ktck;
        this.diemTB = tinhDiemTB();
        this.xepLoai = tinhXepLoai();
    }

    public double getDiemTB() { return diemTB; }
    public void setDiemTB(double diemTB) { this.diemTB = diemTB; }

    public String getXepLoai() { return xepLoai; }
    public void setXepLoai(String xepLoai) { this.xepLoai = xepLoai; }

    @Override
    public String toString() {
        return "Diem{" + "maSV='" + maSV + "', maMon='" + maMon + "', diemTB=" + diemTB + ", xepLoai='" + xepLoai + "'}";
    }
}
