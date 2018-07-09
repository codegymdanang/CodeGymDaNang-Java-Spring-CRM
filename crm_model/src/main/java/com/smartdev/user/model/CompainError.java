package com.smartdev.user.model;

public class CompainError {
    private String nameError;
    private String descriptionError;
    private String fromError;
    private String toError;
    private String fileError;

    public CompainError() {}

    public String getNameError() {
        return nameError;
    }

    public void setNameError(String nameError) {
        this.nameError = nameError;
    }

    public String getDescriptionError() {
        return descriptionError;
    }

    public void setDescriptionError(String descriptionError) {
        this.descriptionError = descriptionError;
    }

    public String getFromError() {
        return fromError;
    }

    public void setFromError(String fromError) {
        this.fromError = fromError;
    }

    public String getToError() {
        return toError;
    }

    public void setToError(String toError) {
        this.toError = toError;
    }

    public String getFileError() {
        return fileError;
    }

    public void setFileError(String fileError) {
        this.fileError = fileError;
    }
}
