package models;

import java.util.Objects;

public class ReimbStatusModel {
    private Integer reimb_status_id;
    private String reimb_status;

    public ReimbStatusModel(){}

    public ReimbStatusModel(Integer reimb_status_id, String reimb_status) {
        this.reimb_status_id = reimb_status_id;
        this.reimb_status = reimb_status;
    }

    public Integer getReimb_status_id() {
        return reimb_status_id;
    }

    public void setReimb_status_id(Integer reimb_status_id) {
        this.reimb_status_id = reimb_status_id;
    }

    public String getReimb_status() {
        return reimb_status;
    }

    public void setReimb_status(String reimb_status) {
        this.reimb_status = reimb_status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReimbStatusModel that = (ReimbStatusModel) o;
        return Objects.equals(reimb_status_id, that.reimb_status_id) && Objects.equals(reimb_status, that.reimb_status);
    }

    @Override
    public String toString() {
        return "ReimbStatusModel{" +
                "reimb_status_id=" + reimb_status_id +
                ", reimb_status='" + reimb_status + '\'' +
                '}';
    }
}
