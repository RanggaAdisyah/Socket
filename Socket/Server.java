import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;

public class Server {

    private static Map<String, String> dataStore = new HashMap<>();

    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        server.createContext("/post", new PostHandler());
        server.createContext("/getByName", new GetByNameHandler());
        server.createContext("/getAllByName", new GetAllByNameHandler());
        server.createContext("/getByAddress", new GetByAddressHandler());
        server.setExecutor(null);
        server.start();
        System.out.println("Server started on port 8000");
    }

    static class PostHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            if ("POST".equals(exchange.getRequestMethod())) {
                String name = exchange.getRequestURI().getQuery().split("=")[1];
                dataStore.put(name, "Sample Data for " + name);
                String response = "Data for " + name + " added.";
                exchange.sendResponseHeaders(200, response.getBytes().length);
                OutputStream os = exchange.getResponseBody();
                os.write(response.getBytes());
                os.close();
            }
        }
    }

    static class GetByNameHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String name = exchange.getRequestURI().getQuery().split("=")[1];
            String response = dataStore.getOrDefault(name, "Name not found");
            exchange.sendResponseHeaders(200, response.getBytes().length);
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }

    static class GetAllByNameHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            StringBuilder response = new StringBuilder("All data:\n");
            dataStore.forEach((k, v) -> response.append(k).append(": ").append(v).append("\n"));
            exchange.sendResponseHeaders(200, response.toString().getBytes().length);
            OutputStream os = exchange.getResponseBody();
            os.write(response.toString().getBytes());
            os.close();
        }
    }

    static class GetByAddressHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String response = "Device Address: " + exchange.getRemoteAddress().toString();
            exchange.sendResponseHeaders(200, response.getBytes().length);
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }
}
