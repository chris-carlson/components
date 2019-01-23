package com.cac.components.io;

import com.google.common.io.Resources;

public class Resource {
    public static String getFilePath(String resourcePath) {
        return Resources.getResource(resourcePath).getPath().replace("%20", " ");
    }
}
