package scopa.cona.database.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by panda on 5/10/16.
 */
public class OriginAttr implements Comparable<OriginAttr>{
    private Integer originAttrId;
    private Integer originTableId;
    private String attrName;
    private Integer columnType;
    private String description;
    private Integer rowOrder;

    public Integer getOriginAttrId() {
        return originAttrId;
    }

    public void setOriginAttrId(Integer originAttrId) {
        this.originAttrId = originAttrId;
    }

    public Integer getOriginTableId() {
        return originTableId;
    }

    public void setOriginTableId(Integer originTableId) {
        this.originTableId = originTableId;
    }

    public String getAttrName() {
        return attrName;
    }

    public void setAttrName(String attrName) {
        this.attrName = attrName;
    }

    public Integer getColumnType() {
        return columnType;
    }

    public void setColumnType(Integer columnType) {
        this.columnType = columnType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getRowOrder() {
        return rowOrder;
    }

    public void setRowOrder(Integer rowOrder) {
        this.rowOrder = rowOrder;
    }

    @Override
    public int compareTo(OriginAttr o) {
        if(this.rowOrder !=null && o.getRowOrder() !=null){
            return this.rowOrder-o.getRowOrder();
        }else{
            return 0;
        }
    }

    public static void main(String[] args) {
        OriginAttr a1 =new OriginAttr();
        a1.setRowOrder(2);
        OriginAttr a2 = new OriginAttr();
        a2.setRowOrder(1);
        List<OriginAttr> list = new ArrayList<>();
        list.add(a1);
        list.add(a2);
        Collections.sort(list);
        System.out.println(list.get(0).getRowOrder() + "--"+list.get(1).getRowOrder());
    }
}
