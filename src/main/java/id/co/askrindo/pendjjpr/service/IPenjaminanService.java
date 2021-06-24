package id.co.askrindo.pendjjpr.service;

import id.co.askrindo.pendjjpr.model.pen.Penjaminan;

import java.util.Date;
import java.util.List;

/**
 * Created by Anggoro Biandono on 13/11/2020.
 */
public interface IPenjaminanService extends IGenericService<Penjaminan, Long> {
    List<Penjaminan> getPenjaminanJpasTglPremiRangeAndStatusSikp(Date tglMulai, Date tglAkhir, Integer statusSikp, Boolean statusSikpIjp);
    List<Penjaminan> getPenjaminanJpasByTglPremiRangeAndKeteranganDjjpr(Date tglMulai, Date tglAkhir, String keteranganDjjpr);
}
