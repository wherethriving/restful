package scopa.cona.database.model;

/**
 * Created by panda on 5/10/16.
 */
public class TargetAttr {
    private Integer targetAttrId;
    private Integer targetTableId;
    private String nameCn;
    private String nameEn;
    private String elementType;
    private Boolean originTbIsExisted;
    private Boolean isPrimaryAttr;
    private String description;
    private String hdfsSavedType;
    private Integer offset;

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getTargetAttrId() {
        return targetAttrId;
    }

    public void setTargetAttrId(Integer targetAttrId) {
        this.targetAttrId = targetAttrId;
    }

    public Integer getTargetTableId() {
        return targetTableId;
    }

    public void setTargetTableId(Integer targetTableId) {
        this.targetTableId = targetTableId;
    }

    public String getNameCn() {
        return nameCn;
    }

    public void setNameCn(String nameCn) {
        this.nameCn = nameCn;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public String getElementType() {
        return elementType;
    }

    public void setElementType(String elementType) {
        this.elementType = elementType;
    }

    public Boolean getOriginTbIsExisted() {
        return originTbIsExisted;
    }

    public void setOriginTbIsExisted(Boolean originTbIsExisted) {
        this.originTbIsExisted = originTbIsExisted;
    }

    public Boolean getIsPrimaryAttr() {
        return isPrimaryAttr;
    }

    public void setIsPrimaryAttr(Boolean isPrimaryAttr) {
        this.isPrimaryAttr = isPrimaryAttr;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHdfsSavedType() {
        return hdfsSavedType;
    }

    public void setHdfsSavedType(String hdfsSavedType) {
        this.hdfsSavedType = hdfsSavedType;
    }
}
