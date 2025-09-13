package dnsfilter.monitor;

import dnsfilter.firewall.FirewallPolicyManager;
import dnsfilter.DNSResolver;
import dnsfilter.log.QueryLogger;

public class RealTimeDNSInterceptor {
    private final FirewallPolicyManager firewallManager;
    private final DNSResolver resolver;
    private final QueryLogger logger;

    public RealTimeDNSInterceptor(FirewallPolicyManager firewallManager, DNSResolver resolver, QueryLogger logger) {
        this.firewallManager = firewallManager;
        this.resolver = resolver;
        this.logger = logger;
    }

    public void intercept(String domain, String ip, int port) {
        logger.log(domain, ip, port); // lưu lại truy vấn

        if (!firewallManager.isAllowed(ip, domain, port)) {
            resolver.blockQuery(domain); // chặn truy vấn nếu không nằm trong whitelist
        }
    }
}
