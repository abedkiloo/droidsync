package com.abedkiloo.dev_abed.androidsync;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by dev-abed   on 3/2/17.
 */

public class NameAdapter extends ArrayAdapter<Name> {
    //storing all names in a list
    private List<Name> names;
    //context object
    private Context context;

    public NameAdapter(Context g_context, int g_resource, List<Name> g_Names) {
        super(g_context, g_resource,g_Names);
//        super(g_context, g_resource,g_Names);
        this.context = g_context;
        this.names = g_Names;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        //getting the layoutinflater
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        //getting listview itmes
        View listViewItem = inflater.inflate(R.layout.names, null, true);
        TextView textViewName = (TextView) listViewItem.findViewById(R.id.textViewName);
        ImageView imageViewStatus = (ImageView) listViewItem.findViewById(R.id.imageViewStatus);

        //getting the current name
        Name name = names.get(position);

        //setting the name to textview
        textViewName.setText(name.getName());

        //if the synced status is 0 displaying
        //queued icon
        //else displaying synced icon
        if (name.getStatus() == 0)
            imageViewStatus.setBackgroundResource(R.drawable.ic_action_need_sync);
        else
            imageViewStatus.setBackgroundResource(R.drawable.ic_action_synced);
        return listViewItem;

    }
}
