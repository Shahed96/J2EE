
package model;


public class BusninessCard {
   public  int id;
   public  String name;
   public  String tel;

    public BusninessCard(int id, String name, String tel) {
        this.id = id;
        this.name = name;
        this.tel = tel;
    }
     public BusninessCard( String name, String tel) {
        this.name = name;
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "BusninessCard{" + "id=" + id + ", name=" + name + ", tel=" + tel + '}';
    }
    
   
}
