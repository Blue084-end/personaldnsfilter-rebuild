package dnsfilter.android.stats;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import dnsfilter.stats.DNSStatsManager;

import java.io.IOException;

public class ExportStatsActivity extends Activity {
    private final DNSStatsManager statsManager = new DNSStatsManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Button exportButton = new Button(this);
        exportButton.setText("Xuất thống kê DNS");
        setContentView(exportButton);

        exportButton.setOnClickListener(v -> {
            try {
                statsManager.exportToFile(getFilesDir() + "/dns_stats.txt");
                Toast.makeText(this, "Đã xuất file dns_stats.txt", Toast.LENGTH_LONG).show();
            } catch (IOException e) {
                Toast.makeText(this, "Lỗi khi xuất file", Toast.LENGTH_LONG).show();
            }
        });
    }
}
