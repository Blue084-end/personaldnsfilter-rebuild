package dnsfilter.android;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import dnsfilter.update.UpdateChecker;

public class DNSFilterService extends Service {
    @Override
    public void onCreate() {
        super.onCreate();

        // Khởi tạo kiểm tra cập nhật nếu được phép
        UpdateChecker checker = new UpdateChecker();
        checker.checkForUpdates();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
