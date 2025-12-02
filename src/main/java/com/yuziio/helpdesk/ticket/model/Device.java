package com.yuziio.helpdesk.ticket.model;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "devices")
public class Device {

    private String name;
    private int deviceNumber;
    private String snid;
    private String model;
    private int chargerNumber;

    public String getSnid() {
        return snid;
    }

    public void setSnid(String snid) {
        this.snid = snid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDeviceNumber() {
        return deviceNumber;
    }

    public void setDeviceNumber(int deviceNumber) {
        this.deviceNumber = deviceNumber;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getChargerNumber() {
        return chargerNumber;
    }

    public void setChargerNumber(int chargerNumber) {
        this.chargerNumber = chargerNumber;
    }
}
