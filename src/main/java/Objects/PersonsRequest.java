package Objects;

public class PersonsRequest {
    private String authTokenUser;

    public PersonsRequest() {
    }

    public PersonsRequest(String authTokenUser) {
        this.authTokenUser = authTokenUser;
    }

    public String getAuthTokenUser() {
        return authTokenUser;
    }

    public void setAuthTokenUser(String authTokenUser) {
        this.authTokenUser = authTokenUser;
    }
}
