package cn.ffb.library.config;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import cn.ffb.library.db.Constants;
import cn.ffb.library.db.DataBaseHelper;


/**
 * 配置服务
 * 
 * @author Yanghuiqiang 2014-5-8
 * 
 */
public class ConfigService {
  public final static String TAG = ConfigService.class.getSimpleName();
  private DataBaseHelper helper;
  private SQLiteDatabase db;

  public ConfigService(Context context) {
    helper = DataBaseHelper.getInstance(context);
    db = helper.getWritableDatabase();
  }

  public boolean saveConfig(JSONObject[] jsons) {
    db.beginTransaction(); // 开始事务
    try {
      db.execSQL("delete from " + Constants.DATABASENAME_CONFIG);
      for (int i = 0; i < jsons.length; i++) {
        JSONObject json = jsons[i];
        db.execSQL("INSERT INTO " + Constants.DATABASENAME_CONFIG + "(key, value) VALUES(?, ?)",
            new Object[] {json.get("key"), json.get("value")});
      }
      db.setTransactionSuccessful(); // 设置事务成功完成
      return true;
    } catch (SQLException e) {
      Log.e(TAG, "保存配置信息出错", e);
      return false;
    } catch (JSONException e) {
      Log.e(TAG, "保存配置信息出错", e);
      return false;
    } finally {
      db.endTransaction(); // 结束事务
    }
  }

  /**
   * 获取所有的配置
   * 
   * @return
   */
  public Map<String, String> getConfigs() {
    Map<String, String> config = new HashMap<String, String>();
    Cursor c = db.rawQuery("SELECT * FROM " + Constants.DATABASENAME_CONFIG, null);
    while (c.moveToNext()) {
      String key = c.getString(c.getColumnIndex("key"));
      String value = c.getString(c.getColumnIndex("value"));
      config.put(key, value);
    }
    c.close();
    return config;
  }

  /**
   * 获取配置
   * 
   * @return
   */
  public String getConfig(String key) {
    String value = null;
    Cursor c =
        db.rawQuery(
            "SELECT * FROM " + Constants.DATABASENAME_CONFIG + " where key = '" + key + "'", null);
    while (c.moveToNext()) {
      value = c.getString(c.getColumnIndex("value"));
    }
    c.close();
    return value;
  }

  /**
   * 保存配置
   * 
   * @param key
   * @param value
   * @return
   */
  public boolean saveConfig(String key, String value) {
    db.beginTransaction(); // 开始事务
    try {
      db.execSQL("delete from " + Constants.DATABASENAME_CONFIG + " where key = '" + key + "'");
      db.execSQL("INSERT INTO " + Constants.DATABASENAME_CONFIG + "(key, value) VALUES(?, ?)",
          new Object[] {key, value});
      db.setTransactionSuccessful(); // 设置事务成功完成
      return true;
    } catch (SQLException e) {
      Log.e(TAG, "保存配置信息出错", e);
      return false;
    } finally {
      db.endTransaction(); // 结束事务
    }
  }
}
