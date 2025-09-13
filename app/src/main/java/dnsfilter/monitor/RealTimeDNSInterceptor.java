package dnsfilter.monitor;

import dnsfilter.firewall.FirewallPolicyManager;
import dnsfilter.DNSResolver;
import dnsfilter.stats.DNSStatsManager;

public class RealTimeDNSInterceptor {
    private final FirewallPolicyManager firewallManager;
    private final DNSResolver resolver;
    private final DNSStatsManager statsManager;

    public RealTimeDNSInterceptor(FirewallPolicyManager firewallManager, DNSResolver resolver, DNSStatsManager statsManager) {
        this.firewallManager = firewallManager;
        this.resolver = resolver;
        this.statsManager = statsManager;
    }

    public void intercept(String domain, String ip, int port) {
        boolean allowed = firewallManager.isAllowed(ip, domain, port);
        statsManager.log(domain, ip, port, allowed);

        if (!allowed) {
            resolver.blockQuery(domain);
        }
    }
}
