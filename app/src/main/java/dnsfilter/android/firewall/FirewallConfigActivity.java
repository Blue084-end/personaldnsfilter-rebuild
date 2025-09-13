package dnsfilter.android.firewall;

import android.app.Activity;
import android.os.Bundle;
import android.widget.*;
import dnsfilter.firewall.FirewallPolicyManager;

public class FirewallConfigActivity extends Activity {
    private FirewallPolicyManager firewallManager = new FirewallPolicyManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firewall_config);

        Switch firewallSwitch = findViewById(R.id.firewallSwitch);
        firewallSwitch.setChecked(firewallManager.isFirewallEnabled());
        firewallSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            firewallManager.enableFirewall(isChecked);
        });

        Button addIPButton = findViewById(R.id.addIPButton);
        EditText ipInput = findViewById(R.id.ipInput);
        addIPButton.setOnClickListener(v -> {
            String ip = ipInput.getText().toString();
            firewallManager.addAllowedIP(ip);
            Toast.makeText(this, "Đã thêm IP: " + ip, Toast.LENGTH_SHORT).show();
        });

        // Tương tự cho domain và port...
    }
}
