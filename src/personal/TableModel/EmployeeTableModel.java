package personal.TableModel;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import personal.Objects.DB;
import personal.Objects.Employee;
import personal.Objects.Filial;

public class EmployeeTableModel extends AbstractTableModel {
    
    private ArrayList<Employee> data = new ArrayList();
    private ArrayList<Employee> filteredData = new ArrayList();
    private ArrayList<Filial> filials = new ArrayList();
    private final DB dataBase;
    
    public EmployeeTableModel(DB dataBase) {
        this.dataBase = dataBase;
        getAll();
    }
    
    public final void getAll() {
        
        filials.clear();
        data.clear();
        
        for (Filial filial : dataBase.getFilials()) {
            filials.add(filial);
        }
        for (Employee employee : dataBase.getEmployee()) {
            data.add(employee);
            filteredData.add(employee);
        }
    }
    
    public void refreshFilials(){
        filials.clear();
        for (Filial filial : dataBase.getFilials()) {
            filials.add(filial);
        }
    }
    
    public Filial getFilial(int filial_num) {
        return filials.get(filial_num);
    }
    
    public void changeFilial(int filial_num) {
        filteredData.clear();
        if (filial_num <= -1) {
            for (Employee employee : data) {
                filteredData.add(employee);
            }
            
        } else {
            for (Employee employee : data) {
                if (employee.getFilial_id() == getFilial(filial_num).getFilial_id()) {
                    filteredData.add(employee);
                }
            }
        }
        
        this.fireTableDataChanged();
    }
    
    public void Add(Employee empl, int filial_num) {
        Employee employee = empl;
        int id = this.dataBase.addEmployee(employee.getFilial_id(), employee.getPosition_id(), employee.getFio(), employee.getMobile(), employee.getEmail());
        employee.setEmployee_id(id);
        data.add(employee);
        changeFilial(filial_num);
        this.fireTableDataChanged();
        
    }
    

    public void Remove(int number){
        for (Employee empl: data){
            if (empl == filteredData.get(number)){
                data.remove(empl);
                break;
            }
        }
        this.dataBase.removeEmployee(filteredData.get(number).getEmployee_id());
        filteredData.remove(number);
        this.fireTableDataChanged();
    }
    
    public void Update(int row,Employee oldEmpl,  Employee newEmpl){
        this.dataBase.updateEmployee(newEmpl);
        filteredData.set(row, newEmpl);
        for (Employee empl: data){
            if (empl == oldEmpl){
                data.remove(empl);
                data.add(newEmpl);
                break;
            }
        }
        this.fireTableDataChanged();
    }
    
    public Employee[] getItems() {
        return filteredData.stream().toArray(Employee[]::new);
    }
    
    public Employee getItem(int i) {
        return filteredData.get(i);
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
