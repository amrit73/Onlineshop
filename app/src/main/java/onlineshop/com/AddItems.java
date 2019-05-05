package onlineshop.com;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.PrintStream;

public class AddItems extends AppCompatActivity {
    EditText name, price, desc, img;
    Button btnsave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_items);

        name = findViewById(R.id.item);
        price = findViewById(R.id.price);
        desc = findViewById(R.id.desc);
        img = findViewById(R.id.img);
        btnsave = findViewById(R.id.btnsave);

        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    PrintStream printStream = new PrintStream(openFileOutput("items.txt", MODE_PRIVATE | MODE_APPEND));
                    printStream.println(name.getText().toString() + "->" + price.getText().toString() + "->" + desc.getText().toString() + "->" + img.getText().toString());
                    Toast.makeText(AddItems.this, "Item added", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), Items.class);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }
}
