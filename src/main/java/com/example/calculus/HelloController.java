package com.example.compsalts;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;

import java.io.IOException;


public class HelloController {
    @FXML
    private TextField Val1;
    @FXML
    private TextField Val2;
    @FXML
    private TextField Val3;
    @FXML
    private TextField Val4;
    @FXML
    private TextField Val5;
    @FXML
    private TextField Val6;
    @FXML
    private TextField Val7;
    @FXML
    private TextField Val8;
    @FXML
    private TextField Val9;
    @FXML
    private TextField Val10;
    @FXML
    private TextField Val11;
    @FXML
    private TextField Val12;
    @FXML
    private TextField Val13;
    @FXML
    private TextField Val14;
    @FXML
    private TextField Val15;
    @FXML
    private TextField Val16;
    @FXML
    private TextField Val17;
    @FXML
    private TextField Val18;
    @FXML
    private TextField Val19;
    @FXML
    private TextField Val20;
    @FXML
    private TextField Val21;
    @FXML
    private Hyperlink h11;
    @FXML
    private Hyperlink hl2;

    public void initialize(){
        //Val1.setPromptText("3.95");
        Val1.setText(String.valueOf("3.95"));
        Val2.setText(String.valueOf("3.95"));
        Val3.setText(String.valueOf("13.30"));
        Val4.setText(String.valueOf("26.00"));
        Val5.setText(String.valueOf("6.70"));
        Val6.setText(String.valueOf("3.50"));
        Val7.setText(String.valueOf("151.1"));


    }

    @FXML
    public void calc(ActionEvent event) {
        String cNa = Val1.getText();
        double cNa1 = Double.parseDouble(cNa);

        String cK = Val2.getText();
        double cK1 = Double.parseDouble(cK);

        String cMg = Val3.getText();
        double cMg1 = Double.parseDouble(cMg);

        String cCa = Val4.getText();
        double cCa1 = Double.parseDouble(cCa);

        String cCl = Val5.getText();
        double cCl1 = Double.parseDouble(cCl);

        String cSO4 = Val6.getText();
        double cSO41 = Double.parseDouble(cSO4);

        String cHCO3 = Val7.getText();
        double cHCO31 = Double.parseDouble(cHCO3);

        double mmNa = 22.99;
        double mmK = 39.102;
        double mmMg = 24.312;
        double mmCa = 40.08;
        double mmCl = 35.453;
        double mmSO4 = 96.06;
        double mmHCO3 = 61.016;

        double moNa = (cNa1/1000)/mmNa;
        double moK =  (cK1/1000)/mmK;
        double moMg = (cMg1/1000)/mmMg;
        double moCa = (cCa1/1000)/mmCa;
        double moCl = (cCl1/1000)/mmCl;
        double moSO4 = (cSO41/1000)/mmSO4;
        double moHCO3 = (cHCO31/1000)/mmHCO3;

        double en = moNa+moK+2*moMg+2*moCa-moCl-2*moSO4-moHCO3;
        Val8.setText(String.format("%.2e", en));

        double mmKCl = mmK+mmCl;
        double molKCl = moK;
        double massK = molKCl*mmK;
        double massCl1 = molKCl*mmCl;
        double massKCl = massK+massCl1;
        Val9.setText(String.format("%.2f", massKCl*1000));
        double deltamassCl = (cCl1/1000-massCl1);
        double deltanCl = deltamassCl/mmCl;

        double massCl2  = deltamassCl;
        double massMg1 = mmMg*massCl2/(mmCl*2);
        double massMgCl2 = massCl2+massMg1;
        Val10.setText(String.format("%.2f", massMgCl2*1000));
        double molMg = (massMg1)/mmMg;
        double deltanMg1 = moMg - molMg;

        double massMg2 = deltanMg1*mmMg;
        double massCO31 = massMg2*mmHCO3/mmMg;
        double massMgCO3 = massMg2+massCO31;
        Val11.setText(String.format("%.2f", massMgCO3*1000));
        double nHCO31 = 2*(massCO31/mmHCO3);
        double deltanHCO31 = moHCO3-nHCO31;

        double massCa = moCa*mmCa;
        double massCO3 = massCa*mmHCO3/mmCa;
        double massCaCO3 = massCO3+massCa;
        Val12.setText(String.format("%.2f", massCaCO3*1000));
        double nHCO32 = 2*(massCO3/mmHCO3);
        double deltanHCO32 = deltanHCO31 - nHCO32;

        double molSO4 = moSO4;
        double massSO4 = molSO4*mmSO4;
        double massNa1 = (2*mmNa*massSO4)/mmSO4;
        double massNa2SO4 = massNa1+massSO4;
        Val13.setText(String.format("%.2f", massNa2SO4*1000));
        double molNa1 = massNa1/mmNa;
        double deltaNa = moNa-molNa1;

        double molNa2 = deltaNa;
        double massNa2 = molNa2*mmNa;
        double massHCO32 = massNa2*mmHCO3/mmNa;
        double massNaHCO3 = massNa2+massHCO32;
        Val14.setText(String.format("%.2f", massNaHCO3*1000));

        double cNacalc = ((molNa1+molNa2)*mmNa)*1000;
        double cKcalc = molKCl*mmK*1000;
        double cMgcalc = (molMg+deltanMg1)*1000*mmMg;
        double  cCacalc = massCa*1000;
        double cClcalc = (massCl1+massCl2)*1000;
        double cSO4calc = molSO4*mmSO4*1000;
        double cHCO3calc = (nHCO31+nHCO32+massHCO32/mmHCO3)*mmHCO3*1000;
        Val15.setText(String.format("%.2f", cNacalc));
        Val16.setText(String.format("%.2f", cKcalc));
        Val17.setText(String.format("%.2f", cMgcalc));
        Val18.setText(String.format("%.2f", cCacalc));
        Val19.setText(String.format("%.2f", cClcalc));
        Val20.setText(String.format("%.2f", cSO4calc));
        Val21.setText(String.format("%.2f", cHCO3calc));

    }
    @FXML
    public void link1 (ActionEvent event) throws IOException {
        String URL = "http://hge.spbu.ru/";
        Runtime.getRuntime().exec(String.format("rundll32 url.dll, FileProtocolHandler %s", URL));
    }

    @FXML
    public void link2 (ActionEvent event) throws IOException {
        String URL = "mailto:k.rozov@hgepro.ru";
        Runtime.getRuntime().exec(String.format("rundll32 url.dll, FileProtocolHandler %s", URL));
    }

}