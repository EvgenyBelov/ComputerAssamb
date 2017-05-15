package com.easyway2in.mysqldbdemo.Casee;

/**
 * Created by Evgeny on 13.05.2017.
 */

public class ContactCase {
    private String name, front, factor, size, mass, url, url_img, factor_2, factor_3, factor_4,
            namePrc, nameMath, nameRam, nameVCard, nameHDD, nameCool, nameSSD, namePsup;

    public ContactCase(String name, String factor, String front, String size, String mass, String url, String url_img,
                       String factor_2, String factor_3, String factor_4,
                       String namePrc, String nameMath, String nameRam, String nameVCard, String nameHDD, String nameCool, String nameSSD, String namePsup
                       ) {
        this.setName(name);
        this.setFactor(factor);
        this.setFront(front);
        this.setSize(size);
        this.setMass(mass);
        this.setUrl(url);
        this.setUrl_img(url_img);
        this.setFactor_2(factor_2);
        this.setFactor_3(factor_3);
        this.setFactor_4(factor_4);

        this.setNamePrc(namePrc);
        this.setNameMath(nameMath);
        this.setNameRam(nameRam);
        this.setNameVCard(nameVCard);
        this.setNameHDD(nameHDD);
        this.setNameCool(nameCool);
        this.setNameSSD(nameSSD);
        this.setNamePsup(namePsup);
    }


    public String getFactor_2() {
        return factor_2;
    }

    public void setFactor_2(String factor_2) {
        this.factor_2 = factor_2;
    }

    public String getFactor_3() {
        return factor_3;
    }

    public void setFactor_3(String factor_3) {
        this.factor_3 = factor_3;
    }

    public String getFactor_4() {
        return factor_4;
    }

    public void setFactor_4(String factor_4) {
        this.factor_4 = factor_4;
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

    public String getNameHDD() {
        return nameHDD;
    }

    public void setNameHDD(String nameHDD) {
        this.nameHDD = nameHDD;
    }

    public String getNameCool() {
        return nameCool;
    }

    public void setNameCool(String nameCool) {
        this.nameCool = nameCool;
    }

    public String getNameSSD() {
        return nameSSD;
    }

    public void setNameSSD(String nameSSD) {
        this.nameSSD = nameSSD;
    }

    public String getNamePsup() {
        return namePsup;
    }

    public void setNamePsup(String namePsup) {
        this.namePsup = namePsup;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFront() {
        return front;
    }

    public void setFront(String front) {
        this.front = front;
    }

    public String getFactor() {
        return factor;
    }

    public void setFactor(String factor) {
        this.factor = factor;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getMass() {
        return mass;
    }

    public void setMass(String mass) {
        this.mass = mass;
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
