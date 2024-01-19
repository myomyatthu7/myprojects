package java.stone.allinone.project2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class NoteDbAdapter {
    private final Context context;
    private MyHelper myHelper;
    private SQLiteDatabase sqLiteDatabase;
    public NoteDbAdapter(Context context) {
        this.context = context;
    }
    public void dbOpen() {
        myHelper = new MyHelper(context.getApplicationContext());
        sqLiteDatabase = myHelper.getWritableDatabase();
    }
    public long insertData(String title,String description,String dateTime) {
        ContentValues cv = new ContentValues();
        cv.put(MyHelper.NOTE_TITLE,title);
        cv.put(MyHelper.NOTE_DESCRIPTION,description);
        cv.put(MyHelper.NOTE_DateTime,dateTime);
        return sqLiteDatabase.insert(MyHelper.TB_NAME,null,cv);
    }
    public String queryData() {
        StringBuilder sb = new StringBuilder();
        String [] columns = {MyHelper.NOTE_ID,MyHelper.NOTE_TITLE,MyHelper.NOTE_DESCRIPTION,MyHelper.NOTE_DateTime};
        Cursor cursor = sqLiteDatabase.query(MyHelper.TB_NAME,columns,null,null,null,null,null);
        for (cursor.moveToFirst();!cursor.isAfterLast();cursor.moveToNext()) {
            int indexId = cursor.getColumnIndex(MyHelper.NOTE_ID);
            int indexTitle = cursor.getColumnIndex(MyHelper.NOTE_TITLE);
            int indexDes = cursor.getColumnIndex(MyHelper.NOTE_DESCRIPTION);

            sb.append(cursor.getString(indexId)).append(":").append(cursor.getString(indexTitle)).append(":").append(cursor.getString(indexDes));
        }
        return sb.toString();
    }

    public int updateData(String row_id,String title,String des,String dateTime) {
        myHelper = new MyHelper(context.getApplicationContext());
        sqLiteDatabase = myHelper.getReadableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(MyHelper.NOTE_TITLE,title);
        cv.put(MyHelper.NOTE_DESCRIPTION,des);
        cv.put(MyHelper.NOTE_DateTime,dateTime);
        String[] arg = {row_id};
        return sqLiteDatabase.update(MyHelper.TB_NAME,cv,"id =?",arg);
    }
    public int deleteData(String row_id) {
        myHelper = new MyHelper(context.getApplicationContext());
        return sqLiteDatabase.delete(MyHelper.TB_NAME,"id = ?", new String[]{row_id});
    }
    public void deleteAllData() {
        String deleteAll = "DELETE FROM "+MyHelper.TB_NAME;
        sqLiteDatabase.execSQL(deleteAll);
    }

    Cursor readAllData() {
        String query = "SELECT * FROM "+ MyHelper.TB_NAME;
        sqLiteDatabase = myHelper.getReadableDatabase();
        Cursor cursor = null;
        if (sqLiteDatabase != null) {
            cursor = sqLiteDatabase.rawQuery(query,null);
        }
        return cursor;
    }

    public void dbClose() {
        sqLiteDatabase.close();
    }


    public static class MyHelper extends SQLiteOpenHelper {
        private static final String DB_NAME = "your_note.db";
        private static final String NOTE_ID = "id";
        private static final String NOTE_TITLE = "title";
        private static final String NOTE_DESCRIPTION = "description";
        private static final String NOTE_DateTime = "datetime";
        private static final String TB_NAME = "your_note";
        private static final int DB_VERSION = 1;

        public MyHelper(@Nullable Context context) {
            super(context, DB_NAME, null, DB_VERSION);
        }
        @Override
        public void onCreate(SQLiteDatabase db) {
            String sql = "CREATE TABLE "+TB_NAME+" ("+NOTE_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                    NOTE_TITLE+" VARCHAR(255),"+NOTE_DESCRIPTION+" TEXT,"+NOTE_DateTime+" TEXT)";
            db.execSQL(sql);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS "+TB_NAME);
            onCreate(db);
        }
    }
}
