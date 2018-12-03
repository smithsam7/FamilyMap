package Objects;

public class RegisterResult {
    private String authtoken;
    private String username;
    private String person_id;

    private String resultMess;
    private boolean success;

    public RegisterResult(){
    }

    public RegisterResult(String authtoken, String username, String person_id, String resultMess, boolean success) {
        this.authtoken = authtoken;
        this.username = username;
        this.person_id = person_id;
        this.resultMess = resultMess;
        this.success = success;
    }

    public String getAuthtoken() {
        return authtoken;
    }

    public void setAuthtoken(String authtoken) {
        this.authtoken = authtoken;
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
