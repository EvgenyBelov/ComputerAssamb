package com.easyway2in.mysqldbdemo.pSupply;

/**
 * Created by Evgeny on 13.05.2017.
 */

public class ContactPSupply {
    private String name, power, factor, cert, stand, url, url_img,
                    namePrc, nameMath, nameRam, nameVCard, nameCool, nameHDD, nameSSD,
                    fMath;

    public ContactPSupply(String name, String power, String factor, String cert, String stand, String url, String url_img,
                          String namePrc, String nameMath, String nameRam, String  nameVCard, String nameCool, String nameHDD,
                          String nameSSD, String fMath) {
        this.setName(name);
        this.setPower(power);
        this.setFactor(factor);
        this.setCert(cert);
        this.setStand(stand);
        this.setUrl(url);
        this.setUrl_img(url_img);

        this.setNamePrc(namePrc);
        this.setNameMath(nameMath);
        this.setNameRam(nameRam);
        this.setNameVCard(nameVCard);
        this.setNameCool(nameCool);
        this.setNameHDD(nameHDD);
        this.setNameSSD(nameSSD);

        this.setfMath(fMath);
    }

    public String getfMath() {
        return fMath;
    }

    public void setfMath(String fMath) {
        this.fMath = fMath;
    }

    public String getNamePrc() {
        return namePrc;
    }

    public void setNamePrc(String namePrc) {
        this.namePrc = namePrc;
    }

    public String getNameMath() {
        return nameMath;
    }

    public void setNameMath(String nameMath) {
        this.nameMath = nameMath;
    }

    public String getNameRam() {
        return nameRam;
    }

    public void setNameRam(String nameRam) {
        this.nameRam = nameRam;
    }

    public String getNameVCard() {
        return nameVCard;
    }

    public void setNameVCard(String nameVCard) {
        this.nameVCard = nameVCard;
    }

    public String getNameCool() {
        return nameCool;
    }

    public void setNameCool(String nameCool) {
        this.nameCool = nameCool;
    }

    public String getNameHDD() {
        return nameHDD;
    }

    public void setNameHDD(String nameHDD) {
        this.nameHDD = nameHDD;
    }

    public String getNameSSD() {
        return nameSSD;
    }

    public void setNameSSD(String nameSSD) {
        this.nameSSD = nameSSD;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getFactor() {
        return factor;
    }

    public void setFactor(String factor) {
        this.factor = factor;
    }

    public String getCert() {
        return cert;
    }

    public void setCert(String cert) {
        this.cert = cert;
    }

    public String getStand() {
        return stand;
    }

    public void setStand(String stand) {
        this.stand = stand;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl_img() {
        return url_img;
    }

    public void setUrl_img(String url_img) {
        this.url_img = url_img;
    }
}
