package Objects;

import java.io.*;
import java.net.*;

/*
	The Client class shows how to call a web API operation from
	a Java program.  This is typical of how your Android client
	app will call the web API operations of your server.
*/
public class HttpClient {

    public static PersonsResult getPeople(String urls, String reqdata) {
        try {
            URL url = new URL(urls);

            HttpURLConnection http = (HttpURLConnection)url.openConnection();

            http.setRequestMethod("GET");

            http.setDoOutput(false);

            http.addRequestProperty("Authorization", ClientModel.getInstance().getAuthToken());


            http.addRequestProperty("Accept", "application/json");

            http.connect();

            if (http.getResponseCode() == HttpURLConnection.HTTP_OK) {
                Reader reader = new InputStreamReader(http.getInputStream());
                PersonsResult personsResult = Decoder.decodePersonsResult(reader);
                personsResult.setSuccess(true);
                personsResult.setResultMess(http.getResponseMessage());
                http.getInputStream().close();
                return personsResult;
            }
            else {
                PersonsResult personsResult = new PersonsResult();
                personsResult.setSuccess(false);
                personsResult.setResultMess(http.getResponseMessage());
                return personsResult;
            }
        }
        catch (IOException e) {
            PersonsResult personsResult = new PersonsResult();
            e.printStackTrace();
            personsResult.setResultMess(e.toString());
            return personsResult;
        }
    }

    public static EventsResult getEvents(String urls, String reqdata) {
        try {
            URL url = new URL(urls);

            HttpURLConnection http = (HttpURLConnection)url.openConnection();

            http.setRequestMethod("GET");

            http.setDoOutput(false);

            http.addRequestProperty("Authorization", ClientModel.getInstance().getAuthToken());


            http.addRequestProperty("Accept", "application/json");

            http.connect();

            if (http.getResponseCode() == HttpURLConnection.HTTP_OK) {
                Reader reader = new InputStreamReader(http.getInputStream());
                EventsResult eventsResult = Decoder.decodeEventsResult(reader);
                eventsResult.setSuccess(true);
                eventsResult.setResultMess(http.getResponseMessage());
                http.getInputStream().close();
                return eventsResult;
            }
            else {
                EventsResult eventsResult = new EventsResult();
                eventsResult.setSuccess(false);
                eventsResult.setResultMess(http.getResponseMessage());
                return eventsResult;
            }
        }
        catch (IOException e) {
            EventsResult eventsResult = new EventsResult();
            e.printStackTrace();
            eventsResult.setResultMess(e.toString());
            return eventsResult;
        }
    }

    public static LoginResult postLogin(String urls, String reqdata) {
        try {
            URL url = new URL(urls);

            HttpURLConnection http = (HttpURLConnection)url.openConnection();

            http.setRequestMethod("POST");

            http.setDoOutput(true);

            http.addRequestProperty("Accept", "application/json");

            http.connect();

            String reqData = reqdata;

            OutputStream reqBody = http.getOutputStream();

            writeString(reqData, reqBody);

            reqBody.close();

            if (http.getResponseCode() == HttpURLConnection.HTTP_OK) {
                Reader reader = new InputStreamReader(http.getInputStream());
                LoginResult loginResult = Decoder.decodeLoginResult(reader);
                loginResult.setSuccess(true);
                loginResult.setResultMess(http.getResponseMessage());
                http.getInputStream().close();
                return loginResult;
            }
            else{
                LoginResult loginResult = new LoginResult();
                loginResult.setSuccess(false);
                loginResult.setResultMess(http.getResponseMessage());
                return loginResult;
            }
        }
        catch (IOException e) {
            LoginResult loginResult = new LoginResult();
            e.printStackTrace();
            loginResult.setResultMess(e.toString());
            return loginResult;
        }
    }

    public static RegisterResult postRegister(String urls, String reqdata) {
        try {
            URL url = new URL(urls);

            HttpURLConnection http = (HttpURLConnection)url.openConnection();

            http.setRequestMethod("POST");

            http.setDoOutput(true);

            http.addRequestProperty("Accept", "application/json");

            http.connect();

            String reqData = reqdata;

            OutputStream reqBody = http.getOutputStream();

            writeString(reqData, reqBody);

            reqBody.close();

            if (http.getResponseCode() == HttpURLConnection.HTTP_OK) {
                Reader reader = new InputStreamReader(http.getInputStream());
                RegisterResult registerResult = Decoder.decodeRegisterResult(reader);
                registerResult.setSuccess(true);
                registerResult.setResultMess(http.getResponseMessage());
                http.getInputStream().close();
                return registerResult;
            }
            else{
                RegisterResult registerResult = new RegisterResult();
                registerResult.setSuccess(false);
                registerResult.setResultMess(http.getResponseMessage());
                return registerResult;
            }
        }
        catch (IOException e) {
            RegisterResult registerResult = new RegisterResult();
            e.printStackTrace();
            registerResult.setResultMess(e.toString());
            return registerResult;
        }
    }




    private static String readString(InputStream is) throws IOException {
        StringBuilder sb = new StringBuilder();
        InputStreamReader sr = new InputStreamReader(is);
        char[] buf = new char[1024];
        int len;
        while ((len = sr.read(buf)) > 0) {
            sb.append(buf, 0, len);
        }
        return sb.toString();
    }

    private static void writeString(String str, OutputStream os) throws IOException {
        OutputStreamWriter sw = new OutputStreamWriter(os);
        sw.write(str);
        sw.flush();
    }

}