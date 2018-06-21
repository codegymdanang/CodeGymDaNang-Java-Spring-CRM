package com.smartdev.user.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class Databasechangeloglock {
    private Integer id;
    private Boolean locked;
    private Timestamp lockgranted;
    private String lockedby;

    @Id
    @Column(name = "ID")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "LOCKED")
    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    @Basic
    @Column(name = "LOCKGRANTED")
    public Timestamp getLockgranted() {
        return lockgranted;
    }

    public void setLockgranted(Timestamp lockgranted) {
        this.lockgranted = lockgranted;
    }

    @Basic
    @Column(name = "LOCKEDBY")
    public String getLockedby() {
        return lockedby;
    }

    public void setLockedby(String lockedby) {
        this.lockedby = lockedby;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Databasechangeloglock that = (Databasechangeloglock) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (locked != null ? !locked.equals(that.locked) : that.locked != null) return false;
        if (lockgranted != null ? !lockgranted.equals(that.lockgranted) : that.lockgranted != null) return false;
        if (lockedby != null ? !lockedby.equals(that.lockedby) : that.lockedby != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (locked != null ? locked.hashCode() : 0);
        result = 31 * result + (lockgranted != null ? lockgranted.hashCode() : 0);
        result = 31 * result + (lockedby != null ? lockedby.hashCode() : 0);
        return result;
    }
}
