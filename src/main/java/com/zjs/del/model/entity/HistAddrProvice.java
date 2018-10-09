package com.zjs.del.model.entity;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Created by Liwh on 2018/4/19.
 * Description:历史地址对应所有的省份
 */
public class HistAddrProvice {
    private HistAddrProvice(){}
    public static String getTabName(String proviceName) {
        Map<String, String> map = new HashMap<>();
        map.put("澳门", "FD_HIST_ADD_AOMEN");
        map.put("安徽", "FD_HIST_ADD_ANHUI");
        map.put("北京", "FD_HIST_ADD_BEIJING");
        map.put("重庆", "FD_HIST_ADD_CHONGQING");
        map.put("福建", "FD_HIST_ADD_FUJIAN");
        map.put("甘肃", "FD_HIST_ADD_GANSU");
        map.put("广东", "FD_HIST_ADD_GUANGDONG");
        map.put("广西", "FD_HIST_ADD_GUANGXI");
        map.put("贵州", "FD_HIST_ADD_GUIZHOU");
        map.put("海南", "FD_HIST_ADD_HAINAN");
        map.put("河北", "FD_HIST_ADD_HEBEI");
        map.put("黑龙江", "FD_HIST_ADD_HEILONGJIANG");
        map.put("河南", "FD_HIST_ADD_HENAN");
        map.put("香港", "FD_HIST_ADD_HONGKONG");
        map.put("湖北", "FD_HIST_ADD_HUBEI");
        map.put("湖南", "FD_HIST_ADD_HUNAN");
        map.put("江苏", "FD_HIST_ADD_JIANGSU");
        map.put("江西", "FD_HIST_ADD_JIANGXI");
        map.put("吉林", "FD_HIST_ADD_JILIN");
        map.put("辽宁", "FD_HIST_ADD_LIAONING");
        map.put("内蒙古", "FD_HIST_ADD_NEIMENGGU");
        map.put("宁夏", "FD_HIST_ADD_NINGXIA");
        map.put("青海", "FD_HIST_ADD_QINGHAI");
        map.put("山东", "FD_HIST_ADD_SHANDONG");
        map.put("上海", "FD_HIST_ADD_SHANGHAI");
        map.put("山西", "FD_HIST_ADD_SHANXI");
        map.put("陕西", "FD_HIST_ADD_SHANXI2");
        map.put("四川", "FD_HIST_ADD_SICHUAN");
        map.put("台湾", "FD_HIST_ADD_TAIWAN");
        map.put("天津", "FD_HIST_ADD_TIANJIN");
        map.put("新疆", "FD_HIST_ADD_XINJIANG");
        map.put("西藏", "FD_HIST_ADD_XIZANG");
        map.put("云南", "FD_HIST_ADD_YUNNAN");
        map.put("浙江", "FD_HIST_ADD_ZHEJIANG");
        Iterator<Entry<String, String>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()){
        	Entry<String, String> next = iterator.next();
        	if (proviceName.contains(next.getKey())) {
				return next.getValue();
			}
        }
        return null;
    }
}
