package scopa.cona.database.model;

/**
 * Created by panda on 5/10/16.
 */
public class TargetTable {
    private Integer targetTableId;
    private String labelCn;
    private String labelEn;
    private String tbType;
    private Integer tbNumber;
    private String description;
    private Float version;

    public Integer getTargetTableId() {
        return targetTableId;
    }

    public void setTargetTableId(Integer targetTableId) {
        this.targetTableId = targetTableId;
    }

    public String getLabelCn() {
        return labelCn;
    }

    public void setLabelCn(String labelCn) {
        this.labelCn = labelCn;
    }

    public String getLabelEn() {
        return labelEn;
    }

    public void setLabelEn(String labelEn) {
        this.labelEn = labelEn;
    }

    public String getTbType() {
        return tbType;
    }

    public void setTbType(String tbType) {
        this.tbType = tbType;
    }

    public Integer getTbNumber() {
        return tbNumber;
    }

    public void setTbNumber(Integer tbNumber) {
        this.tbNumber = tbNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getVersion() {
        return version;
    }

    public void setVersion(Float version) {
        this.version = version;
    }
}
