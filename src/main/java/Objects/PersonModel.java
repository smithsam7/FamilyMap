package Objects;

public class PersonModel {
    private String personID;
    private String descendant;
    private String firstName;
    private String lastName;
    private String gender;
    private String father;
    private String mother;
    private String spouse;

    public PersonModel() {
    }

    public PersonModel(String person_id, String descendant, String firstname, String lastname, String gender, String father, String mother, String spouse) {
        this.personID = person_id;
        this.descendant = descendant;
        this.firstName = firstname;
        this.lastName = lastname;
        this.gender = gender;
        this.father = father;
        this.mother = mother;
        this.spouse = spouse;
    }

    public PersonModel(String person_id, String descendant, String firstname, String lastname, String gender, String father, String mother) {
        this.personID = person_id;
        this.descendant = descendant;
        this.firstName = firstname;
        this.lastName = lastname;
        this.gender = gender;
        this.father = father;
        this.mother = mother;
    }

    public String getPerson_id() {
        return personID;
    }

    public void setPerson_id(String person_id) {
        this.personID = person_id;
    }

    public String getDescendant() {
        return descendant;
    }

    public void setDescendant(String descendant) {
        this.descendant = descendant;
    }

    public String getFirstname() {
        return firstName;
    }

    public void setFirstname(String firstname) {
        this.firstName = firstname;
    }

    public String getLastname() {
        return lastName;
    }

    public void setLastname(String lastname) {
        this.lastName = lastname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFather() {
        return father;
    }

    public void setFather(String father) {
        this.father = father;
    }

    public String getMother() {
        return mother;
    }

    public void setMother(String mother) {
        this.mother = mother;
    }

    public String getSpouse() {
        return spouse;
    }

    public void setSpouse(String spouse) {
        this.spouse = spouse;
    }
}
