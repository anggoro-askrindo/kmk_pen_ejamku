package id.co.askrindo.pendjjpr.model.djppr;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import id.co.askrindo.pendjjpr.utils.IsoDateDeserializer;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Anggoro Biandono on 14/11/2020.
 */
public class TagihanResponse extends Tagihan implements Serializable {
    private static final long serialVersionUID = 630208010692931090L;

//    "id_tagihan": 0,
    @JsonProperty("id_tagihan")
    private Long idTagihan;

//    "status_tagihan": 0,
    @JsonProperty("status_tagihan")
    private Integer statusTagihan;

//    "keterangan": "string",
    @JsonProperty("keterangan")
    private String keterangan;

//    "tgl_bayar": "2020-11-14T01:03:43.351Z",
    @JsonDeserialize(using=IsoDateDeserializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone="Asia/Jakarta")
    @JsonProperty("tgl_bayar")
    private Date tglBayar;

//    "tgl_kirim": "2020-11-14T01:03:43.351Z",
    @JsonDeserialize(using=IsoDateDeserializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone="Asia/Jakarta")
    @JsonProperty("tgl_kirim")
    private Date tglKirim;

//    "nilai_dibayar": 0
    @JsonProperty("nilai_dibayar")
    private BigDecimal nilaiDibayar;

    public Long getIdTagihan() {
        return idTagihan;
    }

    public void setIdTagihan(Long idTagihan) {
        this.idTagihan = idTagihan;
    }

    public Integer getStatusTagihan() {
        return statusTagihan;
    }

    public void setStatusTagihan(Integer statusTagihan) {
        this.statusTagihan = statusTagihan;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public Date getTglBayar() {
        return tglBayar;
    }

    public void setTglBayar(Date tglBayar) {
        this.tglBayar = tglBayar;
    }

    public Date getTglKirim() {
        return tglKirim;
    }

    public void setTglKirim(Date tglKirim) {
        this.tglKirim = tglKirim;
    }

    public BigDecimal getNilaiDibayar() {
        return nilaiDibayar;
    }

    public void setNilaiDibayar(BigDecimal nilaiDibayar) {
        this.nilaiDibayar = nilaiDibayar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        TagihanResponse that = (TagihanResponse) o;

        if (idTagihan != null ? !idTagihan.equals(that.idTagihan) : that.idTagihan != null) return false;
        if (statusTagihan != null ? !statusTagihan.equals(that.statusTagihan) : that.statusTagihan != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (idTagihan != null ? idTagihan.hashCode() : 0);
        result = 31 * result + (statusTagihan != null ? statusTagihan.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TagihanResponse{" +
                "idTagihan=" + idTagihan +
                ", statusTagihan=" + statusTagihan +
                ", keterangan='" + keterangan + '\'' +
                ", tglBayar=" + tglBayar +
                ", tglKirim=" + tglKirim +
                ", nilaiDibayar=" + nilaiDibayar +
                '}';
    }
}
