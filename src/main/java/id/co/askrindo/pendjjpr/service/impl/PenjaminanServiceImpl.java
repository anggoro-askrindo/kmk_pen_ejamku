package id.co.askrindo.pendjjpr.service.impl;

import id.co.askrindo.pendjjpr.model.pen.Penjaminan;
import id.co.askrindo.pendjjpr.reporsitory.pen.IPenjaminanRepository;
import id.co.askrindo.pendjjpr.service.IPenjaminanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by Anggoro Biandono on 13/11/2020.
 */
@Service
public class PenjaminanServiceImpl extends GenericServiceImpl<Penjaminan, Long> implements IPenjaminanService {
    private IPenjaminanRepository penjaminanRepository;

    @Autowired
    public PenjaminanServiceImpl(IPenjaminanRepository penjaminanRepository) {
        super(penjaminanRepository);
        this.penjaminanRepository = penjaminanRepository;
    }

    @Override
    public List<Penjaminan> getPenjaminanJpasTglPremiRangeAndStatusSikp(Date tglMulai, Date tglAkhir, Integer statusSikp, Boolean statusSikpIjp) {
        return penjaminanRepository.getPenjaminanJpasTglPremiRangeAndStatusSikp(tglMulai, tglAkhir, statusSikp, statusSikpIjp);
    }

    @Override
    public List<Penjaminan> getPenjaminanJpasByTglPremiRangeAndKeteranganDjjpr(Date tglMulai, Date tglAkhir, String keteranganDjjpr) {
        return penjaminanRepository.getPenjaminanJpasByTglPremiRangeAndKeteranganDjjpr(tglMulai, tglAkhir, keteranganDjjpr);
    }
}
