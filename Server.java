import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

class TweetServerMain {
    static SampleTweets sample = new SampleTweets();
    static TweetServer ts = new TweetServer(sample.t, sample.users);
    
    public static void main(String[] args) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        server.createContext("/tweets", new MyHandler());
        server.createContext("/tweetstyle.css", new CSSHandler());
        server.start();
    }

    static class CSSHandler implements HttpHandler {
      @Override
      public void handle(HttpExchange t) throws IOException {

        try {
          byte[] styleFile = Files.readAllBytes(Paths.get("tweetstyle.css"));
          t.sendResponseHeaders(200, styleFile.length);
          OutputStream os = t.getResponseBody();
          os.write(styleFile);
          os.close();
        }
        catch(Exception e) {
          System.err.println("Error: " + e);
        }
      }
    }

    static class MyHandler implements HttpHandler {
      @Override
      public void handle(HttpExchange t) throws IOException {
        try {
          String response = TweetServerMain.ts.getTweetsHTML(t.getRequestURI().toString());
          t.sendResponseHeaders(200, response.getBytes().length);
          OutputStream os = t.getResponseBody();
          os.write(response.getBytes());
          os.close();
        }
        catch(Exception e) {
          System.err.println("Error: " + e);
        }
      }
    }

}
