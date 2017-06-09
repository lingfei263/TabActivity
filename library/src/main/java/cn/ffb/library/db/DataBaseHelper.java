package cn.ffb.library.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;


/**
 * DataBaseHelper
 * 
 * @author lingfei 2014-4-25
 * 
 */
public class DataBaseHelper extends SQLiteOpenHelper {

  // 类没有实例化,是不能用作父类构造器的参数,必须声明为静态
  private final static String DATABASE_NAME = "flying";
  private final static int DATABASE_VERSION = 1;
  private static DataBaseHelper mInstance = null;

  public static DataBaseHelper getInstance(Context context) {
    if (mInstance == null) {
      mInstance = new DataBaseHelper(context);
    }
    return mInstance;
  }

  public DataBaseHelper(Context context) {
    super(context, DATABASE_NAME, null, DATABASE_VERSION);
  }

  public DataBaseHelper(Context context, String name, CursorFactory factory, int version) {
    super(context, name, factory, version);
  }

  @Override
  public void onCreate(SQLiteDatabase db) {
    db.execSQL("CREATE TABLE IF NOT EXISTS " + Constants.DATABASENAME_CONFIG
        + " (id integer primary key autoincrement, key varchar(100), value varchar(300))");
  }

  @Override
  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL("DROP TABLE IF EXISTS " + Constants.DATABASENAME_CONFIG);
    onCreate(db);
  }

}
