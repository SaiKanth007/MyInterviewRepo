/*
 * //*********************************************** // Copyright UNITEDHEALTH GROUP CORPORATION 2019. // This software
 * and documentation contain confidential and // proprietary information owned by UnitedHealth Group Corporation. //
 * Unauthorized use and distribution are prohibited. //***********************************************
 */

/**
 */
// https://stackoverflow.com/questions/7126550/java-wait-and-notify-illegalmonitorstateexception
// https://www.geeksforgeeks.org/differences-between-wait-and-join-methods-in-java/
public class ThreadWaitProblem {

    Integer cash = 901;

    public static void main(String[] args) {
        final ThreadWaitProblem account = new ThreadWaitProblem();

        new Thread() {
            @Override
            public void run() {
                account.withdraw(1200);
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                account.deposit(1200);
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                account.withdraw2(2000);
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                account.deposit2(1200);
            }
        }.start();

    }

    public synchronized void withdraw(Integer withDrawAmount) {

        if (cash < withDrawAmount) {
            System.out.println("Cash not sufficient for withdrawing and so waiting for deposit");

            try {
                wait();
            } catch (final InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("Withdrawing cash");
            this.cash = this.cash - withDrawAmount;
        } else {
            System.out.println("Withdrawing cash");
            this.cash = this.cash - withDrawAmount;
        }

    }

    public synchronized void deposit(Integer depositAmount) {
        System.out.println("Incrementing cash");
        this.cash = cash + depositAmount;
        System.out.println("Incrementing done");
        notify();
    }

    public void withdraw2(Integer withDrawAmount) {

        synchronized (this) {

            if (cash < withDrawAmount / 2) {
                System.out.println("Cash not sufficient for withdrawing and so waiting for deposit");

                try {
                    wait();
                } catch (final InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                System.out.println("Withdrawing cash");
                this.cash = this.cash - withDrawAmount;
            } else {
                System.out.println("Withdrawing cash");
                this.cash = this.cash - withDrawAmount;
            }
        }

    }

    public void deposit2(Integer depositAmount) {
        synchronized (this) {
            System.out.println("Incrementing cash");
            this.cash = cash + depositAmount;
            System.out.println("Incrementing done");
            notify();
        }
    }
}
