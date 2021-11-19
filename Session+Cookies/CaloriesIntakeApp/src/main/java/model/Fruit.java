
package model;

/**
 *
 * @author Shahed
 */
public class Fruit {
    private String id;
    private String name;
    private int grms;
    private int calories;
    private String photo;

    public Fruit(String id, String name, int grms, int calories, String photo) {
        this.id = id;
        this.name = name;
        this.grms = grms;
        this.calories = calories;
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "Fruit{" + "id=" + id + ", name=" + name + ", grms=" + grms + ", calories=" + calories + ", photo=" + photo + '}';
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getGrms() {
        return grms;
    }

    public int getCalories() {
        return calories;
    }

    public String getPhoto() {
        return photo;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGrms(int grms) {
        this.grms = grms;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
    
    
    
}
