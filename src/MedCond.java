
import java.io.Serializable;

public class MedCond implements Serializable {
    private String _mdContact;
    private String _mdPhone;
    private String _algType;
    private String _illType;

    public MedCond(String mdContact, String mdPhone, String algType, String illType) {
        this._mdContact = mdContact;
        this._mdPhone = mdPhone;
        this._algType = algType;
        this._illType = illType;
    }

    public String getMdContact() {
        return this._mdContact;
    }
    public String getMdPhone(){
        return this._mdPhone;
    }
    public String getAlgType(){
        return this._algType;
    }
    public String getIllType(){
        return this._illType;
    }
    public void updateMdContact(String new_contact){
        this._mdContact = new_contact;
    }
    public void updateMdPhone(String new_phone){
        this._mdPhone = new_phone;
    }
    public void updateAlgType(String new_alg){
        this._algType = new_alg;
    }
    public void updateIllType(String new_ill){
        this._illType = new_ill;
    }

}