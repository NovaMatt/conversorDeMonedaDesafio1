package modulos;




import com.google.gson.Gson;

import io.github.cdimascio.dotenv.Dotenv;


import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;


public class ApiRequest {
    

    public HashMap<String, Float> getMoneda()  {
        Dotenv dotenv = Dotenv.load();
        String APIKEY = dotenv.get("APIKEY");
        String url = "https://v6.exchangerate-api.com/v6/"+APIKEY+"/latest/USD";

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();


        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();
            Gson gson = new Gson();
            Moneda moneda = gson.fromJson(json, Moneda.class);
            return moneda.conversion_rates();
        }catch (Exception e){
            System.out.println("Hubo un error al hacer la petición");
            return null;
        }

    }
}
