package scopa.cona.database.manager.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scopa.cona.database.exception.DbException;
import scopa.cona.database.manager.TargetTableManager;
import scopa.cona.database.mappers.TargetTableMapper;
import scopa.cona.database.model.TargetTable;

/**
 * Created by panda on 5/10/16.
 */

@Service("targetTableManager")
public class TargetTableManagerImpl implements TargetTableManager {

    public static final Logger logger = Logger.getLogger(TargetTableManagerImpl.class);

    @Autowired
    private TargetTableMapper targetTableMapper;

    @Override
    public TargetTable selectTargetTableById(int targetTableId) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (0 == targetTableId) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "failed to input targetTableId");
            throw new IllegalArgumentException("failed to input targetTableId");
        }

        TargetTable targetTable = targetTableMapper.selectTargetTableById(targetTableId);

        if (null == targetTable)
            throw DbException.ENTITY_IS_NOT_FOUND("targetTable");

        return targetTable;
    }

    @Override
    public void insertTargetTable(TargetTable targetTable) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (null == targetTable) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "failed to input targetTable");
            throw new IllegalArgumentException("failed to input targetTable");
        }

        targetTableMapper.insertTargetTable(targetTable);
    }

    @Override
    public void updateTargetTable(TargetTable targetTable) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (null == targetTable) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "failed to input targetTable");
            throw new IllegalArgumentException("failed to input targetTable");
        }

        targetTableMapper.updateTargetTable(targetTable);
    }

    @Override
    public void deleteTargetTable(int targetTableId) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (0 == targetTableId) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "failed to input targetTableId");
            throw new IllegalArgumentException("failed to input targetTableId");
        }

        targetTableMapper.deleteTargetTable(targetTableId);
    }

    @Override
    public TargetTable getTargetTableByLabelEn(String labelEn) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (null == labelEn) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "failed to input labelEn");
            throw new IllegalArgumentException("failed to input labelEn");
        }

        TargetTable targetTable = targetTableMapper.selectTargetTableByLabelEn(labelEn);

        if (null == targetTable)
            throw DbException.ENTITY_IS_NOT_FOUND("targetTable");

        return targetTable;
    }
}
