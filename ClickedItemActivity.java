package com.example.myapplication.work1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;

public class ClickedItemActivity extends AppCompatActivity {
    ImageView imageView;
    TextView textView;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clicked_item);

        imageView = findViewById(R.id.imageView);
        textView = findViewById(R.id.name1);
        button=findViewById(R.id.button14) ;

         button.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 gotourl("https://www.zomato.com");
             }
         });
        Intent intent = getIntent();

        if (intent.getExtras() != null) {
            String selectedName = intent.getStringExtra("name");
            int selectedImage = intent.getIntExtra("image", 0);


            textView.setText(selectedName);
            imageView.setImageResource(selectedImage);
        }


    }

    private void gotourl(String s) {
        Uri uri=Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }
}