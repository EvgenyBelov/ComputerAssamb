package com.easyway2in.mysqldbdemo.VCArd;

/**
 * Created by Evgeny on 12.05.2017.
 */

public class ContactVCard {
    private String name, pci, pci_ver, memory, type, shina, power, url, url_img, nameprc, namemath, nameram,
                    powerPRC, socPRC, sataMath, powerMath, powerRam, factor;

    public ContactVCard(String name, String pci, String pci_ver, String memory, String type, String shina, String power, String url,
                        String url_img, String nameprc, String namemath, String nameram, String powerPRC, String socPRC, String sataMath,
                        String powerMath, String powerRam, String factor) {
        this.setName(name);
        this.setPci(pci);
        this.setMemory(memory);
        this.setType(type);
        this.setShina(shina);
        this.setPower(power);
        this.setUrl(url);
        this.setUrl_img(url_img);
        this.setPci_ver(pci_ver);
        this.setNameprc(nameprc);
        this.setNamemath(namemath);
        this.setNameram(nameram);
        this.setPowerPRC(powerPRC);
        this.setSocPRC(socPRC);
        this.setSataMath(sataMath);
        this.setPowerMath(powerMath);
        this.setPowerRam(powerRam);
        this.setFactor(factor);


    }

    public String getFactor() {
        return factor;
    }

    public void setFactor(String factor) {
        this.factor = factor;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPci() {
        return pci;
    }

    public void setPci(String pci) {
        this.pci = pci;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getShina() {
        return shina;
    }

    public void setShina(String shina) {
        this.shina = shina;
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

    public String getPci_ver() {
        return pci_ver;
    }

    public void setPci_ver(String pci_ver) {
        this.pci_ver = pci_ver;
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

    public String getPowerPRC() {
        return powerPRC;
    }

    public void setPowerPRC(String powerPRC) {
        this.powerPRC = powerPRC;
    }

    public String getSocPRC() {
        return socPRC;
    }

    public void setSocPRC(String socPRC) {
        this.socPRC = socPRC;
    }

    public String getSataMath() {
        return sataMath;
    }

    public void setSataMath(String sataMath) {
        this.sataMath = sataMath;
    }
}
