package dnsfilter.monitor;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import dnsfilter.firewall.FirewallPolicyManager;
import dnsfilter.DNSResolver;

public class BackgroundDNSMonitor {
    private final Context context;
    private final FirewallPolicyManager firewallManager;
    private final DNSResolver dnsResolver;

    public BackgroundDNSMonitor(Context context, FirewallPolicyManager firewallManager, DNSResolver dnsResolver) {
        this.context = context;
        this.firewallManager = firewallManager;
        this.dnsResolver = dnsResolver;
    }

    public void startMonitoring() {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(context, DNSMonitorReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_IMMUTABLE);

        alarmManager.setRepeating(
            AlarmManager.RTC_WAKEUP,
            System.currentTimeMillis(),
            30000, // kiểm tra mỗi 30 giây
            pendingIntent
        );
    }
}
