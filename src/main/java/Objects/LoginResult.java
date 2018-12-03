package Objects;

public class LoginResult {
    private String authToken;
    private String username;
    private String person_id;

    private String resultMess;
    private boolean success = true;

    public LoginResult() {
    }

    public LoginResult(String authToken, String username, String person_id, String resultMess, boolean success) {
        this.authToken = authToken;
        this.username = username;
        this.person_id = person_id;
        this.resultMess = resultMess;
        this.success = success;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPerson_id() {
        return person_id;
    }

    public void setPerson_id(String person_id) {
        this.person_id = person_id;
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
