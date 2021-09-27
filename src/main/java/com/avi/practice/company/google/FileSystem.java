package com.avi.practice.company.google;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by navinash on 27/09/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class FileSystem {
    private static final String PATH_SEP_SPLIT = "\\/";

    private final Dir root = new Dir();

    public FileSystem() {

    }

    public List<String> ls(String path) {
        Dir curr = root;
        if (!path.equals("/")) {
            final String[] dirs = path.split(PATH_SEP_SPLIT);
            for (int i = 1; i < dirs.length - 1; i++) {
                if (curr.dirs.containsKey(dirs[i])) {
                    curr = curr.dirs.get(dirs[i]);
                } else {
                    return Collections.emptyList();
                }
            }

            final String lastDirOrFile = dirs[dirs.length - 1];
            if (curr.files.containsKey(lastDirOrFile)) {
                return Collections.singletonList(lastDirOrFile);
            }
            if (curr.dirs.containsKey(lastDirOrFile)) {
                curr = curr.dirs.get(lastDirOrFile);
            } else {
                return Collections.emptyList();
            }
        }
        final List<String> result = new ArrayList<>(curr.dirs.keySet());
        result.addAll(curr.files.keySet());
        result.sort(String::compareTo);
        return result;
    }

    public void mkdir(String path) {
        if (path == null || "/".equals(path) || "".equals(path)) {
            return;
        }
        final String[] dirs = path.split(PATH_SEP_SPLIT);
        Dir curr = root;
        for (int i = 1; i < dirs.length; i++) {
            curr = curr.dirs.computeIfAbsent(dirs[i], k -> new Dir());
        }
    }

    public void addContentToFile(String filePath, String content) {
        if (filePath == null || "/".equals(filePath) || "".equals(filePath)) {
            return;
        }

        final String[] dirs = filePath.split(PATH_SEP_SPLIT);
        Dir curr = root;
        for (int i = 1; i < dirs.length - 1; i++) {
            if (curr.dirs.containsKey(dirs[i])) {
                curr = curr.dirs.get(dirs[i]);
            } else {
                // throw exception
                return;
            }
        }
        final String lastFile = dirs[dirs.length - 1];
        curr.files.computeIfAbsent(lastFile, k -> new StringBuilder()).append(content);
    }

    public String readContentFromFile(String filePath) {
        if (filePath == null || "/".equals(filePath) || "".equals(filePath)) {
            return null;
        }
        final String[] dirs = filePath.split(PATH_SEP_SPLIT);
        Dir curr = root;
        for (int i = 1; i < dirs.length - 1; i++) {
            if (curr.dirs.containsKey(dirs[i])) {
                curr = curr.dirs.get(dirs[i]);
            } else {
                // throw exception
                return null;
            }
        }
        final String lastFile = dirs[dirs.length - 1];
        if (curr.files.containsKey(lastFile)) {
            return curr.files.get(lastFile).toString();
        }
        return null;
    }


    private static final class Dir {
        private final Map<String, Dir> dirs = new HashMap<>();
        private final Map<String, StringBuilder> files = new HashMap<>();
    }
}
