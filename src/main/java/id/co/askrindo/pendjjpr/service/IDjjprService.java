package id.co.askrindo.pendjjpr.service;

import id.co.askrindo.pendjjpr.model.djppr.Akad;
import id.co.askrindo.pendjjpr.model.djppr.Calon;
import id.co.askrindo.pendjjpr.model.djppr.Tagihan;

import java.util.Date;
import java.util.List;

/**
 * Created by Anggoro Biandono on 13/11/2020.
 */
public interface IDjjprService {
    public String getToken();
    public void postCalonJpas(Date tglMulai, Date tglAkhir);
    public List<Akad> testAkadJpas(Date tglMulai, Date tglAkhir);
    public List<Calon> testCalonJpas(Date tglMulai, Date tglAkhir);
    public void postAkadJpas(Date tglMulai, Date tglAkhir);
    public List<Tagihan> testTagihanJpas(Date tglMulai, Date tglAkhir, String noTagihan);
    public void postTagihanJpas(Date tglMulai, Date tglAkhir, String noTagihan, Integer bulanPenagihan, Integer tahunPenagihan);
    public void cekTagihanJpasGanda(Date tglMulai, Date tglAkhir, String noTagihan, String keteranganDjjpr);
}
