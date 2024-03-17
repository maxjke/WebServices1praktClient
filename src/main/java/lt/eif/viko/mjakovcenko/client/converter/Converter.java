package lt.eif.viko.mjakovcenko.client.converter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
//C:\Users\s047180\Desktop\Client\jdk8u402-b06\bin\xjc.exe -d C:\Users\s047180\Desktop\Client\src\main\java\lt\eif\viko\mjakovcenko\client\ -p model C:\Users\s047180\Desktop\Client\client.xsd
public class Converter {
    public static void convertoToPojoFromXsd() {
        try {

            String command = "C:\\Users\\s047180\\Desktop\\Client\\jdk8u402-b06\\bin\\xjc.exe -d C:\\Users\\s047180\\Desktop\\Client\\src\\main\\java\\lt\\eif\\viko\\mjakovcenko\\client\\model -p lt.eif.viko.mjakovcenko.client.model C:\\Users\\s047180\\Desktop\\Client\\client.xsd";


            Process process = Runtime.getRuntime().exec(command);


            int exitCode = process.waitFor();
            System.out.println("XJC process exited with code " + exitCode);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }


}
