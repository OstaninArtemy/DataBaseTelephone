package com.mirea.kt.databasetelephone;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "phones.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_PHONES = "phones";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_MODEL = "model";
    public static final String COLUMN_SERIAL_NUMBER = "serial_number";
    public static final String COLUMN_PRICE = "price";

    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_PHONES + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_MODEL + " TEXT, " +
                COLUMN_SERIAL_NUMBER + " TEXT, " +
                COLUMN_PRICE + " INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PHONES);
        onCreate(db);
    }
}
