package Objects;

import java.util.UUID;

public class Address {
    private final UUID iD;
    private String country;
    private String city;
    private String postalCode;
    private String additionalInfo;

    Address(String iD, String country, String city, String postalCode, String additionalInfo) {
        this.iD = UUID.fromString(iD);
        this.country = country;
        this.city = city;
        this.postalCode = postalCode;
        this.additionalInfo = additionalInfo;
    }

    Address(String country, String city, String postalCode, String additionalInfo) {
        this.iD = UUID.randomUUID();
        this.country = country;
        this.city = city;
        this.postalCode = postalCode;
        this.additionalInfo = additionalInfo;
    }

    public void changeCountry(String country) {
        this.country = country;
    }

    public void changeCity(String city) {
        this.city = city;
    }

    public void changePostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public void changeAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }


    public UUID getId() {
        return iD;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }





}
