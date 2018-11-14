package com.blabla.layoutapp.layoutapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.security.Key;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView mylistview = (ListView)findViewById(R.id.myListView);
        final EditText myEditText = (EditText)findViewById(R.id.dtTXT);

        final ArrayList<String> todoItems = new ArrayList<String>();

        final ArrayAdapter<String> aa;

        aa = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, todoItems);

        mylistview.setAdapter(aa);

        myEditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN)
                if ((keyCode == KeyEvent.KEYCODE_DPAD_CENTER) || (keyCode == KeyEvent.KEYCODE_ENTER))
                {

                    todoItems.add(0, myEditText.getText().toString());
                    aa.notifyDataSetChanged();
                    myEditText.setText("");
                    return false;

                }

                return false;
            }
        });

    }

}
