package id.co.askrindo.pendjjpr.model.djppr;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by Anggoro Biandono on 12/11/2020.
 */
public class Tagihan implements Serializable {
    private static final long serialVersionUID = 2715583645110457704L;

//    "nomor_tagihan": "string",
    @JsonProperty("nomor_tagihan")
    private String nomorTagihan;

//    "nomor_rekening": "string",
    @JsonProperty("nomor_rekening")
    private String nomorRekening;

//    "kode_bank": "string",

    @JsonProperty("kode_bank")
    private String kodeBank;

//    "outstanding": 0
    @JsonProperty("outstanding")
    private BigDecimal outstanding;

//    "tahun": 0,
    @JsonProperty("tahun")
    private Integer tahun;

//    "nilai_ijp": 0,
    @JsonProperty("nilai_ijp")
    private BigDecimal nilaiIjp;

//    "periode": 0
    @JsonProperty("periode")
    private Integer periode;

    public String getNomorTagihan() {
        return nomorTagihan;
    }

    public void setNomorTagihan(String nomorTagihan) {
        this.nomorTagihan = nomorTagihan;
    }

    public String getNomorRekening() {
        return nomorRekening;
    }

    public void setNomorRekening(String nomorRekening) {
        this.nomorRekening = nomorRekening;
    }

    public String getKodeBank() {
        return kodeBank;
    }

    public void setKodeBank(String kodeBank) {
        this.kodeBank = kodeBank;
    }

    public BigDecimal getOutstanding() {
        return outstanding;
    }

    public void setOutstanding(BigDecimal outstanding) {
        this.outstanding = outstanding;
    }

    public Integer getTahun() {
        return tahun;
    }

    public void setTahun(Integer tahun) {
        this.tahun = tahun;
    }

    public BigDecimal getNilaiIjp() {
        return nilaiIjp;
    }

    public void setNilaiIjp(BigDecimal nilaiIjp) {
        this.nilaiIjp = nilaiIjp;
    }

    public Integer getPeriode() {
        return periode;
    }

    public void setPeriode(Integer periode) {
        this.periode = periode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tagihan tagihan = (Tagihan) o;

        if (kodeBank != null ? !kodeBank.equals(tagihan.kodeBank) : tagihan.kodeBank != null) return false;
        if (nomorRekening != null ? !nomorRekening.equals(tagihan.nomorRekening) : tagihan.nomorRekening != null)
            return false;
        if (nomorTagihan != null ? !nomorTagihan.equals(tagihan.nomorTagihan) : tagihan.nomorTagihan != null)
            return false;
        if (tahun != null ? !tahun.equals(tagihan.tahun) : tagihan.tahun != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = nomorTagihan != null ? nomorTagihan.hashCode() : 0;
        result = 31 * result + (nomorRekening != null ? nomorRekening.hashCode() : 0);
        result = 31 * result + (kodeBank != null ? kodeBank.hashCode() : 0);
        result = 31 * result + (tahun != null ? tahun.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Tagihan{" +
                "nomorTagihan='" + nomorTagihan + '\'' +
                ", nomorRekening='" + nomorRekening + '\'' +
                ", kodeBank='" + kodeBank + '\'' +
                ", outstanding=" + outstanding +
                ", tahun=" + tahun +
                ", nilaiIjp=" + nilaiIjp +
                ", periode=" + periode +
                '}';
    }
}
