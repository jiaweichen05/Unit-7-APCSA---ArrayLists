import java.util.ArrayList;

public class WordScramble
{
    /** Scrambles a given word.
     *
     *  @param word  the word to be scrambled
     *  @return  the scrambled word (possibly equal to word)
     *
     *  Precondition: word is either an empty string or contains only uppercase letters.
     *  Postcondition: the string returned was created from word as follows:
     *  - the word was scrambled, beginning at the first letter and continuing from left to right
     *  - two consecutive letters consisting of "A" followed by a letter that was not "A" were swapped
     *  - letters were swapped at most once
     */
    public static String scrambleWord(String word)
    {
        ArrayList<String> letters = new ArrayList<String>();
        String temp = "";
        for (int i = 0; i < word.length(); i++)
        {
            letters.add(word.substring(i, i + 1));
        }

        for (int i = 0; i < letters.size() - 1; i++)
        {
            if (letters.get(i).equals("A") && !(letters.get(i + 1).equals("A"))){
                letters.set(i, letters.get(i + 1));
                letters.set(i + 1, "A");
                i++;
            }
        }

        for (String i : letters)
        {
            temp += i;
        }
        return temp;
    }

    /** Modifies wordList by replacing each word with its scrambled
     *  version, removing any words that are unchanged as a result of scrambling.
     *
     *  @param wordList the list of words
     *
     *  Precondition: wordList contains only non-null objects
     *  Postcondition:
     *  - all words unchanged by scrambling have been removed from wordList
     *  - each of the remaining words has been replaced by its scrambled version
     *  - the relative ordering of the entries in wordList is the same as it was
     *    before the method was called
     */
    public static void scrambleOrRemove(ArrayList<String> wordList)
    {
        for (int i = wordList.size() -1; i >= 0; i--)
        {
            String temp = scrambleWord(wordList.get(i));
            if (temp.equals(wordList.get(i)))
            {
                wordList.remove(i);
            }else{
                wordList.set(i, temp);
            }
        }

    }
}
