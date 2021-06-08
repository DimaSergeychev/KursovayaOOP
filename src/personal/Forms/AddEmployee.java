package personal.Forms;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import personal.Main;
import personal.Objects.DB;
import personal.Objects.Employee;
import personal.Objects.Filial;
import personal.Objects.Position;

public class AddEmployee extends javax.swing.JFrame {

    DB dataBase;
    ArrayList<Filial> filials = new ArrayList();
    ArrayList<Position> positions = new ArrayList();
    Employee empl;
    String type;

    public AddEmployee(Employee employee, DB dataBase, String type) {
        this.dataBase = dataBase;
        this.empl = employee;
        this.type = type;
        initComponents();
        getParameters();
        this.setTitle("Изменить сотрудника");
        this.addEmployee.setText("Обновить");
    }

    public AddEmployee(int number, DB dataBase, String type) {
        this.dataBase = dataBase;
        this.type = type;
        initComponents();
        updateParameters(number);
    }

    private void getParameters() {

        //Получение филиалов
        selectFilial.removeAllItems();

        int index = 0;
        ArrayList<Filial> filialDB = dataBase.getFilials();
        for (Filial filial : filialDB) {
            filials.add(filial);
            selectFilial.addItem(filial.getName());
            if (filial.getFilial_id() == empl.getFilial_id()) {
                index = filials.indexOf(filial);
            }
        }

        selectFilial.setSelectedIndex(index);

        //Получение должностей
        selectPosition.removeAllItems();

        ArrayList<Position> positionDB = dataBase.getPosition();

        for (Position position : positionDB) {
            positions.add(position);
            selectPosition.addItem(position.getName());
            if (position.getPosition_id() == empl.getPosition_id()) {
                index = positions.indexOf(position);
            }
        }

        selectPosition.setSelectedIndex(index);

        fioField.setText(empl.getFio());
        numberField.setText(empl.getMobile());
        emailField.setText(empl.getEmail());

    }

    private void updateParameters(int number) {

        //Получение филиалов
        selectFilial.removeAllItems();

        ArrayList<Filial> filialDB = dataBase.getFilials();
        for (Filial filial : filialDB) {
            filials.add(filial);
            selectFilial.addItem(filial.getName());

        }

        selectFilial.setSelectedIndex(number);

        //Получение должностей
        selectPosition.removeAllItems();

        ArrayList<Position> positionDB = dataBase.getPosition();

        for (Position position : positionDB) {
            positions.add(position);
            selectPosition.addItem(position.getName());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        selectFilial = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        fioField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        selectPosition = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        emailField = new javax.swing.JTextField();
        addEmployee = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        numberField = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Добавить работника");

        selectFilial.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setText("Филиал");

        jLabel2.setText("ФИО работника");

        jLabel3.setText("Должность");

        selectPosition.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setText("Телефон");

        jLabel5.setText("E-Mail");

        addEmployee.setText("Добавить");
        addEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEmployeeActionPerformed(evt);
            }
        });

        cancel.setText("Отмена");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });

        try {
            numberField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#(###) ###-##-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(selectFilial, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(fioField)
                    .addComponent(selectPosition, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(emailField)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancel, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE))
                    .addComponent(numberField))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(selectFilial, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fioField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(selectPosition, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(4, 4, 4)
                .addComponent(numberField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addEmployee)
                    .addComponent(cancel))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        dispose();
    }//GEN-LAST:event_cancelActionPerformed

    private void addEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addEmployeeActionPerformed

        String EMAIL_PATTERN = "^(.+)@(\\S+)$";
        if (this.type.equals("add")) {
            if (fioField.getText().length() == 0) {
                JOptionPane.showMessageDialog(this, "ФИО не заполнено!");
            } else if (numberField.getText().length() == 0) {
                JOptionPane.showMessageDialog(this, "Номер телефона не заполнен");
            } else if (emailField.getText().length() == 0) {
                JOptionPane.showMessageDialog(this, "Email не заполнен");
            } else if (!emailField.getText().matches(EMAIL_PATTERN))
            {
                JOptionPane.showMessageDialog(this, "Email не верный");
            }
            else{

                Position pos = positions.get(selectPosition.getSelectedIndex());
                Main.employeeModel.Add(new Employee(filials.get(selectFilial.getSelectedIndex()).getFilial_id(),
                        pos.getPosition_id(),
                        pos.getName(),
                        fioField.getText(),
                        emailField.getText(),
                        numberField.getText()), selectFilial.getSelectedIndex());

                JOptionPane.showMessageDialog(this, "Новый работник добавлен");
                dispose();
            }
        } else {

            if (fioField.getText().length() == 0) {
                JOptionPane.showMessageDialog(this, "ФИО не заполнено!");
            } else if (numberField.getText().length() == 0) {
                JOptionPane.showMessageDialog(this, "Номер телефона не заполнен");
            } else if (emailField.getText().length() == 0) {
                JOptionPane.showMessageDialog(this, "Email не заполнен");
            } else {

                Position pos = positions.get(selectPosition.getSelectedIndex());
                Employee newEmpl = new Employee(filials.get(selectFilial.getSelectedIndex()).getFilial_id(),
                        pos.getPosition_id(),
                        pos.getName(),
                        fioField.getText(),
                        emailField.getText(),
                        numberField.getText());

                newEmpl.setEmployee_id(this.empl.getEmployee_id());

                Main.employeeModel.Update(Main.EmployeeTable.getSelectedRow(), this.empl, newEmpl);
                dispose();
                JOptionPane.showMessageDialog(this, "Работник обновлен");
            }
        }

    }//GEN-LAST:event_addEmployeeActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addEmployee;
    private javax.swing.JButton cancel;
    private javax.swing.JTextField emailField;
    private javax.swing.JTextField fioField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JFormattedTextField numberField;
    private javax.swing.JComboBox<String> selectFilial;
    private javax.swing.JComboBox<String> selectPosition;
    // End of variables declaration//GEN-END:variables
}
