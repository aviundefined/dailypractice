package com.avi.practice.company.nutanix.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by navinash on 28/02/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class FileSystem {

    Dir root;

    public FileSystem() {
        root = new Dir();
    }

    public List<String> ls(final String path) {
        if (path == null || "".equals(path)) {
            return Collections.emptyList();
        }
        Dir currDir = root;
        if (!path.equals("/")) {
            // Split path and go to end
            final String[] paths = path.split("/");
            for (int i = 1; i < paths.length - 1; i++) {
                currDir = currDir.dirs.get(paths[i]);
            }
            // check if last one is file or dir
            final String lastFileOrDir = paths[paths.length - 1];
            if (currDir.files.containsKey(lastFileOrDir)) {
                return Collections.singletonList(lastFileOrDir);
            } else {
                currDir = currDir.dirs.get(lastFileOrDir);
            }
        }
        // reached to the end
        //  now get it's all dirs and files
        final List<String> files = new ArrayList<>(currDir.dirs.keySet());
        files.addAll(currDir.files.keySet());
        files.sort(String::compareTo);
        return files;
    }

    public void mkdir(String path) {
        if (path == null || "".equals(path)) {
            return;
        }

        Dir currDir = root;
        // Split path and go to end
        final String[] paths = path.split("/");
        for (int i = 1; i < paths.length; i++) {
            currDir = currDir.dirs.computeIfAbsent(paths[i], s -> new Dir());
        }
    }

    public void addContentToFile(String filePath, String content) {
        if (filePath == null || "".equals(filePath)) {
            return;
        }

        final String[] paths = filePath.split("/");
        Dir currDir = root;
        for (int i = 1; i < paths.length - 1; i++) {
            currDir = currDir.dirs.get(paths[i]);
        }
        final String fileName = paths[paths.length - 1];
        final String existingContent = currDir.files.computeIfAbsent(fileName, p -> "");
        currDir.files.put(fileName, existingContent + content);
    }

    public String readContentFromFile(String filePath) {
        if (filePath == null || "".equals(filePath)) {
            return "";
        }

        final String[] paths = filePath.split("/");
        Dir currDir = root;
        for (int i = 1; i < paths.length - 1; i++) {
            currDir = currDir.dirs.get(paths[i]);
        }
        final String fileName = paths[paths.length - 1];
        return currDir.files.getOrDefault(fileName, "");
    }

    private static final class Dir {
        private final Map<String, Dir> dirs = new HashMap<>();
        private final Map<String, String> files = new HashMap<>();
    }
}
