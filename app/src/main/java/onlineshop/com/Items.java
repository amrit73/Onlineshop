package onlineshop.com;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Items extends AppCompatActivity {
    Button btnload;
    List<ItemsModel> itemsModelList = new ArrayList<>();

    private RecyclerView recyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items);
        recyclerAdapter = findViewById(R.id.itemRecyclerView);
        recyclerAdapter.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerAdapter.setAdapter(new ItemsAdapter(itemsModelList, getApplicationContext()));
        readFile();


        btnload = findViewById(R.id.insert);


        btnload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Items.this, AddItems.class);
                startActivity(intent);
            }
        });

    }


    private void readFile() {
        try {
            FileInputStream fileInputStream = openFileInput("items.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split("->");
                String img = parts[3];
                int res = getResources().getIdentifier(img, "drawable", getPackageName());
                itemsModelList.add(new ItemsModel(parts[0], parts[2], res, parts[1]));
//                itemsModelList.add(new ItemsModel(parts[0], parts[1], res, parts[2]));
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
