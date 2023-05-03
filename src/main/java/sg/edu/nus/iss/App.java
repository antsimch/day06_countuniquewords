package sg.edu.nus.iss;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
        String textFileName = args[0];
        // String stopWordsFileName = args[1];

        File txtFile = new File(textFileName);
        // File stopWordsFile = new File(stopWordsFileName);
        
        FileReader frText = new FileReader(txtFile);
        BufferedReader brText = new BufferedReader(frText);

        // FileReader frStopWords = new FileReader(stopWordsFile);
        // BufferedReader brStopWords = new BufferedReader(frStopWords);

        // String stopWord;
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
        
        // List<String> stopWordsList = new ArrayList<>();

        // while ((stopWord = brStopWords.readLine()) != null) {

        //     stopWordsList.add(stopWord);

        // }


        Map<String,Integer> dictionary = new HashMap<>();

        String line;
        int count = 0;

        while ((line = brText.readLine()) != null) {
            
            // remove punctuations
            line = line.trim().replaceAll("\\p{Punct}", "");

            // remove stopwords and add to dictionary if it is a unique word
            Scanner scan = new Scanner(line);

            while (scan.hasNext()) {

                String wordToCheck = scan.next();

                for (int i = 0; i < STOPWORDS.length; i++) {
                    if (wordToCheck.equalsIgnoreCase(STOPWORDS[i])) {
                        break;
                    }

                    if (!dictionary.containsKey(wordToCheck.toLowerCase())) {
                        dictionary.put(wordToCheck.toLowerCase(), 0);
                        dictionary.put(wordToCheck.toLowerCase(), dictionary.get(wordToCheck.toLowerCase() + 1));
                        System.out.println(wordToCheck);
                    } 
                }
            }

            scan.close();
        }
        System.out.printf("File has %d unique words\n", dictionary.size());
        System.out.printf("File has %d words\n", count);

        // brStopWords.close();
        // frStopWords.close();
        brText.close();
        frText.close();
    }
}
