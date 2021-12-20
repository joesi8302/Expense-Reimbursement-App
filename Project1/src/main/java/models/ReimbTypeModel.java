package models;

import java.util.Objects;

public class ReimbTypeModel {

    private Integer reimb_type_id;
    private String reimb_type;

    public ReimbTypeModel(){}

    public ReimbTypeModel(Integer reimb_type_id, String reimb_type) {
        this.reimb_type_id = reimb_type_id;
        this.reimb_type = reimb_type;
    }

    public Integer getReimb_type_id() {
        return reimb_type_id;
    }

    public void setReimb_type_id(Integer reimb_type_id) {
        this.reimb_type_id = reimb_type_id;
    }

    public String getReimb_type() {
        return reimb_type;
    }

    public void setReimb_type(String reimb_type) {
        this.reimb_type = reimb_type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReimbTypeModel that = (ReimbTypeModel) o;
        return Objects.equals(reimb_type_id, that.reimb_type_id) && Objects.equals(reimb_type, that.reimb_type);
    }

    @Override
    public String toString() {
        return "ReimbTypeModel{" +
                "reimb_type_id=" + reimb_type_id +
                ", reimb_type='" + reimb_type + '\'' +
                '}';
    }
}
