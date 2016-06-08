package scopa.cona.database.manager.impl;


import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import scopa.cona.database.model.TargetAttr;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class TargetAttrManagerTest {

	public static final Logger logger = Logger.getLogger(TargetAttrManagerTest.class);

	@Autowired
	private scopa.cona.database.manager.TargetAttrManager TargetAttrManager;

	@Test
	public void testTargetAttrCUR() {

		logger.info(this.getClass().getSimpleName() + " ==== " +
				Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
				"begin test");

		TargetAttr targetAttr = new TargetAttr();
		targetAttr.setTargetTableId(1);
		targetAttr.setNameCn("简要案情");
		targetAttr.setNameEn("CASE_jyaq");
		targetAttr.setElementType("String");
		targetAttr.setHdfsSavedType("text");
		targetAttr.setOriginTbIsExisted(true);
		targetAttr.setDescription("简要案情");
		targetAttr.setIsPrimaryAttr(true);
		targetAttr.setOffset(6);

		TargetAttrManager.insertTargetAttr(targetAttr);
		//TargetAttr insertTargetAttr = TargetAttrManager.selectTargetAttrById(targetAttr.getTargetAttrId());
/**
		assert (null != insertTargetAttr);
		assert (insertTargetAttr.getTargetTableId().equals(1));
		assert (insertTargetAttr.getNameCn().equals("群组名称"));
		assert (insertTargetAttr.getNameEn().equals("qzmc"));
		assert (insertTargetAttr.getElementType().equals("String"));
		assert (insertTargetAttr.getHdfsSavedType().equals("Text"));
		assert (insertTargetAttr.getOriginTbIsExisted().equals(true));
		assert (insertTargetAttr.getIsPrimaryAttr().equals(true));
		assert (insertTargetAttr.getDescription().equals("group"));
		assert (insertTargetAttr.getOffset().equals(92));


		logger.info(this.getClass().getSimpleName() + " ==== " +
				Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
				"pass insert select");

		insertTargetAttr.setNameCn("人户关系");
		TargetAttrManager.updateTargetAttr(insertTargetAttr);

		TargetAttr updatedTargetAttr = TargetAttrManager.selectTargetAttrById(
				targetAttr.getTargetAttrId());

		assert (null != insertTargetAttr);
		assert (insertTargetAttr.getNameCn().equals("人户关系"));

		logger.info(this.getClass().getSimpleName() + " ==== " +
				Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
				"pass update");
 */
	}

	@Test
	public void testTargetAttrD() {
		logger.info(this.getClass().getSimpleName() + " ==== " +
				Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
				"begin test");

		TargetAttr targetAttr = new TargetAttr();
		targetAttr.setTargetTableId(1);
		targetAttr.setNameCn("群组名称");
		targetAttr.setNameEn("qzmc");
		targetAttr.setElementType("String");
		targetAttr.setHdfsSavedType("Text");
		targetAttr.setOriginTbIsExisted(true);
		targetAttr.setDescription("group");
		targetAttr.setIsPrimaryAttr(true);
		targetAttr.setOffset(92);

		TargetAttrManager.insertTargetAttr(targetAttr);
		TargetAttr insertTargetAttr = TargetAttrManager.selectTargetAttrById(targetAttr.getTargetAttrId());

		assert (null != insertTargetAttr);

		TargetAttrManager.deleteTargetAttr(targetAttr.getTargetAttrId());
		TargetAttr dTargetAttr = TargetAttrManager.selectTargetAttrById(targetAttr.getTargetAttrId());

		assert (null == dTargetAttr);

		logger.info(this.getClass().getSimpleName() + " ==== " +
				Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
				"pass delete");
	}

	@Test
	public void testSelectTargetAttrByName() {
		logger.info(this.getClass().getSimpleName() + " ==== " +
				Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
				"begin test");

		TargetAttr targetAttr = new TargetAttr();
		targetAttr.setTargetTableId(11);
		targetAttr.setNameCn("群组名称");
		targetAttr.setNameEn("qzmc");
		targetAttr.setElementType("String");
		targetAttr.setHdfsSavedType("Text");
		targetAttr.setOriginTbIsExisted(true);
		targetAttr.setDescription("group");
		targetAttr.setIsPrimaryAttr(true);
		targetAttr.setOffset(92);

		TargetAttrManager.insertTargetAttr(targetAttr);

		TargetAttr targetAttr1 = new TargetAttr();
		targetAttr1.setTargetTableId(11);
		targetAttr1.setNameCn("关键人物");
		targetAttr1.setNameEn("MVP");
		targetAttr1.setElementType("String");
		targetAttr1.setHdfsSavedType("Text");
		targetAttr1.setOriginTbIsExisted(true);
		targetAttr1.setDescription("group");
		targetAttr1.setIsPrimaryAttr(true);
		targetAttr1.setOffset(92);

		TargetAttrManager.insertTargetAttr(targetAttr1);

		Integer targetTableId = 11;
		List<TargetAttr> selectedTargetAttr = TargetAttrManager.
				getTargetAttrByTargetTableId(targetTableId);

		int size = selectedTargetAttr.size();

		for (int i = size - 1; i > size - 3; i--) {
			TargetAttr tAttr = selectedTargetAttr.get(i);
			if (i == size - 2) {
				assert (tAttr.getNameCn().equals("群组名称"));
			} else if (i == size - 1) {
				assert (tAttr.getNameEn().equals("MVP"));
			}
		}

	}

}
