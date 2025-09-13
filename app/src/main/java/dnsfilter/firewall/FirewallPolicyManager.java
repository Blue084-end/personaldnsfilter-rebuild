package dnsfilter.firewall;

import java.util.HashSet;
import java.util.Set;

public class FirewallPolicyManager {
    private boolean firewallEnabled = false;
    private final Set<String> allowedIPs = new HashSet<>();
    private final Set<String> allowedDomains = new HashSet<>();
    private final Set<Integer> allowedPorts = new HashSet<>();

    public void enableFirewall(boolean enabled) {
        this.firewallEnabled = enabled;
    }

    public boolean isFirewallEnabled() {
        return firewallEnabled;
    }

    public void addAllowedIP(String ip) {
        allowedIPs.add(ip);
    }

    public void addAllowedDomain(String domain) {
        allowedDomains.add(domain);
    }

    public void addAllowedPort(int port) {
        allowedPorts.add(port);
    }

    public boolean isAllowed(String ip, String domain, int port) {
        if (!firewallEnabled) return true;
        return allowedIPs.contains(ip) || allowedDomains.contains(domain) || allowedPorts.contains(port);
    }
}
