package scopa.cona.database.manager;

import scopa.cona.database.model.OTAttrMapping;

import java.util.List;

/**
 * Created by panda on 5/10/16.
 */
public interface OTAttrMappingManager {
    OTAttrMapping selectOTAttrMappingById(int otAttrMappingId);
    void insertOTAttrMapping(OTAttrMapping otAttrMapping);
    void updateOTAttrMapping(OTAttrMapping otAttrMapping);
    void deleteOTAttrMapping(int otAttrMappingId);
    List<OTAttrMapping> getOTAttrMappingByTAttrId(List<Integer> targetAttrId);
    List<OTAttrMapping> getOTAttrMappingByOAttrId(List<Integer> originAttrIds);
}
