import java.io.Serializable;

public class TravelProf implements Serializable {
    private String travAgentID;
    private String firstName;
    private String lastName;
    private String address;
    private String phone;
    private float tripCost;
    private String travelType;
    private String paymentType;
    private MedCond medCondInfo;


    public TravelProf(String travAgentID, String firstName, String lastName, String address,
                      String phone, float tripCost, String travelType, String paymentType, MedCond medCondInfo) {
        this.travAgentID = travAgentID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
        this.tripCost = tripCost;
        this.travelType = travelType;
        this.paymentType = paymentType;
        this.medCondInfo = medCondInfo;
    }

    public String gettravAgentID() {
        return this.travAgentID;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public  String getAddress() {
        return this.address;
    }

    public String getPhone() {
        return this.phone;
    }

    public float getTripCost() {
        return this.tripCost;
    }

    public String getTravelType() {
        return this.travelType;
    }

    public String getPaymentType() {
        return this.paymentType;
    }

    public MedCond getMedCondInfo() {
        return this.medCondInfo;
    }

    public void updateFirstName(String newFirstName) {
        this.firstName = newFirstName;
    }

    public void updateLastName(String newLastName) {
        this.lastName = newLastName;
    }

    public void updateAddress(String newAddress) {
        this.address = newAddress;
    }

    public void updatePhone(String newPhone) {
        this.phone = newPhone;
    }

    public void updateTripCost(float newCost) {
        this.tripCost = newCost;
    }

    public void updateTravelType(String newTravelType) {
        this.travelType = newTravelType;
    }

    public void updatePaymentType(String newPaymentType) {
        this.paymentType = newPaymentType;
    }

    public void updateMedCondInfo(MedCond newMedCond) {
        this.medCondInfo = newMedCond;
    }
}