package id.co.askrindo.pendjjpr.controller.rest;

import id.co.askrindo.pendjjpr.model.djppr.Akad;
import id.co.askrindo.pendjjpr.model.djppr.Calon;
import id.co.askrindo.pendjjpr.model.djppr.Tagihan;
import id.co.askrindo.pendjjpr.service.impl.DjjprServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * Created by Anggoro Biandono on 13/11/2020.
 */
@RestController
@RequestMapping("/api/v1")
public class DjjprRestController {

    @Autowired
    private DjjprServiceImpl djjprService;

    @RequestMapping(value = "/token", method = RequestMethod.GET)
    public String getToken(){
        return djjprService.getToken();
    }

    @RequestMapping(value = "/testAkad", method = RequestMethod.GET)
    public List<Akad> getProsesTestAkad(@RequestParam("tglMulai") @DateTimeFormat(pattern = "dd-MM-yyyy") Date tglMulai,
                                 @RequestParam("tglAkhir") @DateTimeFormat(pattern = "dd-MM-yyyy") Date tglAkhir){
        long timeTx = 0;
        long startTx = System.currentTimeMillis();
        List<Akad> result = djjprService.testAkadJpas(tglMulai, tglAkhir);
        long endTx = System.currentTimeMillis();
        timeTx += endTx - startTx;
        System.out.println("TIME: total " + timeTx );
        return result;
    }

    @RequestMapping(value = "/testCalon", method = RequestMethod.GET)
    public List<Calon> getProsesTestCalon(@RequestParam("tglMulai") @DateTimeFormat(pattern = "dd-MM-yyyy") Date tglMulai,
                                 @RequestParam("tglAkhir") @DateTimeFormat(pattern = "dd-MM-yyyy") Date tglAkhir){
        long timeTx = 0;
        long startTx = System.currentTimeMillis();
        List<Calon> result = djjprService.testCalonJpas(tglMulai, tglAkhir);
        long endTx = System.currentTimeMillis();
        timeTx += endTx - startTx;
        System.out.println("TIME: total " + timeTx );
        return result;
    }

    @RequestMapping(value = "/calon", method = RequestMethod.GET)
    public String getProsesCalon(@RequestParam("tglMulai") @DateTimeFormat(pattern = "dd-MM-yyyy") Date tglMulai,
                                @RequestParam("tglAkhir") @DateTimeFormat(pattern = "dd-MM-yyyy") Date tglAkhir){
        long timeTx = 0;
        long startTx = System.currentTimeMillis();
        djjprService.postCalonJpas(tglMulai, tglAkhir);
        long endTx = System.currentTimeMillis();
        timeTx += endTx - startTx;
        System.out.println("TIME: total " + timeTx );
        return "OK";
    }

    @RequestMapping(value = "/akad", method = RequestMethod.GET)
    public String getProsesAkad(@RequestParam("tglMulai") @DateTimeFormat(pattern = "dd-MM-yyyy") Date tglMulai,
                           @RequestParam("tglAkhir") @DateTimeFormat(pattern = "dd-MM-yyyy") Date tglAkhir){
        long timeTx = 0;
        long startTx = System.currentTimeMillis();
        djjprService.postAkadJpas(tglMulai, tglAkhir);
        long endTx = System.currentTimeMillis();
        timeTx += endTx - startTx;
        System.out.println("TIME: total " + timeTx);
        return "OK";
    }

    @RequestMapping(value = "/testTagihan", method = RequestMethod.GET)
    public List<Tagihan> getProsesTestCalon(@RequestParam("tglMulai") @DateTimeFormat(pattern = "dd-MM-yyyy") Date tglMulai,
                                          @RequestParam("tglAkhir") @DateTimeFormat(pattern = "dd-MM-yyyy") Date tglAkhir,
                                          @RequestParam("noTagihan") String noTagihan){
        long timeTx = 0;
        long startTx = System.currentTimeMillis();
        List<Tagihan> result = djjprService.testTagihanJpas(tglMulai, tglAkhir, noTagihan);
        long endTx = System.currentTimeMillis();
        timeTx += endTx - startTx;
        System.out.println("TIME: total " + timeTx );
        return result;
    }

    @RequestMapping(value = "/tagihan", method = RequestMethod.GET)
    public String getProsesTagihan(@RequestParam("tglMulai") @DateTimeFormat(pattern = "dd-MM-yyyy") Date tglMulai,
                                 @RequestParam("tglAkhir") @DateTimeFormat(pattern = "dd-MM-yyyy") Date tglAkhir,
                                 @RequestParam("noTagihan") String noTagihan, @RequestParam("bulanPenagihan") Integer bulanPenagihan,
                                   @RequestParam("tahunPenagihan") Integer tahunPenagihan){
        long timeTx = 0;
        long startTx = System.currentTimeMillis();
        djjprService.postTagihanJpas(tglMulai, tglAkhir, noTagihan, bulanPenagihan, tahunPenagihan);
        long endTx = System.currentTimeMillis();
        timeTx += endTx - startTx;
        System.out.println("TIME: total " + timeTx );
        return "OK";
    }

    @RequestMapping(value = "/cekTagihanGanda", method = RequestMethod.GET)
    public String cekTagihanGanda(@RequestParam("tglMulai") @DateTimeFormat(pattern = "dd-MM-yyyy") Date tglMulai,
                                   @RequestParam("tglAkhir") @DateTimeFormat(pattern = "dd-MM-yyyy") Date tglAkhir,
                                   @RequestParam("noTagihan") String noTagihan){
        long timeTx = 0;
        long startTx = System.currentTimeMillis();
        djjprService.cekTagihanJpasGanda(tglMulai, tglAkhir, noTagihan, "Duplikasi Data (Tagihan)");
        long endTx = System.currentTimeMillis();
        timeTx += endTx - startTx;
        System.out.println("TIME: total " + timeTx );
        return "OK";
    }

    @RequestMapping(value = "/token", method = RequestMethod.GET)
    public String getAkadByBankAndRek(){
        return djjprService.getToken();
    }
}
