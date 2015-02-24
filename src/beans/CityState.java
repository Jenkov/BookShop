package beans;

public class CityState implements java.io.Serializable{
    private int CityStateNo;
    private String State, City;

    public CityState() {
    }

    public String getCity() {
        return City;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public int getCityStateNo() {
        return CityStateNo;
    }

    public void setCityStateNo(int CityStateNo) {
        this.CityStateNo = CityStateNo;
    }

    public String getState() {
        return State;
    }

    public void setState(String State) {
        this.State = State;
    }
}