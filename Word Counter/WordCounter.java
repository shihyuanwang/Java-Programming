// SHIH-YUAN WANG - Word Counter

import java.io.FileReader;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.LinkedHashMap;
import java.util.Collections;
import java.util.Map;
import java.util.Comparator;
import java.util.Iterator;

public class WordCounter {

    public Hashtable count_words(String contents) {

        Hashtable<String, Integer> ht_count = new Hashtable<String, Integer>();
        String word;
        //break a string into tokens
        StringTokenizer st = new StringTokenizer(contents, " \t\n\r\f,.:;?!'—\"");
        while (st.hasMoreTokens()) {
            //convert all characters to lowercase
            word = st.nextToken().toLowerCase();

            //get word count times and insert into or update hashtable
            if (ht_count.containsKey(word)) {
                //get the value of the corresponding key
                int count_times = (Integer) ht_count.get(word);
                ht_count.put(word, count_times + 1);
            } else {
                ht_count.put(word, 1);
            }
        }
        return ht_count;
    }


    public LinkedList top20(Hashtable ht_count) {
        // Return top 20 words,
        // Each element of the array can be a Hashtable with only one element sorted where the highest element is at the top
        // For example:  [{the=20}, {a=10}, {boy=10}, {news=5}.....]

        // 1. Convert Map to LinkedList of Map
        LinkedList<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(ht_count.entrySet());

        // 2. Sort list with Collections.sort() according to self-defined criteria(custom Comparator)
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> c1, Map.Entry<String, Integer> c2) {
                //sort in descending order of value(count times), then in ascending order of key(word)
                int cmp1 = c2.getValue().compareTo(c1.getValue());
                if (cmp1 != 0) {
                    //if they're not same values(count times), sort in descending order of value
                    return cmp1;
                } else {
                    //if they're same values(count times), sort in ascending order of key(word)
                    return (c1.getKey().compareTo(c2.getKey()));
                }
            }
        });

        // 3. Loop the sorted LinkedList and insert it into a new insertion order Map LinkedHashMap
        Map <String, Integer> sortedCount = new LinkedHashMap <String, Integer>();
        for (Map.Entry<String, Integer> entry : list) {
            sortedCount.put(entry.getKey(), entry.getValue());
        }

        // 4. Obtain an Iterator for the entries set(key-value pairs) contained in the LinkedHashMap
        Iterator <Map.Entry<String, Integer>> itr = sortedCount.entrySet().iterator();

        // 5. Get first 20 items, insert into a Hashtable with only one element sorted, and return a LinkedList of Hashtable
        LinkedList<Hashtable> countList = new LinkedList<Hashtable>();
        // Iterate first 20 items through LinkedHashMap entries
        int count = 0;
        while (count < 20) {
            //returns the next element
            Map.Entry<String, Integer> countPair = itr.next();
            Hashtable countTable = new Hashtable();
            //insert the key and value of the element into Hashtable
            countTable.put(countPair.getKey(), countPair.getValue());
            //appends this Hashtable to the end of the LinkedList
            countList.add(countTable);
            count++;
        }
        return countList;
    }


    public static void main(String args[]){
        try{
            //Read the file
            String contents = "";
            Scanner in = new Scanner(new FileReader("src/Fear.txt"));
            while(in.hasNextLine()) {
                contents += in.nextLine() + "\n";
            }
            WordCounter wc = new WordCounter();

            //count the times of each word
            Hashtable count = wc.count_words(contents);
            System.out.println(count);

            //get top20 words
            LinkedList top20 = wc.top20(count);
            System.out.println("Top 20 words: " + top20);
            int i = 1;
            for (Object item: top20) {
                System.out.println("Top " + i + " word: " + item);
                i++;
            }
        } catch (Exception e){
            System.err.println("Error " + e.getMessage());
        }
    }
}
