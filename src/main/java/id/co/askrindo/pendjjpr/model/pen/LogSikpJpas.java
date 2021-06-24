package id.co.askrindo.pendjjpr.model.pen;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Anggoro Biandono on 13/11/2020.
 */
@Entity
@Table(name = "log_sikp_jpas")
public class LogSikpJpas implements Serializable {
    private static final long serialVersionUID = 5471515050586341316L;

//    COLUMN_NAME                                    DATA_TYPE  DATA_LENGTH  DATA_PRECISION  DATA_SCALE  NULLABLE  DATA_DEFAULT
//    ---------------------------------------------  ---------  -----------  --------------  ----------  --------  ---------------------------------------------
//    id_log                                         int8                                                NO        nextval('log_sikp_jpas_id_log_seq'::regclass)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "log_sikp_jpas_id_log_seq")
    @SequenceGenerator(name="log_sikp_jpas_id_log_seq", sequenceName = "log_sikp_jpas_id_log_seq", allocationSize=0)
    @Column(name = "id_log")
    private Long idLog;

//    no_rekening                                    varchar                                             NO
    @Column(name = "no_rekening")
    private String noRekening;

//    no_aplikasi                                    varchar                                             YES
    @Column(name = "no_aplikasi")
    private String noAplikasi;

//    no_sertifikat                                  varchar                                             NO
    @Column(name = "no_sertifikat")
    private String noSertifikat;

//    id_penjaminan                                  int8                                                NO
    @Column(name = "id_penjaminan")
    private Long idPenjaminan;

//    id_debitur                                     varchar                                             NO
    @Column(name = "id_debitur")
    private String idDebitur;

//    tgl_premi                                      date                                                NO
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "tgl_premi")
    private Date tglPremi;

//    status                                         int2                                                NO
    @Column(name = "status")
    private Integer status;

//    keterangan                                     varchar                                             YES
    @Column(name = "keterangan")
    private String keterangan;

//    is_active                                      bool                                                NO        true
    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "created_by")
    private String createdBy;

    public Long getIdLog() {
        return idLog;
    }

    public void setIdLog(Long idLog) {
        this.idLog = idLog;
    }

    public String getNoRekening() {
        return noRekening;
    }

    public void setNoRekening(String noRekening) {
        this.noRekening = noRekening;
    }

    public String getNoAplikasi() {
        return noAplikasi;
    }

    public void setNoAplikasi(String noAplikasi) {
        this.noAplikasi = noAplikasi;
    }

    public String getNoSertifikat() {
        return noSertifikat;
    }

    public void setNoSertifikat(String noSertifikat) {
        this.noSertifikat = noSertifikat;
    }

    public Long getIdPenjaminan() {
        return idPenjaminan;
    }

    public void setIdPenjaminan(Long idPenjaminan) {
        this.idPenjaminan = idPenjaminan;
    }

    public String getIdDebitur() {
        return idDebitur;
    }

    public void setIdDebitur(String idDebitur) {
        this.idDebitur = idDebitur;
    }

    public Date getTglPremi() {
        return tglPremi;
    }

    public void setTglPremi(Date tglPremi) {
        this.tglPremi = tglPremi;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LogSikpJpas that = (LogSikpJpas) o;

        if (idDebitur != null ? !idDebitur.equals(that.idDebitur) : that.idDebitur != null) return false;
        if (idLog != null ? !idLog.equals(that.idLog) : that.idLog != null) return false;
        if (idPenjaminan != null ? !idPenjaminan.equals(that.idPenjaminan) : that.idPenjaminan != null) return false;
        if (isActive != null ? !isActive.equals(that.isActive) : that.isActive != null) return false;
        if (noAplikasi != null ? !noAplikasi.equals(that.noAplikasi) : that.noAplikasi != null) return false;
        if (noRekening != null ? !noRekening.equals(that.noRekening) : that.noRekening != null) return false;
        if (noSertifikat != null ? !noSertifikat.equals(that.noSertifikat) : that.noSertifikat != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idLog != null ? idLog.hashCode() : 0;
        result = 31 * result + (noRekening != null ? noRekening.hashCode() : 0);
        result = 31 * result + (noAplikasi != null ? noAplikasi.hashCode() : 0);
        result = 31 * result + (noSertifikat != null ? noSertifikat.hashCode() : 0);
        result = 31 * result + (idPenjaminan != null ? idPenjaminan.hashCode() : 0);
        result = 31 * result + (idDebitur != null ? idDebitur.hashCode() : 0);
        result = 31 * result + (isActive != null ? isActive.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "LogSikpJpas{" +
                "idLog=" + idLog +
                ", noRekening='" + noRekening + '\'' +
                ", noAplikasi='" + noAplikasi + '\'' +
                ", noSertifikat='" + noSertifikat + '\'' +
                ", idPenjaminan=" + idPenjaminan +
                ", idDebitur='" + idDebitur + '\'' +
                ", tglPremi=" + tglPremi +
                ", status=" + status +
                ", keterangan='" + keterangan + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}
