package id.co.askrindo.pendjjpr.service.impl;

import id.co.askrindo.pendjjpr.model.pen.LogSikpJpas;
import id.co.askrindo.pendjjpr.reporsitory.pen.ILogSikpJpasRepository;
import id.co.askrindo.pendjjpr.service.ILogSikpJpasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by Anggoro Biandono on 13/11/2020.
 */
@Service
public class LogSikpJpasServiceImpl extends GenericServiceImpl<LogSikpJpas, Long> implements ILogSikpJpasService {
    private ILogSikpJpasRepository logSikpJpasRepository;

    @Autowired
    public LogSikpJpasServiceImpl(ILogSikpJpasRepository logSikpJpasRepository) {
        super(logSikpJpasRepository);
        this.logSikpJpasRepository = logSikpJpasRepository;
    }

    @Override
    public List<LogSikpJpas> getLogJpasByTglPremiRangeAndKeteranganDjjpr(Date tglMulai, Date tglAkhir, String keteranganDjjpr) {
        return logSikpJpasRepository.getLogJpasByTglPremiRangeAndKeteranganDjjpr(tglMulai, tglAkhir, keteranganDjjpr);
    }
}
