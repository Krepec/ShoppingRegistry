import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import company.ShoppingRegistry;

import java.io.*;

import static org.junit.Assert.assertEquals;
/**
 * Created by laptop on 04.10.17.
 */
public class ShoppingRegistryTest {
    @org.junit.Test
    public void shouldAddData() throws IOException{
        // given - przygotowanie do testów
        ShoppingRegistry shoppingRegistry = new ShoppingRegistry();

        //when - wywołanie fukcji którą testujemy
        shoppingRegistry.addData("woda", "2.0");

        //then - asercja(sprawdzenie )
        File file = new File("Registry"); // mozemy uzyc sciezki posredniej ("Registy") wowczas osoba która sklonuje moj projekt z gita to mu zadziala lub bezposredniej "/home/itp/../Registy" ale nie moze nie zadziałac bo bedzie inna struktura katalogów
        assert(file.exists());
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String result =  bufferedReader.readLine();
        assertEquals("Nazwa: woda  Cena: 2.0",result);

        //afterAll - czyscimy zasoby (pamięc,pliki,połączenia) po testach przez usunięcie pliku
        file.delete();



        }
        @org.junit.Test
        public void shouldSumAllProductPrices() throws IOException{

            //given
            File file = new File("Registry");
            ShoppingRegistry shoppingRegistry = new ShoppingRegistry();
            FileWriter fileWriter = new FileWriter(file,true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("Nazwa: woda Cena: 3.0");
            bufferedWriter.newLine();
            bufferedWriter.write("Nazwa: wóda Cena: 5.0");
            bufferedWriter.close();
            fileWriter.close();

            // when
            double y = shoppingRegistry.totalPrice();

            //then - asercja(sprawdzenie )
            assertEquals(8.0,  y, 0);

            //afterAll - czyscimy zasoby (pamięc,pliki,połączenia) po testach przez usunięcie pliku
            file.delete();


          //  IO - wejscie wyjscie testy na serwerach trwaja duzo dłuzej K
            // IO- operacje wrażliwe i mogą być wolne bo odwołujemy sie do zasobów zewnetrzych np pliki na serweach D
    }

}
