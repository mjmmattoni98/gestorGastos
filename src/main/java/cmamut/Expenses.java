package cmamut;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.TreeMap;

public class Expenses implements Serializable {
    private Map<LocalDateTime, Integer> expenses;
    private int totalExpense;

    public Expenses(){
        this.expenses = new TreeMap<>();
        this.totalExpense = 0;
    }

    public int getTotalExpense() {
        return totalExpense;
    }

    public void add(int expense){
        expenses.put(LocalDateTime.now(), expense);
        totalExpense += expense;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (LocalDateTime date : expenses.keySet())
            sb.append("\t" + date.toString() + " -> " + expenses.get(date).toString() + "\n");
        return sb.toString();
    }
}
