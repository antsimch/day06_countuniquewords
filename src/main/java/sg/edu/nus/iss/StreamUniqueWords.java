package sg.edu.nus.iss;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class StreamUniqueWords {
    public static void main(String[] args) {
        
        Reader r = new FileReader(args[0]);
        BufferedReader br = new BufferedReader(r);

        Map<String, Integer> dictionary = new HashMap<>();

        String[] STOPWORDS = {
            "a", "about", "above", "after", "again", "against", "all", "am", "an", "and", "any", "are", "aren't", "as", "at", "be",
            "because", "been", "before", "being", "below", "between", "both", "but", "by", "can't", "cannot", "could",
            "couldn't", "did", "didn't", "do", "does", "doesn't", "doing", "don't", "down", "during", "each", "few", "for", "from",
            "further", "had", "hadn't", "has", "hasn't", "have", "haven't", "having", "he", "he'd", "he'll",
            "he's", "her", "here", "here's", "hers", "herself", "him", "himself", "his", "how", "how's", "i", "i'd", "i'll",
            "i'm", "i've", "if", "in", "into", "is", "isn't", "it", "it's", "its", "itself", "let's", "me", "more",
            "most", "mustn't", "my", "myself", "no", "nor", "not", "of", "off", "on", "once", "only", "or", "other", "ought",
            "our", "ours", "ourselves", "out", "over", "own", "same", "shan't", "she", "she'd", "she'll", "she's", "should",
            "shouldn't", "so", "some", "such", "than", "that", "that's", "the", "their", "theirs", "them", "themselves", "then",
            "there", "there's", "these", "they", "they'd", "they'll", "they're", "they've", "this", "those", "through", "to",
            "too", "under", "until", "up", "very", "was", "wasn't", "we", "we'd", "we'll", "we're", "we've", "were",
            "weren't", "what", "what's", "when", "when's", "where", "where's", "which", "while", "who", "who's", "whom", "why",
            "why's", "with", "won't", "would", "wouldn't", "you", "you'd", "you'll", "you're", "you've", "your", "yours",
            "yourself", "yourselves"
        };


        br.lines()
            .map(line -> line.trim().toLowerCase().replaceAll("\\p{Punct}", ""))
            .map(line -> line.split("\\s+"))
            .flatMap(words -> Arrays.asList(words).stream())
            .filter(word -> (word.trim().length() > 0))
            .filter(word -> !STOPWORDS.contains(word))
            .forEach(word -> {
                int c = dictionary.computeIfAbsent(word, w -> 0);
                dictionary.put(word, c + 1);
            });
    }
}
