package com.hafele.util;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
* @author Dragon Wen E-mail:18475536452@163.com
* @version ����ʱ�䣺2018��1��9�� ����5:04:31
* JsonUtil
*/
public class JsonUtil {
	/**
	 * ��ResultSet����ת����JsonArray����
	 * @param rs
	 * @return
	 * @throws Exception
	 */
	public static JSONArray formatRsToJsonArray(ResultSet rs)throws Exception{
		ResultSetMetaData md=rs.getMetaData();
		int num=md.getColumnCount();
		JSONArray array=new JSONArray();
		while(rs.next()){
			JSONObject mapOfColValues=new JSONObject();
			for(int i=1;i<=num;i++){
				if(md.getColumnName(i).equals("birthday")||md.getColumnName(i).equals("time")){
					mapOfColValues.put(md.getColumnName(i), rs.getString(i)); //��ȡ������ֵ�Ž�JSON���������
				}else{
					mapOfColValues.put(md.getColumnName(i), rs.getObject(i)); //��ȡ������ֵ�Ž�JSON���������
				}
			}
			array.add(mapOfColValues);//�ŵ�JSON������
		}
		return array;
	}
}
