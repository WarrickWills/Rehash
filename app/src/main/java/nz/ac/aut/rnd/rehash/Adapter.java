package nz.ac.aut.rnd.rehash;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.alamkanak.weekview.WeekViewEvent;

import java.util.List;

/**
 * Created by Stanton on 13/05/2016.
 * Version 1.0
 */
public class Adapter extends ArrayAdapter<WeekViewEvent> {
    private Context aContext;
    private int aResource;
    private final List<WeekViewEvent> tasks;

    public Adapter(Context context, int resource, List<WeekViewEvent> newTask) {
        super(context, resource, newTask);
        this.aContext = context;
        this.aResource = resource;
        this.tasks = newTask;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;

        if (view == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(getContext());
            view = layoutInflater.inflate(aResource, null);
        }

        WeekViewEvent task = tasks.get(position);

        if (task != null) {
            TextView item_title = (TextView) view.findViewById(R.id.item_title);
            TextView item_shortDesc = (TextView) view.findViewById(R.id.item_shortDesc);
            /** Set data to your Views. */
            item_title.setText(task.getName());
            item_shortDesc.setText("Start Time : "+task.getStartTime().getTime().toString()+
                                    "\nEnd Time : "+task.getEndTime().getTime().toString());
        }

        return view;
    }

    protected static class ViewHolder {
        protected TextView item_title;
        protected TextView item_shortDesc;
    }
}
