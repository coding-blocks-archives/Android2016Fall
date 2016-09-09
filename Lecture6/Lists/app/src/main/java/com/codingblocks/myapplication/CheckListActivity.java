package com.codingblocks.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;

import java.util.ArrayList;

public class CheckListActivity extends AppCompatActivity {

    ArrayList<Item> allItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_list);
        allItems = Item.getItems(100);

        ListView listView = (ListView) findViewById(R.id.checklist);
        ChecklistAdapter clAdapter = new ChecklistAdapter();

        listView.setAdapter(clAdapter);

    }


    public class ChecklistAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return allItems.size();
        }

        @Override
        public Item getItem(int position) {
            return allItems.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            convertView = getLayoutInflater().inflate(R.layout.list_item, null);
            final Item item = getItem(position);
            CheckBox checkBox = (CheckBox) convertView.findViewById(R.id.item_checkbox);
            checkBox.setText(String.valueOf(item.getId()));
            checkBox.setChecked(item.isChecked());

            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    item.setChecked(isChecked);
                }
            });

            return convertView;
        }
    }
}
