package hackerrank.search;

import java.util.List;
import java.util.TreeSet;

// https://www.hackerrank.com/challenges/maximum-subarray-sum/problem?isFullScreen=false
final class MaxSubArray {
    public static void main(String[] args) {
        //System.out.println(maximumSum(List.of(3L, 3L, 9L, 9L, 5L), 7L));

        System.out.println(maximumSum(List.of(354724723L, 116663117L, 1885681600L, 474513639L, 2048518168L, 1798715778L, 1154451359L, 560856756L, 1265212167L, 1048886968L, 639685644L, 1765763845L, 1962254641L, 1433464549L, 499924441L, 1054240376L, 1022523980L, 388882895L, 1541208731L, 970773431L, 1604797159L, 1508755786L, 352886413L, 1673921314L, 1488688549L, 422151782L, 1680803283L, 240145938L, 743965900L, 1827917457L, 1639906102L, 1098690623L, 1944580573L, 1378104053L, 1573204261L, 1845615092L, 1029336182L, 580171972L, 258988200L, 147064700L, 1629058939L, 898673843L, 1912828544L, 1443829931L, 184654743L, 265269336L, 350586658L, 1207178723L, 654152230L, 1891795388L, 30468505L, 111465741L, 1253067526L, 383354917L, 1785387054L, 594272426L, 805506698L, 1318706689L, 834418363L, 1549472597L, 999140497L, 326840816L, 500679571L, 796237422L, 1704944868L, 2073883832L, 494368865L, 586797401L, 506572155L, 753357064L, 733862100L, 2135631093L, 1652030907L, 499206995L, 1431977375L, 1836685649L, 764476331L, 1782564032L, 896380723L, 1418628560L, 1526875771L, 926849227L, 1530094300L, 632459648L, 1310204143L, 1167997706L, 1226732073L, 2115710840L, 339220746L, 2061150436L, 1517699789L, 1338361242L, 240507603L, 2018379359L, 2134598663L, 1945452471L, 1944779542L, 481483880L, 384766223L, 303868048L),
                1399760164L));

        System.out.println(maximumSum(List.of(1118628323L, 292015492L, 739388201L, 1617835317L, 1723992866L, 428590202L, 234827999L, 1359073249L, 1324970924L, 1653456559L, 738465372L, 104336503L, 1036067210L, 1370925019L, 1414540645L, 56581267L, 450173444L, 1382767837L, 395802012L, 363840231L, 752983977L, 1734163254L, 604347833L, 623879687L, 1721278268L, 402316655L, 421175581L, 55278499L, 787082878L, 725043628L, 1290119442L, 1905711200L, 1017059120L, 2029507642L, 1376062868L, 593568337L, 310614195L, 1610890867L, 1952641586L, 1635585119L, 1116863777L, 543623309L, 1739921621L, 5447338L, 1914548327L, 1006978617L, 62028605L, 217238122L, 242262805L, 457830616L, 581078352L, 995246781L, 44510221L, 1185426185L, 1619126468L, 1765788489L, 1587742839L, 2040302048L, 1821066987L, 227342068L, 617862027L, 963702780L, 2133053267L, 1634921146L, 845726774L, 1361632487L, 81005835L, 1156340968L, 825039705L, 2033647420L, 644442438L, 1941903481L, 429787080L, 236880410L, 1947350818L, 196851758L, 1243859027L, 2009379422L, 414089880L, 1486121831L, 319726390L, 995168231L, 333884964L, 364236610L, 33110767L, 1953011431L, 2130025098L, 1620853606L, 1845829830L, 1803608437L, 1848195673L, 316208208L, 619827568L, 1833765292L, 1951129354L, 1465554341L, 1047914130L, 2032135188L, 474411661L, 1872953834L),
                1234840943L));

        //System.out.println(maximumSum(List.of(-2L,1L,-3L,4L,-1L,2L,1L,-5L,4L), 0L));

        //System.out.println(maximumSum(List.of(3L, 3L, 9L, 9L, 5L), 7L));
//        System.out.println(maximumSum(List.of(1L, 3L,6L, 4L, 2L), 5L));

        /*
            [1]
            [2]
            [3]
            [1,2]
            [2,3]
            [1,2,3]
         */
    }

    public static long maximumSum(List<Long> a, long m) {
        return maximumSum(a, 0, a.size() - 1, m);
    }

    private static long maximumSum(List<Long> arr, int left, int right, long m) {
        if (left == right) {
            return arr.get(left) % m;
        }

        int mid = (left + right) / 2;

        long leftMax = maximumSum(arr, left, mid, m);
        long rightMax = maximumSum(arr, mid + 1, right, m);
        long crossMax = maximumCrossingSum(arr, left, mid, right, m);

        return Math.max(Math.max(leftMax, rightMax), crossMax);
    }

    private static long maximumCrossingSum(List<Long> arr, int left, int middle, int right, long m) {
        long leftSum = 0;
        long rightSum = 0;
        long maxModSum = 0;

        // Find maximum subarray sum for the left part and right part
        long tempSum = 0;
        for (int i = middle; i >= left; i--) {
            tempSum = (tempSum + arr.get(i) % m + m) % m;
            leftSum = Math.max(leftSum, tempSum);
        }

        tempSum = 0;
        for (int i = middle + 1; i <= right; i++) {
            tempSum = (tempSum + arr.get(i) % m + m) % m;
            rightSum = Math.max(rightSum, tempSum);
        }

        maxModSum = (leftSum + rightSum) % m;

        // Find maximum subarray sum for the case where the subarray crosses the middle
        TreeSet<Long> rightPrefixSums = new TreeSet<>();
        tempSum = 0;
        for (int i = middle + 1; i <= right; i++) {
            tempSum = (tempSum + arr.get(i) % m + m) % m;
            rightPrefixSums.add(tempSum);
        }

        tempSum = 0;
        for (int i = middle; i >= left; i--) {
            tempSum = (tempSum + arr.get(i) % m + m) % m;
            maxModSum = Math.max(maxModSum, tempSum);

            Long higher = rightPrefixSums.ceiling((m - tempSum) % m);
            if (higher != null) {
                maxModSum = Math.max(maxModSum, (tempSum + higher) % m);
            }
        }

        return maxModSum;
    }
}