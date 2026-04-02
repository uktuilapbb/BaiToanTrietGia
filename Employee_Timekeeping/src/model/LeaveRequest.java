package model;

public class LeaveRequest {

    private int id;
    private String fullName;
    private String leaveDate;
    private String reason;
    private String status;

    // getters & setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getLeaveDate() {
        return leaveDate;
    }
    public void setLeaveDate(String leaveDate) {
        this.leaveDate = leaveDate;
    }

    public String getReason() {
        return reason;
    }
    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}
