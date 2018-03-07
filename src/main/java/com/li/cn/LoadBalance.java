package com.li.cn;

import java.util.List;

public class LoadBalance {

    private List<String> services;
    private Integer index;

    public LoadBalance(List<String> services) {
        this.services = services;
        this.index = 0;
    }

    public String choose() {
        if (index > services.size() - 1 || index < 0) {

            return null;
        }
        String service = services.get(index++);

        if (index >= services.size()) {

            index = 0;
        }

        return service;
    }

}
