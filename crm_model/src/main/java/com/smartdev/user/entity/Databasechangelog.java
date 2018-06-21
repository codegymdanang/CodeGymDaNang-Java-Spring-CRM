package com.smartdev.user.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import java.sql.Timestamp;

@Entity
public class Databasechangelog {
    private String id;
    private String author;
    private String filename;
    private Timestamp dateexecuted;
    private Integer orderexecuted;
    private String exectype;
    private String md5Sum;
    private String description;
    private String comments;
    private String tag;
    private String liquibase;

    @Basic
    @Column(name = "ID")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "AUTHOR")
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Basic
    @Column(name = "FILENAME")
    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    @Basic
    @Column(name = "DATEEXECUTED")
    public Timestamp getDateexecuted() {
        return dateexecuted;
    }

    public void setDateexecuted(Timestamp dateexecuted) {
        this.dateexecuted = dateexecuted;
    }

    @Basic
    @Column(name = "ORDEREXECUTED")
    public Integer getOrderexecuted() {
        return orderexecuted;
    }

    public void setOrderexecuted(Integer orderexecuted) {
        this.orderexecuted = orderexecuted;
    }

    @Basic
    @Column(name = "EXECTYPE")
    public String getExectype() {
        return exectype;
    }

    public void setExectype(String exectype) {
        this.exectype = exectype;
    }

    @Basic
    @Column(name = "MD5SUM")
    public String getMd5Sum() {
        return md5Sum;
    }

    public void setMd5Sum(String md5Sum) {
        this.md5Sum = md5Sum;
    }

    @Basic
    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "COMMENTS")
    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Basic
    @Column(name = "TAG")
    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @Basic
    @Column(name = "LIQUIBASE")
    public String getLiquibase() {
        return liquibase;
    }

    public void setLiquibase(String liquibase) {
        this.liquibase = liquibase;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Databasechangelog that = (Databasechangelog) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (author != null ? !author.equals(that.author) : that.author != null) return false;
        if (filename != null ? !filename.equals(that.filename) : that.filename != null) return false;
        if (dateexecuted != null ? !dateexecuted.equals(that.dateexecuted) : that.dateexecuted != null) return false;
        if (orderexecuted != null ? !orderexecuted.equals(that.orderexecuted) : that.orderexecuted != null)
            return false;
        if (exectype != null ? !exectype.equals(that.exectype) : that.exectype != null) return false;
        if (md5Sum != null ? !md5Sum.equals(that.md5Sum) : that.md5Sum != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (comments != null ? !comments.equals(that.comments) : that.comments != null) return false;
        if (tag != null ? !tag.equals(that.tag) : that.tag != null) return false;
        if (liquibase != null ? !liquibase.equals(that.liquibase) : that.liquibase != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (filename != null ? filename.hashCode() : 0);
        result = 31 * result + (dateexecuted != null ? dateexecuted.hashCode() : 0);
        result = 31 * result + (orderexecuted != null ? orderexecuted.hashCode() : 0);
        result = 31 * result + (exectype != null ? exectype.hashCode() : 0);
        result = 31 * result + (md5Sum != null ? md5Sum.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (comments != null ? comments.hashCode() : 0);
        result = 31 * result + (tag != null ? tag.hashCode() : 0);
        result = 31 * result + (liquibase != null ? liquibase.hashCode() : 0);
        return result;
    }
}
