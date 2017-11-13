package com.shilin.hope.amazon;

/**
 * 菜谱
 * 大概意思是给人推荐菜谱，input 是两个二维String 数组，第一个用来存菜名和
 * 对应的菜系，第二个用来存人名和这个人喜欢的菜系，要去返回一个二维
 * String 数组，存的值是人名对应可能喜欢的菜名(如果人名后面对应的是“*”，那
 * 么就表示所有菜系都要)。
 * input: String[][] menu, String[][] personPreferences
 * output: String[][] recommendation
 * example 1:
 * input: {{"Pizza", "Italian"}, {"Pasta", "Italian"}, {"Burger", "American"}}, {{"Peter",
 * "Italian"}, {"Adam", "American"}}
 * Expected output: {{"Peter", "Pizza"}, {"Peter", "Pasta"}, {"Adam", "Burger"}}
 * example 2:
 * input: {{"Pizza", "Italian"}, {"Pasta", "Italian"}, {"Burger", "American"}}, {{"Peter",
 * "*"}}
 * Expected output: {{"Peter", "Pizza"}, {"Peter", "Pasta"}, {"Peter", "Burger"}}
 * <p>
 * Created by Shilin_Gan on 11/13/2017.
 */
public class Recipe {


}
