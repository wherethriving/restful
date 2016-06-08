package scopa.cona.database.model;

/**
 * Created by panda on 5/10/16.
 */
public class AttrConf {
    private Integer attrConfId;
    private Integer confDictId;
    private String  attrName;
    private String confParam;
    private Boolean isOptional;
    private String columnType;
    private String description;
    private Boolean isType;

    public Integer getAttrConfId() {
        return attrConfId;
    }

    public void setAttrConfId(Integer attrConfId) {
        this.attrConfId = attrConfId;
    }

    public Integer getConfDictId() {
        return confDictId;
    }

    public void setConfDictId(Integer confDictId) {
        this.confDictId = confDictId;
    }

    public String getAttrName() {
        return attrName;
    }

    public void setAttrName(String attrName) {
        this.attrName = attrName;
    }

    public String getConfParam() {
        return confParam;
    }

    public void setConfParam(String confParam) {
        this.confParam = confParam;
    }

    public Boolean getIsOptional() {
        return isOptional;
    }

    public void setIsOptional(Boolean isOptional) {
        this.isOptional = isOptional;
    }

    public String getColumnType() {
        return columnType;
    }

    public void setColumnType(String columnType) {
        this.columnType = columnType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getIsType() {
        return isType;
    }

    public void setIsType(Boolean isType) {
        this.isType = isType;
    }
}
