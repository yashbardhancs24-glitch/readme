
package Collections;
import java.util.*;

class Account {
    String accountId;
    String ownerName;

    Account(String accountId, String ownerName) {
        this.accountId = accountId;
        this.ownerName = ownerName;
    }

   
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Account account = (Account) obj;
        return Objects.equals(accountId, account.accountId);
    }

    
    public int hashCode() {
        return Objects.hash(accountId);
    }

    
    public String toString() {
        return "Account{" + "id='" + accountId + '\'' + ", owner='" + ownerName + '\'' + '}';
    }
}

class Transaction {
    String transactionId;
    String accountId;
    double amount;
    String type; 

    Transaction(String transactionId, String accountId, double amount, String type) {
        this.transactionId = transactionId;
        this.accountId = accountId;
        this.amount = amount;
        this.type = type;
    }

   
    public String toString() {
        return "Transaction{" +
                "id='" + transactionId + '\'' +
                ", accountId='" + accountId + '\'' +
                ", amount=" + amount +
                ", type='" + type + '\'' +
                '}';
    }
}

public class Banking_transaction_system {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Transaction> allTransactions = new ArrayList<>();
        Queue<Transaction> pendingTransactions = new LinkedList<>();
        Set<Account> validAccounts = new HashSet<>();
        Stack<Transaction> rollbackStack = new Stack<>();

       
        validAccounts.add(new Account("A101", "Alice"));
        validAccounts.add(new Account("A102", "Bob"));
        validAccounts.add(new Account("A103", "Charlie"));

      
        System.out.print("How many transactions to add? ");
        int tCount = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < tCount; i++) {
            System.out.println("Enter transactionId, accountId, amount, type(deposit/withdraw):");
            String tid = scanner.nextLine();
            String aid = scanner.nextLine();
            double amt = scanner.nextDouble();
            scanner.nextLine();
            String type = scanner.nextLine();

            Transaction t = new Transaction(tid, aid, amt, type);
            pendingTransactions.offer(t);
        }

        
        while (!pendingTransactions.isEmpty()) {
            Transaction current = pendingTransactions.poll();

            
            boolean valid = validAccounts.stream().anyMatch(a -> a.accountId.equals(current.accountId));
            if (!valid) {
                System.out.println("Invalid account for transaction: " + current);
                continue;
            }

            
            System.out.println("Executing transaction: " + current);
            allTransactions.add(current);
            rollbackStack.push(current);
        }

       
        System.out.println("Do you want to rollback last transaction? (yes/no)");
        String response = scanner.nextLine();
        if (response.equalsIgnoreCase("yes")) {
            if (!rollbackStack.isEmpty()) {
                Transaction last = rollbackStack.pop();
                allTransactions.remove(last);
                System.out.println("Rolled back transaction: " + last);
            } else {
                System.out.println("No transactions to rollback.");
            }
        }

        System.out.println("\nAll successful transactions:");
        for (Transaction tx : allTransactions) {
            System.out.println(tx);
        }
    }
}

