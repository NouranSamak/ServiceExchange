/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service_exchange.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * @author Nouran
 */
@Embeddable
public class UserBadgePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "user_id")
    private int userId;
    @Basic(optional = false)
    @Column(name = "badge_id")
    private int badgeId;

    public UserBadgePK() {
    }

    public UserBadgePK(int userId, int badgeId) {
        this.userId = userId;
        this.badgeId = badgeId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getBadgeId() {
        return badgeId;
    }

    public void setBadgeId(int badgeId) {
        this.badgeId = badgeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) userId;
        hash += (int) badgeId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserBadgePK)) {
            return false;
        }
        UserBadgePK other = (UserBadgePK) object;
        if (this.userId != other.userId) {
            return false;
        }
        if (this.badgeId != other.badgeId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.service_exchange.UserBadgePK[ userId=" + userId + ", badgeId=" + badgeId + " ]";
    }

}
