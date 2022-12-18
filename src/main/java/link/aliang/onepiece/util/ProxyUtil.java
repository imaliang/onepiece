package link.aliang.onepiece.util;

/**
 * @Description: ProxyUtil
 * @Author: aliang
 * @Date: 2022-12-17 21:11
 */
public class ProxyUtil {

    public static void init() {
        String PROXY_HOST = "127.0.0.1";
        String PROXY_PORT = "7890";
        System.setProperty("http.proxyHost", PROXY_HOST);
        System.setProperty("https.proxyHost", PROXY_HOST);
        System.setProperty("http.proxyPort", PROXY_PORT);
        System.setProperty("https.proxyPort", PROXY_PORT);
    }
}
