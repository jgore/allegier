package pl.allegier.controller.frontend.rest;

import java.util.Objects;

/**
 * Created by Pawel Szczepkowski | Satlan on 14.04.17.
 */
public class RestResponse {

    private int status;
    private String message;
    private Object data;

    public RestResponse(int status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        RestResponse that = (RestResponse) o;
        return Objects.equals(getStatus(), that.getStatus()) &&
                Objects.equals(getMessage(), that.getMessage()) &&
                Objects.equals(getData(), that.getData());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStatus(), getMessage(), getData());
    }
}