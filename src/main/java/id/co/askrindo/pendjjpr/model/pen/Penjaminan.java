package id.co.askrindo.pendjjpr.model.pen;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Anggoro Biandono on 12/11/2020.
 */
@Entity
@Table(name = "t_penjaminan_jpas")
public class Penjaminan implements Serializable {
    private static final long serialVersionUID = 7878628364174092605L;

//    COLUMN_NAME                                          DATA_TYPE  DATA_LENGTH  DATA_PRECISION  DATA_SCALE  NULLABLE  DATA_DEFAULT
//    ---------------------------------------------------  ---------  -----------  --------------  ----------  --------  ---------------------------------------------------
//    id_penjaminan                                        int8                                                NO        nextval('t_penjaminan_id_penjaminan_seq'::regclass)
    @Id
    @Column(name = "id_penjaminan")
    private Long idPenjaminan;

//    Ngk ada di JPAS
//    @Column(name = "transaction_id_bank")
//    private String transactionIdBank;

//    kode_bank                                            varchar    8                                        NO
    @Column(name = "kode_bank")
    private String kodeBank;

//    kode_cabang_bank                                     varchar    8                                        NO
    @Column(name = "kode_cabang_bank")
    private String kodeCabangBank;

//    nama_cabang_bank                                     varchar    255                                      YES
    @Column(name = "nama_cabang_bank")
    private String namaCabangBank;

//    kode_cabang_askrindo                                 varchar    3                                        NO
    @Column(name = "kode_cabang_askrindo")
    private String kodeCabangAskrindo;

//    no_rekening_pinjaman                                 varchar    50                                       YES
    @Column(name = "no_rekening_pinjaman")
    private String noRekeningPinjaman;

//    no_rek_lama                                          varchar                                             YES
    @Column(name = "no_rek_lama")
    private String noRekLama;

//    no_perjanjian_kredit                                 varchar    50                                       YES
    @Column(name = "no_perjanjian_kredit")
    private String noPerjanjianKredit;

//    tgl_pk                                               date                                                YES
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "tgl_pk")
    private Date tglPk;

//    tgl_awal_pertanggungan                               date                                                YES
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "tgl_awal_pertanggungan")
    private Date tglAwalPertanggungan;

//    tgl_akhir_pertanggungan                              date                                                YES
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "tgl_akhir_pertanggungan")
    private Date tglAkhirPertanggungan;

//    nama_debitur                                         varchar    255                                      NO
    @Column(name = "nama_debitur")
    private String namaDebitur;

//    alamat_debitur                                       varchar    512                                      NO
    @Column(name = "alamat_debitur")
    private String alamatDebitur;

//    kode_pos                                             varchar    6                                        YES
    @Column(name = "kode_pos")
    private String kodePos;

//    tempat_lahir                                         varchar    100                                      YES
    @Column(name = "tempat_lahir")
    private String tempatLahir;

//    tgl_lahir                                            date                                                NO
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "tgl_lahir")
    private Date tglLahir;

//    jenis_kelamin                                        numeric                                             YES
    @Column(name = "jenis_kelamin")
    private Integer jenisKelamin;

//    no_hp_debitur                                        varchar    20                                       NO
    @Column(name = "no_hp_debitur")
    private String noHpDebitur;

//    pendidikan                                           numeric                                             YES
    @Column(name = "pendidikan")
    private Integer pendidikan;

//    marital_status                                       numeric                                             YES
    @Column(name = "marital_status")
    private Integer maritalStatus;

//    no_id_debitur                                        varchar    40                                       NO
    @Column(name = "no_id_debitur")
    private String noIdDebitur;

//    npwp                                                 varchar    40                                       NO
    @Column(name = "npwp")
    private String npwp;

//    no_ijin_usaha                                        varchar    100                                      NO
    @Column(name = "no_ijin_usaha")
    private String noIjinUsaha;

//    tgl_mulai_usaha                                      date                                                NO
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "tgl_mulai_usaha")
    private Date tglMulaiUsaha;

//    modal_usaha                                          numeric                                             YES
    @Column(name = "modal_usaha", length = 18, precision = 2)
    private BigDecimal modalUsaha;

//    jumlah_tenaga_kerja                                  numeric                                             YES
    @Column(name = "jumlah_tenaga_kerja")
    private Integer jumlahTenagaKerja;

//    omset_usaha                                          numeric                                             NO
    @Column(name = "omset_usaha", length = 18, precision = 2)
    private BigDecimal omsetUsaha;

//    jenis_pekerjaan                                      numeric                                             NO
    @Column(name = "jenis_pekerjaan")
    private Integer jenisPekerjaan;

//    plafond_kredit                                       numeric                 18              2           NO        0
    @Column(name = "plafond_kredit", length = 18, precision = 2)
    private BigDecimal plafondKredit;

//    bakidebet                                            numeric                 18              2           YES
    @Column(name = "bakidebet", length = 18, precision = 2)
    private BigDecimal bakiDebet;

//    nilai_pertanggungan                                  numeric                 18              2           NO        0
    @Column(name = "nilai_pertanggungan", length = 18, precision = 2)
    private BigDecimal nilaiPertanggungan;

//    sektor_ekonomi                                       varchar    10                                       NO
    @Column(name = "sektor_ekonomi")
    private String sektorEkonomi;

//    coverage                                             numeric                 5               2           NO        0
//    kolektibilitas_kredit                                varchar    20                                       NO
//    loan_type                                            varchar    20                                       YES
//    mekanisme_penyaluran                                 varchar    20                                       YES
//    is_cac                                               bool                                                NO        true
//    sumber                                               int2                                                NO        1
//    no_sertifikat                                        varchar    30                                       YES
    @Column(name = "no_sertifikat")
    private String noSertifikat;

//    tgl_sertifikat                                       date                                                YES
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "tgl_sertifikat")
    private Date tglSertifikat;

//    tgl_rekam_sertifikat                                 date                                                YES
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "tgl_rekam_sertifikat")
    private Date tglRekamSertifikat;

//    rate                                                 numeric                 7               5           YES       0
//    total_ijp                                            numeric                 18              2           YES       0
//    status_penjaminan_id                                 int2                                                NO
//    jenis_pengajuan                                      varchar                                             NO
//    no_sertifikat_sebelumnya                             varchar                                             YES
//    no_pks                                               varchar    100                                      NO
//    keterangan                                           varchar    255                                      YES
//    version                                              int2                                                NO        1
//    created_by                                           varchar    20                                       NO
//    created_date                                         timestamp                                           NO        now()
//    modified_by                                          varchar    20                                       YES
//    modified_date                                        timestamp                                           YES
//    plafon_disetujui                                     numeric                                             YES
//    alasan_penolakan                                     varchar                                             YES
//    no_reg_air                                           varchar                                             YES
//    ket_audit_trail                                      varchar    1000                                     YES
//    exception_flag                                       int2                                                YES
//    status_sikp                                          int2                                                NO        0
    @Column(name = "status_sikp")
    private Integer statusSikp;

//    is_cancel                                            bool                                                YES       false
//    status_update_sikp                                   int2                                                YES       0
//    status_cetak                                         int2                                                NO        0
//    jangka_waktu_hari                                    int2                                                YES
//    id_penjaminan_prev                                   int8                                                YES
//    ket_sikp                                             varchar    1000                                     YES
//    jenis_pembatalan                                     int2                                                YES
//    is_penagihan                                         bool                                                YES       true
//    persetujuan_bank                                     bool                                                NO        false
//    is_proses_approval                                   bool                                                NO        false
//    dokumen_pembatalan                                   text                                                YES
//    tgl_endorse                                          timestamp                                           YES
//    tgl_surat_pembatalan                                 timestamp                                           YES
//    no_surat_pembatalan                                  varchar                                             YES


    public Long getIdPenjaminan() {
        return idPenjaminan;
    }

    public void setIdPenjaminan(Long idPenjaminan) {
        this.idPenjaminan = idPenjaminan;
    }

//    public String getTransactionIdBank() {
//        return transactionIdBank;
//    }
//
//    public void setTransactionIdBank(String transactionIdBank) {
//        this.transactionIdBank = transactionIdBank;
//    }

    public String getKodeBank() {
        return kodeBank;
    }

    public void setKodeBank(String kodeBank) {
        this.kodeBank = kodeBank;
    }

    public String getKodeCabangBank() {
        return kodeCabangBank;
    }

    public void setKodeCabangBank(String kodeCabangBank) {
        this.kodeCabangBank = kodeCabangBank;
    }

    public String getNamaCabangBank() {
        return namaCabangBank;
    }

    public void setNamaCabangBank(String namaCabangBank) {
        this.namaCabangBank = namaCabangBank;
    }

    public String getKodeCabangAskrindo() {
        return kodeCabangAskrindo;
    }

    public void setKodeCabangAskrindo(String kodeCabangAskrindo) {
        this.kodeCabangAskrindo = kodeCabangAskrindo;
    }

    public String getNoRekeningPinjaman() {
        return noRekeningPinjaman;
    }

    public void setNoRekeningPinjaman(String noRekeningPinjaman) {
        this.noRekeningPinjaman = noRekeningPinjaman;
    }

    public String getNoRekLama() {
        return noRekLama;
    }

    public void setNoRekLama(String noRekLama) {
        this.noRekLama = noRekLama;
    }

    public String getNoPerjanjianKredit() {
        return noPerjanjianKredit;
    }

    public void setNoPerjanjianKredit(String noPerjanjianKredit) {
        this.noPerjanjianKredit = noPerjanjianKredit;
    }

    public Date getTglPk() {
        return tglPk;
    }

    public void setTglPk(Date tglPk) {
        this.tglPk = tglPk;
    }

    public Date getTglAwalPertanggungan() {
        return tglAwalPertanggungan;
    }

    public void setTglAwalPertanggungan(Date tglAwalPertanggungan) {
        this.tglAwalPertanggungan = tglAwalPertanggungan;
    }

    public Date getTglAkhirPertanggungan() {
        return tglAkhirPertanggungan;
    }

    public void setTglAkhirPertanggungan(Date tglAkhirPertanggungan) {
        this.tglAkhirPertanggungan = tglAkhirPertanggungan;
    }

    public String getNamaDebitur() {
        return namaDebitur;
    }

    public void setNamaDebitur(String namaDebitur) {
        this.namaDebitur = namaDebitur;
    }

    public String getAlamatDebitur() {
        return alamatDebitur;
    }

    public void setAlamatDebitur(String alamatDebitur) {
        this.alamatDebitur = alamatDebitur;
    }

    public String getKodePos() {
        return kodePos;
    }

    public void setKodePos(String kodePos) {
        this.kodePos = kodePos;
    }

    public String getTempatLahir() {
        return tempatLahir;
    }

    public void setTempatLahir(String tempatLahir) {
        this.tempatLahir = tempatLahir;
    }

    public Date getTglLahir() {
        return tglLahir;
    }

    public void setTglLahir(Date tglLahir) {
        this.tglLahir = tglLahir;
    }

    public Integer getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(Integer jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getNoHpDebitur() {
        return noHpDebitur;
    }

    public void setNoHpDebitur(String noHpDebitur) {
        this.noHpDebitur = noHpDebitur;
    }

    public Integer getPendidikan() {
        return pendidikan;
    }

    public void setPendidikan(Integer pendidikan) {
        this.pendidikan = pendidikan;
    }

    public Integer getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(Integer maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getNoIdDebitur() {
        return noIdDebitur;
    }

    public void setNoIdDebitur(String noIdDebitur) {
        this.noIdDebitur = noIdDebitur;
    }

    public String getNpwp() {
        return npwp;
    }

    public void setNpwp(String npwp) {
        this.npwp = npwp;
    }

    public String getNoIjinUsaha() {
        return noIjinUsaha;
    }

    public void setNoIjinUsaha(String noIjinUsaha) {
        this.noIjinUsaha = noIjinUsaha;
    }

    public Date getTglMulaiUsaha() {
        return tglMulaiUsaha;
    }

    public void setTglMulaiUsaha(Date tglMulaiUsaha) {
        this.tglMulaiUsaha = tglMulaiUsaha;
    }

    public BigDecimal getModalUsaha() {
        return modalUsaha;
    }

    public void setModalUsaha(BigDecimal modalUsaha) {
        this.modalUsaha = modalUsaha;
    }

    public Integer getJumlahTenagaKerja() {
        return jumlahTenagaKerja;
    }

    public void setJumlahTenagaKerja(Integer jumlahTenagaKerja) {
        this.jumlahTenagaKerja = jumlahTenagaKerja;
    }

    public BigDecimal getOmsetUsaha() {
        return omsetUsaha;
    }

    public void setOmsetUsaha(BigDecimal omsetUsaha) {
        this.omsetUsaha = omsetUsaha;
    }

    public Integer getJenisPekerjaan() {
        return jenisPekerjaan;
    }

    public void setJenisPekerjaan(Integer jenisPekerjaan) {
        this.jenisPekerjaan = jenisPekerjaan;
    }

    public BigDecimal getPlafondKredit() {
        return plafondKredit;
    }

    public void setPlafondKredit(BigDecimal plafondKredit) {
        this.plafondKredit = plafondKredit;
    }

    public BigDecimal getBakiDebet() {
        return bakiDebet;
    }

    public void setBakiDebet(BigDecimal bakiDebet) {
        this.bakiDebet = bakiDebet;
    }

    public BigDecimal getNilaiPertanggungan() {
        return nilaiPertanggungan;
    }

    public void setNilaiPertanggungan(BigDecimal nilaiPertanggungan) {
        this.nilaiPertanggungan = nilaiPertanggungan;
    }

    public String getSektorEkonomi() {
        return sektorEkonomi;
    }

    public void setSektorEkonomi(String sektorEkonomi) {
        this.sektorEkonomi = sektorEkonomi;
    }

    public String getNoSertifikat() {
        return noSertifikat;
    }

    public void setNoSertifikat(String noSertifikat) {
        this.noSertifikat = noSertifikat;
    }

    public Date getTglSertifikat() {
        return tglSertifikat;
    }

    public void setTglSertifikat(Date tglSertifikat) {
        this.tglSertifikat = tglSertifikat;
    }

    public Date getTglRekamSertifikat() {
        return tglRekamSertifikat;
    }

    public void setTglRekamSertifikat(Date tglRekamSertifikat) {
        this.tglRekamSertifikat = tglRekamSertifikat;
    }

    public Integer getStatusSikp() {
        return statusSikp;
    }

    public void setStatusSikp(Integer statusSikp) {
        this.statusSikp = statusSikp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Penjaminan that = (Penjaminan) o;

        if (idPenjaminan != null ? !idPenjaminan.equals(that.idPenjaminan) : that.idPenjaminan != null) return false;
        if (kodeBank != null ? !kodeBank.equals(that.kodeBank) : that.kodeBank != null) return false;
        if (kodeCabangAskrindo != null ? !kodeCabangAskrindo.equals(that.kodeCabangAskrindo) : that.kodeCabangAskrindo != null)
            return false;
        if (kodeCabangBank != null ? !kodeCabangBank.equals(that.kodeCabangBank) : that.kodeCabangBank != null)
            return false;
        if (noPerjanjianKredit != null ? !noPerjanjianKredit.equals(that.noPerjanjianKredit) : that.noPerjanjianKredit != null)
            return false;
        if (noRekeningPinjaman != null ? !noRekeningPinjaman.equals(that.noRekeningPinjaman) : that.noRekeningPinjaman != null)
            return false;
        if (noSertifikat != null ? !noSertifikat.equals(that.noSertifikat) : that.noSertifikat != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idPenjaminan != null ? idPenjaminan.hashCode() : 0;
        result = 31 * result + (kodeBank != null ? kodeBank.hashCode() : 0);
        result = 31 * result + (kodeCabangBank != null ? kodeCabangBank.hashCode() : 0);
        result = 31 * result + (kodeCabangAskrindo != null ? kodeCabangAskrindo.hashCode() : 0);
        result = 31 * result + (noRekeningPinjaman != null ? noRekeningPinjaman.hashCode() : 0);
        result = 31 * result + (noPerjanjianKredit != null ? noPerjanjianKredit.hashCode() : 0);
        result = 31 * result + (noSertifikat != null ? noSertifikat.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Penjaminan{" +
                "idPenjaminan=" + idPenjaminan +
                ", kodeBank='" + kodeBank + '\'' +
                ", kodeCabangBank='" + kodeCabangBank + '\'' +
                ", namaCabangBank='" + namaCabangBank + '\'' +
                ", kodeCabangAskrindo='" + kodeCabangAskrindo + '\'' +
                ", noRekeningPinjaman='" + noRekeningPinjaman + '\'' +
                ", noRekLama='" + noRekLama + '\'' +
                ", noPerjanjianKredit='" + noPerjanjianKredit + '\'' +
                '}';
    }
}
