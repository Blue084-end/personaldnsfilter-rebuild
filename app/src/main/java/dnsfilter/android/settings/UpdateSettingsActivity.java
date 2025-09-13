package dnsfilter.android.settings;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Switch;
import dnsfilter.ConfigUtil;

public class UpdateSettingsActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Switch updateSwitch = new Switch(this);
        setContentView(updateSwitch);

        updateSwitch.setChecked(ConfigUtil.isUpdateCheckEnabled());
        updateSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            ConfigUtil.setBoolean("update_check_enabled", isChecked);
        });
    }
}
