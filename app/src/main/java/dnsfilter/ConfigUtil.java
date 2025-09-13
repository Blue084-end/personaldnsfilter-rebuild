package dnsfilter.remote;

import android.util.Log;
import dnsfilter.ConfigUtil;

public class RemoteAccessClient {
    public void connectToServer(String ip, int port) {
        if (!ConfigUtil.isRemoteAccessEnabled()) {
            Log.i("RemoteAccess", "Remote access client is disabled.");
            return;
        }

        // Tiếp tục kết nối nếu được phép
        // ... phần xử lý kết nối
    }
}
