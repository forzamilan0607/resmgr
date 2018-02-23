package com.chris.common.utils;

import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.regex.Pattern;


/**
 * 身份证号码有效性验证
 * @author chris
 * @since2016-09-28
 */
public final class IdCardValidator {
    private static final String SUCCESS = "0";

    private static final Map<String, String> AREA_CODES = new HashMap<>();

    static {
        AREA_CODES.put("11", "北京");
        AREA_CODES.put("12", "天津");
        AREA_CODES.put("13", "河北");
        AREA_CODES.put("14", "山西");
        AREA_CODES.put("15", "内蒙古");
        AREA_CODES.put("21", "辽宁");
        AREA_CODES.put("22", "吉林");
        AREA_CODES.put("23", "黑龙江");
        AREA_CODES.put("31", "上海");
        AREA_CODES.put("32", "江苏");
        AREA_CODES.put("33", "浙江");
        AREA_CODES.put("34", "安徽");
        AREA_CODES.put("35", "福建");
        AREA_CODES.put("36", "江西");
        AREA_CODES.put("37", "山东");
        AREA_CODES.put("41", "河南");
        AREA_CODES.put("42", "湖北");
        AREA_CODES.put("43", "湖南");
        AREA_CODES.put("44", "广东");
        AREA_CODES.put("45", "广西");
        AREA_CODES.put("46", "海南");
        AREA_CODES.put("50", "重庆");
        AREA_CODES.put("51", "四川");
        AREA_CODES.put("52", "贵州");
        AREA_CODES.put("53", "云南");
        AREA_CODES.put("54", "西藏");
        AREA_CODES.put("61", "陕西");
        AREA_CODES.put("62", "甘肃");
        AREA_CODES.put("63", "青海");
        AREA_CODES.put("64", "宁夏");
        AREA_CODES.put("65", "新疆");
        AREA_CODES.put("71", "台湾");
        AREA_CODES.put("81", "香港");
        AREA_CODES.put("82", "澳门");
        AREA_CODES.put("91", "国外");
    }
    /**
     *
     * @description:验证主方法，里面会调用所有方法来验证
     * @author chris
     * @param idCard
     * @return
     * @throws ParseException
     */
    public static String validate(String idCard) throws ParseException {
        String ai = "";
        // 判断号码的长度 15位或18位  
        if (idCard.length() != 15 && idCard.length() != 18) {
            return "身份证号码长度应该为15位或18位。";
        }

        // 18位身份证前17位位数字，如果是15位的身份证则所有号码都为数字  
        if (idCard.length() == 18) {
            ai = idCard.substring(0, 17);
        } else if (idCard.length() == 15) {
            ai = idCard.substring(0, 6) + "19" + idCard.substring(6, 15);
        }
        if (isNumeric(ai) == false) {
            return "身份证15位号码都应为数字 ; 18位号码除最后一位外，都应为数字。";
        }
        // 判断出生年月是否有效
        String strYear = ai.substring(6, 10);// 年份
        String strMonth = ai.substring(10, 12);// 月份
        String strDay = ai.substring(12, 14);// 日期
        if (!isValidDate(strYear + "-" + strMonth + "-" + strDay)) {
            return "身份证出生日期无效。";
        }
        GregorianCalendar gc = new GregorianCalendar();
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        try {
            if ((gc.get(Calendar.YEAR) - Integer.parseInt(strYear)) > 150
                    || (gc.getTime().getTime() - s.parse(
                    strYear + "-" + strMonth + "-" + strDay).getTime()) < 0) {
                return "身份证生日不在有效范围。";
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }
        if (Integer.parseInt(strMonth) > 12 || Integer.parseInt(strMonth) == 0) {
            return "身份证月份无效";
        }
        if (Integer.parseInt(strDay) > 31 || Integer.parseInt(strDay) == 0) {
            return "身份证日期无效";
        }
        // 判断地区码是否有效
        //如果身份证前两位的地区码不在Hashtable，则地区码有误
        if (StringUtils.isEmpty(AREA_CODES.get(ai.substring(0, 2)))) {
            return "身份证地区编码错误。";
        }

        if(isVarifyCode(ai,idCard)==false){
            return "身份证校验码无效，不是合法的身份证号码";
        }
        return SUCCESS;
    }  
      
      
     /* 
      * 判断第18位校验码是否正确 
     * 第18位校验码的计算方式：  
        　　1. 对前17位数字本体码加权求和  
        　　公式为：S = Sum(Ai * Wi), i = 0, ... , 16  
        　　其中Ai表示第i个位置上的身份证号码数字值，Wi表示第i位置上的加权因子，其各位对应的值依次为： 7 9 10 5 8 4 2 1 6 3 7 9 10 5 8 4 2  
        　　2. 用11对计算结果取模  
        　　Y = mod(S, 11)  
        　　3. 根据模的值得到对应的校验码  
        　　对应关系为：  
        　　 Y值：     0  1  2  3  4  5  6  7  8  9  10  
        　　校验码： 1  0  X  9  8  7  6  5  4  3   2 
     */
    /**
     *
     * @description: 用于计算验证身份证号码最后一位的正确性
     * @author chris
     * @param ai
     * @param idCard
     * @return
     */
    private static boolean isVarifyCode(String ai,String idCard) {
        String[] VarifyCode = { "1", "0", "X", "9", "8", "7", "6", "5", "4","3", "2" };
        String[] Wi = { "7", "9", "10", "5", "8", "4", "2", "1", "6", "3", "7","9", "10", "5", "8", "4", "2" };
        int sum = 0;
        for (int i = 0; i < 17; i++) {
            sum = sum + Integer.parseInt(String.valueOf(ai.charAt(i))) * Integer.parseInt(Wi[i]);
        }
        int modValue = sum % 11;
        String strVerifyCode = VarifyCode[modValue];
        ai = ai + strVerifyCode;
        if (idCard.length() == 18) {
            if (!ai.equals(idCard)) {
                return false;
            }
        }
        return true;
    }

    /**
     * @author chris
     * 判断字符串是否为数字,0-9重复0次或者多次    
     * @param strnum
     * @return
     */
    private static boolean isNumeric(String strnum) {
        Pattern pattern = Pattern.compile("[0-9]*");
        return pattern.matcher(strnum).matches();
    }

    /**
     * @author chris
     * 功能：判断字符串出生日期是否符合正则表达式：包括年月日，闰年、平年和每月31天、30天和闰月的28天或者29天 
     * @param strDate
     * @return
     */
    public static boolean isValidDate(String strDate) {
        Pattern pattern = Pattern
                .compile("^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))?$");
        return pattern.matcher(strDate).matches();
    }

    public static void main(String[] args) throws ParseException {
        System.out.println(validate("430381199003180066"));
    }


}

