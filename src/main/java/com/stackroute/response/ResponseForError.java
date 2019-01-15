package com.stackroute.response;

public class ResponseForError {

    private int errorID;
    private String errorMessageInformation;

    public int getErrorID() {
        return errorID;
    }

    public void setErrorID(int errorID) {
        this.errorID = errorID;
    }

    public String getErrorMessageInformation() {
        return errorMessageInformation;
    }

    public void setErrorMessageInformation(String errorMessageInformation) {
        this.errorMessageInformation = errorMessageInformation;
    }
}
