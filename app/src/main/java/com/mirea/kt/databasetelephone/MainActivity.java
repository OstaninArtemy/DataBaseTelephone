package com.mirea.kt.databasetelephone;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextModel;
    private EditText editTextSerialNumber;
    private EditText editTextPrice;
    private DataBaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextModel = findViewById(R.id.editTextModel);
        editTextSerialNumber = findViewById(R.id.editTextSerialNumber);
        editTextPrice = findViewById(R.id.editTextPrice);
        Button buttonSave = findViewById(R.id.buttonSave);
        Button buttonView = findViewById(R.id.buttonView);

        dbHelper = new DataBaseHelper(this);

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                savePhone();
            }
        });

        buttonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ActiviteView.class));
            }
        });
    }

    private void savePhone() {
        String model = editTextModel.getText().toString();
        String serialNumber = editTextSerialNumber.getText().toString();
        int price = Integer.parseInt(editTextPrice.getText().toString());

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DataBaseHelper.COLUMN_MODEL, model);
        values.put(DataBaseHelper.COLUMN_SERIAL_NUMBER, serialNumber);
        values.put(DataBaseHelper.COLUMN_PRICE, price);

        long newRowId = db.insert(DataBaseHelper.TABLE_PHONES, null, values);

        if (newRowId != -1) {
            Toast.makeText(this, "Phone saved with ID: " + newRowId, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Error saving phone", Toast.LENGTH_SHORT).show();
        }
    }
}