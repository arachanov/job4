package ru.job4j.condition;

public class Max {
    public int max(int first, int second) {
        int result = first > second ? first : second;
        return result;
    }
    public int max(int first, int second, int third) {
        int result = first > second ? first : second;
        return max(result, third);
    }
    public int max(int first, int second, int third, int four) {
        int result = first > second ? first : second;
        int max3 = max(result, third);
        return max(max3, four);
    }
}