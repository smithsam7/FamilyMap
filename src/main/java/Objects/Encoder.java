package Objects;

import com.google.gson.Gson;

public class Encoder {


    public Encoder(){}

    public static String encode(Object result){
        Gson gson = new Gson();
        String json = gson.toJson(result);
        return json;
    }

}
