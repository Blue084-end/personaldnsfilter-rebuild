package dnsfilter.log;

import java.util.ArrayList;
import java.util.List;

public class QueryLogger {
    private final List<String> queryHistory = new ArrayList<>();

    public void log(String domain, String ip, int port) {
        String entry = String.format("Domain: %s, IP: %s, Port: %d", domain, ip, port);
        queryHistory.add(entry);
    }

    public List<String> getHistory() {
        return new ArrayList<>(queryHistory);
    }

    public void clearHistory() {
        queryHistory.clear();
    }
}
