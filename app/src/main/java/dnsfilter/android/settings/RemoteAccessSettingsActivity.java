package dnsfilter.android.settings;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Switch;
import dnsfilter.ConfigUtil;

public class RemoteAccessSettingsActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Switch remoteSwitch = new Switch(this);
        setContentView(remoteSwitch);

        remoteSwitch.setChecked(ConfigUtil.isRemoteAccessEnabled());
        remoteSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            ConfigUtil.setBoolean("remote_access_enabled", isChecked);
        });
    }
}
