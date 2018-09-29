package johnmmm.mytest_action.data;

import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;

public class JohnSQLOpenHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "JohnSQL";
    private static final int DB_VERSION = 9;

    //建立新的数据库table的快捷信息
    public static final String JOHN1_TABLE_NAME = "johnmmm";
    public static final String FIELD_ID = "id";
    public static final String FIELD_NAME = "name";
    public static final String FIELD_AGE = "age";
    private static final String JOHN1_TABLE_CREATE = "create table if not exists " +
            JOHN1_TABLE_NAME + " (" + FIELD_ID + " integer primary key autoincrement, " +
            FIELD_NAME + " text, " +
            FIELD_AGE + " integer);";


    private static JohnSQLOpenHelper instance;
    private JohnSQLOpenHelper(Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }
    public static synchronized JohnSQLOpenHelper getInstance(Context context){
        if (instance == null){
            instance = new JohnSQLOpenHelper(context);
        }
        return instance;
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(JOHN1_TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("drop table if exists " + JOHN1_TABLE_NAME + ";");
        db.execSQL(JOHN1_TABLE_CREATE);
    }

    @Override
    protected void finalize(){
        close();
    }
}
