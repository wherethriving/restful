package scopa.cona.database.model;

/**
 * Created by panda on 5/10/16.
 */
public class OriginTable {
    private Integer originTableId;
    private Integer dataSourceInfoId;
    private String tbName;
    private String description;
    private Boolean isIncremental;
    private String increColName;
    private Integer increColType;

    public String getIncreColName() {
        return increColName;
    }

    public void setIncreColName(String increColName) {
        this.increColName = increColName;
    }

    public Integer getIncreColType() {
        return increColType;
    }

    public void setIncreColType(Integer increColType) {
        this.increColType = increColType;
    }

    public Integer getOriginTableId() {
        return originTableId;
    }

    public void setOriginTableId(Integer originTableId) {
        this.originTableId = originTableId;
    }

    public Integer getDataSourceInfoId() {
        return dataSourceInfoId;
    }

    public void setDataSourceInfoId(Integer dataSourceInfoId) {
        this.dataSourceInfoId = dataSourceInfoId;
    }

    public String getTbName() {
        return tbName;
    }

    public void setTbName(String tbName) {
        this.tbName = tbName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getIsIncremental() {
        return isIncremental;
    }

    public void setIsIncremental(Boolean isIncremental) {
        this.isIncremental = isIncremental;
    }
}
