package com.blindcarboncopy.emotionalrobot.model.messagecomponent;

import com.blindcarboncopy.emotionalrobot.model.interfaces.NodeRedMessageComponent;

import java.util.ArrayList;

/**
 * A Model to represent the Sentiment Analysis message component
 */
public class NodeRedSentiment implements NodeRedMessageComponent {

    private int score;
    private int comparative;
    private ArrayList<String> tokens;
    private ArrayList<String> words;
    private ArrayList<String> positiveWords;
    private ArrayList<String> negativeWords;

    public NodeRedSentiment() {
        score = 0;
        comparative = 0;
        tokens = new ArrayList<>();
        words = new ArrayList<>();
        positiveWords = new ArrayList<>();
        negativeWords = new ArrayList<>();
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getComparative() {
        return comparative;
    }

    public void setComparative(int comparative) {
        this.comparative = comparative;
    }

    public ArrayList<String> getTokens() {
        return tokens;
    }

    public void setTokens(ArrayList<String> tokens) {
        this.tokens = tokens;
    }

    public ArrayList<String> getWords() {
        return words;
    }

    public void setWords(ArrayList<String> words) {
        this.words = words;
    }

    public ArrayList<String> getPositiveWords() {
        return positiveWords;
    }

    public void setPositiveWords(ArrayList<String> positiveWords) {
        this.positiveWords = positiveWords;
    }

    public ArrayList<String> getNegativeWords() {
        return negativeWords;
    }

    public void setNegativeWords(ArrayList<String> negativeWords) {
        this.negativeWords = negativeWords;
    }
}
