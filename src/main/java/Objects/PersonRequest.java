package Objects;

public class PersonRequest {
    private String personID;

    public PersonRequest() {
    }

    public PersonRequest(String person_id) {
        this.personID = person_id;
    }

    public String getPerson_id() {
        return personID;
    }

    public void setPerson_id(String person_id) {
        this.personID = person_id;
    }
}
