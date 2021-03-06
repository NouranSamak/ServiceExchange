/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service_exchange.entities;


import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 *
 * @author Nouran
 */
@Entity
@Table(name = "user_telephone")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "UserTelephone.findAll", query = "SELECT u FROM UserTelephone u")
        , @NamedQuery(name = "UserTelephone.findByUserId", query = "SELECT u FROM UserTelephone u WHERE u.userTelephonePK.userId = :userId")
        , @NamedQuery(name = "UserTelephone.findByTelephone", query = "SELECT u FROM UserTelephone u WHERE u.userTelephonePK.telephone = :telephone")})
public class UserTelephone implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected com.service_exchange.entities.UserTelephonePK userTelephonePK;
    @JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private UserTable userTable;

    public UserTelephone() {
    }

    public UserTelephone(com.service_exchange.entities.UserTelephonePK userTelephonePK) {
        this.userTelephonePK = userTelephonePK;
    }

    public UserTelephone(int userId, String telephone) {
        this.userTelephonePK = new com.service_exchange.entities.UserTelephonePK(userId, telephone);
    }

    public UserTelephone(int userId, String telephone, UserTable userTable) {
        this.userTelephonePK = new com.service_exchange.entities.UserTelephonePK(userId, telephone);
        this.userTable = userTable;
    }

    public com.service_exchange.entities.UserTelephonePK getUserTelephonePK() {
        return userTelephonePK;
    }

    public void setUserTelephonePK(com.service_exchange.entities.UserTelephonePK userTelephonePK) {
        this.userTelephonePK = userTelephonePK;
    }

    public UserTable getUserTable() {
        return userTable;
    }

    public void setUserTable(UserTable userTable) {
        this.userTable = userTable;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userTelephonePK != null ? userTelephonePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserTelephone)) {
            return false;
        }
        UserTelephone other = (UserTelephone) object;
        if ((this.userTelephonePK == null && other.userTelephonePK != null) || (this.userTelephonePK != null && !this.userTelephonePK.equals(other.userTelephonePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.service_exchange.UserTelephone[ userTelephonePK=" + userTelephonePK + " ]";
    }

}
