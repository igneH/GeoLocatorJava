package windows;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class APICall {
    private String ip;
    public APICall(String ip) {
        this.ip = ip;
    }

    public String getGeoLocation(){
        try {
            HttpRequest getRequest = HttpRequest.newBuilder()
                    .uri(new URI("https://ipinfo.io/"+ip+"/json"))
                    .GET()
                    .build();

            HttpClient httpClient = HttpClient.newHttpClient();

            HttpResponse<String> getResponse = httpClient.send(getRequest, HttpResponse.BodyHandlers.ofString());

            System.out.println(getResponse.body());

            return getResponse.body();
        } catch (URISyntaxException | IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
