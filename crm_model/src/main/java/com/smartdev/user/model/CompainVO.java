package com.smartdev.user.model;

import org.hibernate.validator.constraints.NotEmpty;

public class CompainVO {
    @NotEmpty(message = "Campain is required.")
    private String compain;
    @NotEmpty(message = "Description is required")
    private String description;
    @NotEmpty(message = "Date from is required")
    private String from;
    @NotEmpty(message = "Date to is required")
    private String to;
    @NotEmpty(message = "File is required.")
    private String file;

    public CompainVO() {}

    public String getCompain() {
        return compain;
    }

    public void setCompain(String compain) {
        this.compain = compain;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }
}
