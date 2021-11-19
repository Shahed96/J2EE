package services;

import controller.FruitController;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import model.Fruit;

/**
 *
 * @author Shahed
 */
public class FruitServices {

    private static File file = null;
    private static ArrayList<Fruit> fruitList = new ArrayList<Fruit>();

    public static void loadFile() throws FileNotFoundException, IOException {
        file = new File("C:\\Users\\DELL\\OneDrive - Philadelphia University\\Desktop\\NetBeansProjects\\CaloriesIntakeApp\\src\\main\\webapp\\WEB-INF\\data\\data.txt");
      
        try (BufferedReader inputStream = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = inputStream.readLine()) != null) {

                String[] pieces = line.split(" ");
          
               String id = pieces[0];
                String name = pieces[1];
                int grms = Integer.parseInt(pieces[2]);
                int calories = Integer.parseInt(pieces[3]);
                String photo = pieces[4];

                Fruit f = new Fruit(id, name, grms, calories, photo);

                fruitList.add(f);

            }
        }
    }
    
    public static ArrayList<Fruit> read() {

        return fruitList;
    }
    
    public static Fruit read(String id) {
        Fruit f = null;

        for (Fruit x : fruitList) {
            if (x.getId().equals(id)) {
                f = x;
                break;
            }

        }
        return f;
    }
public static void main (String[]a) throws IOException{
loadFile();

       ArrayList<Fruit> read = read();
   System.out.println(read("1").toString()); 
}
}
