import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Client {

    private static final String SERVER_URL = "http://localhost:8000";

    public static void main(String[] args) throws Exception {
        post("Alice");
        getByName("Alice");
        getAllByName();
        getByAddress();
    }

    public static void post(String name) throws Exception {
        URL url = new URL(SERVER_URL + "/post?name=" + name);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);

        OutputStream os = connection.getOutputStream();
        os.flush();
        os.close();

        System.out.println("POST Response: " + readResponse(connection));
    }

    public static void getByName(String name) throws Exception {
        URL url = new URL(SERVER_URL + "/getByName?name=" + name);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        System.out.println("GET by Name Response: " + readResponse(connection));
    }

    public static void getAllByName() throws Exception {
        URL url = new URL(SERVER_URL + "/getAllByName");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        System.out.println("GET All by Name Response: " + readResponse(connection));
    }

    public static void getByAddress() throws Exception {
        URL url = new URL(SERVER_URL + "/getByAddress");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        System.out.println("GET by Address Response: " + readResponse(connection));
    }

    private static String readResponse(HttpURLConnection connection) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuilder content = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        return content.toString();
    }
}
