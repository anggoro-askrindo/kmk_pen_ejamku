package id.co.askrindo.pendjjpr.reporsitory.pen;

import id.co.askrindo.pendjjpr.model.pen.PenjaminanIjp;
import id.co.askrindo.pendjjpr.reporsitory.IGenericRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Created by Anggoro Biandono on 13/11/2020.
 */
@Repository
public interface IPenjaminanIjpRepository extends IGenericRepository<PenjaminanIjp, Long> {
    @Query(value = "SELECT " +
            "    b.* " +
            "FROM " +
            "    t_penjaminan_jpas a inner join t_penjaminan_ijp_jpas b on a.id_penjaminan = b.id_penjaminan " +
            "WHERE " +
            "    a.status_penjaminan_id = 3 AND a.is_cancel = false AND a.status_sikp = :statusSikp AND b.status_sikp = :statusSikpIjp AND b.tgl_premi between :tglMulai AND :tglAkhir", nativeQuery = true)
    List<PenjaminanIjp> getIjpJpasTglPremiRangeAndStatusSikp(@Param("tglMulai") Date tglMulai, @Param("tglAkhir") Date tglAkhir, @Param("statusSikp") Integer statusSikp, @Param("statusSikpIjp") Boolean statusSikpIjp);

    @Query(value = "SELECT " +
            "    c.* " +
            "FROM " +
            "    t_penjaminan_jpas a inner join log_sikp_jpas b on a.id_penjaminan = b.id_penjaminan " +
            "    inner join t_penjaminan_ijp_jpas c on a.id_penjaminan = c.id_penjaminan " +
            "WHERE " +
            "    a.status_penjaminan_id = 3 AND a.is_cancel = false AND b.is_active = true AND c.status_sikp = :statusSikpIjp AND b.tgl_premi between :tglMulai AND :tglAkhir" +
            "    AND b.keterangan = :keteranganDjjpr " +
            "ORDER BY " +
            "    a.id_penjaminan ", nativeQuery = true)
    List<PenjaminanIjp> getIjpJpasByTglPremiRangeAndKeteranganDjjpr(@Param("tglMulai") Date tglMulai, @Param("tglAkhir") Date tglAkhir, @Param("statusSikpIjp") Boolean statusSikpIjp, @Param("keteranganDjjpr") String keteranganDjjpr);
}
