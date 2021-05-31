/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author DLH
 */
public class NhanVienModel extends AbstractTableModel {
    private Vector tbData;
    private Vector colName;
    private String col[] = {"ID", "Tên", "Loại","Ngày sinh", "CMND","Địa chỉ","SDT", "Email", "Chú thích"};
    public NhanVienModel(ResultSet rs)
    {
        try
        {
            ResultSetMetaData rsm = rs.getMetaData();
            int Colcount= rsm.getColumnCount();
            colName=new Vector(Colcount);
            tbData = new Vector();
            for(int i=0;i<Colcount;i++)
                colName.addElement(col[i]);
            while(rs.next())
            {
                Vector rowData = new Vector();
                for(int i = 1; i <= Colcount; i++)
                {
                    rowData.addElement(rs.getObject(i));
                }
                tbData.addElement(rowData);
            }
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }   
    }
    @Override
    public int getRowCount() {
        return tbData.size(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getColumnCount() {
        return colName.size(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getColumnName(int column) {
        return (String)colName.elementAt(column); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Vector rowData=(Vector)tbData.elementAt(rowIndex);
        return rowData.elementAt(columnIndex); //To change body of generated methods, choose Tools | Templates.
    }
}
