#!/bin/bash

# ✅ Thêm import ConfigManager vào HttpProxy.java
sed -i '/import util.http.HttpHeader;/a\import util.ConfigManager;' app/src/main/java/util/conpool/HttpProxy.java

# ✅ Thêm trường config vào HttpProxy.java
sed -i '/Logger logger = Logger.getLogger(HttpProxy.class.getName());/a\    private final ConfigManager config;' app/src/main/java/util/conpool/HttpProxy.java

# ✅ Thay constructor HttpProxy để nhận ConfigManager
sed -i '/public HttpProxy(InetSocketAddress adr) {/,+1d' app/src/main/java/util/conpool/HttpProxy.java
echo '    public HttpProxy(InetSocketAddress adr, ConfigManager config) throws IOException {' >> app/src/main/java/util/conpool/HttpProxy.java
echo '        this(adr, null, config);' >> app/src/main/java/util/conpool/HttpProxy.java
echo '    }' >> app/src/main/java/util/conpool/HttpProxy.java

# ✅ Sửa logic openTunnel() để dùng config
sed -i '/adr.getAddress().getHostAddress().equals("40.50.0.0")/,/adr.getHostName();/c\        String placeholderIP = config.get("defaultPlaceholderIP", "40.50.0.0");\n        String host = placeholderIP.equals(adr.getAddress().getHostAddress()) ? adr.getHostName() : adr.getAddress().getHostAddress();' app/src/main/java/util/conpool/HttpProxy.java

# ✅ Thêm import ConfigManager vào DNSServer.java
sed -i '/import util.conpool.HttpProxy;/a\import util.ConfigManager;' app/src/main/java/dnsfilter/DNSServer.java

# ✅ Sửa khởi tạo HttpProxy trong DNSServer.java
sed -i '/proxy = new HttpProxy/,/setProxyAuth/c\        ConfigManager config = new ConfigManager("dnsfilter.conf");\n        proxy = new HttpProxy(new InetSocketAddress(proxyAddr, Integer.parseInt(proxyPort)), proxyAuthStr, config);' app/src/main/java/dnsfilter/DNSServer.java

# ✅ Commit thay đổi
git add app/src/main/java/util/conpool/HttpProxy.java
git add app/src/main/java/dnsfilter/DNSServer.java
git commit -m "Update HttpProxy and DNSServer using ConfigManager via sed"
