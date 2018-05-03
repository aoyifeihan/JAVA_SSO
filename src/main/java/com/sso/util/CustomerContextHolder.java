package com.sso.util;
//并发有问题
public class CustomerContextHolder {
    private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();

    public static void setCustomerType(String customerType) {
        contextHolder.set(customerType);
    }

    public static void clearCustomerType() {
        contextHolder.remove();
    }

    public static String getCustomerType() {
        return contextHolder.get();
    }
}