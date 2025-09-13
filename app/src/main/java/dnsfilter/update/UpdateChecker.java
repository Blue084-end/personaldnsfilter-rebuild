package dnsfilter.update;

import dnsfilter.ConfigUtil;

public class UpdateChecker {
    public void checkForUpdates() {
        if (!ConfigUtil.isUpdateCheckEnabled()) {
            System.out.println("Tính năng cập nhật đã bị vô hiệu hóa.");
            return;
        }

        // Nếu được phép, tiếp tục kiểm tra phiên bản mới
        // (giả lập: gọi API hoặc kiểm tra file)
    }
}
