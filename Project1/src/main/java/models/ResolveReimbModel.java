package models;

import java.util.Objects;

public class ResolveReimbModel {
    private Integer reimb_id;
    private Integer reimb_resolver;
    private String reimb_type;


    public ResolveReimbModel(){

    }

    public ResolveReimbModel(Integer reimb_id, Integer reimb_resolver, String reimb_type) {
        this.reimb_id = reimb_id;
        this.reimb_resolver = reimb_resolver;
        this.reimb_type = reimb_type;
    }


    public Integer getReimb_id() {
        return reimb_id;
    }

    public void setReimb_id(Integer reimb_id) {
        this.reimb_id = reimb_id;
    }

    public Integer getReimb_resolver() {
        return reimb_resolver;
    }

    public void setReimb_resolver(Integer reimb_resolver) {
        this.reimb_resolver = reimb_resolver;
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
        ResolveReimbModel that = (ResolveReimbModel) o;
        return Objects.equals(reimb_id, that.reimb_id) && Objects.equals(reimb_resolver, that.reimb_resolver) && Objects.equals(reimb_type, that.reimb_type);
    }


    @Override
    public String toString() {
        return "ResolveReimbModel{" +
                "reimb_id=" + reimb_id +
                ", reimb_resolver=" + reimb_resolver +
                ", reimb_type='" + reimb_type + '\'' +
                '}';
    }
}
