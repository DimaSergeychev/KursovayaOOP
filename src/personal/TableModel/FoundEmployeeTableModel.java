package personal.TableModel;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import personal.Objects.Employee;


public class FoundEmployeeTableModel extends AbstractTableModel {
    
    
    private ArrayList<Employee> data = new ArrayList();

    
    public FoundEmployeeTableModel(ArrayList<Employee> employee){
        this.data = employee;
    }
    
    public Employee[] getItems() {
        return data.stream().toArray(Employee[]::new);
    }
    
    public Employee getItem(int i){
        return data.get(i);
    }

    @Override
    public int getRowCount() {
        return getItems().length;
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int r, int c) {
        switch (c) {
            case 0:
                return this.getItems()[r].getFio();
            case 1:
                return this.getItems()[r].getPosition_name();
            case 2:
                return this.getItems()[r].getMobile();
            case 3:
                return this.getItems()[r].getEmail();
        }
        return "";
    }
    
    @Override
    public String getColumnName(int c) {
        String сolumn = "";
        switch (c) {
            case 0:
                сolumn = "ФИО работника";
                break;
            case 1:
                сolumn = "Должность";
                break;
            case 2:
                сolumn = "Телефон";
                break;
            case 3:
                сolumn = "Почта";
                break;
        }
        return сolumn;
    }
    
}
