package com.pecan.hope.amazon;

import java.util.*;

/**
 * 菜谱 大概意思是给人推荐菜谱，input 是两个二维String 数组，第一个用来存菜名和 对应的菜系，第二个用来存人名和这个人喜欢的菜系，要去返回一个二维 String
 * 数组，存的值是人名对应可能喜欢的菜名(如果人名后面对应的是“*”，那 么就表示所有菜系都要)。 input: String[][] menu, String[][] personPreferences output:
 * String[][] recommendation example 1: input: {{"Pizza", "Italian"}, {"Pasta", "Italian"}, {"Burger", "American"}},
 * {{"Peter", "Italian"}, {"Adam", "American"}} Expected output: {{"Peter", "Pizza"}, {"Peter", "Pasta"}, {"Adam",
 * "Burger"}} example 2: input: {{"Pizza", "Italian"}, {"Pasta", "Italian"}, {"Burger", "American"}}, {{"Peter", "*"}}
 * Expected output: {{"Peter", "Pizza"}, {"Peter", "Pasta"}, {"Peter", "Burger"}}
 * <p>
 * Created by Shilin_Gan on 11/13/2017.
 */
public class Recipe {

    public static void main(String[] args) {
        Recipe test = new Recipe();

        String[][] res = test.solution(new String[][]{{"Pizza", "Italian"}, {"Pasta", "Italian"}, {"Burger", "American"}}, new String[][]{{"Peter", "Italian"}, {"Adam", "American"}});

        System.out.println(Arrays.deepToString(res));
    }

    public String[][] solution(String[][] menu, String[][] personPref) {

        if (menu == null || menu.length == 0 || personPref == null || personPref.length == 0) {
            return null;
        }

        Map<String, List<String>> menuMap = new HashMap<>();

        for (String[] item : menu) {
            String origin = getCountry(item);
            if (menuMap.containsKey(origin)) {
                menuMap.get(origin).add(getFood(item));
            } else {
                menuMap.put(origin, new ArrayList<>(Arrays.asList(getFood(item))));
            }
        }

        Map<String, List<String>> match = new HashMap<>();

        for (String[] pref : personPref) {
            String name = getName(pref);
            String origin = getCountry(pref);
            if (match.containsKey(name)) {
                if ("*".equals(origin)) {
                    match.get(name).addAll(getAllFoods(menuMap));
                } else {
                    match.get(name).addAll(menuMap.get(origin));
                }
            } else {
                if ("*".equals(origin)) {
                    match.put(name, new ArrayList<>(getAllFoods(menuMap)));
                } else {
                    match.put(name, new ArrayList<>(menuMap.get(origin)));
                }
            }
        }

        String[][] res = new String[getSize(match)][];

        int i = 0;
        for (Map.Entry<String, List<String>> entry : match.entrySet()) {
            for (String food : entry.getValue()) {
                res[i] = new String[]{entry.getKey(), food};
                i++;
            }
        }

        return res;
    }

    private Integer getSize(Map<String, List<String>> menuMap) {
        int res = 0;
        for (Map.Entry<String, List<String>> entry : menuMap.entrySet()) {
            res += entry.getValue().size();
        }
        return res;
    }

    private Collection<String> getAllFoods(Map<String, List<String>> menuMap) {
        List<String> res = new ArrayList<>();

        for (Map.Entry<String, List<String>> entry : menuMap.entrySet()) {
            res.addAll(entry.getValue());
        }

        return res;
    }

    private String getName(String[] pref) {
        return pref[0];
    }

    private String getCountry(String[] item) {
        return item[1];
    }

    private String getFood(String[] item) {
        return item[0];
    }


}
