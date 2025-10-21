#!/bin/bash

echo "📁 Copy file mới ConfigManager.java"
cp external/ConfigManager.java app/src/main/java/util/ConfigManager.java

echo "📦 Áp dụng bản vá HttpProxy"
git apply patches/patch-httpproxy.diff

echo "📦 Áp dụng bản vá DNSServer"
git apply patches/patch-dnsserver.diff

echo "✅ Kiểm tra trạng thái"
git status
