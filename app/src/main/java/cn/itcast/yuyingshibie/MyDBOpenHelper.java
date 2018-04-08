package cn.itcast.yuyingshibie;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDBOpenHelper extends SQLiteOpenHelper {

    public MyDBOpenHelper(Context context) {
        super(context, "userInformation.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table Users(" +
                "name String(20) primary key)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public boolean DBSearch(String Name,SQLiteDatabase db,MyDBOpenHelper myDBHelper) {
        db=myDBHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("select name from Users where name = ?", new String[]{Name.trim()});
        if (cursor.getCount() != 0) {
            cursor.close();
            return true;
        } else {
            cursor.close();
            return false;
        }
    }
}