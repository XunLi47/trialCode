package com.tc.trialCode.trial.util;


import java.util.Arrays;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;





public class MessageUtil {
	private static final Logger logger = LoggerFactory.getLogger(MessageUtil.class);
	public static final String DEFAULT_CODE = "utf-8";

	/**
	 * 签名
	 * 
	 * @param sign

	 */
	public static String sign(Map<String,Object> map,String secretKey) throws Exception {
		
        StringBuilder contentBuffer = new StringBuilder();
		Object[] signParamArray = map.keySet().toArray();
		Arrays.sort(signParamArray);
		for (Object key : signParamArray) {
			Object value = map.get(key);
			if (!"digest".equals(key) && value!=null&& !value.equals("")) {
				contentBuffer.append(key + "=" + value + "&");
			}
		}
		
		String sign=contentBuffer.substring(0, contentBuffer.length()-1)+secretKey;
		System.out.println("======="+sign);
		logger.info("签名前 str ：{}", sign);
		sign =CertUtil.Md5(sign,DEFAULT_CODE);
		System.out.println("xxx="+sign);
		logger.info("xxx str ：{}", sign);

		return sign;
	}
	
	
	public static boolean verifySign(Map<String,Object> map,String secretKey) throws Exception
	{
		boolean result = false;
		String sign="";
		String originSign = (String) map.get("sign");
		System.out.println("originSign="+originSign);
		map.remove("sign");
		sign = sign(map,secretKey);
		System.out.println("sign="+sign);
		if(sign.equals(originSign))result = true;
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(CertUtil.Md5("application=app64672551304953856&content=[ECU]您的验证码是:500101&source=4&timestamp=131249668401574000&to=13918605120&type=0TINTEMY1120JCX"));
	}
	


}
