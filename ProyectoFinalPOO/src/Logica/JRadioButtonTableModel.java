package Logica;

import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class JRadioButtonTableModel extends DefaultTableModel {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JRadioButtonTableModel(Object[] columnNames, int rowCount) {
        super(columnNames, rowCount);
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == 0) {
            return Boolean.class; // Use Boolean for JRadioButton
        }
        return super.getColumnClass(columnIndex);
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        if (column == 0) {
            return true;
        }
        return false;
    }
}
