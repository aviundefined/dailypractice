package com.avi.practice.company.google;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by navinash on 29/09/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class SnakeGameTest {

    @Test
    public void useCase1() {
        /*
         * ["SnakeGame","move","move","move","move","move","move"]
         * [[3,2,[[1,2],[0,1]]],["R"],["D"],["R"],["U"],["L"],["U"]]
         *
         * [null,0,0,1,1,2,-1]
         */

        final int width = 3;
        final int height = 2;
        final int[][] food = {
                {1, 2},
                {0, 1}
        };
        final SnakeGame game = new SnakeGame(width, height, food);
        {
            final int expected = 0;
            final int move = game.move("R");
            Assert.assertEquals(expected, move);
        }
        {
            final int expected = 0;
            final int move = game.move("D");
            Assert.assertEquals(expected, move);
        }
        {
            final int expected = 1;
            final int move = game.move("R");
            Assert.assertEquals(expected, move);
        }
        {
            final int expected = 1;
            final int move = game.move("U");
            Assert.assertEquals(expected, move);
        }
        {
            final int expected = 2;
            final int move = game.move("L");
            Assert.assertEquals(expected, move);
        }
        {
            final int expected = -1;
            final int move = game.move("U");
            Assert.assertEquals(expected, move);
        }
    }

    @Test
    public void useCase2() {
        /*
         * ["SnakeGame","move","move"]
         * [[2,2,[[0,1]]],["R"],["D"]]
         */

        final int width = 2;
        final int height = 2;
        final int[][] food = {
                {0, 1}
        };
        final SnakeGame game = new SnakeGame(width, height, food);
        {
            final int expected = 1;
            final int move = game.move("R");
            Assert.assertEquals(expected, move);
        }
        {
            final int expected = 1;
            final int move = game.move("D");
            Assert.assertEquals(expected, move);
        }
    }

    @Test
    public void useCase3() {
        /*
         * ["SnakeGame","move","move","move","move","move"]
         * [[2,2,[[1,1],[0,0]]],["R"],["D"],["L"],["U"],["R"]]
         * [null,0,1,1,2,-1]
         */

        final int width = 2;
        final int height = 2;
        final int[][] food = {
                {1, 1},
                {0, 0}
        };
        final SnakeGame game = new SnakeGame(width, height, food);
        {
            final int expected = 0;
            final int move = game.move("R");
            Assert.assertEquals(expected, move);
        }
        {
            final int expected = 1;
            final int move = game.move("D");
            Assert.assertEquals(expected, move);
        }
        {
            final int expected = 1;
            final int move = game.move("L");
            Assert.assertEquals(expected, move);
        }
        {
            final int expected = 2;
            final int move = game.move("U");
            Assert.assertEquals(expected, move);
        }
        {
            final int expected = 2;
            final int move = game.move("R");
            Assert.assertEquals(expected, move);
        }
    }

    @Test
    public void useCase4() {
        /*
         * ["SnakeGame","move","move","move","move","move","move","move","move","move","move","move","move"]
         * [[3,3,[[2,0],[0,0],[0,2],[2,2]]],["D"],["D"],["R"],["U"],["U"],["L"],["D"],["R"],["R"],["U"],["L"],["D"]]
         * [null,0,1,1,1,1,2,2,2,2,3,3,3]
         */

        final int width = 3;
        final int height = 3;
        final int[][] food = {
                {2, 0},
                {0, 0},
                {0, 2},
                {2, 2},
        };
        final SnakeGame game = new SnakeGame(width, height, food);
        {
            final int expected = 0;
            final int move = game.move("D");
            Assert.assertEquals(expected, move);
        }
        {
            final int expected = 1;
            final int move = game.move("D");
            Assert.assertEquals(expected, move);
        }
        {
            final int expected = 1;
            final int move = game.move("R");
            Assert.assertEquals(expected, move);
        }
        {
            final int expected = 1;
            final int move = game.move("U");
            Assert.assertEquals(expected, move);
        }
        {
            final int expected = 1;
            final int move = game.move("U");
            Assert.assertEquals(expected, move);
        }
        {
            final int expected = 2;
            final int move = game.move("L");
            Assert.assertEquals(expected, move);
        }
        {
            final int expected = 2;
            final int move = game.move("D");
            Assert.assertEquals(expected, move);
        }
        {
            final int expected = 2;
            final int move = game.move("R");
            Assert.assertEquals(expected, move);
        }
        {
            final int expected = 2;
            final int move = game.move("R");
            Assert.assertEquals(expected, move);
        }
        {
            final int expected = 3;
            final int move = game.move("U");
            Assert.assertEquals(expected, move);
        }
        {
            final int expected = 3;
            final int move = game.move("L");
            Assert.assertEquals(expected, move);
        }
        {
            final int expected = 3;
            final int move = game.move("D");
            Assert.assertEquals(expected, move);
        }
    }
}