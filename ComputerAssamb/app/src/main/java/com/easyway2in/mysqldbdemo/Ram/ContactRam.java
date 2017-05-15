package com.easyway2in.mysqldbdemo.Ram;

import com.easyway2in.mysqldbdemo.SSD.SSD;

/**
 * Created by Evgeny on 12.05.2017.
 */

public class ContactRam {
    private String name, memory, memory_max, freq, power, url, url_img, nameprc, namemath,
                    pci_1, pci_2, powerPRC, powerMath,socPRC, sataMath, factor;

    public ContactRam(String name, String memory, String memory_max, String freq, String power, String url,
                      String url_img, String nameprc, String namemath, String pci_1, String pci_2, String powerPRC,
                      String powerMath, String socPRC, String sataMath, String factor) {
        this.setName(name);
        this.setMemory(memory);
        this.setMemory_max(memory_max);
        this.setFreq(freq);
        this.setPower(power);
        this.setUrl(url);
        this.setUrl_img(url_img);
        this.setNameprc(nameprc);
        this.setNamemath(namemath);
        this.setPci_1(pci_1);
        this.setPci_2(pci_2);
        this.setPowerPRC(powerPRC);
        this.setSocPRC(socPRC);
        this.setSataMath(sataMath);
        this.setPowerMath(powerMath);
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getMemory_max() {
        return memory_max;
    }

    public void setMemory_max(String memory_max) {
        this.memory_max = memory_max;
    }

    public String getFreq() {
        return freq;
    }

    public void setFreq(String freq) {
        this.freq = freq;
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

    public String getPci_1() {
        return pci_1;
    }

    public void setPci_1(String pci_1) {
        this.pci_1 = pci_1;
    }

    public String getPci_2() {
        return pci_2;
    }

    public void setPci_2(String pci_2) {
        this.pci_2 = pci_2;
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
