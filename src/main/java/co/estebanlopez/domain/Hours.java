package co.estebanlopez.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Hours {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int quantity;
    private double unitPrice;
    private double totalPrice;
    private int approved;

    @Temporal(TemporalType.DATE)
    private Date date;

    @Enumerated(EnumType.STRING)
    private StatusPay statusPay;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference
    private Employee employee;

    public Hours() {
    }

    public Hours(int quantity, double unitPrice, double totalPrice, int approved, Date date, StatusPay statusPay, Employee employee) {
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.totalPrice = totalPrice;
        this.approved = approved;
        this.date = date;
        this.statusPay = statusPay;
        this.employee = employee;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public StatusPay getStatusPay() {
        return statusPay;
    }

    public void setStatusPay(StatusPay statusPay) {
        this.statusPay = statusPay;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getApproved() {
        return approved;
    }

    public void setApproved(int approved) {
        this.approved = approved;
    }
}
