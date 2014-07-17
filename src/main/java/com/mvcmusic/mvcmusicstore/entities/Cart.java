/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mvcmusic.mvcmusicstore.entities;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author seannils1
 */
@Entity
@Table(name = "CART")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cart.findAll", query = "SELECT c FROM Cart c"),
    @NamedQuery(name = "Cart.findByRecordid", query = "SELECT c FROM Cart c WHERE c.recordid = :recordid"),
    @NamedQuery(name = "Cart.findByCartid", query = "SELECT c FROM Cart c WHERE c.cartid = :cartid"),
    @NamedQuery(name = "Cart.findByCount", query = "SELECT c FROM Cart c WHERE c.count = :count"),
    @NamedQuery(name = "Cart.findByDatecreate", query = "SELECT c FROM Cart c WHERE c.datecreate = :datecreate")})
public class Cart implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "RECORDID")
    private Integer recordid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CARTID")
    private BigInteger cartid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COUNT")
    private BigInteger count;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATECREATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datecreate;
    @JoinColumn(name = "ALBUMID", referencedColumnName = "ALBUMID")
    @ManyToOne(optional = false)
    private Album albumid;

    public Cart() {
    }

    public Cart(Integer recordid) {
        this.recordid = recordid;
    }

    public Cart(Integer recordid, BigInteger cartid, BigInteger count, Date datecreate) {
        this.recordid = recordid;
        this.cartid = cartid;
        this.count = count;
        this.datecreate = datecreate;
    }

    public Integer getRecordid() {
        return recordid;
    }

    public void setRecordid(Integer recordid) {
        this.recordid = recordid;
    }

    public BigInteger getCartid() {
        return cartid;
    }

    public void setCartid(BigInteger cartid) {
        this.cartid = cartid;
    }

    public BigInteger getCount() {
        return count;
    }

    public void setCount(BigInteger count) {
        this.count = count;
    }

    public Date getDatecreate() {
        return datecreate;
    }

    public void setDatecreate(Date datecreate) {
        this.datecreate = datecreate;
    }

    public Album getAlbumid() {
        return albumid;
    }

    public void setAlbumid(Album albumid) {
        this.albumid = albumid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (recordid != null ? recordid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cart)) {
            return false;
        }
        Cart other = (Cart) object;
        if ((this.recordid == null && other.recordid != null) || (this.recordid != null && !this.recordid.equals(other.recordid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mvcmusic.mvcmusicstore.entities.Cart[ recordid=" + recordid + " ]";
    }
    
}
