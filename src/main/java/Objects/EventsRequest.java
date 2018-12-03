package Objects;

public class EventsRequest {
    private String authTokenUser;

    public EventsRequest() {
    }

    public EventsRequest(String authTokenUser) {
        this.authTokenUser = authTokenUser;
    }

    public String getAuthTokenUser() {
        return authTokenUser;
    }

    public void setAuthTokenUser(String authTokenUser) {
        this.authTokenUser = authTokenUser;
    }

}
