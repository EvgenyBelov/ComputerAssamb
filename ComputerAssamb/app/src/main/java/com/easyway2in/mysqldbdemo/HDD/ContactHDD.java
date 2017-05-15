package com.easyway2in.mysqldbdemo.HDD;

/**
 * Created by Evgeny on 12.05.2017.
 */

public class ContactHDD {
    private String name, sata, speed, memory, speed_disk, power, url, url_img,
            nameProc, nameMath, nameRam, nameVCard, nameCool, SATAMath, powerPrc, powerMath, powerRam, powerVCard, powerCool, factor;

    public ContactHDD(String name, String sata, String speed, String memory, String speed_disk, String power, String url, String url_img,
                      String nameProc, String nameMath, String nameRam, String nameVCard, String nameCool, String SATAMath, String powerPrc,
                      String powerMath, String powerRam, String powerVCard, String powerCool, String factor) {
        this.setName(name);
        this.setSata(sata);
        this.setSpeed(speed);
        this.setMemory(memory);
        this.setSpeed_disk(speed_disk);
        this.setPower(power);
        this.setUrl(url);
        this.setUrl_img(url_img);
        this.setNameProc(nameProc);
        this.setNameMath(nameMath);
        this.setNameRam(nameRam);
        this.setNameVCard(nameVCard);
        this.setNameCool(nameCool);
        this.setSATAMath(SATAMath);

        this.setPowerPrc(powerPrc);
        this.setPowerMath(powerMath);
        this.setPowerRam(powerRam);
        this.setPowerVCard(powerVCard);
        this.setPowerCool(powerCool);

        this.setFactor(factor);

    }

    public String getFactor() {
        return factor;
    }

    public void setFactor(String factor) {
        this.factor = factor;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSata() {
        return sata;
    }

    public void setSata(String sata) {
        this.sata = sata;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getSpeed_disk() {
        return speed_disk;
    }

    public void setSpeed_disk(String speed_disk) {
        this.speed_disk = speed_disk;
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

    public String getNameProc() {
        return nameProc;
    }

    public void setNameProc(String nameProc) {
        this.nameProc = nameProc;
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

    public String getSATAMath() {
        return SATAMath;
    }

    public void setSATAMath(String SATAMath) {
        this.SATAMath = SATAMath;
    }
}
