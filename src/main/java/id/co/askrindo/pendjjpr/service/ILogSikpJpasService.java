package id.co.askrindo.pendjjpr.service;

import id.co.askrindo.pendjjpr.model.pen.LogSikpJpas;

import java.util.Date;
import java.util.List;

/**
 * Created by Anggoro Biandono on 13/11/2020.
 */
public interface ILogSikpJpasService extends IGenericService<LogSikpJpas, Long> {
    List<LogSikpJpas> getLogJpasByTglPremiRangeAndKeteranganDjjpr(Date tglMulai, Date tglAkhir, String keteranganDjjpr);
}
