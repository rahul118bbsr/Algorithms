package algorithms.mishra.dev.rahul.quora.designpattern;

import java.util.ArrayList;
import java.util.List;

/**
 * http://www.java2novice.com/java-design-patterns/proxy-design-pattern/
 * https://www.javacodegeeks.com/2015/09/proxy-design-pattern.html
 * Created by aleesha on 20/07/17.
 */
public class ProxyPattern {
    public static void main(String[] args) {
        Internet internet = new ProxyInternet();
        internet.connect("www.AA.com");
        internet.connect("www.A.com");
    }
}

interface Internet {
    void connect(String host);
}

class RealInternet implements Internet {

    @Override
    public void connect(String host) {
        System.out.println("Real Internet is connection to host: " + host);
    }
}

class ProxyInternet implements Internet {
    private Internet internet;
    private List<String> blockedSiteList;

    public ProxyInternet() {
        internet = new RealInternet();
        init();
    }

    public void init() {
        blockedSiteList = new ArrayList<>();
        blockedSiteList.add("www.A.com");
        blockedSiteList.add("www.B.com");
        blockedSiteList.add("www.C.com");
    }

    @Override
    public void connect(String host) {
        if(!blockedSiteList.contains(host)) {
            internet.connect(host);
        }
        throw new RuntimeException("Trying to access a site which is blocked!!!");
    }
}
