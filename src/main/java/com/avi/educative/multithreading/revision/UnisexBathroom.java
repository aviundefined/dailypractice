package com.avi.educative.multithreading.revision;

/**
 * A bathroom is being designed for the use of both males and females in an office but requires the following constraints to be maintained:
 * <p>
 * There cannot be men and women in the bathroom at the same time.
 * There should never be more than three employees in the bathroom simultaneously.
 */
public class UnisexBathroom {
    private static final int MAX_NUM_EMPLOYEE = 3;

    private enum Gender {
        MALE,
        FEMALE,
        NONE
    }
    
    private int numberOfEmployeesInBathroom = 0;
    private Gender usedBy = Gender.NONE;

    private final Object lock = new Object();

    public void maleUseBathroom(final String name) throws InterruptedException {
        synchronized (lock) {
            while (usedBy == Gender.FEMALE || this.numberOfEmployeesInBathroom >= MAX_NUM_EMPLOYEE) {
                lock.wait();
            }
            usedBy = Gender.MALE;
            this.numberOfEmployeesInBathroom++;
        }

        useBathRoom(name);

        synchronized (lock) {
            this.numberOfEmployeesInBathroom--;
            if (numberOfEmployeesInBathroom == 0) {
                this.usedBy = Gender.NONE;
            }
            lock.notifyAll();
        }
    }

    public void femaleUseBathroom(final String name) throws InterruptedException {
        synchronized (lock) {
            while (usedBy == Gender.MALE || this.numberOfEmployeesInBathroom >= MAX_NUM_EMPLOYEE) {
                lock.wait();
            }
            usedBy = Gender.FEMALE;
            this.numberOfEmployeesInBathroom++;
        }

        useBathRoom(name);

        synchronized (lock) {
            this.numberOfEmployeesInBathroom--;
            if (numberOfEmployeesInBathroom == 0) {
                this.usedBy = Gender.NONE;
            }
            lock.notifyAll();
        }
    }

    private void useBathRoom(final String name) throws InterruptedException {
        System.out.println(name + " using bathroom. Current employees in bathroom = " + name);
        Thread.sleep(1000);
        System.out.println(name + " done using bathroom");
    }
}
