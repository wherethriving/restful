package scopa.cona.database.mappers;

import scopa.cona.database.model.TAttrNAttrConf;
import scopa.cona.database.model.TargetTable;

/**
 * Created by panda on 5/10/16.
 */
public interface TAttrNAttrConfMapper {
    TAttrNAttrConf selectTAttrNAttrConfById(int tAttrNAttrConfId);
    void insertTAttrNAttrConf(TAttrNAttrConf TAttrNAttrConf);
    void updateTAttrNAttrConf(TAttrNAttrConf TAttrNAttrConf);
    void deleteTAttrNAttrConf(int tAttrNAttrConfId);
}
