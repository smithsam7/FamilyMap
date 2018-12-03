package Objects;

public class EventRequest {

    private String eventID;


    public EventRequest() {
    }

    public EventRequest(String event_id) {
        this.eventID = event_id;
    }


    public String getEvent_id() {
        return eventID;
    }

    public void setEvent_id(String event_id) {
        this.eventID = event_id;
    }
}


