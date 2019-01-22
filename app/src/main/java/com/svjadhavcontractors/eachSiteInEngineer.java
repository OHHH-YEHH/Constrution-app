package com.svjadhavcontractors;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.svjadhavcontractors.Login.login;
import com.svjadhavcontractors.firstpageafterLogin.SupervisorActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class eachSiteInEngineer extends AppCompatActivity {
    private ArrayList<String> assignedsite = new ArrayList<>();
    public static String selectedsite;
    Engineer_delete_Adapter adapterforassignedsite;

    FirebaseDatabase databaseforPeople = FirebaseDatabase.getInstance();
    final DatabaseReference tableuserPpl = databaseforPeople.getReference("People").child(login.usname).child(engineerassignedCity.selectedcity);


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_engineer);
        getSupportActionBar().setTitle(engineerassignedCity.selectedcity);


        tableuserPpl.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
               assignedsite.clear();
                for (DataSnapshot ds : dataSnapshot.getChildren())
                    assignedsite.add(ds.getKey());

                adapterforassignedsite = new Engineer_delete_Adapter(eachSiteInEngineer.this, assignedsite);
                final ListView listView = findViewById(R.id.dele_engi);
                listView.setAdapter(adapterforassignedsite);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        selectedsite = assignedsite.get(position);
                        startActivity(new Intent(eachSiteInEngineer.this, SupervisorActivity.class));
                    }
                });
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



    }

    public static class Engineer_delete_Adapter extends ArrayAdapter<String> {


        public Engineer_delete_Adapter(Context context, ArrayList<String> dataItem) {
           //layout of single file
            super(context, R.layout.list_item_engi_delete, dataItem);

        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // Check if an existing view is being reused, otherwise inflate the view
            View listItemView = convertView;
            if (listItemView == null) {
                listItemView = LayoutInflater.from(getContext()).inflate(
                        R.layout.list_item_engi_delete, parent, false);
            }

            TextView nameofengi =  listItemView.findViewById(R.id.textView2);

            nameofengi.setText(getItem(position));
            return listItemView;
        }
    }
}
