package scopa.cona.database.manager;

import scopa.cona.database.model.TAttrNAttrConf;

/**
 * Created by panda on 5/10/16.
 */
public interface TAttrNAttrConfManager {
    TAttrNAttrConf selectTAttrNAttrConfById(int tAttrNAttrConfId);
    void insertTAttrNAttrConf(TAttrNAttrConf TAttrNAttrConf);
    void updateTAttrNAttrConf(TAttrNAttrConf TAttrNAttrConf);
    void deleteTAttrNAttrConf(int tAttrNAttrConfId);
}
