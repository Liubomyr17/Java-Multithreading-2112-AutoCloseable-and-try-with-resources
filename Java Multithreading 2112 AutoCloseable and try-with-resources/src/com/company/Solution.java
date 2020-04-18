package com.company;

/*

2112 AutoCloseable and try-with-resources
In the FakeConnection class, implement the AutoCloseable interface so that objects of this type can be used in try-with-resources.
The close () method should display the phrase "Closing database connection ..."
In the try block, call the usefulOperation () and unsupportedOperation () methods sequentially.
The output to the screen should be as follows:
Creating database connection ...
Entering the body of try block.
Executing useful operation.
Operation is not supported yet!
Closing database connection ...
Note that resources were freed automatically despite an exception thrown by unsupportedOperation.

Requirements:
1. The FakeConnection class must support the AutoCloseable interface.
2. The close method of the FakeConnection class should display the phrase "Closing database connection ...".
3. In the main method of the Solution class, the usefulOperation and unsupportedOperation methods of the FakeConnection class object must be called.
4. The output to the screen should correspond to the condition of the task.
5. The close method of the FakeConnection class should not be called explicitly.


 */



public class Solution {
    public static void main(String[] args) {
        FakeConnection.DBConnectionManager dbConnectionManager = new FakeConnection.DBConnectionManager();
        try (FakeConnection fakeConnection = dbConnectionManager.getFakeConnection()) {
            System.out.println("Entering the body of try block.");
            fakeConnection.usefulOperation();
            fakeConnection.unsupportedOperation();
        } catch (Exception e) {
        }
    }



public static class FakeConnection implements AutoCloseable {

    public FakeConnection() {
        System.out.println("Creating database connection...");
    }

    public void unsupportedOperation() {
        System.out.println("Operation is not supported yet!");
        throw new RuntimeException("UnsupportedOperation!");
    }

    public void usefulOperation() {
        System.out.println("Executing useful operation.");
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing database connection...");
    }


    public static class DBConnectionManager {
        public FakeConnection getFakeConnection() {
            return new FakeConnection();
        }
    }
}}