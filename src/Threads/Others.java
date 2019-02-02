import java.util.Map;

import utils.MyJavaUtils;

/*
 * //*********************************************** // Copyright UNITEDHEALTH GROUP CORPORATION 2018. // This software
 * and documentation contain confidential and // proprietary information owned by UnitedHealth Group Corporation. //
 * Unauthorized use and distribution are prohibited. //***********************************************
 */

/**
 */
public class Others {

    public static void main(String[] args) {
        System.out.println(covertRomansToNumber("XIVCMM"));
    }

    public static String covertNumberToRomans(Integer Number) {
        return "";
    }

    public static Integer covertRomansToNumber(String romanNumber) {
        if (romanNumber == null || romanNumber == " ") {
            return 0;
        }
        final char[] array = romanNumber.toCharArray();
        final int length = array.length;
        final Map<String, Integer> romantToNumberMap = MyJavaUtils.getRomansToNumberMap();
        if (length == 1) {
            return romantToNumberMap.get(String.valueOf(array[0]));
        }
        Integer sum = romantToNumberMap.get(String.valueOf(array[length - 1]));
        for (int i = length - 2; i >= 0; i--) {
            if (romantToNumberMap.get(String.valueOf(array[i])) < romantToNumberMap.get(String.valueOf(array[i + 1]))) {
                sum = sum - romantToNumberMap.get(String.valueOf(array[i]));
            } else {
                sum = romantToNumberMap.get(String.valueOf(array[i])) + sum;

            }

        }
        return sum;

    }

    public static boolean checkIfPrime(Integer number) {
        for (int index = 2; index < Math.sqrt(number); index++) {
            if (number % index == 0) {
                return false;
            }
        }
        return true;
    }

    public static int choclateWrapperProblem(int money, int price, int wrapper) {
        return 0;
    }

}
