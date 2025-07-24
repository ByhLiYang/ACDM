package com.hq.acdm.service.statistics.bridgeRate.impl;

import com.hq.acdm.dao.statistics.BridgeRateMapper;
import com.hq.acdm.model.statistics.bridgeRate.BridgeRateT1;
import com.hq.acdm.model.statistics.bridgeRate.BridgeRateT2;
import com.hq.acdm.model.statistics.bridgeRate.T1;
import com.hq.acdm.model.statistics.bridgeRate.T2;
import com.hq.acdm.service.statistics.bridgeRate.BridgeRateService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author wangshuhao
 * @date 2018/9/25 0025 15:01
 */
@Service("BridgeRateService")
public class BridgeRateServiceImpl implements BridgeRateService {
    @Resource
    private BridgeRateMapper bridgeRateMapper;



    @Override
    public List<T1> queryT1() {
        java.text.DecimalFormat df = new java.text.DecimalFormat("#.##");
        List<BridgeRateT1> bridgeRateT1Inits = bridgeRateMapper.queryT1Init();
        List<BridgeRateT1> bridgeRateT1OverAs = bridgeRateMapper.queryT1OverA();
        List<BridgeRateT1> bridgeRateT1OverDs = bridgeRateMapper.queryT1OverD();
        T1 bridgeRateT1sf = new T1();
        T1 bridgeRateT1sfgz = new T1();
        List<T1> list = new ArrayList<>();
        int muk=0;
        int mus=0;
        int fmk=0;
        int fms=0;
        int cak=0;
        int cas=0;
        int nxk=0;
        int nxs=0;
        int kak=0;
        int kas=0;
        int nhk=0;
        int nhs=0;
        int jlk=0;
        int jls=0;
        int cik=0;
        int cis=0;
        int hxk=0;
        int hxs=0;
        int brk=0;
        int brs=0;
        int oek=0;
        int oes=0;
        int kek=0;
        int kes=0;
        String murate = "";
        String fmrate = "";
        String carate = "";
        String nxrate = "";
        String karate = "";
        String nhrate = "";
        String jlrate = "";
        String cirate = "";
        String hxrate = "";
        String brrate = "";
        String oerate = "";
        String kerate = "";
        for(int i=0;i<bridgeRateT1OverAs.size();i++){
            if("MU".equals(bridgeRateT1OverAs.get(i).getAIRLINE_CODE_IATA())){
                muk = muk + bridgeRateT1OverAs.get(i).getK();
                mus = mus + bridgeRateT1OverAs.get(i).getS();
            }else if("FM".equals(bridgeRateT1OverAs.get(i).getAIRLINE_CODE_IATA())){
                fmk = fmk + bridgeRateT1OverAs.get(i).getK();
                fms = fms + bridgeRateT1OverAs.get(i).getS();
            }else if("CA".equals(bridgeRateT1OverAs.get(i).getAIRLINE_CODE_IATA())){
                cak = cak + bridgeRateT1OverAs.get(i).getK();
                cas = cas + bridgeRateT1OverAs.get(i).getS();
            }else if("NX".equals(bridgeRateT1OverAs.get(i).getAIRLINE_CODE_IATA())){
                nxk = nxk + bridgeRateT1OverAs.get(i).getK();
                nxs = nxs + bridgeRateT1OverAs.get(i).getS();
            }else if("KA".equals(bridgeRateT1OverAs.get(i).getAIRLINE_CODE_IATA())){
                kak = kak + bridgeRateT1OverAs.get(i).getK();
                kas = kas + bridgeRateT1OverAs.get(i).getS();
            }else if("NH".equals(bridgeRateT1OverAs.get(i).getAIRLINE_CODE_IATA())){
                nhk = nhk + bridgeRateT1OverAs.get(i).getK();
                nhs = nhs + bridgeRateT1OverAs.get(i).getS();
            }else if("JL".equals(bridgeRateT1OverAs.get(i).getAIRLINE_CODE_IATA())){
                jlk = jlk + bridgeRateT1OverAs.get(i).getK();
                jls = jls + bridgeRateT1OverAs.get(i).getS();
            }else if("CI".equals(bridgeRateT1OverAs.get(i).getAIRLINE_CODE_IATA())){
                cik = cik + bridgeRateT1OverAs.get(i).getK();
                cis = cis + bridgeRateT1OverAs.get(i).getS();
            }else if("HX".equals(bridgeRateT1OverAs.get(i).getAIRLINE_CODE_IATA())){
                hxk = hxk + bridgeRateT1OverAs.get(i).getK();
                hxs = hxs + bridgeRateT1OverAs.get(i).getS();
            }else if("BR".equals(bridgeRateT1OverAs.get(i).getAIRLINE_CODE_IATA())){
                brk = brk + bridgeRateT1OverAs.get(i).getK();
                brs = brs + bridgeRateT1OverAs.get(i).getS();
            }else if("OE".equals(bridgeRateT1OverAs.get(i).getAIRLINE_CODE_IATA())){
                oek = oek + bridgeRateT1OverAs.get(i).getK();
                oes = oes + bridgeRateT1OverAs.get(i).getS();
            }else if("KE".equals(bridgeRateT1OverAs.get(i).getAIRLINE_CODE_IATA())){
                kek = kek + bridgeRateT1OverAs.get(i).getK();
                kes = kes + bridgeRateT1OverAs.get(i).getS();
            }
        }
        for(int i=0;i<bridgeRateT1OverDs.size();i++){
            if("MU".equals(bridgeRateT1OverDs.get(i).getAIRLINE_CODE_IATA())){
                muk = muk + bridgeRateT1OverDs.get(i).getK();
                mus = mus + bridgeRateT1OverDs.get(i).getS();
            }else if("FM".equals(bridgeRateT1OverDs.get(i).getAIRLINE_CODE_IATA())){
                fmk = fmk + bridgeRateT1OverDs.get(i).getK();
                fms = fms + bridgeRateT1OverDs.get(i).getS();
            }else if("CA".equals(bridgeRateT1OverDs.get(i).getAIRLINE_CODE_IATA())){
                cak = cak + bridgeRateT1OverDs.get(i).getK();
                cas = cas + bridgeRateT1OverDs.get(i).getS();
            }else if("NX".equals(bridgeRateT1OverDs.get(i).getAIRLINE_CODE_IATA())){
                nxk = nxk + bridgeRateT1OverDs.get(i).getK();
                nxs = nxs + bridgeRateT1OverDs.get(i).getS();
            }else if("KA".equals(bridgeRateT1OverDs.get(i).getAIRLINE_CODE_IATA())){
                kak = kak + bridgeRateT1OverDs.get(i).getK();
                kas = kas + bridgeRateT1OverDs.get(i).getS();
            }else if("NH".equals(bridgeRateT1OverDs.get(i).getAIRLINE_CODE_IATA())){
                nhk = nhk + bridgeRateT1OverDs.get(i).getK();
                nhs = nhs + bridgeRateT1OverDs.get(i).getS();
            }else if("JL".equals(bridgeRateT1OverDs.get(i).getAIRLINE_CODE_IATA())){
                jlk = jlk + bridgeRateT1OverDs.get(i).getK();
                jls = jls + bridgeRateT1OverDs.get(i).getS();
            }else if("CI".equals(bridgeRateT1OverDs.get(i).getAIRLINE_CODE_IATA())){
                cik = cik + bridgeRateT1OverDs.get(i).getK();
                cis = cis + bridgeRateT1OverDs.get(i).getS();
            }else if("HX".equals(bridgeRateT1OverDs.get(i).getAIRLINE_CODE_IATA())){
                hxk = hxk + bridgeRateT1OverDs.get(i).getK();
                hxs = hxs + bridgeRateT1OverDs.get(i).getS();
            }else if("BR".equals(bridgeRateT1OverDs.get(i).getAIRLINE_CODE_IATA())){
                brk = brk + bridgeRateT1OverDs.get(i).getK();
                brs = brs + bridgeRateT1OverDs.get(i).getS();
            }else if("OE".equals(bridgeRateT1OverDs.get(i).getAIRLINE_CODE_IATA())){
                oek = oek + bridgeRateT1OverDs.get(i).getK();
                oes = oes + bridgeRateT1OverDs.get(i).getS();
            }else if("KE".equals(bridgeRateT1OverDs.get(i).getAIRLINE_CODE_IATA())){
                kek = kek + bridgeRateT1OverDs.get(i).getK();
                kes = kes + bridgeRateT1OverDs.get(i).getS();
            }
        }
        if(muk ==0){
            murate = "0%";
        }else{
            murate = df.format(mus*100.0/muk)+"%";
        }
        if(fmk ==0){
            fmrate = "0%";
        }else{
            fmrate = df.format(fms*100.0/fmk)+"%";
        }
        if(cak ==0){
            carate = "0%";
        }else{
            carate = df.format(cas*100.0/cak)+"%";
        }
        if(nxk ==0){
            nxrate = "0%";
        }else{
            nxrate = df.format(nxs*100.0/nxk)+"%";
        }
        if(kak ==0){
            karate = "0%";
        }else{
            karate = df.format(kas*100.0/kak)+"%";
        }
        if(nhk ==0){
            nhrate = "0%";
        }else{
            nhrate = df.format(nhs*100.0/nhk)+"%";
        }
        if(jlk ==0){
            jlrate = "0%";
        }else{
            jlrate = df.format(jls*100.0/jlk)+"%";
        }
        if(cik ==0){
            cirate = "0%";
        }else{
            cirate = df.format(cis*100.0/cik)+"%";
        }
        if(hxk ==0){
            hxrate = "0%";
        }else{
            hxrate = df.format(hxs*100.0/hxk)+"%";
        }
        if(brk ==0){
            brrate = "0%";
        }else{
            brrate = df.format(brs*100.0/brk)+"%";
        }
        if(oek ==0){
            oerate = "0%";
        }else{
            oerate = df.format(oes*100.0/oek)+"%";
        }
        if(kek ==0){
            kerate = "0%";
        }else{
            kerate = df.format(kes*100.0/kek)+"%";
        }

        bridgeRateT1sf.setBrk(brk);
        bridgeRateT1sf.setBrs(brs);
        bridgeRateT1sf.setBrrate(brrate);
        bridgeRateT1sf.setCak(cak);
        bridgeRateT1sf.setCas(cas);
        bridgeRateT1sf.setCarate(carate);
        bridgeRateT1sf.setCik(cik);
        bridgeRateT1sf.setCis(cis);
        bridgeRateT1sf.setCirate(cirate);
        bridgeRateT1sf.setMuk(muk);
        bridgeRateT1sf.setMus(mus);
        bridgeRateT1sf.setMurate(murate);
        bridgeRateT1sf.setFmk(fmk);
        bridgeRateT1sf.setFms(fms);
        bridgeRateT1sf.setFmrate(fmrate);
        bridgeRateT1sf.setNhk(nhk);
        bridgeRateT1sf.setNhs(nhs);
        bridgeRateT1sf.setNhrate(nhrate);
        bridgeRateT1sf.setKak(kak);
        bridgeRateT1sf.setKas(kas);
        bridgeRateT1sf.setKarate(karate);
        bridgeRateT1sf.setNxk(nxk);
        bridgeRateT1sf.setNxs(nxs);
        bridgeRateT1sf.setNxrate(nxrate);
        bridgeRateT1sf.setJlk(jlk);
        bridgeRateT1sf.setJls(jls);
        bridgeRateT1sf.setJlrate(jlrate);
        bridgeRateT1sf.setHxk(hxk);
        bridgeRateT1sf.setHxs(hxs);
        bridgeRateT1sf.setHxrate(hxrate);
        bridgeRateT1sf.setOek(oek);
        bridgeRateT1sf.setOerate(oerate);
        bridgeRateT1sf.setOes(oes);
        bridgeRateT1sf.setKek(kek);
        bridgeRateT1sf.setKes(kes);
        bridgeRateT1sf.setKerate(kerate);
        bridgeRateT1sf.setData_type("T1过站");
        list.add(bridgeRateT1sf);
        for(int i=0;i<bridgeRateT1Inits.size();i++){
            if("MU".equals(bridgeRateT1Inits.get(i).getAIRLINE_CODE_IATA())){
                muk = muk + bridgeRateT1Inits.get(i).getK();
                mus = mus + bridgeRateT1Inits.get(i).getS();
            }else if("FM".equals(bridgeRateT1Inits.get(i).getAIRLINE_CODE_IATA())){
                fmk = fmk + bridgeRateT1Inits.get(i).getK();
                fms = fms + bridgeRateT1Inits.get(i).getS();
            }else if("CA".equals(bridgeRateT1Inits.get(i).getAIRLINE_CODE_IATA())){
                cak = cak + bridgeRateT1Inits.get(i).getK();
                cas = cas + bridgeRateT1Inits.get(i).getS();
            }else if("NX".equals(bridgeRateT1Inits.get(i).getAIRLINE_CODE_IATA())){
                nxk = nxk + bridgeRateT1Inits.get(i).getK();
                nxs = nxs + bridgeRateT1Inits.get(i).getS();
            }else if("KA".equals(bridgeRateT1Inits.get(i).getAIRLINE_CODE_IATA())){
                kak = kak + bridgeRateT1Inits.get(i).getK();
                kas = kas + bridgeRateT1Inits.get(i).getS();
            }else if("NH".equals(bridgeRateT1Inits.get(i).getAIRLINE_CODE_IATA())){
                nhk = nhk + bridgeRateT1Inits.get(i).getK();
                nhs = nhs + bridgeRateT1Inits.get(i).getS();
            }else if("JL".equals(bridgeRateT1Inits.get(i).getAIRLINE_CODE_IATA())){
                jlk = jlk + bridgeRateT1Inits.get(i).getK();
                jls = jls + bridgeRateT1Inits.get(i).getS();
            }else if("CI".equals(bridgeRateT1Inits.get(i).getAIRLINE_CODE_IATA())){
                cik = cik + bridgeRateT1Inits.get(i).getK();
                cis = cis + bridgeRateT1Inits.get(i).getS();
            }else if("HX".equals(bridgeRateT1Inits.get(i).getAIRLINE_CODE_IATA())){
                hxk = hxk + bridgeRateT1Inits.get(i).getK();
                hxs = hxs + bridgeRateT1Inits.get(i).getS();
            }else if("BR".equals(bridgeRateT1Inits.get(i).getAIRLINE_CODE_IATA())){
                brk = brk + bridgeRateT1Inits.get(i).getK();
                brs = brs + bridgeRateT1Inits.get(i).getS();
            }else if("OE".equals(bridgeRateT1Inits.get(i).getAIRLINE_CODE_IATA())){
                oek = oek + bridgeRateT1Inits.get(i).getK();
                oes = oes + bridgeRateT1Inits.get(i).getS();
            }else if("KE".equals(bridgeRateT1Inits.get(i).getAIRLINE_CODE_IATA())){
                kek = kek + bridgeRateT1Inits.get(i).getK();
                kes = kes + bridgeRateT1Inits.get(i).getS();
            }
        }
        if(muk ==0){
            murate = "0%";
        }else{
            murate = df.format(mus*100.0/muk)+"%";
        }
        if(fmk ==0){
            fmrate = "0%";
        }else{
            fmrate = df.format(fms*100.0/fmk)+"%";
        }
        if(cak ==0){
            carate = "0%";
        }else{
            carate = df.format(cas*100.0/cak)+"%";
        }
        if(nxk ==0){
            nxrate = "0%";
        }else{
            nxrate = df.format(nxs*100.0/nxk)+"%";
        }
        if(kak ==0){
            karate = "0%";
        }else{
            karate = df.format(kas*100.0/kak)+"%";
        }
        if(nhk ==0){
            nhrate = "0%";
        }else{
            nhrate = df.format(nhs*100.0/nhk)+"%";
        }
        if(jlk ==0){
            jlrate = "0%";
        }else{
            jlrate = df.format(jls*100.0/jlk)+"%";
        }
        if(cik ==0){
            cirate = "0%";
        }else{
            cirate = df.format(cis*100.0/cik)+"%";
        }
        if(hxk ==0){
            hxrate = "0%";
        }else{
            hxrate = df.format(hxs*100.0/hxk)+"%";
        }
        if(brk ==0){
            brrate = "0%";
        }else{
            brrate = df.format(brs*100.0/brk)+"%";
        }
        if(oek ==0){
            oerate = "0%";
        }else{
            oerate = df.format(oes*100.0/oek)+"%";
        }
        if(kek ==0){
            kerate = "0%";
        }else{
            kerate = df.format(kes*100.0/kek)+"%";
        }
        bridgeRateT1sfgz.setBrk(brk);
        bridgeRateT1sfgz.setBrs(brs);
        bridgeRateT1sfgz.setBrrate(brrate);
        bridgeRateT1sfgz.setCak(cak);
        bridgeRateT1sfgz.setCas(cas);
        bridgeRateT1sfgz.setCarate(carate);
        bridgeRateT1sfgz.setCik(cik);
        bridgeRateT1sfgz.setCis(cis);
        bridgeRateT1sfgz.setCirate(cirate);
        bridgeRateT1sfgz.setMuk(muk);
        bridgeRateT1sfgz.setMus(mus);
        bridgeRateT1sfgz.setMurate(murate);
        bridgeRateT1sfgz.setFmk(fmk);
        bridgeRateT1sfgz.setFms(fms);
        bridgeRateT1sfgz.setFmrate(fmrate);
        bridgeRateT1sfgz.setNhk(nhk);
        bridgeRateT1sfgz.setNhs(nhs);
        bridgeRateT1sfgz.setNhrate(nhrate);
        bridgeRateT1sfgz.setKak(kak);
        bridgeRateT1sfgz.setKas(kas);
        bridgeRateT1sfgz.setKarate(karate);
        bridgeRateT1sfgz.setNxk(nxk);
        bridgeRateT1sfgz.setNxs(nxs);
        bridgeRateT1sfgz.setNxrate(nxrate);
        bridgeRateT1sfgz.setJlk(jlk);
        bridgeRateT1sfgz.setJls(jls);
        bridgeRateT1sfgz.setJlrate(jlrate);
        bridgeRateT1sfgz.setHxk(hxk);
        bridgeRateT1sfgz.setHxs(hxs);
        bridgeRateT1sfgz.setHxrate(hxrate);
        bridgeRateT1sfgz.setOek(oek);
        bridgeRateT1sfgz.setOerate(oerate);
        bridgeRateT1sfgz.setOes(oes);
        bridgeRateT1sfgz.setKek(kek);
        bridgeRateT1sfgz.setKes(kes);
        bridgeRateT1sfgz.setKerate(kerate);
        bridgeRateT1sfgz.setData_type("T1过站与始发");
        list.add(bridgeRateT1sfgz);
        return list;
    }

    @Override
    public List<T2> queryT2() {

        java.text.DecimalFormat df = new java.text.DecimalFormat("#.##");
        List<BridgeRateT2> bridgeRateT2Inits = bridgeRateMapper.queryT2Init();
        List<BridgeRateT2> bridgeRateT2OverAs = bridgeRateMapper.queryT2OverA();
        List<BridgeRateT2> bridgeRateT2OverDs = bridgeRateMapper.queryT2OverD();
        T2 bridgeRateT2sf = new T2();
        T2 bridgeRateT2sfgz = new T2();
        List<T2> modifyList = new ArrayList();
        int ek = 0;
        int es = 0;
        int eds = 0;
        int shk =0;
        int shs = 0;
        int shds = 0;
        int lk = 0;
        int ls =0;
        int lds =0;
        int ck =0;
        int cs = 0;
        int cds = 0;
        int sk = 0;
        int ss =0;
        int sds =0;
        int dfk = 0;
        int dfs =0;
        int dfds = 0;
        String erate = "";
        String lrate = "";
        String shrate = "";
        String crate = "";
        String srate = "";
        String dfrate = "";

        for(int i=0;i<bridgeRateT2OverAs.size();i++){
            if("FM".equals(bridgeRateT2OverAs.get(i).getAIRLINE_CODE_IATA())){
                shk = shk + bridgeRateT2OverAs.get(i).getK();
                shs = shs + bridgeRateT2OverAs.get(i).getS();
                shds = shds +bridgeRateT2OverAs.get(i).getDS();
            }else if("HO".equals(bridgeRateT2OverAs.get(i).getAIRLINE_CODE_IATA())){
                lk = lk + bridgeRateT2OverAs.get(i).getK();
                ls = ls + bridgeRateT2OverAs.get(i).getS();
                lds = lds +bridgeRateT2OverAs.get(i).getDS();
            }else if("CZ".equals(bridgeRateT2OverAs.get(i).getAIRLINE_CODE_IATA())){
                sk = sk + bridgeRateT2OverAs.get(i).getK();
                ss = ss + bridgeRateT2OverAs.get(i).getS();
                sds = sds +bridgeRateT2OverAs.get(i).getDS();
            }else if("CA".equals(bridgeRateT2OverAs.get(i).getAIRLINE_CODE_IATA())||"ZH".equals(bridgeRateT2OverAs.get(i).getAIRLINE_CODE_IATA())){

                ck = ck + bridgeRateT2OverAs.get(i).getK();
                cs = cs + bridgeRateT2OverAs.get(i).getS();
                cds = cds +bridgeRateT2OverAs.get(i).getDS();
//                MF HU GS TV 8L NS
            }else if("MF".equals(bridgeRateT2OverAs.get(i).getAIRLINE_CODE_IATA())||"HU".equals(bridgeRateT2OverAs.get(i).getAIRLINE_CODE_IATA())
                    ||"GS".equals(bridgeRateT2OverAs.get(i).getAIRLINE_CODE_IATA())||"TV".equals(bridgeRateT2OverAs.get(i).getAIRLINE_CODE_IATA())
                    ||"8L".equals(bridgeRateT2OverAs.get(i).getAIRLINE_CODE_IATA())||"NS".equals(bridgeRateT2OverAs.get(i).getAIRLINE_CODE_IATA())){
                dfk = dfk + bridgeRateT2OverAs.get(i).getK();
                dfs = dfs + bridgeRateT2OverAs.get(i).getS();
                dfds = dfds +bridgeRateT2OverAs.get(i).getDS();
            }else if("MU".equals(bridgeRateT2OverAs.get(i).getAIRLINE_CODE_IATA())||"SC".equals(bridgeRateT2OverAs.get(i).getAIRLINE_CODE_IATA())||
                    "EU".equals(bridgeRateT2OverAs.get(i).getAIRLINE_CODE_IATA())){
                ek = ek + bridgeRateT2OverAs.get(i).getK();
                es = es + bridgeRateT2OverAs.get(i).getS();
                eds = eds +bridgeRateT2OverAs.get(i).getDS();
            }
        }
        for(int i=0;i<bridgeRateT2OverDs.size();i++){
            if("FM".equals(bridgeRateT2OverDs.get(i).getAIRLINE_CODE_IATA())){
                shk = shk + bridgeRateT2OverDs.get(i).getK();
                shs = shs + bridgeRateT2OverDs.get(i).getS();
                shds = shds +bridgeRateT2OverDs.get(i).getDS();
            }else if("HO".equals(bridgeRateT2OverDs.get(i).getAIRLINE_CODE_IATA())){
                lk = lk + bridgeRateT2OverDs.get(i).getK();
                ls = ls + bridgeRateT2OverDs.get(i).getS();
                lds = lds +bridgeRateT2OverDs.get(i).getDS();
            }else if("CZ".equals(bridgeRateT2OverDs.get(i).getAIRLINE_CODE_IATA())){
                sk = sk + bridgeRateT2OverDs.get(i).getK();
                ss = ss + bridgeRateT2OverDs.get(i).getS();
                sds = sds +bridgeRateT2OverDs.get(i).getDS();
            }else if("CA".equals(bridgeRateT2OverDs.get(i).getAIRLINE_CODE_IATA())||"ZH".equals(bridgeRateT2OverDs.get(i).getAIRLINE_CODE_IATA())){

                ck = ck + bridgeRateT2OverDs.get(i).getK();
                cs = cs + bridgeRateT2OverDs.get(i).getS();
                cds = cds +bridgeRateT2OverDs.get(i).getDS();
//                MF HU GS TV 8L NS
            }else if("MF".equals(bridgeRateT2OverDs.get(i).getAIRLINE_CODE_IATA())||"HU".equals(bridgeRateT2OverDs.get(i).getAIRLINE_CODE_IATA())
                    ||"GS".equals(bridgeRateT2OverDs.get(i).getAIRLINE_CODE_IATA())||"TV".equals(bridgeRateT2OverDs.get(i).getAIRLINE_CODE_IATA())
                    ||"8L".equals(bridgeRateT2OverDs.get(i).getAIRLINE_CODE_IATA())||"NS".equals(bridgeRateT2OverDs.get(i).getAIRLINE_CODE_IATA())){
                dfk = dfk + bridgeRateT2OverDs.get(i).getK();
                dfs = dfs + bridgeRateT2OverDs.get(i).getS();
                dfds = dfds +bridgeRateT2OverDs.get(i).getDS();
            }else if("MU".equals(bridgeRateT2OverDs.get(i).getAIRLINE_CODE_IATA())||"SC".equals(bridgeRateT2OverDs.get(i).getAIRLINE_CODE_IATA())||
                    "EU".equals(bridgeRateT2OverDs.get(i).getAIRLINE_CODE_IATA())){
                ek = ek + bridgeRateT2OverDs.get(i).getK();
                es = es + bridgeRateT2OverDs.get(i).getS();
                eds = eds +bridgeRateT2OverDs.get(i).getDS();
            }
        }
        if(ek==0){
            erate = "0%";
        }else{
            erate = df.format(es*100.0/ek)+"%";
        }
        if(lk==0){
            lrate = "0%";
        }else{
            lrate = df.format(ls*100.0/lk)+"%";
        }
        if(shk==0){
            shrate = "0%";
        }else{
            shrate = df.format(shs*100.0/shk)+"%";
        }
        if(ck==0){
            crate = "0%";
        }else{
            crate = df.format(cs*100.0/ck)+"%";
        }
        if(dfk==0){
            dfrate = "0%";
        }else{
            dfrate = df.format(dfs*100.0/dfk)+"%";
        }
        if(sk==0){
            srate = "0%";
        }else{
            srate = df.format(ss*100.0/sk)+"%";
        }


        bridgeRateT2sf.setData_type("T2过站");
        bridgeRateT2sf.setLD_close(dfk);
        bridgeRateT2sf.setLD_close_rate(dfrate);
        bridgeRateT2sf.setLDA_close(dfs);
        bridgeRateT2sf.setLDBA_close(dfds);
        bridgeRateT2sf.setS_close(sk);
        bridgeRateT2sf.setS_close_rate(srate);
        bridgeRateT2sf.setSA_close(ss);
        bridgeRateT2sf.setSBA_close(sds);
        bridgeRateT2sf.setC_close(ck);
        bridgeRateT2sf.setC_close_rate(crate);
        bridgeRateT2sf.setCA_close(cs);
        bridgeRateT2sf.setCBA_close(cds);
        bridgeRateT2sf.setL_close(lk);
        bridgeRateT2sf.setL_close_rate(lrate);
        bridgeRateT2sf.setLA_close(ls);
        bridgeRateT2sf.setLBA_close(lds);
        bridgeRateT2sf.setSH_close(shk);
        bridgeRateT2sf.setSH_close_rate(shrate);
        bridgeRateT2sf.setSHA_close(shs);
        bridgeRateT2sf.setSHBA_close(shds);
        bridgeRateT2sf.setE_close(ek);
        bridgeRateT2sf.setE_close_rate(erate);
        bridgeRateT2sf.setEA_close(es);
        bridgeRateT2sf.setEBA_close(eds);
        modifyList.add(bridgeRateT2sf);
        for(int i=0;i<bridgeRateT2Inits.size();i++){
            if("FM".equals(bridgeRateT2Inits.get(i).getAIRLINE_CODE_IATA())){
                shk = shk + bridgeRateT2Inits.get(i).getK();
                shs = shs + bridgeRateT2Inits.get(i).getS();
                shds = shds +bridgeRateT2Inits.get(i).getDS();
            }else if("HO".equals(bridgeRateT2Inits.get(i).getAIRLINE_CODE_IATA())){
                lk = lk + bridgeRateT2Inits.get(i).getK();
                ls = ls + bridgeRateT2Inits.get(i).getS();
                lds = lds +bridgeRateT2Inits.get(i).getDS();
            }else if("CZ".equals(bridgeRateT2Inits.get(i).getAIRLINE_CODE_IATA())){
                sk = sk + bridgeRateT2Inits.get(i).getK();
                ss = ss + bridgeRateT2Inits.get(i).getS();
                sds = sds +bridgeRateT2Inits.get(i).getDS();
            }else if("CA".equals(bridgeRateT2Inits.get(i).getAIRLINE_CODE_IATA())||"ZH".equals(bridgeRateT2Inits.get(i).getAIRLINE_CODE_IATA())){

                ck = ck + bridgeRateT2Inits.get(i).getK();
                cs = cs + bridgeRateT2Inits.get(i).getS();
                cds = cds +bridgeRateT2Inits.get(i).getDS();
//                MF HU GS TV 8L NS
            }else if("MF".equals(bridgeRateT2Inits.get(i).getAIRLINE_CODE_IATA())||"HU".equals(bridgeRateT2Inits.get(i).getAIRLINE_CODE_IATA())
                    ||"GS".equals(bridgeRateT2Inits.get(i).getAIRLINE_CODE_IATA())||"TV".equals(bridgeRateT2Inits.get(i).getAIRLINE_CODE_IATA())
                    ||"8L".equals(bridgeRateT2Inits.get(i).getAIRLINE_CODE_IATA())||"NS".equals(bridgeRateT2Inits.get(i).getAIRLINE_CODE_IATA())){
                dfk = dfk + bridgeRateT2Inits.get(i).getK();
                dfs = dfs + bridgeRateT2Inits.get(i).getS();
                dfds = dfds +bridgeRateT2Inits.get(i).getDS();
            }else if("MU".equals(bridgeRateT2Inits.get(i).getAIRLINE_CODE_IATA())||"SC".equals(bridgeRateT2Inits.get(i).getAIRLINE_CODE_IATA())||
                    "EU".equals(bridgeRateT2Inits.get(i).getAIRLINE_CODE_IATA())){
                ek = ek + bridgeRateT2Inits.get(i).getK();
                es = es + bridgeRateT2Inits.get(i).getS();
                eds = eds +bridgeRateT2Inits.get(i).getDS();
            }
        }
        if(ek==0){
            erate = "0%";
        }else{
            erate = df.format(es*100.0/ek)+"%";
        }
        if(lk==0){
            lrate = "0%";
        }else{
            lrate = df.format(ls*100.0/lk)+"%";
        }
        if(shk==0){
            shrate = "0%";
        }else{
            shrate = df.format(shs*100.0/shk)+"%";
        }
        if(ck==0){
            crate = "0%";
        }else{
            crate = df.format(cs*100.0/ck)+"%";
        }
        if(dfk==0){
            dfrate = "0%";
        }else{
            dfrate = df.format(dfs*100.0/dfk)+"%";
        }
        if(sk==0){
            srate = "0%";
        }else{
            srate = df.format(ss*100.0/sk)+"%";
        }
        bridgeRateT2sfgz.setData_type("T2过站与始发");
        bridgeRateT2sfgz.setLD_close(dfk);
        bridgeRateT2sfgz.setLD_close_rate(dfrate);
        bridgeRateT2sfgz.setLDA_close(dfs);
        bridgeRateT2sfgz.setLDBA_close(dfds);
        bridgeRateT2sfgz.setS_close(sk);
        bridgeRateT2sfgz.setS_close_rate(srate);
        bridgeRateT2sfgz.setSA_close(ss);
        bridgeRateT2sfgz.setSBA_close(sds);
        bridgeRateT2sfgz.setC_close(ck);
        bridgeRateT2sfgz.setC_close_rate(crate);
        bridgeRateT2sfgz.setCA_close(cs);
        bridgeRateT2sfgz.setCBA_close(cds);
        bridgeRateT2sfgz.setL_close(lk);
        bridgeRateT2sfgz.setL_close_rate(lrate);
        bridgeRateT2sfgz.setLA_close(ls);
        bridgeRateT2sfgz.setLBA_close(lds);
        bridgeRateT2sfgz.setSH_close(shk);
        bridgeRateT2sfgz.setSH_close_rate(shrate);
        bridgeRateT2sfgz.setSHA_close(shs);
        bridgeRateT2sfgz.setSHBA_close(shds);
        bridgeRateT2sfgz.setE_close(ek);
        bridgeRateT2sfgz.setE_close_rate(erate);
        bridgeRateT2sfgz.setEA_close(es);
        bridgeRateT2sfgz.setEBA_close(eds);
        modifyList.add(bridgeRateT2sfgz);
        return modifyList;
    }
}
