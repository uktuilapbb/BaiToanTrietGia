package model;

public class Lop {
    private String maLop;
    private String tenLop;
    private String maNganh;

    // Constructor
    public Lop() {}

    public Lop(String maLop, String tenLop, String maNganh) {
        this.maLop = maLop;
        this.tenLop = tenLop;
        this.maNganh = maNganh;
    }

    // Getters & Setters
    public String getMaLop() { return maLop; }
    public void setMaLop(String maLop) { this.maLop = maLop; }

    public String getTenLop() { return tenLop; }
    public void setTenLop(String tenLop) { this.tenLop = tenLop; }

    public String getMaNganh() { return maNganh; }
    public void setMaNganh(String maNganh) { this.maNganh = maNganh; }

    @Override
    public String toString() {
        return "Lop{" + "maLop='" + maLop + "', tenLop='" + tenLop + "'}";
    }
}
