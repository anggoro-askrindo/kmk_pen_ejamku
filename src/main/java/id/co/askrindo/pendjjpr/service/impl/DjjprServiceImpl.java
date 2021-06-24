package id.co.askrindo.pendjjpr.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import id.co.askrindo.pendjjpr.component.RestTemplateResponseErrorHandler;
import id.co.askrindo.pendjjpr.model.djppr.*;
import id.co.askrindo.pendjjpr.model.pen.LogSikpJpas;
import id.co.askrindo.pendjjpr.model.pen.Penjaminan;
import id.co.askrindo.pendjjpr.model.pen.PenjaminanIjp;
import id.co.askrindo.pendjjpr.service.IDjjprService;
import id.co.askrindo.pendjjpr.service.ILogSikpJpasService;
import id.co.askrindo.pendjjpr.service.IPenjaminanIjpService;
import id.co.askrindo.pendjjpr.service.IPenjaminanService;
import id.co.askrindo.pendjjpr.utils.ConverterUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.*;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.*;

/**
 * Created by Anggoro Biandono on 13/11/2020.
 */
@Service
public class DjjprServiceImpl implements IDjjprService {

    @Autowired
    private IPenjaminanService penjaminanService;

    @Autowired
    private IPenjaminanIjpService ijpService;

    @Autowired
    private ILogSikpJpasService logSikpJpasService;

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    static {
        disableSslVerification();
    }

    private static void disableSslVerification() {
        try {
            // Create a trust manager that does not validate certificate chains
            TrustManager[] trustAllCerts = new TrustManager[]{
                new X509TrustManager() {
                    public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                        return null;
                    }

                    public void checkClientTrusted(X509Certificate[] certs, String authType) {
                    }

                    public void checkServerTrusted(X509Certificate[] certs, String authType) {
                    }
                }
            };

            // Install the all-trusting trust manager
            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

            // Create all-trusting host name verifier
            HostnameVerifier allHostsValid = new HostnameVerifier() {
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            };

            // Install the all-trusting host verifier
            HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getToken() {
        // send http post
        RestTemplate restTemplate = restTemplateBuilder
                .errorHandler(new RestTemplateResponseErrorHandler())
                .build();
        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.APPLICATION_JSON);

        //Penambahan karena ada bug forbiden 403 di BNI
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        HttpEntity<String> requestEntity = new HttpEntity<>("{\"username\": \"askrindo\",\"password\": \"bzMjN9Wc8DeATBKh\"}", headers);
//========================== PRODUCTION ===============================
        Response<String> response = restTemplate.postForObject("https://sbn-ritel.kemenkeu.go.id/gateway/test-pen/api/v1/Auth", requestEntity, Response.class);
//========================== DEVELOPMENT ==============================
//        Response<String> response = restTemplate.postForObject("https://sbn-ritel.kemenkeu.go.id/gateway/test-pen/development/api/v1/Auth", requestEntity, Response.class);

        return response.getData();
    }

    @Override
    public void postCalonJpas(Date tglMulai, Date tglAkhir) {
        List<Penjaminan> penjaminanList = penjaminanService.getPenjaminanJpasTglPremiRangeAndStatusSikp(tglMulai, tglAkhir, 0, Boolean.FALSE);
        List<Penjaminan> penjaminanSaveList = new ArrayList<>(200);
        List<LogSikpJpas> logList = new ArrayList<>();

        if(penjaminanList.size() != 0) {
            // send http post
            RestTemplate restTemplate = restTemplateBuilder
                    .errorHandler(new RestTemplateResponseErrorHandler())
                    .build();
            HttpHeaders headers = new HttpHeaders();

            String token = getToken();
            // create auth credentials
            headers.add("Authorization", "Bearer " + token);

            headers.setContentType(MediaType.APPLICATION_JSON);
            //Penambahan karena ada bug forbiden 403 di BNI
            headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");

            Response<Calon> response;
            Calon calon = null;
            LogSikpJpas logSikpJpas;
            int counter = 0;

            for (Penjaminan penjaminan : penjaminanList) {
                try{
                    if (calon == null) calon = new Calon();
                    calon = ConverterUtils.convertToCalon(calon, penjaminan);
                    //========================== PRODUCTION ===============================
                    response = restTemplate.postForObject("https://sbn-ritel.kemenkeu.go.id/gateway/test-pen/api/v1/Calon", new HttpEntity<>(calon, headers), Response.class);
                    //========================== DEVELOPMENT ==============================
//                    response = restTemplate.postForObject("https://sbn-ritel.kemenkeu.go.id/gateway/test-pen/development/api/v1/Calon", new HttpEntity<>(calon, headers), Response.class);
                    if (!response.getError()) {
                        penjaminan.setStatusSikp(1);
                    } else {
                        logSikpJpas = new LogSikpJpas();

                        logSikpJpas.setNoRekening(penjaminan.getNoRekeningPinjaman());
                        logSikpJpas.setNoAplikasi("");
                        logSikpJpas.setNoSertifikat(penjaminan.getNoSertifikat());
                        logSikpJpas.setIdPenjaminan(penjaminan.getIdPenjaminan());
                        logSikpJpas.setIdDebitur(penjaminan.getNoIdDebitur());
                        logSikpJpas.setTglPremi(penjaminan.getTglSertifikat());
                        logSikpJpas.setStatus(Integer.parseInt(response.getCode()));
                        logSikpJpas.setKeterangan(response.getMessage());
                        logSikpJpas.setIsActive(Boolean.TRUE);
                        logSikpJpas.setCreatedBy("ADMIN TAMPAN");

                        logList.add(logSikpJpas);
                    }

                    if(counter%200 == 0 || penjaminanList.size() == counter){
                        penjaminanService.saveAll(penjaminanSaveList);
                        logSikpJpasService.saveAll(logList);
                        System.out.println("[INFO CK] -- NGASO DISEK");
                        penjaminanSaveList.clear();
                        logList.clear();
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }

//            penjaminanService.saveAll(penjaminanList);
//            logSikpJpasService.saveAll(logList);
        }
    }

    @Override
    public List<Akad> testAkadJpas(Date tglMulai, Date tglAkhir) {
        List<Penjaminan> penjaminanList = penjaminanService.getPenjaminanJpasTglPremiRangeAndStatusSikp(tglMulai, tglAkhir, 0, Boolean.FALSE);
        List<Akad> akadList = new ArrayList<>(penjaminanList.size());

        penjaminanList.forEach(penjaminan -> akadList.add(ConverterUtils.convertToAkad(new Akad(), penjaminan)));

        return akadList;
    }

    @Override
    public List<Calon> testCalonJpas(Date tglMulai, Date tglAkhir) {
        List<Penjaminan> penjaminanList = penjaminanService.getPenjaminanJpasTglPremiRangeAndStatusSikp(tglMulai, tglAkhir, 0, Boolean.FALSE);
        List<Calon> calonList = new ArrayList<>(penjaminanList.size());

        penjaminanList.forEach(penjaminan -> calonList.add(ConverterUtils.convertToCalon(new Calon(), penjaminan)));

        return calonList;
    }

    @Override
    public void postAkadJpas(Date tglMulai, Date tglAkhir) {
        List<Penjaminan> penjaminanList = penjaminanService.getPenjaminanJpasTglPremiRangeAndStatusSikp(tglMulai, tglAkhir, 1, Boolean.FALSE);
        List<Penjaminan> penjaminanSaveList = new ArrayList<>(200);
        List<LogSikpJpas> logList = new ArrayList<>();

        //penjaminanList.forEach(penjaminan -> akadList.add(ConverterUtils.convertToAkad(new Akad(), penjaminan)));

        if(penjaminanList.size() != 0) {
            // send http post
            RestTemplate restTemplate = restTemplateBuilder
                    .errorHandler(new RestTemplateResponseErrorHandler())
                    .build();
            HttpHeaders headers = new HttpHeaders();

            String token = getToken();
            // create auth credentials
            headers.add("Authorization", "Bearer " + token);

            headers.setContentType(MediaType.APPLICATION_JSON);
            //Penambahan karena ada bug forbiden 403 di BNI
            headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");

            Response<AkadResponse> response;
            Akad akad = null;
            LogSikpJpas logSikpJpas;
            int counter = 0;

            for (Penjaminan penjaminan : penjaminanList) {
                if (akad == null) akad = new Akad();
                try{
                    akad = ConverterUtils.convertToAkad(akad, penjaminan);
                    //========================== PRODUCTION ===============================
                    response = restTemplate.postForObject("https://sbn-ritel.kemenkeu.go.id/gateway/test-pen/api/v1/Akad", new HttpEntity<>(akad, headers), Response.class);
                    //========================== DEVELOPMENT ==============================
                    //            response = restTemplate.postForObject("https://sbn-ritel.kemenkeu.go.id/gateway/test-pen/development/api/v1/Akad", new HttpEntity<>(akad, headers), Response.class);
                    if (!response.getError()) {
                        penjaminan.setStatusSikp(2);
                        penjaminanSaveList.add(penjaminan);
                    } else {
                        if(response.getCode().equals("19")) {
                            penjaminan.setStatusSikp(2);
                            penjaminanSaveList.add(penjaminan);
                        }else {
                            logSikpJpas = new LogSikpJpas();

                            logSikpJpas.setNoRekening(penjaminan.getNoRekeningPinjaman());
                            logSikpJpas.setNoAplikasi("");
                            logSikpJpas.setNoSertifikat(penjaminan.getNoSertifikat());
                            logSikpJpas.setIdPenjaminan(penjaminan.getIdPenjaminan());
                            logSikpJpas.setIdDebitur(penjaminan.getNoIdDebitur());
                            logSikpJpas.setTglPremi(penjaminan.getTglSertifikat());
                            logSikpJpas.setStatus(Integer.parseInt(response.getCode()));
                            logSikpJpas.setKeterangan(response.getMessage());
                            logSikpJpas.setIsActive(Boolean.TRUE);
                            logSikpJpas.setCreatedBy("ADMIN TAMPAN");

                            logList.add(logSikpJpas);
                        }
                    }

                    counter++;

                    if(counter%200 == 0 || penjaminanList.size() == counter){
                        penjaminanService.saveAll(penjaminanSaveList);
                        logSikpJpasService.saveAll(logList);
                        System.out.println("[INFO CK] -- NGASO DISEK");
                        penjaminanSaveList.clear();
                        logList.clear();
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }

//            penjaminanService.saveAll(penjaminanList);
//            logSikpJpasService.saveAll(logList);
        }
    }

    @Override
    public List<Tagihan> testTagihanJpas(Date tglMulai, Date tglAkhir, String noTagihan) {
        List<Penjaminan> penjaminanList = penjaminanService.getPenjaminanJpasTglPremiRangeAndStatusSikp(tglMulai, tglAkhir, 2, Boolean.FALSE);
        List<PenjaminanIjp> ijpList = ijpService.getIjpTglPremiRangeAndStatusSikp(tglMulai, tglAkhir, 2, Boolean.FALSE);
        Map<Long, PenjaminanIjp> ijpMap = new HashMap<>(ijpList.size());
        ijpList.forEach(ijp -> ijpMap.put(ijp.getIdPenjaminan(), ijp));

        List<Tagihan> tagihanList = new ArrayList<>(penjaminanList.size());

        penjaminanList.forEach(penjaminan -> tagihanList.add(ConverterUtils.convertToTagihan(new Tagihan(), penjaminan, ijpMap.get(penjaminan.getIdPenjaminan()),noTagihan)));

        return tagihanList;
    }

    @Override
    public void postTagihanJpas(Date tglMulai, Date tglAkhir, String noTagihan, Integer bulanPenagihan, Integer tahunPenagihan) {
        List<Penjaminan> penjaminanList = penjaminanService.getPenjaminanJpasTglPremiRangeAndStatusSikp(tglMulai, tglAkhir, 2, Boolean.FALSE);
        List<PenjaminanIjp> ijpList = ijpService.getIjpTglPremiRangeAndStatusSikp(tglMulai, tglAkhir, 2, Boolean.FALSE);
        Map<Long, PenjaminanIjp> ijpMap = new HashMap<>(ijpList.size());
        ijpList.forEach(ijp -> ijpMap.put(ijp.getIdPenjaminan(), ijp));
        List<Penjaminan> penjaminanSaveList = new ArrayList<>(200);
        List<PenjaminanIjp> ijpSaveList = new ArrayList<>(200);
        List<LogSikpJpas> logList = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();

        //penjaminanList.forEach(penjaminan -> akadList.add(ConverterUtils.convertToAkad(new Akad(), penjaminan)));

        if(penjaminanList.size() != 0) {
            // send http post
            RestTemplate restTemplate = restTemplateBuilder
                    .errorHandler(new RestTemplateResponseErrorHandler())
                    .build();
            HttpHeaders headers = new HttpHeaders();

            String token = getToken();
            // create auth credentials
            headers.add("Authorization", "Bearer " + token);

            headers.setContentType(MediaType.APPLICATION_JSON);
            //Penambahan karena ada bug forbiden 403 di BNI
            headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");

            String response;
            Tagihan tagihan = null;
            LogSikpJpas logSikpJpas;
            int counter = 0;

            for (Penjaminan penjaminan : penjaminanList) {
                if (tagihan == null) tagihan = new Tagihan();
                try{
                    tagihan = ConverterUtils.convertToTagihan(tagihan, penjaminan, ijpMap.get(penjaminan.getIdPenjaminan()), noTagihan);
                    //========================== PRODUCTION ===============================
                    response = restTemplate.postForObject("https://sbn-ritel.kemenkeu.go.id/gateway/test-pen/api/v1/Tagihan", new HttpEntity<>(tagihan, headers), String.class);
                    //========================== DEVELOPMENT ==============================
                    //            response = restTemplate.postForObject("https://sbn-ritel.kemenkeu.go.id/gateway/test-pen/development/api/v1/Tagihan", new HttpEntity<>(tagihan, headers), Response.class);

                    Response<TagihanResponse> tagihanResponse = mapper.readValue(response, new TypeReference<Response<TagihanResponse>>() {});

                    if (!tagihanResponse.getError()) {
                        penjaminan.setStatusSikp(3);
                        ijpMap.get(penjaminan.getIdPenjaminan()).setStatusSikp(Boolean.TRUE);
                        ijpMap.get(penjaminan.getIdPenjaminan()).setIdTagihanDjppr(tagihanResponse.getData().getIdTagihan());
                        ijpMap.get(penjaminan.getIdPenjaminan()).setModifiedBy("SYSTEM");
                        ijpMap.get(penjaminan.getIdPenjaminan()).setModifiedDate(new Date());

                        penjaminanSaveList.add(penjaminan);
                        ijpSaveList.add(ijpMap.get(penjaminan.getIdPenjaminan()));
                    } else {
                        logSikpJpas = new LogSikpJpas();

                        logSikpJpas.setNoRekening(penjaminan.getNoRekeningPinjaman());
                        logSikpJpas.setNoAplikasi("");
                        logSikpJpas.setNoSertifikat(penjaminan.getNoSertifikat());
                        logSikpJpas.setIdPenjaminan(penjaminan.getIdPenjaminan());
                        logSikpJpas.setIdDebitur(penjaminan.getNoIdDebitur());
                        logSikpJpas.setTglPremi(penjaminan.getTglSertifikat());
                        if(tagihanResponse.getCode() != null)
                            logSikpJpas.setStatus(Integer.parseInt(tagihanResponse.getCode()));
                        logSikpJpas.setKeterangan(tagihanResponse.getMessage());
                        logSikpJpas.setIsActive(Boolean.TRUE);
                        logSikpJpas.setCreatedBy("ADMIN TAMPAN");

                        logList.add(logSikpJpas);
                    }

                    counter++;

                    if(counter%200 == 0 || penjaminanList.size() == counter){
                        penjaminanService.saveAll(penjaminanSaveList);
                        ijpService.saveAll(ijpSaveList);
                        logSikpJpasService.saveAll(logList);
                        System.out.println("[INFO CK] -- NGASO DISEK");
                        penjaminanSaveList.clear();
                        ijpSaveList.clear();
                        logList.clear();
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void cekTagihanJpasGanda(Date tglMulai, Date tglAkhir, String noTagihan, String keteranganDjjpr) {
        List<Penjaminan> penjaminanList = penjaminanService.getPenjaminanJpasByTglPremiRangeAndKeteranganDjjpr(tglMulai, tglAkhir, keteranganDjjpr);
        List<PenjaminanIjp> ijpList = ijpService.getIjpJpasByTglPremiRangeAndKeteranganDjjpr(tglMulai, tglAkhir, Boolean.FALSE, keteranganDjjpr);
        List<LogSikpJpas> logList = logSikpJpasService.getLogJpasByTglPremiRangeAndKeteranganDjjpr(tglMulai, tglAkhir, keteranganDjjpr);

        Map<Long, PenjaminanIjp> ijpMap = new HashMap<>(ijpList.size());
        Map<Long, LogSikpJpas> logMap = new HashMap<>(logList.size());
        ijpList.forEach(ijp -> ijpMap.put(ijp.getIdPenjaminan(), ijp));
        logList.forEach(log -> logMap.put(log.getIdPenjaminan(), log));

        List<Penjaminan> penjaminanSaveList = new ArrayList<>();
        List<PenjaminanIjp> ijpSaveList = new ArrayList<>();
        List<LogSikpJpas> logSaveList = new ArrayList<>();

        ObjectMapper mapper = new ObjectMapper();

        if(penjaminanList.size() != 0) {
            // send http post
            RestTemplate restTemplate = restTemplateBuilder
                    .errorHandler(new RestTemplateResponseErrorHandler())
                    .build();
            HttpHeaders headers = new HttpHeaders();

            String token = getToken();
            // create auth credentials
            headers.add("Authorization", "Bearer " + token);

            headers.setContentType(MediaType.APPLICATION_JSON);
            //Penambahan karena ada bug forbiden 403 di BNI
            headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
            HttpEntity<String> entity = new HttpEntity<>("body", headers);

            ResponseEntity<String> response;
            Tagihan tagihan = null;
            LogSikpJpas logSikpJpas;
            int counter = 0;

            for (Penjaminan penjaminan : penjaminanList) {
                try{
                    //========================== PRODUCTION ===============================
                    //exchange("/api/url", HttpMethod.POST, httpEntity, MyModel.class)
                    response = restTemplate.exchange("https://sbn-ritel.kemenkeu.go.id/gateway/test-pen/api/v1/Tagihan?kode_bank=" + penjaminan.getKodeBank() + "&nomor_rekening=" + penjaminan.getNoRekeningPinjaman(),
                            HttpMethod.GET, entity, String.class);
                    //========================== DEVELOPMENT ==============================
                    //            response = restTemplate.postForObject("https://sbn-ritel.kemenkeu.go.id/gateway/test-pen/development/api/v1/Tagihan", new HttpEntity<>(tagihan, headers), Response.class);

                    InquiryResponse<TagihanResponse> tagihanResponse = mapper.readValue(response.getBody(), new TypeReference<InquiryResponse<TagihanResponse>>() {});

                    if (!tagihanResponse.getError()) {
                        if(tagihanResponse.getCode().equals("56") && tagihanResponse.getData().length > 0 && tagihanResponse.getData()[0].getNomorTagihan().equals(noTagihan)){
                            penjaminan.setStatusSikp(3);
                            ijpMap.get(penjaminan.getIdPenjaminan()).setStatusSikp(Boolean.TRUE);
                            ijpMap.get(penjaminan.getIdPenjaminan()).setIdTagihanDjppr(tagihanResponse.getData()[0].getIdTagihan());
                            ijpMap.get(penjaminan.getIdPenjaminan()).setModifiedBy("SYSTEM");
                            ijpMap.get(penjaminan.getIdPenjaminan()).setModifiedDate(new Date());
                            logMap.get(penjaminan.getIdPenjaminan()).setIsActive(Boolean.FALSE);

                            penjaminanSaveList.add(penjaminan);
                            ijpSaveList.add(ijpMap.get(penjaminan.getIdPenjaminan()));
                            logSaveList.add(logMap.get(penjaminan.getIdPenjaminan()));
                        }
                    }

                    counter++;

                    if(counter%200 == 0 || penjaminanList.size() == counter){
                        penjaminanService.saveAll(penjaminanSaveList);
                        ijpService.saveAll(ijpSaveList);
                        logSikpJpasService.saveAll(logSaveList);
                        System.out.println("[INFO CK] -- NGASO DISEK");
                        penjaminanSaveList.clear();
                        ijpSaveList.clear();
                        logSaveList.clear();
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
}
