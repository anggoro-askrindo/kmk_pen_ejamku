package id.co.askrindo.pendjjpr.model.djppr;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Created by Anggoro Biandono on 13/11/2020.
 */
public class InquiryResponse<T> implements Serializable {
    private static final long serialVersionUID = -1868364822510299334L;

    @JsonProperty("error")
    private Boolean error;

    @JsonProperty("code")
    private String code;

    @JsonProperty("message")
    private String message;

    @JsonProperty("total_record")
    private String totalRecord;

    @JsonProperty("max_offset")
    private String maxOffset;

    @JsonProperty("version")
    private String version;
    private T[] data;

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

    public String getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(String totalRecord) {
        this.totalRecord = totalRecord;
    }

    public String getMaxOffset() {
        return maxOffset;
    }

    public void setMaxOffset(String maxOffset) {
        this.maxOffset = maxOffset;
    }

    public T[] getData() {
        return data;
    }

    public void setData(T[] data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InquiryResponse response = (InquiryResponse) o;

        if (code != null ? !code.equals(response.code) : response.code != null) return false;
        if (error != null ? !error.equals(response.error) : response.error != null) return false;
        if (message != null ? !message.equals(response.message) : response.message != null) return false;
        if (version != null ? !version.equals(response.version) : response.version != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = error != null ? error.hashCode() : 0;
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (message != null ? message.hashCode() : 0);
        result = 31 * result + (version != null ? version.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Response{" +
                "error=" + error +
                ", code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", version='" + version + '\'' +
                ", data=" + data +
                '}';
    }
}
