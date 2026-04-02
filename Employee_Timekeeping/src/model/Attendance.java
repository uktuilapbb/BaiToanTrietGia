package model;


public class Attendance {
    private String fullName;
    private String checkIn;
    private String checkOut;
    private String status;


    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }


    public String getCheckIn() { return checkIn; }
    public void setCheckIn(String checkIn) { this.checkIn = checkIn; }


    public String getCheckOut() { return checkOut; }
    public void setCheckOut(String checkOut) { this.checkOut = checkOut; }


    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}