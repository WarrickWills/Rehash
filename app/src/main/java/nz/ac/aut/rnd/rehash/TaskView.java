package nz.ac.aut.rnd.rehash;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.alamkanak.weekview.WeekViewEvent;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class TaskView extends AppCompatActivity {

    private List<WeekViewEvent> events = new ArrayList<>();
    private Adapter customAdapter;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_view);

        Firebase firebaseRef = new Firebase("https://rehashaut.firebaseio.com/");

        Firebase ref = new Firebase("https://rehashaut.firebaseio.com/").child(firebaseRef.getAuth().getUid()).child("stateChart");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                events= new ArrayList<WeekViewEvent>();
                int i = 1;
                for (DataSnapshot postSnapshot : snapshot.getChildren()) {

                    String title = postSnapshot.child("title").getValue().toString();

                    Calendar startCal = Calendar.getInstance();
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.US);
                    try {
                        startCal.setTime(sdf.parse(postSnapshot.child("startDate").getValue().toString() + " " + postSnapshot.child("startTime").getValue().toString()));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }

                    Calendar endCal = Calendar.getInstance();
                    try {
                        endCal.setTime(sdf.parse(postSnapshot.child("endDate").getValue().toString() + " " + postSnapshot.child("endTime").getValue().toString()));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }

                    WeekViewEvent weekViewEvent = new WeekViewEvent(i,title,startCal,endCal);
                    events.add(weekViewEvent);
                }
                listView = (ListView) findViewById(R.id.task_view);
                customAdapter = new Adapter(TaskView.this, R.layout.task_item, events);
                listView.setAdapter(customAdapter);
                customAdapter.notifyDataSetChanged();
            }
            @Override
            public void onCancelled(FirebaseError firebaseError) {
                System.out.println("The read failed: " + firebaseError.getMessage());
            }
        });


    }
}
