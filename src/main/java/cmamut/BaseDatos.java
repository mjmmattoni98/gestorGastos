package cmamut;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class BaseDatos implements Serializable {
    private Set<TipoGasto> totalExpenses;

    public BaseDatos(){
        this.totalExpenses = new HashSet<>();
    }

    public boolean addNewExpense(TipoGasto type, String month, int amount){
        type.addNewMonthExpense(month, amount);
        boolean isAdded = totalExpenses.add(type);
        return isAdded;
    }

    public int updateExpense(String idType, String month, int amount){
        int newAmount = 0;
        for(TipoGasto type : totalExpenses){
            if (type.getId().equalsIgnoreCase(idType)){
                newAmount = type.updatedMonthExpense(month, amount);
                break;
            }
        }
        /*if(newAmount == 0)
            System.out.println("No existe el gasto " + idType);
        else if(newAmount < 0)
            System.out.println("No existe el mes " + month + " asociado al tipo " + idType);
        else
            System.out.println("El nuevo gasto para " + idType + " en " + month + " es: " + newAmount);
*/
        return newAmount;
    }

}
