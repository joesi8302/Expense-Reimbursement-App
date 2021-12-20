package models;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.InputStream;
import java.sql.Blob;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

public class ReimbModel {

    private Integer reimb_id;
    private Double reimb_amount;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm a z")
    private Timestamp reimb_submitted;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm a z")
    private Timestamp reimb_resolved;
    private String reimb_description;
    private byte[] reimb_receipt;
    private Integer reimb_author;
    private Integer reimb_resolver;
    private Integer reimb_status_id;
    private Integer reimb_type_id;

    public ReimbModel(){}

    public ReimbModel(Integer reimb_id, Double reimb_amount, Timestamp reimb_submitted, Timestamp reimb_resolved,
                      String reimb_description, byte[] reimb_receipt, Integer reimb_author, Integer reimb_resolver,
                      Integer reimb_status_id, Integer reimb_type_id) {
        this.reimb_id = reimb_id;
        this.reimb_amount = reimb_amount;
        this.reimb_submitted = reimb_submitted;
        this.reimb_resolved = reimb_resolved;
        this.reimb_description = reimb_description;
        this.reimb_receipt = reimb_receipt;
        this.reimb_author = reimb_author;
        this.reimb_resolver = reimb_resolver;
        this.reimb_status_id = reimb_status_id;
        this.reimb_type_id = reimb_type_id;
    }

    public Integer getReimb_id() {
        return reimb_id;
    }

    public void setReimb_id(Integer reimb_id) {
        this.reimb_id = reimb_id;
    }

    public Double getReimb_amount() {
        return reimb_amount;
    }

    public void setReimb_amount(Double reimb_amount) {
        this.reimb_amount = reimb_amount;
    }

    public Timestamp getReimb_submitted() {
        return reimb_submitted;
    }

    public void setReimb_submitted(Timestamp reimb_submitted) {
        this.reimb_submitted = reimb_submitted;
    }

    public Timestamp getReimb_resolved() {
        return reimb_resolved;
    }

    public void setReimb_resolved(Timestamp reimb_resolved) {
        this.reimb_resolved = reimb_resolved;
    }

    public String getReimb_description() {
        return reimb_description;
    }

    public void setReimb_description(String reimb_description) {
        this.reimb_description = reimb_description;
    }

    public byte[] getReimb_receipt() {
        return reimb_receipt;
    }

    public void setReimb_receipt(byte[] reimb_receipt) {
        this.reimb_receipt = reimb_receipt;
    }

    public Integer getReimb_author() {
        return reimb_author;
    }

    public void setReimb_author(Integer reimb_author) {
        this.reimb_author = reimb_author;
    }

    public Integer getReimb_resolver() {
        return reimb_resolver;
    }

    public void setReimb_resolver(Integer reimb_resolver) {
        this.reimb_resolver = reimb_resolver;
    }

    public Integer getReimb_status_id() {
        return reimb_status_id;
    }

    public void setReimb_status_id(Integer reimb_status_id) {
        this.reimb_status_id = reimb_status_id;
    }

    public Integer getReimb_type_id() {
        return reimb_type_id;
    }

    public void setReimb_type_id(Integer reimb_type_id) {
        this.reimb_type_id = reimb_type_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReimbModel that = (ReimbModel) o;
        return Objects.equals(reimb_id, that.reimb_id) && Objects.equals(reimb_amount, that.reimb_amount)
                && Objects.equals(reimb_submitted, that.reimb_submitted) && Objects.equals(reimb_resolved, that.reimb_resolved)
                && Objects.equals(reimb_description, that.reimb_description) && Objects.equals(reimb_receipt, that.reimb_receipt)
                && Objects.equals(reimb_author, that.reimb_author) && Objects.equals(reimb_resolver, that.reimb_resolver)
                && Objects.equals(reimb_status_id, that.reimb_status_id) && Objects.equals(reimb_type_id, that.reimb_type_id);
    }


    @Override
    public String toString() {
        return "ReimbModel{" +
                "reimb_id=" + reimb_id +
                ", reimb_amount=" + reimb_amount +
                ", reimb_submitted=" + reimb_submitted +
                ", reimb_resolved=" + reimb_resolved +
                ", reimb_description='" + reimb_description + '\'' +
                ", reimb_receipt=" + reimb_receipt +
                ", reimb_author=" + reimb_author +
                ", reimb_resolver=" + reimb_resolver +
                ", reimb_status_id=" + reimb_status_id +
                ", reimb_type_id=" + reimb_type_id +
                '}';
    }
}
