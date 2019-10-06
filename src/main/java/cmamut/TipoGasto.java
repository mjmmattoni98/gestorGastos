package cmamut;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class TipoGasto implements Serializable {
    private String id;
    private String descripcion;
    private Map<String, Expenses> mapMonthExpense;

    public TipoGasto(){
        super();
    }

    public TipoGasto(String id){
        this.id = id;
        this.mapMonthExpense = new HashMap<>();
    }

    public TipoGasto(String id, String descripcion){
        this.id = id;
        this.descripcion = descripcion;
        this.mapMonthExpense = new HashMap<>();
    }

    public boolean addNewMonthExpense(String month, int expense){
        if (mapMonthExpense.containsKey(month))
            return false;
        Expenses expenses = new Expenses();
        expenses.add(expense);
        mapMonthExpense.put(month, expenses);
        return true;
    }

    public int updatedMonthExpense(String month, int expense){
        for(String m : mapMonthExpense.keySet()){
            if(month.equalsIgnoreCase(m)){ //Si está el mes, acualizamos el gasto y devolvemos su suma
                Expenses e = mapMonthExpense.get(m);
                e.add(expense);
                mapMonthExpense.put(m, e);
                return e.getTotalExpense();
            }
        }
        return -1; //Devolvemos -1 en caso de que no exista el mes
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object o){
        TipoGasto anotherType = (TipoGasto) o;
        return this.id.equalsIgnoreCase(anotherType.getId());
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(id);
        if(!descripcion.equals(""))
            sb.append("(" + descripcion + ")");
        sb.append(":\n");
        for(String month : mapMonthExpense.keySet())
            sb.append(month + ":\n" + mapMonthExpense.get(month));

        return sb.toString();
    }
}
