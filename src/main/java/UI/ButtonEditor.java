package UI;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.AbstractCellEditor;
import javax.swing.table.TableCellEditor;

public class ButtonEditor extends AbstractCellEditor implements TableCellEditor {

    private JButton button;
    private String label;
    private boolean isPushed;

    public ButtonEditor(JTable table) {
        button = new JButton();
        button.setOpaque(true);

        // Action Listener for button clicks
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (label.equals("Update")) {
                    // Handle the update operation
                    System.out.println("Update clicked for row " + table.getSelectedRow());
                    // Add your update logic here
                } else if (label.equals("Delete")) {
                    // Handle the delete operation
                    System.out.println("Delete clicked for row " + table.getSelectedRow());
                    // Add your delete logic here
                }
                fireEditingStopped();
            }
        });
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        label = (value == null) ? "" : value.toString();
        button.setText(label);
        isPushed = true;
        return button;
    }

    @Override
    public Object getCellEditorValue() {
        isPushed = false;
        return label;
    }
}
