package com.example.adaptaon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DescriptionActivity extends AppCompatActivity {
    ImageView img_usuario;
    TextView titleDescriptionTextView;
    TextView pcDescriptionTextView;
    TextView statusDescriptionTextView;
    Button exitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        ListElement element = (ListElement) getIntent().getSerializableExtra(  "ListElement");

        img_usuario = findViewById(R.id.img_usuario);
        titleDescriptionTextView = findViewById(R.id.titleDescriptionTextView);
        pcDescriptionTextView = findViewById(R.id.pcDescriptionTextView);
        statusDescriptionTextView = findViewById(R.id.statusDescriptionTextView);
        exitButton = findViewById(R.id.exitButton);

        titleDescriptionTextView.setText(element.getName());
        pcDescriptionTextView.setText(element.getPc());
        statusDescriptionTextView.setText(element.getStatus());

        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intenti = new Intent(DescriptionActivity.this, Login.class);
                startActivity(intenti);
                finish();
            }
        });
    }
}