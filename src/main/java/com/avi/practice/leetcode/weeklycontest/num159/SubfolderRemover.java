package com.avi.practice.leetcode.weeklycontest.num159;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by navinash on 22/10/19.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
final class SubfolderRemover {

    static List<String> solve(final String[] folder) {
        if (folder == null || folder.length == 0) {
            return Collections.emptyList();
        }
        if (folder.length == 1) {
            return Collections.singletonList(folder[0]);
        }

        final Map<String, LinkedHashSet<String>> rootsByFolder = new HashMap<>();
        final Set<String> allFolders = new HashSet<>();
        for (final String s : folder) {
            if (!rootsByFolder.containsKey(s)) {
                rootsByFolder.put(s, roots(s));
            }
            allFolders.add(s);
        }
        final Set<String> result = new HashSet<>();

        for (final String f : folder) {
            final LinkedHashSet<String> roots = rootsByFolder.get(f);
            for (final String root : roots) {
                if (allFolders.contains(root)) {
                    result.add(root);
                    break;
                }
            }
        }
        final List<String> retVal = new ArrayList<>(result);
        Collections.sort(retVal);
        return retVal;
    }


    private static LinkedHashSet<String> roots(final String f) {
        final LinkedHashSet<String> roots = new LinkedHashSet<>();
        final String[] strs = f.split("\\/");
        String last = "";
        for (int i = 1; i < strs.length; i++) {
            final String root = last + "/" + strs[i];
            roots.add(root);
            last = root;
        }
        return roots;
    }

}
