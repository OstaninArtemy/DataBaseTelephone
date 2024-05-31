package com.mirea.kt.databasetelephone;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class ActiviteView extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AdapterForPhone adapter;
    private DataBaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        dbHelper = new DataBaseHelper(this);

        loadPhones();
    }

    private void loadPhones() {
        List<Phone> phoneList = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        Cursor cursor = db.query(
                DataBaseHelper.TABLE_PHONES,
                null,
                null,
                null,
                null,
                null,
                null
        );

        while (cursor.moveToNext()) {
            String model = cursor.getString(cursor.getColumnIndexOrThrow(DataBaseHelper.COLUMN_MODEL));
            String serialNumber = cursor.getString(cursor.getColumnIndexOrThrow(DataBaseHelper.COLUMN_SERIAL_NUMBER));
            int price = cursor.getInt(cursor.getColumnIndexOrThrow(DataBaseHelper.COLUMN_PRICE));

            phoneList.add(new Phone(model, serialNumber, price));
        }
        cursor.close();

        adapter = new AdapterForPhone(phoneList);
        recyclerView.setAdapter(adapter);
    }
}
