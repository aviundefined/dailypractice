package com.avi.practice.company.google;


import com.avi.practice.company.google.DesignExcelSumFormula.Excel;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by navinash on 22/08/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class DesignExcelSumFormulaTest {

    @Test
    public void testUseCase1() {
        final int height = 3;
        final char width = 'C';
        final Excel excel = new Excel(height, width);
        excel.set(1, 'A', 2);
        {
            final int actual = excel.get(1, 'A');
            Assert.assertEquals(2, actual);
        }
        {
            final String[] numbers = {"A1", "A1:B2"};
            final int actual = excel.sum(3, 'C', numbers);
            Assert.assertEquals(4, actual);
        }
        excel.set(2, 'B', 2);
        {
            final int actual = excel.get(3, 'C');
            Assert.assertEquals(6, actual);
        }
    }
}