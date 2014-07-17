/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mvcmusic.mvcmusicstore.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author seannils1
 */
@Entity
@Table(name = "ORDER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Order.findAll", query = "SELECT o FROM Order o"),
    @NamedQuery(name = "Order.findByOrderid", query = "SELECT o FROM Order o WHERE o.orderid = :orderid"),
    @NamedQuery(name = "Order.findByOrderdate", query = "SELECT o FROM Order o WHERE o.orderdate = :orderdate"),
    @NamedQuery(name = "Order.findByAddress", query = "SELECT o FROM Order o WHERE o.address = :address"),
    @NamedQuery(name = "Order.findByCity", query = "SELECT o FROM Order o WHERE o.city = :city"),
    @NamedQuery(name = "Order.findByState", query = "SELECT o FROM Order o WHERE o.state = :state"),
    @NamedQuery(name = "Order.findByPostalcode", query = "SELECT o FROM Order o WHERE o.postalcode = :postalcode"),
    @NamedQuery(name = "Order.findByCountry", query = "SELECT o FROM Order o WHERE o.country = :country"),
    @NamedQuery(name = "Order.findByTotal", query = "SELECT o FROM Order o WHERE o.total = :total")})
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ORDERID")
    private Integer orderid;
    @Column(name = "ORDERDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderdate;
    @Size(max = 50)
    @Column(name = "ADDRESS")
    private String address;
    @Size(max = 50)
    @Column(name = "CITY")
    private String city;
    @Size(max = 50)
    @Column(name = "STATE")
    private String state;
    @Size(max = 50)
    @Column(name = "POSTALCODE")
    private String postalcode;
    @Size(max = 50)
    @Column(name = "COUNTRY")
    private String country;
    @Column(name = "TOTAL")
    private Double total;
    @JoinColumn(name = "USERID", referencedColumnName = "USERID")
    @ManyToOne(optional = false)
    private User userid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orderid")
    private Collection<Orderdetail> orderdetailCollection;

    public Order() {
    }

    public Order(Integer orderid) {
        this.orderid = orderid;
    }

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public Date getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(Date orderdate) {
        this.orderdate = orderdate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public User getUserid() {
        return userid;
    }

    public void setUserid(User userid) {
        this.userid = userid;
    }

    @XmlTransient
    public Collection<Orderdetail> getOrderdetailCollection() {
        return orderdetailCollection;
    }

    public void setOrderdetailCollection(Collection<Orderdetail> orderdetailCollection) {
        this.orderdetailCollection = orderdetailCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderid != null ? orderid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Order)) {
            return false;
        }
        Order other = (Order) object;
        if ((this.orderid == null && other.orderid != null) || (this.orderid != null && !this.orderid.equals(other.orderid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mvcmusic.mvcmusicstore.entities.Order1[ orderid=" + orderid + " ]";
    }
    
}
