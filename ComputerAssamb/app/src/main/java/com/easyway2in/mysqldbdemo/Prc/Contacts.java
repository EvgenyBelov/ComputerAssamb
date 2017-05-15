package com.easyway2in.mysqldbdemo.Prc;

/**
 * Created by Evgeny on 07.05.2017.
 */

public class Contacts {
    private String name, socket, core, freq, cache, cache_two, cache_thr, power, url, url_img;

    public Contacts(String name, String socket, String core, String freq, String cache, String cache_two,
                    String cache_thr, String power, String url, String url_img) {
        this.setName(name);
        this.setSocket(socket);
        this.setCore(core);
        this.setFreq(freq);
        this.setCache(cache);
        this.setCache_two(cache_two);
        this.setCache_thr(cache_thr);
        this.setPower(power);
        this.setUrl(url);
        this.setUrl_img(url_img);

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

    public String getCore() {
        return core;
    }

    public void setCore(String core) {
        this.core = core;
    }

    public String getFreq() {
        return freq;
    }

    public void setFreq(String freq) {
        this.freq = freq;
    }

    public String getCache() {
        return cache;
    }

    public void setCache(String cache) {
        this.cache = cache;
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

    public String getCache_two() {
        return cache_two;
    }

    public void setCache_two(String cache_two) {
        this.cache_two = cache_two;
    }

    public String getCache_thr() {
        return cache_thr;
    }

    public void setCache_thr(String cache_thr) {
        this.cache_thr = cache_thr;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }
}
