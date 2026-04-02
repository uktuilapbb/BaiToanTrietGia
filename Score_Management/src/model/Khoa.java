package model;

public class Khoa {
    private String maKhoa;
    private String tenKhoa;

    // Constructor
    public Khoa() {}

    public Khoa(String maKhoa, String tenKhoa) {
        this.maKhoa = maKhoa;
        this.tenKhoa = tenKhoa;
    }

    // Getters & Setters
    public String getMaKhoa() { return maKhoa; }
    public void setMaKhoa(String maKhoa) { this.maKhoa = maKhoa; }

    public String getTenKhoa() { return tenKhoa; }
    public void setTenKhoa(String tenKhoa) { this.tenKhoa = tenKhoa; }

    @Override
    public String toString() {
        return "Khoa{" + "maKhoa='" + maKhoa + "', tenKhoa='" + tenKhoa + "'}";
    }
}
