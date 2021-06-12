package services;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import model.BC;

public class BCServices {

    private static File file = null;
    private static ArrayList<BC> bCA = new ArrayList<BC>();

    public static void loadFile() throws FileNotFoundException, IOException {
        file = new File("C:\\Users\\DELL\\OneDrive - Philadelphia University\\Desktop\\NetBeansProjects\\BC2\\src\\main\\webapp\\WEB-INF\\data\\bc.txt");

        //create inputStream obj
        try (BufferedReader inputStream = new BufferedReader(new FileReader(file))) {
            String line;
            //read each line 
            while ((line = inputStream.readLine()) != null) {
//split the line 
                String[] pieces = line.split(" ");
//get the data with it's appropriate value
                int id = Integer.parseInt(pieces[0]);
                String name = pieces[1];
                String tel = pieces[2];
//create the model object
                BC bc = new BC(id, name, tel);
//add model object to the ArratList
                bCA.add(bc);

            }
        }
    }

    public static ArrayList<BC> read() {

        return bCA;
    }

    public static BC read(int id) {
        BC bc = null;

        for (BC x : bCA) {
            if (x.getId() == id) {
                bc = x;
                break; //no need to cont the loop
            }

        }
        return bc;
    }

    private static boolean isExisit(BC bc) {

        //return ( bCA.contains(bc)) ;
        boolean flag = false;
        for (BC x : bCA) {
            if (x.getName().equals(bc.getName()) && x.getTel().equals(bc.getTel())) {

                flag = true;
                bc.setId(x.getId());
                break;
            }
        }
        return flag;
    }

    private static int getNewCardId() {

        return (bCA.size() + 1);

    }

    public static BC create(String name, String tel) {
        BC newCard = new BC(-1, name, tel);
        if (!isExisit(newCard)) {
            //if card does not exisit before, create new id for it 
            newCard.setId(getNewCardId());
            //add it to the list
            bCA.add(newCard);
        }
        return newCard;
    }
    
    
    public static boolean delete(int id) {
        boolean flag = false;
      //  BC bcToDelete = null;
        for (BC bc : bCA) {
            if (id == bc.getId()) {
                flag = true;
                bCA.remove(bc);
                break;
            }
        }
      /*  if (bcToDelete != null) {
            //we deleted it from the vector, not from db
            bCA.remove(bcToDelete);
        }*/
        return flag;
    }
    
    public static boolean update(BC bc) {
        boolean flag = false;
        for (BC x : bCA) {
            if (x.getId() == bc.getId()) {
                x.setName(bc.getName());
                x.setTel(bc.getTel());
                flag = true;
                break;
            }

        }

        return flag;
    }
    public static void save() throws IOException {
        file = new File("C:\\Users\\DELL\\OneDrive - Philadelphia University\\Desktop\\NetBeansProjects\\BC2\\src\\main\\webapp\\WEB-INF\\data\\bc.txt");

        try (PrintWriter outputStream = new PrintWriter(new BufferedWriter(new FileWriter(file)))) {
            for (BC x : bCA) {
                outputStream.println(x.getId() + " " + x.getName() + " " + x.getTel());
            }

        }

    }

    public static void main(String[] arg) throws IOException {
        loadFile();
    //  BC bb=  create("Neema", "12345678");
     //boolean bb=delete(6);
         //System.out.println(bb.getName());
        //for (BC x : bb) {
     // System.out.println(bb);
        //   }

    }
}
