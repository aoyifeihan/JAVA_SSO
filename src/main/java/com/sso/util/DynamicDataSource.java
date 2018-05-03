package com.sso.util;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
//并发有问题
public class DynamicDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        return CustomerContextHolder.getCustomerType();
    }
}