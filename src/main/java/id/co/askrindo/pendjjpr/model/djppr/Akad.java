package id.co.askrindo.pendjjpr.model.djppr;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import id.co.askrindo.pendjjpr.utils.IsoDateDeserializer;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Anggoro Biandono on 12/11/2020.
 */
public class Akad implements Serializable{
    private static final long serialVersionUID = -7068844003434986187L;

//    {
//        "rekening_baru": "string",
//        "kode_bank": "string",
//        "nik": "string",
//        "rekening_lama": "string",
//        "status_akad": "string",
//        "status_rekening": 0,
//        "nomor_akad": "string",
//        "tgl_akad": "2020-11-12T03:05:12.752Z",
//        "tgl_penarikan": "2020-11-12T03:05:12.752Z",
//        "tgl_jatuh_tempo": "2020-11-12T03:05:12.752Z",
//        "nilai_akad": 0,
//        "tgl_penjaminan": "2020-11-12T03:05:12.752Z",
//        "nomorPenjaminan": "string",
//        "nilai_dijamin": 0,
//        "sektor": "string"
//    }

    @JsonProperty("rekening_baru")
    private String rekeningBaru;

    @JsonProperty("kode_bank")
    private String kodeBank;

    private String nik;

    @JsonProperty("rekening_lama")
    private String rekeningLama;

    @JsonProperty("status_akad")
    private String statusAkad;

    @JsonProperty("status_rekening")
    private Integer statusRekening;

    @JsonProperty("nomor_akad")
    private String nomorAkad;

    @JsonDeserialize(using=IsoDateDeserializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone="Asia/Jakarta")
    @JsonProperty("tgl_akad")
    private Date tglAkad;

    @JsonDeserialize(using=IsoDateDeserializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone="Asia/Jakarta")
    @JsonProperty("tgl_penarikan")
    private Date tglPenarikan;

    @JsonDeserialize(using=IsoDateDeserializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone="Asia/Jakarta")
    @JsonProperty("tgl_jatuh_tempo")
    private Date tglJatuhTempo;

    @JsonProperty("nilai_akad")
    private BigDecimal nilaiAkad;

    @JsonDeserialize(using=IsoDateDeserializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone="Asia/Jakarta")
    @JsonProperty("tgl_penjaminan")
    private Date tglPenjaminan;

    @JsonProperty("nomor_penjaminan")
    private String nomorPenjaminan;

    @JsonProperty("nilai_dijamin")
    private BigDecimal nilaiDijamin;

    @JsonProperty("sektor")
    private String sektor;

    public String getRekeningBaru() {
        return rekeningBaru;
    }

    public void setRekeningBaru(String rekeningBaru) {
        this.rekeningBaru = rekeningBaru;
    }

    public String getKodeBank() {
        return kodeBank;
    }

    public void setKodeBank(String kodeBank) {
        this.kodeBank = kodeBank;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getRekeningLama() {
        return rekeningLama;
    }

    public void setRekeningLama(String rekeningLama) {
        this.rekeningLama = rekeningLama;
    }

    public String getStatusAkad() {
        return statusAkad;
    }

    public void setStatusAkad(String statusAkad) {
        this.statusAkad = statusAkad;
    }

    public Integer getStatusRekening() {
        return statusRekening;
    }

    public void setStatusRekening(Integer statusRekening) {
        this.statusRekening = statusRekening;
    }

    public String getNomorAkad() {
        return nomorAkad;
    }

    public void setNomorAkad(String nomorAkad) {
        this.nomorAkad = nomorAkad;
    }

    public Date getTglAkad() {
        return tglAkad;
    }

    public void setTglAkad(Date tglAkad) {
        this.tglAkad = tglAkad;
    }

    public Date getTglPenarikan() {
        return tglPenarikan;
    }

    public void setTglPenarikan(Date tglPenarikan) {
        this.tglPenarikan = tglPenarikan;
    }

    public Date getTglJatuhTempo() {
        return tglJatuhTempo;
    }

    public void setTglJatuhTempo(Date tglJatuhTempo) {
        this.tglJatuhTempo = tglJatuhTempo;
    }

    public BigDecimal getNilaiAkad() {
        return nilaiAkad;
    }

    public void setNilaiAkad(BigDecimal nilaiAkad) {
        this.nilaiAkad = nilaiAkad;
    }

    public Date getTglPenjaminan() {
        return tglPenjaminan;
    }

    public void setTglPenjaminan(Date tglPenjaminan) {
        this.tglPenjaminan = tglPenjaminan;
    }

    public String getNomorPenjaminan() {
        return nomorPenjaminan;
    }

    public void setNomorPenjaminan(String nomorPenjaminan) {
        this.nomorPenjaminan = nomorPenjaminan;
    }

    public BigDecimal getNilaiDijamin() {
        return nilaiDijamin;
    }

    public void setNilaiDijamin(BigDecimal nilaiDijamin) {
        this.nilaiDijamin = nilaiDijamin;
    }

    public String getSektor() {
        return sektor;
    }

    public void setSektor(String sektor) {
        this.sektor = sektor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Akad akad = (Akad) o;

        if (kodeBank != null ? !kodeBank.equals(akad.kodeBank) : akad.kodeBank != null) return false;
        if (nik != null ? !nik.equals(akad.nik) : akad.nik != null) return false;
        if (nomorAkad != null ? !nomorAkad.equals(akad.nomorAkad) : akad.nomorAkad != null) return false;
        if (nomorPenjaminan != null ? !nomorPenjaminan.equals(akad.nomorPenjaminan) : akad.nomorPenjaminan != null)
            return false;
        if (rekeningBaru != null ? !rekeningBaru.equals(akad.rekeningBaru) : akad.rekeningBaru != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = rekeningBaru != null ? rekeningBaru.hashCode() : 0;
        result = 31 * result + (kodeBank != null ? kodeBank.hashCode() : 0);
        result = 31 * result + (nik != null ? nik.hashCode() : 0);
        result = 31 * result + (nomorAkad != null ? nomorAkad.hashCode() : 0);
        result = 31 * result + (nomorPenjaminan != null ? nomorPenjaminan.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Akad{" +
                "rekeningBaru='" + rekeningBaru + '\'' +
                ", kodeBank='" + kodeBank + '\'' +
                ", nik='" + nik + '\'' +
                ", rekeningLama='" + rekeningLama + '\'' +
                ", statusAkad='" + statusAkad + '\'' +
                ", statusRekening=" + statusRekening +
                ", nomorAkad='" + nomorAkad + '\'' +
                ", tglAkad=" + tglAkad +
                ", tglPenarikan=" + tglPenarikan +
                ", tglJatuhTempo=" + tglJatuhTempo +
                ", nilaiAkad=" + nilaiAkad +
                ", tglPenjaminan=" + tglPenjaminan +
                ", nomorPenjaminan='" + nomorPenjaminan + '\'' +
                ", nilaiDijamin=" + nilaiDijamin +
                ", sektor='" + sektor + '\'' +
                '}';
    }
}
