package dnsfilter.stats;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DNSStatsManager {
    private final List<String> statsLog = new ArrayList<>();
    private boolean statsEnabled = true;

    public void setStatsEnabled(boolean enabled) {
        this.statsEnabled = enabled;
    }

    public boolean isStatsEnabled() {
        return statsEnabled;
    }

    public void log(String domain, String ip, int port, boolean allowed) {
        if (!statsEnabled) return;

        String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        String entry = String.format("%s | Domain: %s | IP: %s | Port: %d | %s",
                timestamp, domain, ip, port, allowed ? "ALLOWED" : "BLOCKED");
        statsLog.add(entry);
    }

    public List<String> getStats() {
        return new ArrayList<>(statsLog);
    }

    public void exportToFile(String path) throws IOException {
        FileWriter writer = new FileWriter(path);
        for (String entry : statsLog) {
            writer.write(entry + "\n");
        }
        writer.close();
    }
}
