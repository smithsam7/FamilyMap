package Objects;

import com.google.gson.Gson;

import java.util.ArrayList;

public class Proxy {

//    1. encode the request data to json
//	2. send the json to the server (with path for service)
//	3. decode the response data from json

    public Proxy(){}

    public LoginResult login(LoginRequest loginRequest){
        String url = "http://" + ClientModel.getInstance().getServerHost() + ":" + ClientModel.getInstance().getServerPort() + "/user/login";
        String reqData = Encoder.encode(loginRequest);
        HttpClient httpClient = new HttpClient();
        LoginResult loginResult  = httpClient.postLogin(url, reqData);
        sync(loginResult.getUsername(), loginResult.getAuthToken(), loginResult.getPerson_id());
        return loginResult;
    }


    public RegisterResult register(RegisterRequest registerRequest){
        String url = "http://" + ClientModel.getInstance().getServerHost() + ":" + ClientModel.getInstance().getServerPort() + "/user/register";
        String reqData = Encoder.encode(registerRequest);
        HttpClient httpClient = new HttpClient();
        RegisterResult registerResult = httpClient.postRegister(url, reqData);
        sync(registerResult.getUsername(), registerResult.getAuthtoken(), registerResult.getPerson_id());
        return registerResult;
    }


    public void getPeople(){
        ArrayList<PersonModel> people = new ArrayList<>();
        String url = "http://" + ClientModel.getInstance().getServerHost() + ":" + ClientModel.getInstance().getServerPort() + "/person";
        PersonsRequest personsRequest = new PersonsRequest();
        personsRequest.setAuthTokenUser(ClientModel.getInstance().getAuthToken());
        String reqData = Encoder.encode(personsRequest);
        HttpClient httpClient = new HttpClient();
        PersonsResult personsResult = httpClient.getPeople(url, reqData);
        ClientModel.getInstance().setPeople(personsResult.getData());
    }

    public void getEvents(){
        ArrayList<EventModel> events = new ArrayList<>();
        String url = "http://" + ClientModel.getInstance().getServerHost() + ":" + ClientModel.getInstance().getServerPort() + "/event";
        EventsRequest eventsRequest = new EventsRequest();
        eventsRequest.setAuthTokenUser(ClientModel.getInstance().getAuthToken());
        String reqData = Encoder.encode(eventsRequest);
        HttpClient httpClient = new HttpClient();
        EventsResult eventsResult = httpClient.getEvents(url, reqData);
        ClientModel.getInstance().setEvents(eventsResult.getData());
    }

    public void sync(String username, String authToken, String personID){
        ClientModel.getInstance().setUserName(username);
        ClientModel.getInstance().setAuthToken(authToken);
        ClientModel.getInstance().setPersonID(personID);
    }


}
