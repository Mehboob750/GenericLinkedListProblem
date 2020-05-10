package com.genericsexample;

import org.junit.Assert;
import org.junit.Test;

public class LinkedListTest {

    @Test
    public void givenLinkList_IfEmpty_ShouldReturnTrue() {
        LinkedList linkedList = new LinkedList();
        Assert.assertTrue(linkedList.isEmpty());
    }
}