package java.stone.allinone;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class SQLiteHelperAdapter {
    private final Context context;
    private SQLiteDatabase sqLiteDatabase;
    private MyHelper myHelper;
    private static StringBuilder sb;

    public SQLiteHelperAdapter(Context context) {
        this.context = context;
    }
    public void dbOpen() {
        myHelper = new MyHelper(context);
        sqLiteDatabase = myHelper.getWritableDatabase();
    }
    public long dataInsert(String name,String code,String city) {
        ContentValues cv = new ContentValues();
        cv.put(MyHelper.STUDENT_NAME,name);
        cv.put(MyHelper.STUDENT_CODE,code);
        cv.put(MyHelper.STUDENT_CITY,city);
        return sqLiteDatabase.insert(MyHelper.TB_NAME,null,cv); // nullColumnHack is define if you want null column or more colums;
    }
    public String dataQuery(String searchText) {
        sb = new StringBuilder();
        String [] selectionArgs = {searchText,searchText,searchText,searchText};
        String [] columns = {MyHelper.STUDENT_ID,MyHelper.STUDENT_NAME,
                MyHelper.STUDENT_CODE,MyHelper.STUDENT_CITY};

//        String table, String[] columns, String selection,
//                String[] selectionArgs, String groupBy, String having,
//                String orderBy

        Cursor cursor = sqLiteDatabase.query(MyHelper.TB_NAME,columns,
                //MyHelper.STUDENT_NAME + "='"+name+"'",
                //MyHelper.STUDENT_NAME +"=? OR "+MyHelper.STUDENT_CODE+"=?",
                MyHelper.STUDENT_NAME +"=? OR "+MyHelper.STUDENT_CODE+"=? OR "+
                MyHelper.STUDENT_CODE+"=? OR "+MyHelper.STUDENT_CITY+"=?",
                selectionArgs,null,null,null);
        int indexId = cursor.getColumnIndex(MyHelper.STUDENT_ID);
        int indexName = cursor.getColumnIndex(MyHelper.STUDENT_NAME);
        int indexCode = cursor.getColumnIndex(MyHelper.STUDENT_CODE);
        int indexCity = cursor.getColumnIndex(MyHelper.STUDENT_CITY);
        for (cursor.moveToFirst();!cursor.isAfterLast();cursor.moveToNext()) {
            showDetail(cursor,indexId,indexName,indexCode,indexCity);
        }
        return sb.toString();
    }
    public int dataUpdate(String oldText,String newName,String newCode,String newCity) {
        ContentValues cv = new ContentValues();
        cv.put(MyHelper.STUDENT_NAME,newName);
        cv.put(MyHelper.STUDENT_CODE,newCode);
        cv.put(MyHelper.STUDENT_CITY,newCity);
        int row = sqLiteDatabase.update(MyHelper.TB_NAME,cv,MyHelper.STUDENT_CODE+
                //"='"+oldText+"'",null);
                "=?", new String[]{oldText});
        return row;
    }
    public int dataDelete(String Id) {
        //ContentValues cv = new ContentValues();
        String [] id = {Id};
        int row = sqLiteDatabase.delete(MyHelper.TB_NAME,MyHelper.STUDENT_CODE+"=?",id);
        return row;
    }

    private void showDetail(Cursor cursor,int indexId,int indexName,int indexCode,int indexCity) {
        sb.append(cursor.getString(indexId)).append(" : ")
                .append(cursor.getString(indexName)).append(" : ")
                .append(cursor.getString(indexCode)).append(" : ")
                .append(cursor.getString(indexCity)).append("\n");
    }
    public void dbClose() {
        myHelper.close();
    }

    private static class MyHelper extends SQLiteOpenHelper {
        private static final String DB_NAME = "Android_Class";
        private static final String STUDENT_CODE = "student_code";
        private static final String STUDENT_NAME = "student_name";
        private static final String STUDENT_CITY = "student_city";
        private static final String STUDENT_ID = "_id";
        private static final String TB_NAME = "student";
        private static final int DB_VERSION = 1;

        private MyHelper(@Nullable Context context) {
            super(context, DB_NAME, null, DB_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE "+TB_NAME+" ("+
                    STUDENT_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                    STUDENT_NAME+" VARCHAR(255),"+
                    STUDENT_CODE+" VARCHAR(255),"+
                    STUDENT_CITY+" VARCHAR(255));");
            Log.d("DataBase","onCreate");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS "+TB_NAME);
            onCreate(db);
            Log.d("DataBase","onUpgrade");
        }
    }
}
