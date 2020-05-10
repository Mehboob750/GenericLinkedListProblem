package com.genericsexample;

import org.junit.Assert;
import org.junit.Test;

public class LinkedListTest {

    @Test
    public void givenLinkList_IfEmpty_ShouldReturnTrue() {
        LinkedList linkedList = new LinkedList();
        Assert.assertTrue(linkedList.isEmpty());
    }
    @Test
    public void givenValue_WhenInserted_ShouldReturnSizeOfTheList() {
        LinkedList linkedList = new LinkedList();
        linkedList.insert(1);
        linkedList.insert("Mehboob");
        Assert.assertEquals(2, linkedList.listSize());
    }

    @Test
    public void givenNullValue_WhenInserted_ShouldNotBeInserted() {
        LinkedList linkedList = new LinkedList();
        linkedList.insert(null);
        Assert.assertEquals(0, linkedList.listSize());
    }

    @Test
    public void givenEmptyValue_WhenInserted_ShouldNotBeInserted() {
        LinkedList linkedList = new LinkedList();
        linkedList.insert(" ");
        Assert.assertEquals(0, linkedList.listSize());
    }

    @Test
    public void givenValue_WhenSearched_IfPresent_ShouldBeDeleted_AndReturnSizeOfTheList() {
        LinkedList linkedList = new LinkedList();
        linkedList.insert(1);
        linkedList.insert("Mehboob");
        linkedList.insert("Shaikh");
        linkedList.remove(1);
        linkedList.printList(linkedList);
        Assert.assertEquals(2, linkedList.listSize());
    }

    @Test
    public void givenValue_WhenSearched_IfPresent_ShouldReturnTrue() {
        LinkedList linkedList = new LinkedList();
        linkedList.insert(1);
        linkedList.insert("Mehboob");
        linkedList.insert("Shaikh");
        boolean result = linkedList.search(1);
        Assert.assertTrue(result);
    }

    @Test
    public void givenValue_WhenSearched_IfNotPresent_ShouldReturnFalse() {
        LinkedList linkedList = new LinkedList();
        linkedList.insert(1);
        linkedList.insert("Mehboob");
        linkedList.insert("Shaikh");
        boolean result = linkedList.search(2);
        Assert.assertFalse(result);
    }
}