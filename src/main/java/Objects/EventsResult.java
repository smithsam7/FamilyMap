package Objects;

import java.util.ArrayList;

public class EventsResult {
    private ArrayList<EventModel> data;
    private String resultMess;
    private boolean success;


    public EventsResult() {
    }

    public EventsResult(ArrayList<EventModel> data, String resultMess, boolean success) {
        this.data = data;
        this.resultMess = resultMess;
        this.success = success;
    }

    public ArrayList<EventModel> getData() {
        return data;
    }

    public void setData(ArrayList<EventModel> data) {
        this.data = data;
    }

    public String getResultMess() {
        return resultMess;
    }

    public void setResultMess(String resultMess) {
        this.resultMess = resultMess;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
