import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Map;

public class ProcessBuilderExample {
  public static void main(String[] args) throws IOException {
    ProcessBuilder builder = new ProcessBuilder("./test-script.js");

    Map<String, String> environment = builder.environment();
    environment.put("SERVER_PROTOCOL", "HTTP/1.1");

    Process process = builder.start();

    BufferedWriter writer = new BufferedWriter(
        new OutputStreamWriter(process.getOutputStream()));
    writer.write("42");

    BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

    String response = "200 OK HTTP/1.1\r\nServer: Roberts, Roberts\r\nDate: krglkadfg\r\n";

    String line;
    while ((line = reader.readLine()) != null) {
      response = response + line + "\r\n";
    }

    System.out.println(response);
  }
}