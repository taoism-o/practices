package com.linewell.desk.quest.area;

import com.linewell.desk.quest.data.DataUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;

@Service
public class AreaService implements InitializingBean {

	private static HashMap<String, String> areaMap;

	/**
	 * @param mobile 手机号
	 * @return 返回的地区，如果未查到，返回null
	 */
	public Area getArea(String mobile) throws IOException {
		if (null == areaMap) {
			areaMap = DataUtils.getAreaMap();
		}

		String mobilePrefix = mobile.substring(0,7);
		String areaValue = areaMap.get(mobilePrefix);

		if (null == areaValue) {
			return null;
		}

		String[] areaArray = areaValue.split("\\s");

		Area area = new Area(Integer.valueOf(mobilePrefix), Short.valueOf(areaArray[0]), areaArray[1]);

		return area;
	}

	@Override
	public void afterPropertiesSet() throws Exception {

	}
}
