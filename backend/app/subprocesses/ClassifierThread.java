package subprocesses;

import java.io.*;
import java.util.Map;
import java.util.Scanner;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class ClassifierThread {

    public static Double runClassifier(JsonNode data) {
        try {

            ProcessBuilder pb = new ProcessBuilder("python3", "magic.py");
            Map<String, String> env = pb.environment();
            //pb.directory(new File("/root/classifier"));
            pb.directory(new File("/root/classifier"));
            pb.redirectErrorStream(true);
            Process process = pb.start();
            PrintWriter pw = new PrintWriter(process.getOutputStream());
            pw.write(data.toString());
            pw.close();
            process.getOutputStream().close();
            BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String str = in.readLine();
            System.out.println(str);
            //Scanner s = new Scanner(process.getInputStream());
            //String str = s.nextLine();
            return Double.parseDouble(str);
        } catch (IOException e) {e.printStackTrace();}
        return 0.0;
    }

}
