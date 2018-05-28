/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service_exchange.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Altysh
 */
@Entity
@Table(name = "user_notification")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserNotification.findAll", query = "SELECT u FROM UserNotification u")
    , @NamedQuery(name = "UserNotification.findByUserId", query = "SELECT u FROM UserNotification u WHERE u.userNotificationPK.userId = :userId")
    , @NamedQuery(name = "UserNotification.findByNotificationId", query = "SELECT u FROM UserNotification u WHERE u.userNotificationPK.notificationId = :notificationId")
    , @NamedQuery(name = "UserNotification.findByState", query = "SELECT u FROM UserNotification u WHERE u.state = :state")})
public class UserNotification implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UserNotificationPK userNotificationPK;
    @Size(max = 45)
    @Column(name = "state")
    private String state;
    @JoinColumn(name = "notification_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Notification notification;
    @JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private User user;

    public UserNotification() {
    }

    public UserNotification(UserNotificationPK userNotificationPK) {
        this.userNotificationPK = userNotificationPK;
    }

    public UserNotification(int userId, int notificationId) {
        this.userNotificationPK = new UserNotificationPK(userId, notificationId);
    }

    public UserNotificationPK getUserNotificationPK() {
        return userNotificationPK;
    }

    public void setUserNotificationPK(UserNotificationPK userNotificationPK) {
        this.userNotificationPK = userNotificationPK;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Notification getNotification() {
        return notification;
    }

    public void setNotification(Notification notification) {
        this.notification = notification;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userNotificationPK != null ? userNotificationPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserNotification)) {
            return false;
        }
        UserNotification other = (UserNotification) object;
        if ((this.userNotificationPK == null && other.userNotificationPK != null) || (this.userNotificationPK != null && !this.userNotificationPK.equals(other.userNotificationPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.service_exchange.entities.UserNotification[ userNotificationPK=" + userNotificationPK + " ]";
    }
    
}
