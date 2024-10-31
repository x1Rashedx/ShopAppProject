package Objects;

public class Address {
    private String Country;
    private String city;
    private String postalCode;
    private String AdditionalInfo;


    public void setCountry(String country) {
        Country = country;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public void setAdditionalInfo(String additionalInfo) {
        AdditionalInfo = additionalInfo;
    }

    public String getCountry() {
        return Country;
    }

    public String getCity() {
        return city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getAdditionalInfo() {
        return AdditionalInfo;
    }





}
