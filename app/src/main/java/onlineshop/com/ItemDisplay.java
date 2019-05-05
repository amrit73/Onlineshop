package onlineshop.com;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class ItemDisplay extends AppCompatActivity {
    ImageView imageView;
    TextView name, price, desc;
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_display);
        bundle = getIntent().getExtras();
        init();
    }

    private void init() {
        imageView = findViewById(R.id.individualImage);
        name = findViewById(R.id.individuaName);
        price = findViewById(R.id.individualPrice);
        desc = findViewById(R.id.individualDesc);

        if (bundle != null) {
            imageView.setImageResource(bundle.getInt("image"));
            name.setText(bundle.getString("name"));
            price.setText(bundle.getString("price"));
            desc.setText(bundle.getString("desc"));
        }
    }
}
