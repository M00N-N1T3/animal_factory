package wethinkcode.util;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

public class StdoutReader {
    private final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    private final PrintStream defaultStream = System.out;
    private final PrintStream outputStream = new PrintStream(byteArrayOutputStream);


    public void captureOutput(){
        setCustomOutputStream();
    }


    private void setCustomOutputStream(){
        System.setOut(outputStream);
    }

    public byte[] getOutputAsByteArray(){
        resetOutputStream();
        return byteArrayOutputStream.toByteArray();
    }

    public String getOutputAsText(){
        resetOutputStream();
        return byteArrayOutputStream.toString(StandardCharsets.UTF_8);
    }

    private void resetOutputStream(){
        System.out.flush();
        System.setOut(defaultStream);
    }

    public void closeOutputStream(){
        resetOutputStream();
    }


}
