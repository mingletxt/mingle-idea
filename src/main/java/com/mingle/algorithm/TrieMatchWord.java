package com.mingle.algorithm;

import java.util.Scanner;

/**
 * User: mingle
 * Date: 12-11-27
 * Time: 下午11:17
 * desc
 */


class Trie { //字典树
    Trie next[] = new Trie[26];//所有儿子节点
    String enWord;// 用于记录对应的英语单词

    public Trie() {
        enWord = null;
    }
}

public class TrieMatchWord {
    Trie root = new Trie();

    void solve() {
        Scanner in = new Scanner(System.in);
        String input;
        String[] array = new String[2];
        while (in.hasNext()) {//用所有外文字符串,构造字典树
            input = in.nextLine();
            if (input.length() == 0) break;
            array = input.split(" ");
            insert(array[1], array[0]);
        }
        while (in.hasNext()) {
            input = in.nextLine();
            System.out.println(search(input));
        }
    }

    //建立字典树
    public void insert(String str, String enWord) {  //将一个外文字符串插入字典树
        if (str == null || str.length() == 0) {
            return;
        }
        Trie node = root;
        char[] letters = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            int pos = letters[i] - 'a';
            if (node.next[pos] == null) {
                node.next[pos] = new Trie();
                //node.son[pos].val = letters[i];
            }
            node = node.next[pos];
        }
        //外文字符串的最后一个节点,根节点到此节点构成了一个外文单词,此单词对应的英文单词为enWord;
        node.enWord = enWord;
    }


    // 在字典树中查找一个完全匹配的外文单词，返回其对应的英文单词.
    public String search(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        Trie node = root;
        char[] letters = str.toCharArray();
        for (int i = 0, len = str.length(); i < len; i++) {
            int pos = letters[i] - 'a';
            if (node.next[pos] != null) {
                node = node.next[pos];
            } else {
                return "eh";
            }
        }
        return node.enWord;
    }


    public static void main(String[] args) {
        TrieMatchWord test = new TrieMatchWord();
        test.solve();
    }
}

