package id.co.askrindo.pendjjpr.model.djppr;

import java.io.Serializable;

/**
 * Created by Anggoro Biandono on 13/11/2020.
 */
public class Token implements Serializable {
    private static final long serialVersionUID = 7159449484130354166L;

//    "error": true,
    private Boolean error;

//    "code": "string",
    private String code;

//    "message": "string",
    private String message;

//    "version": "string",
    private String version;

//    "data": "string"
    private String data;

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Token token = (Token) o;

        if (code != null ? !code.equals(token.code) : token.code != null) return false;
        if (data != null ? !data.equals(token.data) : token.data != null) return false;
        if (error != null ? !error.equals(token.error) : token.error != null) return false;
        if (message != null ? !message.equals(token.message) : token.message != null) return false;
        if (version != null ? !version.equals(token.version) : token.version != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = error != null ? error.hashCode() : 0;
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (message != null ? message.hashCode() : 0);
        result = 31 * result + (version != null ? version.hashCode() : 0);
        result = 31 * result + (data != null ? data.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Token{" +
                "error=" + error +
                ", code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", version='" + version + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}
