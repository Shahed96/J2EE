package Services;

import Controllers.BCController;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import model.BusninessCard;

public class BCServices {

    private static File file = null;
    private static ArrayList<BusninessCard> bCA = new ArrayList<BusninessCard>();

    public static void loadFile() throws FileNotFoundException, IOException {
        file = new File("C:\\Users\\DELL\\OneDrive - Philadelphia University\\Desktop\\NetBeansProjects\\BC\\src\\main\\webapp\\WEB-INF\\data\\bc.txt");

        try (BufferedReader inputStream = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = inputStream.readLine()) != null) {

                String[] pieces = line.split(" ");

                int id = Integer.parseInt(pieces[0]);
                String name = pieces[1];
                String tel = pieces[2];

                BusninessCard bc = new BusninessCard(id, name, tel);

                bCA.add(bc);

            }
        }
    }

    public static ArrayList<BusninessCard> read() {

        return bCA;
    }

    public static BusninessCard read(int id) {
        BusninessCard bc = null;

        for (BusninessCard x : bCA) {
            if (x.id == id) {
                bc = x;
                break;
            }

        }
        return bc;
    }

    private static boolean isExisit(BusninessCard bc) {

        //return ( bCA.contains(bc)) ;
        boolean flag = false;
        for (BusninessCard x : bCA) {
            if (x.name.equals(bc.name) && x.tel.equals(bc.tel)) {

                flag = true;
                bc.id = x.id;
                break;
            }
        }
        return flag;
    }

    private static int getNewCardId() {

        return (bCA.size() + 1);

    }

    public static BusninessCard create(String name, String tel) {
        BusninessCard newCard = new BusninessCard(-1, name, tel);
        if (!isExisit(newCard)) {
            //if card does not exisit before, create new id for it 
            newCard.id = getNewCardId();
            //add it to the list
            bCA.add(newCard);
        }
        return newCard;
    }

    public static boolean delete(int id) {
        boolean flag = false;
        BusninessCard bcToDelete = null;
        for (BusninessCard bc : bCA) {
            if (id == bc.id) {
                flag = true;
                bcToDelete = bc;
                break;
            }
        }
        if (bcToDelete != null) {
            //we deleted it from the vector, not from db
            bCA.remove(bcToDelete);
        }
        return flag;
    }

    public static boolean update(BusninessCard bc) {
        boolean flag = false;
        for (BusninessCard x : bCA) {
            if (x.id == bc.id) {
                x.name = bc.name;
                x.tel = bc.tel;
                flag = true;
                break;
            }

        }

        return flag;
    }

    public static void save() throws IOException {
        file = new File("C:\\Users\\DELL\\OneDrive - Philadelphia University\\Desktop\\NetBeansProjects\\BC\\src\\main\\webapp\\WEB-INF\\data\\bc.txt");

        try (PrintWriter outputStream = new PrintWriter(new BufferedWriter(new FileWriter(file)))) {
            for (BusninessCard x : bCA) {
                outputStream.println(x.id + " " + x.name + " " + x.tel);
            }

        }

    }

     public static void main(String []arg) throws IOException{
    loadFile();
    update(new BusninessCard(1, "shosho" ,"uuuuu"));
    save();
  //  System.out.println();
    
    
    }
}
