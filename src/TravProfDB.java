
import java.io.*;
import java.util.*;

public class TravProfDB {
    private int _numTravelers;
    private int _currentTravelerIndex = 0;
    private String _fileName;
    public ArrayList<TravelProf> _travelerList = new ArrayList<TravelProf>();

    public TravProfDB(String fileName) {
        this._fileName = fileName;
        this._numTravelers = this._travelerList.size();
    }

    public void insertNewProfile(TravelProf traveler) {
        this._travelerList.add(traveler);
        this._numTravelers = _travelerList.size();
        this._currentTravelerIndex = _numTravelers;
    }

    public boolean deleteProfile(String travAgentID, String lastName) {
        TravelProf profile = findProfile(travAgentID, lastName);
        if (profile != null) {
            this._travelerList.remove(profile);
            this._numTravelers = this._travelerList.size();
            return true;
        }
        return false;
    }

    public TravelProf findProfile(String _travAgentID, String _lastName) {
        String travAgentID;
        String lastName;
        TravelProf prof = null;
        for (int i = 0; i < this._numTravelers; i++) {
            prof = this._travelerList.get(i);
            travAgentID = prof.gettravAgentID();
            lastName = prof.getLastName();
            if (travAgentID.equals(_travAgentID) && lastName.equals(_lastName)) {
                return prof;

            }
        }
        return null;
    }

    public TravelProf findFirstProfile() {
        if (this._travelerList.size() == 0) {
            return null;
        }
        return this._travelerList.get(0);
    }

    public TravelProf findNextProfile() {
        this._currentTravelerIndex += 1;
        //return null
        if (this._currentTravelerIndex >= this._travelerList.size()) {
            this._currentTravelerIndex = 0; //reset index
            return null;
        }
        return this._travelerList.get(this._currentTravelerIndex);
    }

    public void writeAllTravProf(String _fileName) throws Exception {
        try {
            FileOutputStream writeData = new FileOutputStream(_fileName + ".ser");
            ObjectOutputStream writeStream = new ObjectOutputStream(writeData);

            writeStream.writeObject(this._travelerList);
            writeStream.flush();
            writeStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void initializeDatabase(String fileName) throws Exception {
        System.out.println("Initializing Database");
        try {
            FileInputStream readData = new FileInputStream(fileName + ".ser");
            ObjectInputStream readStream = new ObjectInputStream(readData);

            this._travelerList = (ArrayList<TravelProf>) readStream.readObject();
            this._numTravelers = _travelerList.size();
            readStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}