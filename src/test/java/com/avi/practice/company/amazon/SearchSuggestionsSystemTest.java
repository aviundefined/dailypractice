package com.avi.practice.company.amazon;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by navinash on 03/08/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class SearchSuggestionsSystemTest {

    @Test
    public void suggestedProducts() {
        final SearchSuggestionsSystem solver = new SearchSuggestionsSystem();
        final String[] products = {"mobile", "mouse", "moneypot", "monitor", "mousepad"};
        final String searchWord = "mouse";
        final List<List<String>> expected = new ArrayList<>();
        expected.add(Arrays.asList("mobile", "moneypot", "monitor"));
        expected.add(Arrays.asList("mobile", "moneypot", "monitor"));
        expected.add(Arrays.asList("mouse", "mousepad"));
        expected.add(Arrays.asList("mouse", "mousepad"));
        expected.add(Arrays.asList("mouse", "mousepad"));
        System.out.println("products: "+Arrays.toString(products));
        System.out.println("searchWord: "+searchWord);
        final List<List<String>> actual = solver.suggestedProducts(products, searchWord);
        Assert.assertEquals(expected, actual);
    }
}