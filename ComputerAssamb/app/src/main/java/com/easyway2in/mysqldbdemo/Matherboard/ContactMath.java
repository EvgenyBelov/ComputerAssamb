package com.easyway2in.mysqldbdemo.Matherboard;

/**
 * Created by Evgeny on 11.05.2017.
 */

public class ContactMath {
    private String name, socket, memory, memory_max, pci_one, pci_two,
            vga, factor, sata, power, url, url_img, soc, nameprc, powerPRC;

    public ContactMath(String name, String socket, String memory, String memory_max, String pci_one, String pci_two,
                       String vga, String factor, String sata, String power, String url, String url_img, String soc, String nameprc,
                       String powerPRC) {
        this.setName(name);
        this.setSocket(socket);
        this.setMemory(memory);
        this.setMemory_max(memory_max);
        this.setPci_one(pci_one);
        this.setPci_two(pci_two);
        this.setVga(vga);
        this.setFactor(factor);
        this.setSata(sata);
        this.setPower(power);
        this.setUrl(url);
        this.setUrl_img(url_img);
        this.setSoc(soc);
        this.setNameprc(nameprc);
        this.setPowerPRC(powerPRC);
        this.setSoc(soc);

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

    public String getPci_one() {
        return pci_one;
    }

    public void setPci_one(String pci_one) {
        this.pci_one = pci_one;
    }

    public String getPci_two() {
        return pci_two;
    }

    public void setPci_two(String pci_two) {
        this.pci_two = pci_two;
    }

    public String getVga() {
        return vga;
    }

    public void setVga(String vga) {
        this.vga = vga;
    }

    public String getFactor() {
        return factor;
    }

    public void setFactor(String factor) {
        this.factor = factor;
    }

    public String getSata() {
        return sata;
    }

    public void setSata(String sata) {
        this.sata = sata;
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

    public String getSoc() {
        return soc;
    }

    public void setSoc(String soc) {
        this.soc = soc;
    }

    public String getNameprc() {
        return nameprc;
    }

    public void setNameprc(String nameprc) {
        this.nameprc = nameprc;
    }

    public String getPowerPRC() {
        return powerPRC;
    }

    public void setPowerPRC(String powerPRC) {
        this.powerPRC = powerPRC;
    }
}
