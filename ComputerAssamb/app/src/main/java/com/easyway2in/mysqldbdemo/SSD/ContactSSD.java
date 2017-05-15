package com.easyway2in.mysqldbdemo.SSD;

/**
 * Created by Evgeny on 12.05.2017.
 */

public class ContactSSD {
    private String name, interfc, time, memory, speed, power, url, url_img,
                    namePrc, nameMath, nameRam, nameVCard, nameHDD, nameCool,
                    powerPrc, powerMath, powerRam, powerVCard, powerCool, powerHDD, factor;

    public ContactSSD(String name, String interfc, String time, String memory, String speed, String power, String url, String url_img,
                      String namePrc, String nameMath, String nameRam, String nameVCard, String nameHDD, String nameCool, String powerPrc,
                      String powerMath, String powerRam, String powerVCard, String powerCool, String powerHDD, String factor) {
        this.setName(name);
        this.setInterfc(interfc);
        this.setTime(time);
        this.setMemory(memory);
        this.setSpeed(speed);
        this.setPower(power);
        this.setUrl(url);
        this.setUrl_img(url_img);

        this.setNamePrc(namePrc);
        this.setNameMath(nameMath);
        this.setNameRam(nameRam);
        this.setNameVCard(nameVCard);
        this.setNameHDD(nameHDD);
        this.setNameCool(nameCool);

        this.setPowerPrc(powerPrc);
        this.setPowerMath(powerMath);
        this.setPowerRam(powerRam);
        this.setPowerVCard(powerVCard);
        this.setPowerCool(powerCool);
        this.setPowerHDD(powerHDD);
        this.setFactor(factor);

    }

    public String getFactor() {
        return factor;
    }

    public void setFactor(String factor) {
        this.factor = factor;
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

    public String getPowerPrc() {
        return powerPrc;
    }

    public void setPowerPrc(String powerPrc) {
        this.powerPrc = powerPrc;
    }

    public String getPowerMath() {
        return powerMath;
    }

    public void setPowerMath(String powerMath) {
        this.powerMath = powerMath;
    }

    public String getPowerRam() {
        return powerRam;
    }

    public void setPowerRam(String powerRam) {
        this.powerRam = powerRam;
    }

    public String getPowerVCard() {
        return powerVCard;
    }

    public void setPowerVCard(String powerVCard) {
        this.powerVCard = powerVCard;
    }

    public String getPowerCool() {
        return powerCool;
    }

    public void setPowerCool(String powerCool) {
        this.powerCool = powerCool;
    }

    public String getPowerHDD() {
        return powerHDD;
    }

    public void setPowerHDD(String powerHDD) {
        this.powerHDD = powerHDD;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInterfc() {
        return interfc;
    }

    public void setInterfc(String interfc) {
        this.interfc = interfc;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
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
