package org.codeforall.ooptimus;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Main {
    public static void main(String[] args) throws UnknownHostException {
        String host = getHost();
        try {
            InetAddress address = InetAddress.getByName(host);

            System.out.println("Testing ");
        }
        InetAddress inetAddress;
        inetAddress.getAddress();
        System.out.println(InetAddress.getByName(host));





    }

    private static String getHost() {


    }

}