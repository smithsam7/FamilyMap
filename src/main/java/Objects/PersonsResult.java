package Objects;

import java.util.ArrayList;

public class PersonsResult {
    private ArrayList<PersonModel> data;
    private String resultMess;
    private boolean success;

    public PersonsResult() {
    }

    public PersonsResult(ArrayList<PersonModel> data, String resultMess, boolean success) {
        this.data = data;
        this.resultMess = resultMess;
        this.success = success;
    }

    public ArrayList<PersonModel> getData() {
        return data;
    }

    public void setData(ArrayList<PersonModel> data) {
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
