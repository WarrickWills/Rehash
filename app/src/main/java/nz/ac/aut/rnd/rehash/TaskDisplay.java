package nz.ac.aut.rnd.rehash;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stanton on 13/05/2016.
 * Version 1.0
 */
public class TaskDisplay  extends Activity {
    private List<Task> task = new ArrayList<>();
    private Adapter customAdapter;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.taskdisplay_main);

        Task task1 = new Task("Task 1", "Eat a dick");
        Task task2 = new Task("Task 2", "Eat a pill");
        task.add(task1);
        task.add(task2);

        listView = (ListView) findViewById(R.id.task_view);
        customAdapter = new Adapter(this, R.layout.task_item, task);
        listView.setAdapter(customAdapter);
        customAdapter.notifyDataSetChanged();
    }

}
