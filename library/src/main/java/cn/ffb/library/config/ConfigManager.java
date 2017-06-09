package cn.ffb.library.config;

import android.content.Context;

import java.util.HashMap;
import java.util.Map;


/**
 * 系统配置管理
 * 
 * @author Yanghuiqiang 2014-5-14
 * 
 */
public class ConfigManager {
  private final static Map<String, String> configMap = new HashMap<String, String>();
  public static ConfigService configService;
  private static Context context;
  public static ConfigManager instance;

  private ConfigManager(Context context) {
    ConfigManager.context = context;
    configService = new ConfigService(context);
    configMap.putAll(configService.getConfigs());
  }

  /**
   * 初始化配置缓存
   * 
   * @param context
   */
  public static void init(Context context) {
    if (instance == null) {
      instance = new ConfigManager(context);
    }
  }

  /**
   * 获取Key的配置值
   * 
   * @param key
   * @return
   */
  public static String getConfig(String key) {
    return getConfig(key, "");
  }

  /**
   * 获取Key的配置值
   * 
   * @param context
   * @param key
   * @return
   */
  public static String getConfig(Context context, String key) {
    ConfigManager.context = context;
    return getConfig(key, "");
  }

  /**
   * 获取Key的配置值
   * 
   * @param key
   * @param defaultValue
   * @return
   */
  public static String getConfig(String key, String defaultValue) {
    String value = configMap.get(key);
    if (value == null || value.equals("")) {
      if (configService == null) {
        init(context);
      }
      value = configService.getConfig(key);
      if (value == null || value.equals("")) {
        value = defaultValue;
      }
      configMap.put(key, value);
    }
    return value;
  }

  /**
   * 设置Key的值为value
   * 
   * @param key
   * @param value
   */
  public static void setConfig(String key, String value) {
    if (configService == null) {
      init(context);
    }
    configMap.put(key, value);
    configService.saveConfig(key, value);
  }

}
