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
public class Calon implements Serializable {
    private static final long serialVersionUID = -1842723925873666194L;

//    "nik": "string",
    private String nik;

//    "nama": "string",
    private String nama;

//    "tgl_lahir": "2020-11-12T04:22:46.348Z",
    @JsonDeserialize(using=IsoDateDeserializer.class)
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSS'Z", timezone="Asia/Jakarta")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone="Asia/Jakarta")
    @JsonProperty("tgl_lahir")
    private Date tgl_lahir;

//    "jns_kelamin": 0,
    @JsonProperty("jns_kelamin")
    private Integer jnsKelamin;

//    "maritas_sts": 0,
    @JsonProperty("maritas_sts")
    private Integer maritasSts;

//    "pendidikan": 0,
    private Integer pendidikan;

//    "pekerjaan": 0,
    private Integer pekerjaan;

//    "jns_debitur": "string",
    @JsonProperty("jns_debitur")
    private String jnsDebitur;

//    "alamat": "string",
    private String alamat;

//    "kode_kabkota": "string",
    @JsonProperty("kode_kabkota")
    private String kodeKabkota;

//    "kode_pos": "string",
    @JsonProperty("kode_pos")
    private String kodePos;

//    "npwp": "string",
    private String npwp;

//    "mulai_usaha": "2020-11-12T04:22:46.348Z",
    @JsonDeserialize(using=IsoDateDeserializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone="Asia/Jakarta")
    @JsonProperty("mulai_usaha")
    private Date mulaiUsaha;

//    "alamat_usaha": "string",
    @JsonProperty("alamat_usaha")
    private String alamatUsaha;

//    "ijin_usaha": "string",
    @JsonProperty("ijin_usaha")
    private String ijinUsaha;

//    "modal_usaha": 0,
    @JsonProperty("modal_usaha")
    private BigDecimal modalUsaha;

//    "jml_pekerja": 0,
    @JsonProperty("jml_pekerja")
    private Integer jmlPekerja;

//    "no_hp": "string",
    @JsonProperty("no_hp")
    private String noHp;

//    "uraian_agunan": "string"
    @JsonProperty("uraian_agunan")
    private String uraianAgunan;

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Date getTgl_lahir() {
        return tgl_lahir;
    }

    public void setTgl_lahir(Date tgl_lahir) {
        this.tgl_lahir = tgl_lahir;
    }

    public Integer getJnsKelamin() {
        return jnsKelamin;
    }

    public void setJnsKelamin(Integer jnsKelamin) {
        this.jnsKelamin = jnsKelamin;
    }

    public Integer getMaritasSts() {
        return maritasSts;
    }

    public void setMaritasSts(Integer maritasSts) {
        this.maritasSts = maritasSts;
    }

    public Integer getPendidikan() {
        return pendidikan;
    }

    public void setPendidikan(Integer pendidikan) {
        this.pendidikan = pendidikan;
    }

    public Integer getPekerjaan() {
        return pekerjaan;
    }

    public void setPekerjaan(Integer pekerjaan) {
        this.pekerjaan = pekerjaan;
    }

    public String getJnsDebitur() {
        return jnsDebitur;
    }

    public void setJnsDebitur(String jnsDebitur) {
        this.jnsDebitur = jnsDebitur;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getKodeKabkota() {
        return kodeKabkota;
    }

    public void setKodeKabkota(String kodeKabkota) {
        this.kodeKabkota = kodeKabkota;
    }

    public String getKodePos() {
        return kodePos;
    }

    public void setKodePos(String kodePos) {
        this.kodePos = kodePos;
    }

    public String getNpwp() {
        return npwp;
    }

    public void setNpwp(String npwp) {
        this.npwp = npwp;
    }

    public Date getMulaiUsaha() {
        return mulaiUsaha;
    }

    public void setMulaiUsaha(Date mulaiUsaha) {
        this.mulaiUsaha = mulaiUsaha;
    }

    public String getAlamatUsaha() {
        return alamatUsaha;
    }

    public void setAlamatUsaha(String alamatUsaha) {
        this.alamatUsaha = alamatUsaha;
    }

    public String getIjinUsaha() {
        return ijinUsaha;
    }

    public void setIjinUsaha(String ijinUsaha) {
        this.ijinUsaha = ijinUsaha;
    }

    public BigDecimal getModalUsaha() {
        return modalUsaha;
    }

    public void setModalUsaha(BigDecimal modalUsaha) {
        this.modalUsaha = modalUsaha;
    }

    public Integer getJmlPekerja() {
        return jmlPekerja;
    }

    public void setJmlPekerja(Integer jmlPekerja) {
        this.jmlPekerja = jmlPekerja;
    }

    public String getNoHp() {
        return noHp;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }

    public String getUraianAgunan() {
        return uraianAgunan;
    }

    public void setUraianAgunan(String uraianAgunan) {
        this.uraianAgunan = uraianAgunan;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Calon calon = (Calon) o;

        if (maritasSts != null ? !maritasSts.equals(calon.maritasSts) : calon.maritasSts != null) return false;
        if (nik != null ? !nik.equals(calon.nik) : calon.nik != null) return false;
        if (npwp != null ? !npwp.equals(calon.npwp) : calon.npwp != null) return false;
        if (pekerjaan != null ? !pekerjaan.equals(calon.pekerjaan) : calon.pekerjaan != null) return false;
        if (pendidikan != null ? !pendidikan.equals(calon.pendidikan) : calon.pendidikan != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = nik != null ? nik.hashCode() : 0;
        result = 31 * result + (maritasSts != null ? maritasSts.hashCode() : 0);
        result = 31 * result + (pendidikan != null ? pendidikan.hashCode() : 0);
        result = 31 * result + (pekerjaan != null ? pekerjaan.hashCode() : 0);
        result = 31 * result + (npwp != null ? npwp.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Calon{" +
                "nik='" + nik + '\'' +
                ", nama='" + nama + '\'' +
                ", tgl_lahir=" + tgl_lahir +
                ", jnsKelamin=" + jnsKelamin +
                ", maritasSts=" + maritasSts +
                ", pendidikan=" + pendidikan +
                ", pekerjaan=" + pekerjaan +
                ", jnsDebitur='" + jnsDebitur + '\'' +
                ", alamat='" + alamat + '\'' +
                ", kodeKabkota='" + kodeKabkota + '\'' +
                ", kodePos='" + kodePos + '\'' +
                ", npwp='" + npwp + '\'' +
                ", mulaiUsaha=" + mulaiUsaha +
                ", alamatUsaha='" + alamatUsaha + '\'' +
                ", ijinUsaha='" + ijinUsaha + '\'' +
                ", modalUsaha=" + modalUsaha +
                ", jmlPekerja=" + jmlPekerja +
                ", noHp='" + noHp + '\'' +
                ", uraianAgunan='" + uraianAgunan + '\'' +
                '}';
    }
}
