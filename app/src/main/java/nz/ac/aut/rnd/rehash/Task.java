package nz.ac.aut.rnd.rehash;

/**
 * Created by Stanton on 15/05/2016.
 */
public class Task {
    private String title;
    private String desc;

    public Task(String newTitle, String newDesc) {
        title = newTitle;
        desc = newDesc;
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }
}
