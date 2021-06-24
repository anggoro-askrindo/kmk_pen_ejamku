package id.co.askrindo.pendjjpr.model.pen;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Anggoro Biandono on 12/11/2020.
 */
@Entity
@Table(name = "t_penjaminan_ijp_jpas")
public class PenjaminanIjp implements Serializable {
    private static final long serialVersionUID = -6931143514627997133L;

//    COLUMN_NAME                                                  DATA_TYPE  DATA_LENGTH  DATA_PRECISION  DATA_SCALE  NULLABLE  DATA_DEFAULT
//    -----------------------------------------------------------  ---------  -----------  --------------  ----------  --------  -----------------------------------------------------------
//    penjaminan_ijp_id                                            int8                                                NO        nextval('t_penjaminan_ijp_penjaminan_ijp_id_seq'::regclass)
    @Id
    @Column(name = "penjaminan_ijp_id")
    private Long penjaminanIjpId;

//    id_penjaminan                                                int8                                                NO
    @Column(name = "id_penjaminan")
    private Long idPenjaminan;

//    tahun_ke                                                     int2                                                NO
    @Column(name = "tahun_ke")
    private Integer tahunKe;

//    tgl_premi                                                    date                                                YES
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "tgl_premi")
    private Date tglPremi;

//    premi                                                        numeric                                             NO        0
    @Column(name = "premi", length = 18, precision = 2)
    private BigDecimal premi;

//    jatuh_tempo                                                  date                                                YES
//    premi_dibayar                                                numeric                                             YES       0
//    status_bayar                                                 bool                                                NO        false
//    no_bukti_bayar                                               varchar                                             YES
//    tgl_bayar                                                    date                                                YES
//    version                                                      int2                                                NO        1
//    created_by                                                   varchar    20                                       NO
//    created_date                                                 timestamp                                           NO        now()
//    modified_by                                                  varchar    20                                       YES
    @Column(name = "modified_by")
    private String modifiedBy;

//    modified_date                                                timestamp                                           YES
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modified_date")
    private Date modifiedDate;

//    cadangan                                                     numeric                 18              2           YES       0
    @Column(name = "cadangan", length = 18, precision = 2)
    private BigDecimal cadangan;

//    id_jurnal_produksi_ijp                                       int8                                                YES
//    premi_nett                                                   numeric                 18              2           YES       0
//    status_sikp                                                  bool                                                NO        false
    @Column(name = "status_sikp")
    private Boolean statusSikp;
//    is_koreksi                                                   bool

    //id_tagihan_djppr                                          int8
    @Column(name = "id_tagihan_djppr")
    private Long idTagihanDjppr;

//    tgl_penagihan
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "tgl_penagihan")
    private Date tglPenagihan;

//    bulan_penagihan
    @Column(name = "bulan_penagihan")
    private Integer bulanPenagihan;

//    tahun_penagihan
    @Column(name = "tahun_penagihan")
    private Integer tahunPenagihan;

    public Long getPenjaminanIjpId() {
        return penjaminanIjpId;
    }

    public void setPenjaminanIjpId(Long penjaminanIjpId) {
        this.penjaminanIjpId = penjaminanIjpId;
    }

    public Long getIdPenjaminan() {
        return idPenjaminan;
    }

    public void setIdPenjaminan(Long idPenjaminan) {
        this.idPenjaminan = idPenjaminan;
    }

    public Integer getTahunKe() {
        return tahunKe;
    }

    public void setTahunKe(Integer tahunKe) {
        this.tahunKe = tahunKe;
    }

    public Date getTglPremi() {
        return tglPremi;
    }

    public void setTglPremi(Date tglPremi) {
        this.tglPremi = tglPremi;
    }

    public BigDecimal getPremi() {
        return premi;
    }

    public void setPremi(BigDecimal premi) {
        this.premi = premi;
    }

    public BigDecimal getCadangan() {
        return cadangan;
    }

    public void setCadangan(BigDecimal cadangan) {
        this.cadangan = cadangan;
    }

    public Boolean getStatusSikp() {
        return statusSikp;
    }

    public void setStatusSikp(Boolean statusSikp) {
        this.statusSikp = statusSikp;
    }

    public Long getIdTagihanDjppr() {
        return idTagihanDjppr;
    }

    public void setIdTagihanDjppr(Long idTagihanDjppr) {
        this.idTagihanDjppr = idTagihanDjppr;
    }

    public Date getTglPenagihan() {
        return tglPenagihan;
    }

    public void setTglPenagihan(Date tglPenagihan) {
        this.tglPenagihan = tglPenagihan;
    }

    public Integer getBulanPenagihan() {
        return bulanPenagihan;
    }

    public void setBulanPenagihan(Integer bulanPenagihan) {
        this.bulanPenagihan = bulanPenagihan;
    }

    public Integer getTahunPenagihan() {
        return tahunPenagihan;
    }

    public void setTahunPenagihan(Integer tahunPenagihan) {
        this.tahunPenagihan = tahunPenagihan;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PenjaminanIjp that = (PenjaminanIjp) o;

        if (idPenjaminan != null ? !idPenjaminan.equals(that.idPenjaminan) : that.idPenjaminan != null) return false;
        if (penjaminanIjpId != null ? !penjaminanIjpId.equals(that.penjaminanIjpId) : that.penjaminanIjpId != null)
            return false;
        if (statusSikp != null ? !statusSikp.equals(that.statusSikp) : that.statusSikp != null) return false;
        if (tahunKe != null ? !tahunKe.equals(that.tahunKe) : that.tahunKe != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = penjaminanIjpId != null ? penjaminanIjpId.hashCode() : 0;
        result = 31 * result + (idPenjaminan != null ? idPenjaminan.hashCode() : 0);
        result = 31 * result + (tahunKe != null ? tahunKe.hashCode() : 0);
        result = 31 * result + (statusSikp != null ? statusSikp.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PenjaminanIjp{" +
                "penjaminanIjpId=" + penjaminanIjpId +
                ", idPenjaminan=" + idPenjaminan +
                ", tahunKe=" + tahunKe +
                ", tglPremi=" + tglPremi +
                ", premi=" + premi +
                ", cadangan=" + cadangan +
                ", statusSikp=" + statusSikp +
                '}';
    }
}
