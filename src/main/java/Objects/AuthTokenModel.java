package Objects;

public class AuthTokenModel {
    private String authToken;
    private String userName;

    public AuthTokenModel() {
    }

    public AuthTokenModel(String authtoken, String username) {
        this.authToken = authtoken;
        this.userName = username;
    }

    public String getAuthtoken() {
        return authToken;
    }

    public void setAuthtoken(String authtoken) {
        this.authToken = authtoken;
    }

    public String getUsername() {
        return userName;
    }

    public void setUsername(String username) {
        this.userName = username;
    }

}
