package dnsfilter.remote;

import android.util.Log;
import dnsfilter.ConfigUtil;

public class RemoteAccessServer {
    public void startServer() {
        if (!ConfigUtil.isRemoteAccessEnabled()) {
            Log.i("RemoteAccess", "Remote access is disabled by configuration.");
            return;
        }

        // Tiếp tục khởi tạo nếu được phép
        // ... phần khởi tạo server
    }
}
