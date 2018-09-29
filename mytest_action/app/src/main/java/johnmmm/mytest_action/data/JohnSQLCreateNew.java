package johnmmm.mytest_action.data;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import android.util.Log;

import johnmmm.mytest_action.data.JohnSQLOpenHelper;

public class JohnSQLCreateNew extends JohnSQLManager {
    private static String msg = "John APP: ";

    private static JohnSQLCreateNew instance;
    private JohnSQLOpenHelper openHelper;

    private JohnSQLCreateNew(JohnSQLOpenHelper openHelper){
        this.openHelper = openHelper;
    }
    //这样可以保证只有一个sql的实例
    public static JohnSQLCreateNew getInstance(JohnSQLOpenHelper openHelper){
        if (instance == null){
            instance = new JohnSQLCreateNew(openHelper);
        }
        return instance;
    }

    public boolean createNewSqlite(){
        Log.d(msg, "Create a new sqlite!");

        SQLiteDatabase db = openHelper.getWritableDatabase();

        //用这个数据结构来方便插入
        ContentValues newData = new ContentValues();
        newData.put(JohnSQLOpenHelper.FIELD_NAME, "John");
        newData.put(JohnSQLOpenHelper.FIELD_AGE, 21);

        long res = db.insert(JohnSQLOpenHelper.JOHN1_TABLE_NAME, null, newData);

        return res != 1;
    }

    public boolean removeAll(){
        Log.d(msg, "Delete the sqlite!");

        SQLiteDatabase db = openHelper.getWritableDatabase();

        int deleteNo = db.delete(JohnSQLOpenHelper.JOHN1_TABLE_NAME, null, null);

        return deleteNo != 0;
    }
}
