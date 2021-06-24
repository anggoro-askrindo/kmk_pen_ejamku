package id.co.askrindo.pendjjpr.service.impl;

import id.co.askrindo.pendjjpr.model.pen.PenjaminanIjp;
import id.co.askrindo.pendjjpr.reporsitory.pen.IPenjaminanIjpRepository;
import id.co.askrindo.pendjjpr.service.IPenjaminanIjpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by Anggoro Biandono on 13/11/2020.
 */
@Service
public class PenjaminanIjpServiceImpl extends GenericServiceImpl<PenjaminanIjp, Long> implements IPenjaminanIjpService {
    private IPenjaminanIjpRepository penjaminanIjpRepository;

    @Autowired
    public PenjaminanIjpServiceImpl(IPenjaminanIjpRepository penjaminanIjpRepository) {
        super(penjaminanIjpRepository);
        this.penjaminanIjpRepository = penjaminanIjpRepository;
    }

    @Override
    public List<PenjaminanIjp> getIjpTglPremiRangeAndStatusSikp(Date tglMulai, Date tglAkhir, Integer statusSikp, Boolean statusSikpIjp) {
        return penjaminanIjpRepository.getIjpJpasTglPremiRangeAndStatusSikp(tglMulai, tglAkhir, statusSikp, statusSikpIjp);
    }

    @Override
    public List<PenjaminanIjp> getIjpJpasByTglPremiRangeAndKeteranganDjjpr(Date tglMulai, Date tglAkhir, Boolean statusSikpIjp, String keteranganDjjpr) {
        return penjaminanIjpRepository.getIjpJpasByTglPremiRangeAndKeteranganDjjpr(tglMulai, tglAkhir, statusSikpIjp, keteranganDjjpr);
    }
}
