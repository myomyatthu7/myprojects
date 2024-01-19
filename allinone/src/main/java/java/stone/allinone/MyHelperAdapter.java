package java.stone.allinone;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyHelperAdapter {
    Context context;
    MyHelper helper;
    SQLiteDatabase sqLiteDatabase;

    public MyHelperAdapter(Context context) {
        this.context = context;
    }
    public void dbOpen() {
        helper = new MyHelper(context);
        sqLiteDatabase = helper.getWritableDatabase();
    }
    public long Insert(String name,String code,String city) {
        ContentValues cv = new ContentValues();
        cv.put(MyHelper.STUDENT_NAME,name);
        cv.put(MyHelper.STUDENT_CODE,code);
        cv.put(MyHelper.STUDENT_CITY,city);
        return sqLiteDatabase.insert(MyHelper.TB_NAME, null, cv);
    }

    public void dbClose() {
        sqLiteDatabase.close();
    }
    private static class MyHelper extends SQLiteOpenHelper {
        private static final String DB_NAME = "Computer_Class";
        private static final String STUDENT_CODE = "student_code";
        private static final String STUDENT_NAME = "student_name";
        private static final String STUDENT_CITY = "student_city";
        private static final String STUDENT_ID = "_id";
        private static final String TB_NAME = "student";
        private static final int DB_VERSION = 1;
        private MyHelper(@Nullable Context context ) {
            super(context, DB_NAME, null, DB_VERSION);
            ToastMsg.toastMsg(context,"Create MyHelper");
        }
        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE "+TB_NAME+"("+STUDENT_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+
                    STUDENT_NAME+" VARCHAR(255),"+
                    STUDENT_CODE+" VARCHAR(255),"+
                    STUDENT_CITY+" VARCHAR(255))");
            //ToastMsg.toastMsg(context.getApplicationContext(), "Create DateBase");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS "+TB_NAME);
            onCreate(db);
        }
    }
}
