package scopa.cona.database.manager.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scopa.cona.database.exception.DbException;
import scopa.cona.database.manager.TAttrNAttrConfManager;
import scopa.cona.database.mappers.TAttrNAttrConfMapper;
import scopa.cona.database.model.TAttrNAttrConf;

/**
 * Created by panda on 5/10/16.
 */

@Service("tAttrNAttrConfManager")
public class TAttrNAttrConfManagerImpl implements TAttrNAttrConfManager {

    public static final Logger logger = Logger.getLogger(TAttrNAttrConfManagerImpl.class);

    @Autowired
    private TAttrNAttrConfMapper tAttrNAttrConfMapper;

    @Override
    public TAttrNAttrConf selectTAttrNAttrConfById(int tAttrNAttrConfId) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (0 == tAttrNAttrConfId) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "failed to input tAttrNAttrConfId");
            throw new IllegalArgumentException("failed to input tAttrNAttrConfId");
        }

        TAttrNAttrConf tAttrNAttrConf = tAttrNAttrConfMapper.selectTAttrNAttrConfById(tAttrNAttrConfId);

        if (null == tAttrNAttrConf)
            throw DbException.ENTITY_IS_NOT_FOUND("tAttrNAttrConf");

        return tAttrNAttrConf;
    }

    @Override
    public void insertTAttrNAttrConf(TAttrNAttrConf TAttrNAttrConf) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (null == TAttrNAttrConf) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "failed to input TAttrNAttrConf");
            throw new IllegalArgumentException("failed to input TAttrNAttrConf");
        }

        tAttrNAttrConfMapper.insertTAttrNAttrConf(TAttrNAttrConf);
    }

    @Override
    public void updateTAttrNAttrConf(TAttrNAttrConf TAttrNAttrConf) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (null == TAttrNAttrConf) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "failed to input TAttrNAttrConf");
            throw new IllegalArgumentException("failed to input TAttrNAttrConf");
        }

        tAttrNAttrConfMapper.updateTAttrNAttrConf(TAttrNAttrConf);
    }

    @Override
    public void deleteTAttrNAttrConf(int tAttrNAttrConfId) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (0 == tAttrNAttrConfId) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "failed to input tAttrNAttrConfId");
            throw new IllegalArgumentException("failed to input tAttrNAttrConfId");
        }

        tAttrNAttrConfMapper.deleteTAttrNAttrConf(tAttrNAttrConfId);
    }
}
