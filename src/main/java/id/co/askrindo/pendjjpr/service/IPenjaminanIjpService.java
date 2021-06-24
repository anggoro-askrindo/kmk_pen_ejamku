package id.co.askrindo.pendjjpr.service;

import id.co.askrindo.pendjjpr.model.pen.PenjaminanIjp;

import java.util.Date;
import java.util.List;

/**
 * Created by Anggoro Biandono on 13/11/2020.
 */
public interface IPenjaminanIjpService extends IGenericService<PenjaminanIjp, Long>{
    List<PenjaminanIjp> getIjpTglPremiRangeAndStatusSikp(Date tglMulai, Date tglAkhir, Integer statusSikp, Boolean statusSikpIjp);
    List<PenjaminanIjp> getIjpJpasByTglPremiRangeAndKeteranganDjjpr(Date tglMulai, Date tglAkhir, Boolean statusSikpIjp, String keteranganDjjpr);
}
