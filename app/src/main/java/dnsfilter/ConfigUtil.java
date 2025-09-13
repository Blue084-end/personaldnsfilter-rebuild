package dnsfilter;

import android.content.Context;
import android.content.SharedPreferences;

public class ConfigUtil {
    private static SharedPreferences prefs;

    public static void init(Context context) {
        prefs = context.getSharedPreferences("dnsfilter_config", Context.MODE_PRIVATE);
    }

    public static boolean getBoolean(String key, boolean defaultValue) {
        return prefs.getBoolean(key, defaultValue);
    }

    public static void setBoolean(String key, boolean value) {
        prefs.edit().putBoolean(key, value).apply();
    }

    public static boolean isUpdateCheckEnabled() {
        return getBoolean("update_check_enabled", false); // mặc định là false
    }

    public static boolean isRemoteAccessEnabled() {
        return getBoolean("remote_access_enabled", false); // mặc định là false
    }
}
