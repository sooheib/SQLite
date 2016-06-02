package com.example.sooheib.sqlite;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void retrieveData(View view) {
        SQLiteDatabase db = openOrCreateDatabase("MyDB", MODE_PRIVATE, null);

        Cursor cursor = db.rawQuery("SELECT * FROM Person", null);
        cursor.moveToFirst();

        do {
            int cI = cursor.getColumnIndex("FirstName");

            Toast.makeText(this, "User: " + cursor.getString(cI), Toast.LENGTH_LONG).show();
        } while (cursor.moveToNext());

        db.close();
    }

    public void insertData(View view) {
        SQLiteDatabase db=openOrCreateDatabase("MyDB",MODE_PRIVATE,null);
        db.execSQL("CREATE TABLE IF NOT EXISTS Person(LastName TEXT, FirstName TEXT,Age INT(3));");
        db.execSQL("INSERT INTO Person VALUES('Aranaha','selmi',33)");
        db.execSQL("INSERT INTO Person VALUES('SOUHEIB','selmi',33)");
        db.execSQL("INSERT INTO Person VALUES('AYMEN','selmi',33)");
        db.close();
        Toast.makeText(this,"Database created",Toast.LENGTH_LONG).show();
    }
}
