package com.example.jorge.projeto3;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import java.util.LinkedList;

public class ListViewLoader extends Activity {

    ListView listView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_android_example);

        // Get ListView object from xml1
        listView = (ListView) findViewById(R.id.lista);

        // Defined Array values to show in ListView
        Dicionario dic = new Dicionario();
        LinkedList<LinkedList<String>> alfas = dic.getDicionario();
        LinkedList<String> valuesChar = alfas.get(0);
        LinkedList<String> valuesMorse = alfas.get(1);
        LinkedList<String> tudo = new LinkedList<String>();
        for (int i = 0; i<valuesChar.size();i++){
            String trans = valuesChar.get(i) + "                                    :                                    " + valuesMorse.get(i);
            tudo.add(trans);

        }

        // Define a new Adapter
        // First parameter - Context
        // Second parameter - Layout for the row
        // Third parameter - ID of the TextView to which the data is written
        // Forth - the Array of data

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, tudo);


        // Assign adapter to ListView
        listView.setAdapter(adapter);

    // ListView Item Click Listener
//        listView.setOnItemClickListener(new OnItemClickListener() {
//
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//                // ListView Clicked item index
//                int itemPosition     = position;
//               // ListView Clicked item value
//                String  itemValue    = (String) listView.getItemAtPosition(position);
//
//                // Show Alert
//                Toast.makeText(getApplicationContext(),
//                        "Position :"+itemPosition+"  ListItem : " +itemValue , Toast.LENGTH_LONG)
//                        .show();
//
//            }
//
//        });
    }

}