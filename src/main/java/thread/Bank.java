package thread;

public class Bank {

    private int money;

    private String name;

    public Bank(int money, String name) {
        this.money = money;
        this.name = name;
    }

    public void deposit(int m){
        money+=m;
    }

    public boolean withdraw(int m){
        if(money>=m){
            money-=m;
            check();
            return true;
        }else {
            return false;
        }
    }

    private void check() {
        if(money<0){
            System.out.println(this.name+"可用余额为:"+this.money);
        }
    }

    static class BankThread implements Runnable{

        public Bank bank;

        BankThread(Bank bank){
            this.bank = bank;
        }

        @Override
        public void run() {
            while (true){
                boolean flag = bank.withdraw(1000);
                if(flag){
                    bank.deposit(1000);
                }
            }
        }
    }

    public static void main(String[] args) {
        Bank bank = new Bank(1000,"中国");
        new Thread(new BankThread(bank)).start();
        new Thread(new BankThread(bank)).start();
    }
}
