package Objects;

public class EventModel {
    private String eventID;
    private String descendant;
    private String personID;
    private Float latitude;
    private Float longitude;
    private String country;
    private String city;
    private String eventType;
    private int year;

    public EventModel() {
    }

    public EventModel(String event_id, String descendant, String person_id, float latitude, float longitude, String country, String city, String eventType, int year) {
        this.eventID = event_id;
        this.descendant = descendant;
        this.personID = person_id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.country = country;
        this.city = city;
        this.eventType = eventType;
        this.year = year;
    }

    public String getEvent_id() {
        return eventID;
    }

    public void setEvent_id(String event_id) {
        this.eventID = event_id;
    }

    public String getDescendant() {
        return descendant;
    }

    public void setDescendant(String descendant) {
        this.descendant = descendant;
    }

    public String getPerson_id() {
        return personID;
    }

    public void setPerson_id(String person_id) {
        this.personID = person_id;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
