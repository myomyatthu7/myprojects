package java.stone.allinone.password;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.stone.allinone.SQLiteHelperAdapter;

public class PwDataAdapter {
    Context context;
    SQLiteDatabase sqLiteDatabase;
    MyHelpers myHelpers;
    public PwDataAdapter(Context context) {
        this.context = context;
    }
    public void dbOpen() {
        myHelpers = new MyHelpers(context);
        sqLiteDatabase = myHelpers.getWritableDatabase();
    }
    public long dataInsert(String pw) {
        ContentValues cv = new ContentValues();
        cv.put(MyHelpers.DB_PW,pw);
        return sqLiteDatabase.insert(MyHelpers.TB_Name,null,cv);
    }
    public String dataQuery() {
        StringBuilder sb = new StringBuilder();
        sqLiteDatabase = myHelpers.getReadableDatabase();
        String [] columns = {MyHelpers.DB_PW};
        Cursor cursor = sqLiteDatabase.query(MyHelpers.TB_Name,columns,null,null,null,null,null);
        for (cursor.moveToFirst();!cursor.isAfterLast();cursor.moveToNext()) {
            //int indexId = cursor.getColumnIndex(MyHelpers.DB_ID);
            int indexPw = cursor.getColumnIndex(MyHelpers.DB_PW);
            sb.append(cursor.getInt(indexPw)).append("\n");
        }
        return sb.toString();
    }

    public int dataUpdate(String oldPw,String newPw) {
        ContentValues cv = new ContentValues();
        //cv.put(MyHelpers.DB_ID,id);
        cv.put(MyHelpers.DB_PW,newPw);
        return sqLiteDatabase.update(MyHelpers.TB_Name,cv,MyHelpers.DB_PW+"=?",
                new String[]{oldPw});
    }

    public void dataDeletePw() {
        sqLiteDatabase.execSQL("DELETE FROM "+MyHelpers.TB_Name);
    }

    public void dbClose() {
        sqLiteDatabase.close();
    }
    private static class MyHelpers extends SQLiteOpenHelper {
        private static final String DB_Name = "password_db.db";
        private static final String DB_PW = "pw";
        //private static final String DB_ID = "_id";
        private static final String TB_Name = "password_tb";
        private static final int DB_VERSION = 1;

        public MyHelpers(@Nullable Context context) {
            super(context, DB_Name, null, DB_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE "+MyHelpers.TB_Name+" ("+
                    MyHelpers.DB_PW+" TEXT)");
            Log.d("DataBase","OnCreate");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS "+MyHelpers.TB_Name);
            Log.d("DataBase","OnUpgrade");
        }
    }
}
