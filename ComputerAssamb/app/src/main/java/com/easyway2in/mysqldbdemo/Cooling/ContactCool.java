package com.easyway2in.mysqldbdemo.Cooling;

/**
 * Created by Evgeny on 12.05.2017.
 */

public class ContactCool {
    private String name, socket, power, noise, speed, url, url_img, nameprc, namemath, nameram, namevcard, sataMath,
            powerPrc, powerMath, powerRam, powerVCard, factor;

    public ContactCool(String name, String socket, String power, String noise, String speed, String url, String url_img,
                        String nameprc, String namemath, String nameram, String namevcard, String sataMath, String powerPrc,
                       String powerMath, String powerRam, String powerVCard, String factor) {
        this.setName(name);
        this.setSocket(socket);
        this.setPower(power);
        this.setNoise(noise);
        this.setSpeed(speed);
        this.setUrl(url);
        this.setUrl_img(url_img);
        this.setNameprc(nameprc);
        this.setNamemath(namemath);
        this.setNameram(nameram);
        this.setNamevcard(namevcard);
        this.setSataMath(sataMath);
        this.setPowerPrc(powerPrc);
        this.setPowerMath(powerMath);
        this.setPowerRam(powerRam);
        this.setPowerVCard(powerVCard);
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSocket() {
        return socket;
    }

    public void setSocket(String socket) {
        this.socket = socket;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getNoise() {
        return noise;
    }

    public void setNoise(String noise) {
        this.noise = noise;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
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

    public String getNameprc() {
        return nameprc;
    }

    public void setNameprc(String nameprc) {
        this.nameprc = nameprc;
    }

    public String getNamemath() {
        return namemath;
    }

    public void setNamemath(String namemath) {
        this.namemath = namemath;
    }

    public String getNameram() {
        return nameram;
    }

    public void setNameram(String nameram) {
        this.nameram = nameram;
    }

    public String getNamevcard() {
        return namevcard;
    }

    public void setNamevcard(String namevcard) {
        this.namevcard = namevcard;
    }

    public String getSataMath() {
        return sataMath;
    }

    public void setSataMath(String sataMath) {
        this.sataMath = sataMath;
    }
}
