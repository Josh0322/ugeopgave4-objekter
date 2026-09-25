import java.util.ArrayList;

    class Transaction {
        String type;
        double amount;

        Transaction(String type, double amount) {
            this.type = type;
            this.amount = amount;
        }

        public String toString() {
            return type + ": " + amount + " kr";
        }
    }

    class bankAccount {
        String owner;
        double balance;
        ArrayList<Transaction> transactions; // Liste der gemmer alle transaktioner

        bankAccount(String owner, double startBalance) {
            this.owner = owner;
            this.balance = startBalance;
            this.transactions = new ArrayList<>();
            transactions.add(new Transaction("Start balance", startBalance));
        }

        void deposit(double amount) {
            if (amount > 0) {
                balance = balance + amount;
                transactions.add(new Transaction("deposited", amount)); // Gemmer deposit
                System.out.println("deposited " + amount + " kr");
            }
        }

        void withdraw(double amount) {
            if (amount > 0 && amount < balance) {
                balance = balance - amount;
                transactions.add(new Transaction("withdrew", amount));
                System.out.println("Withdrew " + amount + " kr");
            } else if (amount > balance) {
                System.out.println("Not enough money on account");
            }
        }

        void printTransactionHistory() {
            System.out.println(" ");
            System.out.println("Transaction history for: " + owner);
            for (Transaction t : transactions) { // Printer alle transactions fra arrayList
                System.out.println(t); // toString bliver brugt som t
            }
        }

        double getBalance() {
            return + balance;
        }
    }

        void main() {
            bankAccount account = new bankAccount("Josh", 500);

            account.deposit(500);
            account.deposit(250);
            account.withdraw(150);
            account.deposit(50);

            account.printTransactionHistory();
            account.getBalance();
            System.out.println("(Total balance: " + account.getBalance() + " kr)");

        }