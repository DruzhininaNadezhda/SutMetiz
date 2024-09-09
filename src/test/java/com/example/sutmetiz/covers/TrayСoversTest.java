package com.example.sutmetiz.covers;

import com.example.sutmetiz.productAnalysis.impl.TrayCoversAnalysisImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TrayСoversTest {

    @Test
    void allCovers() {
    }

    @Test
    void coverName() {
        TrayCoversAnalysisImpl trayCoversAnalysis = new TrayCoversAnalysisImpl();
        trayCoversAnalysis.coversForAllnomenclatureYesOrNo("ЛМЗС 100*100-1,0-3000-ОЦ");
        Assertions.assertEquals(trayCoversAnalysis.getCover(), "КЛЗС 100*100-1,0-3000-ОЦ");
    }
    @Test
    void coverName2() {
        TrayCoversAnalysisImpl trayCoversAnalysis = new TrayCoversAnalysisImpl();
        trayCoversAnalysis.coversForAllnomenclatureYesOrNo("ЛМС 100*100-1,0-3000-ОЦ");
        Assertions.assertEquals(trayCoversAnalysis.getCover(), "КЛС 100*100-1,0-3000-ОЦ");
    }
    @Test
    void coverName3() {
        TrayCoversAnalysisImpl trayCoversAnalysis = new TrayCoversAnalysisImpl();
        trayCoversAnalysis.coversForAllnomenclatureYesOrNo("ЛМ 100*100-1,0-3000-ОЦ");
        Assertions.assertEquals(trayCoversAnalysis.getCover(), "КЛ 100-1,0-3000-ОЦ");
    }
    @Test
    void coverName4() {
        TrayCoversAnalysisImpl trayCoversAnalysis = new TrayCoversAnalysisImpl();
        trayCoversAnalysis.coversForAllnomenclatureYesOrNo("НЛС 100*100-1,0-3000-ОЦ");
        Assertions.assertEquals(trayCoversAnalysis.getCover(), "КНС 100*100-1,0-3000-ОЦ");
    }
    @Test
    void coverName5() {
        TrayCoversAnalysisImpl trayCoversAnalysis = new TrayCoversAnalysisImpl();
        trayCoversAnalysis.coversForAllnomenclatureYesOrNo("НЛП 100*100-1,0-3000-ОЦ");
        Assertions.assertEquals(trayCoversAnalysis.getCover(), "КНП 100-1,0-3000-ОЦ");
    }
    @Test
    void coverName6() {
        TrayCoversAnalysisImpl trayCoversAnalysis = new TrayCoversAnalysisImpl();
        trayCoversAnalysis.coversForAllnomenclatureYesOrNo("ЛМЗРц 300/100*100-1,0-3000-ОЦ");
        Assertions.assertEquals(trayCoversAnalysis.getCover(), "КЛЗРц 300/100-1,0-3000-ОЦ");
    }
    @Test
    void coverName7() {
        TrayCoversAnalysisImpl trayCoversAnalysis = new TrayCoversAnalysisImpl();
        trayCoversAnalysis.coversForAllnomenclatureYesOrNo("НТ 500*100-1,0-3000-ОЦ");
        Assertions.assertEquals(trayCoversAnalysis.getCover(), "КТ 500-1,0-3000-ОЦ");
    }
    @Test
    void coverName8() {
        TrayCoversAnalysisImpl trayCoversAnalysis = new TrayCoversAnalysisImpl();
        trayCoversAnalysis.coversForAllnomenclatureYesOrNo("НТТ 500*100-1,0-3000-ОЦ");
        Assertions.assertEquals(trayCoversAnalysis.getCover(), "КТТ 500-1,0-3000-ОЦ");
    }
    @Test
    void coverName9() {
        TrayCoversAnalysisImpl trayCoversAnalysis = new TrayCoversAnalysisImpl();
        trayCoversAnalysis.coversForAllnomenclatureYesOrNo("ЛМЗТвв 500*100-1,0-3000-ОЦ");
        Assertions.assertEquals(trayCoversAnalysis.getCover(), "");
    }
    @Test
    void noCover() {
        TrayCoversAnalysisImpl trayCoversAnalysis = new TrayCoversAnalysisImpl();
        Assertions.assertFalse(trayCoversAnalysis.noCover("ЛМЗТвв 500*100-1,0-3000-ОЦ"));
    }
    @Test
    void noCover1() {
        TrayCoversAnalysisImpl trayCoversAnalysis = new TrayCoversAnalysisImpl();
        Assertions.assertTrue(trayCoversAnalysis.noCover("ЛМЗТ 500*100-1,0-3000-ОЦ"));
    }
    @Test
    void quantityCover() {
        TrayCoversAnalysisImpl trayCoversAnalysis = new TrayCoversAnalysisImpl();
        trayCoversAnalysis.coversForAllnomenclatureYesOrNo("НТ 500*100-1,0-3000-ОЦ");
        Assertions.assertEquals(trayCoversAnalysis.getQuantityCovers(),1);
    }
    @Test
    void quantityCover1() {
        TrayCoversAnalysisImpl trayCoversAnalysis = new TrayCoversAnalysisImpl();
        trayCoversAnalysis.coversForAllnomenclatureYesOrNo("ЛТ 500*100-1,0-6000-ОЦ");
        Assertions.assertEquals(trayCoversAnalysis.getQuantityCovers(),2);
    }
    @Test
    void quantityCover2() {
        TrayCoversAnalysisImpl trayCoversAnalysis = new TrayCoversAnalysisImpl();
        trayCoversAnalysis.coversForAllnomenclatureYesOrNo("ЛТГ 500*100-1,0-6000-ОЦ");
        Assertions.assertEquals(trayCoversAnalysis.getCover(),"КТ 500-1,0-3000-ОЦ");
    }
    @Test
    void quantityCover3() {
        TrayCoversAnalysisImpl trayCoversAnalysis = new TrayCoversAnalysisImpl();
        trayCoversAnalysis.coversForAllnomenclatureYesOrNo("ЛТГ 500*100-1,0-3000-ОЦ");
        Assertions.assertEquals(trayCoversAnalysis.getCover(),"КТ 500-1,0-3000-ОЦ");
    }
    @Test
    void quantityCover4() {
        TrayCoversAnalysisImpl trayCoversAnalysis = new TrayCoversAnalysisImpl();
        trayCoversAnalysis.coversForAllnomenclatureYesOrNo("ЛТГ 500*100-1,0-4000-ОЦ");
        Assertions.assertEquals(trayCoversAnalysis.getCover(),"КТ 500-1,0-2000-ОЦ");
    }
    @Test
    void quantityCover5() {
        TrayCoversAnalysisImpl trayCoversAnalysis = new TrayCoversAnalysisImpl();
        trayCoversAnalysis.coversForAllnomenclatureYesOrNo("НТ 500*100-1,0-4000-ОЦ");
        Assertions.assertEquals(trayCoversAnalysis.getCover(),"КТ 500-1,0-2000-ОЦ");
    }
    @Test
    void quantityCover6() {
        TrayCoversAnalysisImpl trayCoversAnalysis = new TrayCoversAnalysisImpl();
        trayCoversAnalysis.coversForAllnomenclatureYesOrNo("НТРц 500*100-1,0-ОЦ");
        Assertions.assertEquals(trayCoversAnalysis.getCover(),"КТРц 500-1,0-ОЦ");
    }
    @Test
    void quantityCover7() {
        TrayCoversAnalysisImpl trayCoversAnalysis = new TrayCoversAnalysisImpl();
        trayCoversAnalysis.coversForAllnomenclatureYesOrNo("НТРц 500*100-1,0-ОЦ");
        Assertions.assertEquals(trayCoversAnalysis.getQuantityCovers(),1);
    }
    @Test
    void coverNo() {
        TrayCoversAnalysisImpl trayCoversAnalysis = new TrayCoversAnalysisImpl();
        Assertions.assertFalse(trayCoversAnalysis.coversForAllnomenclatureYesOrNo("КЛЗРц 500*100-1,0-ОЦ"));
    }
    @Test
    void coverNo1() {
        TrayCoversAnalysisImpl trayCoversAnalysis = new TrayCoversAnalysisImpl();
        Assertions.assertFalse(trayCoversAnalysis.coversForAllnomenclatureYesOrNo("ОВ8 ГЦ"));
    }
    @Test
    void coverNo3() {
        TrayCoversAnalysisImpl trayCoversAnalysis = new TrayCoversAnalysisImpl();
        Assertions.assertFalse(trayCoversAnalysis.coversForAllnomenclatureYesOrNo("по чертежам НТРц 500*100-1,0-ОЦ"));
    }

}