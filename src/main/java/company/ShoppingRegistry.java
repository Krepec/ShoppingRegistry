package company;

import javax.security.auth.login.FailedLoginException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by laptop on 29.09.17.
 */
public class ShoppingRegistry {

    public void addData(String name,String price) throws IOException{
        FileWriter fileWriter = new FileWriter("Registry", true);  // true jes potrzebny zeby nie czyscic pliku i miec mozliwosc dodawania innych lini
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write("Nazwa: " +name +"  " + "Cena: " + price+"\n");
        bufferedWriter.close();
        fileWriter.close();
    }

    public Double totalPrice() throws FileNotFoundException, IOException {

        FileReader fileReader = new FileReader("Registry");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

       Double total = 0.0;
        String a;
        while ((a = bufferedReader.readLine()) != null ){
            String price = a.substring(a.lastIndexOf(" "));
            total +=Double.valueOf(price);

        }
        return total;
    }
}
