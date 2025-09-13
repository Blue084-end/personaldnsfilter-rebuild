package dnsfilter.android.settings;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Switch;
import dnsfilter.stats.DNSStatsManager;

public class StatsSettingsActivity extends Activity {
    private final DNSStatsManager statsManager = new DNSStatsManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Switch statsSwitch = new Switch(this);
        setContentView(statsSwitch);

        statsSwitch.setChecked(statsManager.isStatsEnabled());
        statsSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            statsManager.setStatsEnabled(isChecked);
        });
    }
}
