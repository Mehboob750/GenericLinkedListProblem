package com.genericsexample;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

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
    public void givenValue_WhenRemove_ItShouldBeRemoved_AndReturnTheSizeOfTheList() {
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

    @Test
    public void givenValue_WhenAppend_ShouldAddToTheList(){
        LinkedList linkedList = new LinkedList();
        linkedList.append(1);
        linkedList.append(2);
        linkedList.printList(linkedList);
        Assert.assertEquals(2,linkedList.listSize());
    }

    @Test
    public void givenMultipleValues_WhenAppend_ShouldAddToTheList(){
        LinkedList linkedList = new LinkedList();
        linkedList.append(1,2,3,"Hii");
        linkedList.printList(linkedList);
        Assert.assertEquals(4,linkedList.listSize());
    }

    @Test
    public void givenValue_WhenSearchForIndex_ShouldReturnTheindexNumber(){
        LinkedList linkedList = new LinkedList();
        linkedList.append(1,2,3,"Hii");
        int result=linkedList.index(2);
        Assert.assertEquals(2,result);
    }

    @Test
    public void givenValue_WhenSearchForIndexInEmptyList_ShouldReturnZero(){
        LinkedList linkedList = new LinkedList();
        int result=linkedList.index(2);
        Assert.assertEquals(0,result);
    }

    @Test
    public void givenValueWithLocation_ShouldinsertdAtLocationAndReturnThePosition(){
        LinkedList linkedList = new LinkedList();
        linkedList.append(1,2,3);
        int result=linkedList.insertAtIndex(4,4);
        linkedList.printList(linkedList);
       Assert.assertEquals(4,result);
    }

    @Test
    public void whenPop_ShouldRemoveAndReturnTheLastElement(){
        LinkedList linkedList = new LinkedList();
        linkedList.append(1,2,3,"Hello");
        Object result= linkedList.pop();
        Assert.assertEquals("Hello",result);
    }

    @Test
    public void givenPosition_ShouldRemoveAndReturnTheElementAtThatPosition(){
        LinkedList linkedList = new LinkedList();
        linkedList.append(1,2,3,"Hello");
        Object result= linkedList.popAtPosition(4);
        Assert.assertEquals("Hello",result);
    }

    @Test
    public void givenPositionLargeThanListSize_ShouldReturnZero(){
        LinkedList linkedList = new LinkedList();
        linkedList.append(1,2,3,"Hello");
        Object result= linkedList.popAtPosition(5);
        Assert.assertEquals(0,result);
    }

    @Test
    public void givenData_IfFoundInFile_ShouldBeDeletedAndReturnTheMessage() throws Exception {
        LinkedList linkedList=new LinkedList();
        ReadFromFile readFromFile=new ReadFromFile();
        List list = readFromFile.read();
        linkedList=readFromFile.copyToLinkedList(list);
        linkedList.printList(linkedList);
        readFromFile.searchElement("Hello");
    }

    @Test
    public void givenData_IfNotFoundInFile_ShouldBeAddedAndReturnTheMessage() throws Exception {
        LinkedList linkedList=new LinkedList();
        ReadFromFile readFromFile=new ReadFromFile();
        List list = readFromFile.read();
        linkedList=readFromFile.copyToLinkedList(list);
        linkedList.printList(linkedList);
        readFromFile.searchElement("1234");
    }
}