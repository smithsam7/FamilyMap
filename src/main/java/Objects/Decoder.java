package Objects;

import com.google.gson.Gson;

import java.io.Reader;

public class Decoder {

    public Decoder(){}

    public static LoginRequest decodeLoginRequest(Reader json){
        LoginRequest request;
        Gson gson = new Gson();
        request = gson.fromJson(json, LoginRequest.class);
        return request;
    }

    public static LoginResult decodeLoginResult(Reader json){
        LoginResult result;
        Gson gson = new Gson();
        result = gson.fromJson(json, LoginResult.class);
        return result;
    }

    public static RegisterResult decodeRegisterResult(Reader json){
        RegisterResult result;
        Gson gson = new Gson();
        result = gson.fromJson(json, RegisterResult.class);
        return result;
    }

    public static PersonsResult decodePersonsResult(Reader json){
        PersonsResult result;
        Gson gson = new Gson();
        result = gson.fromJson(json, PersonsResult.class);
        return result;
    }

    public static EventsResult decodeEventsResult(Reader json){
        EventsResult result;
        Gson gson = new Gson();
        result = gson.fromJson(json, EventsResult.class);
        return result;
    }

}
