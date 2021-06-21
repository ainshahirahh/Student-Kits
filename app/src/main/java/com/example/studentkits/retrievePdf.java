package com.example.studentkits;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


import java.util.ArrayList;
import java.util.List;

public class retrievePdf extends AppCompatActivity {

    ListView myPDFListView;
    DatabaseReference databaseReference;
    List<putPDF> uploadPDFs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrieve_pdf);

        myPDFListView = findViewById(R.id.myListView);
        uploadPDFs = new ArrayList<>();

        viewAllFiles();

        myPDFListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                putPDF putPDF = uploadPDFs.get(position);
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setType("application/pdf");
                intent.setData(Uri.parse(putPDF.getUrl()));
                startActivity(intent);

            }
        });

    }

    private void viewAllFiles() {

        databaseReference = FirebaseDatabase.getInstance().getReference("File Upload by Students");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot postSnapshot : snapshot.getChildren()) {

                    putPDF putPDF = postSnapshot.getValue(com.example.studentkits.putPDF.class);
                    uploadPDFs.add(putPDF);

                }

                String[] uploadsName = new String[uploadPDFs.size()];

                for (int i = 0; i < uploadsName.length; i++) {
                    uploadsName[i] = uploadPDFs.get(i).getName();
                }

                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getApplicationContext(),
                        android.R.layout.simple_list_item_1, uploadsName){

                @NonNull
                @Override
                public View getView (int position, @Nullable View convertView,
                @NonNull ViewGroup parent){

                    View view = super.getView(position, convertView, parent);
                    TextView textView = (TextView) view.findViewById(R.id.textView1);

                    textView.setTextColor(Color.BLACK);
                    textView.setTextSize(20);
                    return view;
                }
            };

            myPDFListView.setAdapter(arrayAdapter);
        }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

}

