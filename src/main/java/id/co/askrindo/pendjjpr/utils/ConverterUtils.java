package id.co.askrindo.pendjjpr.utils;

import id.co.askrindo.pendjjpr.model.djppr.Akad;
import id.co.askrindo.pendjjpr.model.djppr.Calon;
import id.co.askrindo.pendjjpr.model.djppr.Tagihan;
import id.co.askrindo.pendjjpr.model.pen.Penjaminan;
import id.co.askrindo.pendjjpr.model.pen.PenjaminanIjp;

/**
 * Created by Anggoro Biandono on 13/11/2020.
 */
public class ConverterUtils {
    private ConverterUtils() {
    }
    public static Calon convertToCalon(Calon calon, Penjaminan penjaminan){
//        "nik": "string",
        calon.setNik(penjaminan.getNoIdDebitur());

//        "nama": "string",
        calon.setNama(penjaminan.getNamaDebitur());

//        "tgl_lahir": "2020-11-13T12:07:14.918Z",
        calon.setTgl_lahir(penjaminan.getTglLahir());

//        "jns_kelamin": 0,
        calon.setJnsKelamin(penjaminan.getJenisKelamin());

//        "maritas_sts": 0,
        calon.setMaritasSts(penjaminan.getMaritalStatus());

//        "pendidikan": 0,
        calon.setPendidikan(penjaminan.getPendidikan());

//        "pekerjaan": 0,
        calon.setPekerjaan(penjaminan.getJenisPekerjaan());

//        "jns_debitur": "string",
        calon.setJnsDebitur("R");

//        "alamat": "string",
        calon.setAlamat(penjaminan.getAlamatDebitur());

//        "kode_kabkota": "string",
        if(penjaminan.getNoIdDebitur().length() >= 4)
            calon.setKodeKabkota(penjaminan.getNoIdDebitur().substring(0, 4));
        else
            calon.setKodeKabkota("");

//        "kode_pos": "string",
        calon.setKodePos(penjaminan.getKodePos());

//        "npwp": "string",
        if(penjaminan.getNpwp().replace(".", "").replace("-", "").length() == 15)
            calon.setNpwp(penjaminan.getNpwp().replace(".", "").replace("-", ""));
        else
            calon.setNpwp("");

//        "mulai_usaha": "2020-11-13T12:07:14.918Z",
        calon.setMulaiUsaha(penjaminan.getTglMulaiUsaha());

//        "alamat_usaha": "string",
        calon.setAlamatUsaha("");

//        "ijin_usaha": "string",
        calon.setIjinUsaha(penjaminan.getNoIjinUsaha());

//        "modal_usaha": 0,
        calon.setModalUsaha(penjaminan.getModalUsaha());

//        "jml_pekerja": 0,
        calon.setJmlPekerja(penjaminan.getJumlahTenagaKerja());

//        "no_hp": "string",
        calon.setNoHp(penjaminan.getNoHpDebitur());

//        "uraian_agunan": "string"
        calon.setUraianAgunan("");

        return  calon;
    }

    public static Akad convertToAkad(Akad akad, Penjaminan penjaminan){
//        {
//        "rekening_baru": "string",
        akad.setRekeningBaru(penjaminan.getNoRekeningPinjaman());
//        "kode_bank": "string",
        akad.setKodeBank(penjaminan.getKodeBank());
//        "nik": "string",
        akad.setNik(penjaminan.getNoIdDebitur());
//        "rekening_lama": "string",
        akad.setRekeningLama(penjaminan.getNoRekLama());
//        "status_akad": "string",
        akad.setStatusAkad("B");
//        "status_rekening": 0,
        akad.setStatusRekening(1);
//        "nomor_akad": "string",
        akad.setNomorAkad(penjaminan.getNoPerjanjianKredit());
//        "tgl_akad": "2020-11-12T03:05:12.752Z",
        akad.setTglAkad(penjaminan.getTglPk());
//        "tgl_penarikan": "2020-11-12T03:05:12.752Z",
        akad.setTglPenarikan(penjaminan.getTglAwalPertanggungan());
//        "tgl_jatuh_tempo": "2020-11-12T03:05:12.752Z",
        akad.setTglJatuhTempo(penjaminan.getTglAkhirPertanggungan());
//        "nilai_akad": 0,
        akad.setNilaiAkad(penjaminan.getPlafondKredit());
//        "tgl_penjaminan": "2020-11-12T03:05:12.752Z",
        akad.setTglPenjaminan(penjaminan.getTglSertifikat());
//        "nomor_penjaminan": "string",
        akad.setNomorPenjaminan(penjaminan.getNoSertifikat());
//        "nilai_dijamin": 0,
        akad.setNilaiDijamin(penjaminan.getNilaiPertanggungan());
//        "sektor": "string"
        akad.setSektor(penjaminan.getSektorEkonomi());
//    }
        return akad;
    }

    public static Tagihan convertToTagihan(Tagihan tagihan, Penjaminan penjaminan, PenjaminanIjp ijp, String noTagihan){
//        "nomor_tagihan": "string",
        tagihan.setNomorTagihan(noTagihan);

//        "nomor_rekening": "string",
        tagihan.setNomorRekening(penjaminan.getNoRekeningPinjaman());

//        "kode_bank": "string",
        tagihan.setKodeBank(penjaminan.getKodeBank());

//        "outstanding": 0,
        tagihan.setOutstanding(ijp.getPremi());

//        "tahun": 0, MASIH DI HARD CODE HARUSNYA AMBIL DARI TAHUN TGL PREMI
        tagihan.setTahun(2020);

//        "nilai_ijp": 0,
        tagihan.setNilaiIjp(ijp.getPremi());

//        "periode": 0
        tagihan.setPeriode(ijp.getTahunKe());

        return tagihan;
    }
}
