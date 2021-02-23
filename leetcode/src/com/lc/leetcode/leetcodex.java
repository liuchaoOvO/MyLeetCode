package com.lc.leetcode;

/**
 * @author liuchao02
 * @ClassName: leetcodex
 * @Description:最大公共子串 动态规划 解决 最大公共子串 模板代码demo
 * 详见：https://mp.weixin.qq.com/s/Yx3uRVGFYikx8gm-oi-0vg
 * @date 2021/2/23 18:33
 */
public class leetcodex {
    public static void main(String[] args) {
        System.out.println("result:--->" + lcsUseDynamicProgram("abc", "bcd"));
    }
    //使用动态规划解决 查询最长公共子串
    public static String lcsUseDynamicProgram(String str1, String str2) {
        char[] strChar1 = str1.toCharArray();
        char[] strChar2 = str2.toCharArray();
        int maxLen = 0; //公共子串最大长度
        int index = 0;  //需要开始截断的位置
        int[][] arr = new int[strChar1.length + 1][strChar2.length + 1];
        //初始化[*][0] 和[0][*] 为0
        for (int i = 0; i < strChar1.length; i++) {
            for (int j = 0; j < strChar2.length; j++) {
                if (i == 0 || j == 0) arr[i][j] = 0;
            }
        }
        for (int i = 0; i < strChar1.length; i++) {
            for (int j = 0; j < strChar2.length; j++) {
                if (strChar1[i] != strChar2[j]) {
                    arr[i + 1][j + 1] = 0;
                } else {
                    arr[i + 1][j + 1] = arr[i][j] + 1;
                }
                if (arr[i + 1][j + 1] > maxLen) {
                    maxLen = arr[i + 1][j + 1];
                    index = i;
                }
            }
        }
        String resultStr = "";
        if (maxLen == 0) {
            resultStr = "";
        } else
            resultStr = "";
        //str1.substring(index - 1, str1.length()-maxLen+1); 根据index 和maxLen 截断方式 待todo
        return resultStr;






        //1.  建立两个变量去存储其实位置的index 和最大长度 maxLen
        /*
         * var maxLen = 0;
var index = 0;
for(var i = 0; i <= str1.length; i++){
    for(var j = 0; j <= str2.length; j++){
        if(i == 0 || j == 0){
            arr[i][j] = 0
        }else{
            if (str1[i] == str2[j] && str1[i - 1] == str2[j - 1]) {
                arr[i][j] = arr[i - 1][j - 1] + 1;
            }else{
                arr[i][j] = 0;
            }
        }
        if(arr[i][j] > maxLen){
            maxLen = arr[i][j];
            index = i;
        }
    }
}
         */

        //2.接下来就是选择其中的一个字符串去截取字串
        //var str = "";
        //if(maxLen == 0){
        //    return "";
        //}else{
        //    for(var k = index - maxLen; k < maxLen; k++){
        //        str += str1[k];
        //    }
        //    return str;
        //}
    }
}
