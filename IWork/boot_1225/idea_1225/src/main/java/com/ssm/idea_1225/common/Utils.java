package com.ssm.idea_1225.common;

import java.util.UUID;

/**
 * @Author sml
 * @Time 2017-12-27 11:36
 **/

public class Utils {
    public static String getUuid() {
        return UUID.randomUUID().toString().replace("-","");
    }
}
