public class Book {
    public String pigLatin(String word) {
        for (int i = 0; i < word.length(); i++) {
            if ("aeiou".indexOf(word.charAt(i)) != -1) {
                return i != 0 ? word.substring(i) + word.substring(0, i) + "ay" : word + "yay";
            }
        }
        return word + "ay";
    }
    public String translate(String sentence) {
        String[] words = sentence.split(" ");
        int[] capitals;
        int counter;
        char prefix;
        String suffix;
        String result = "";

        for (String word : words) {
            if (word.isBlank()) continue;
            if (Character.isDigit(word.charAt(0))) {
                result += word + " ";
                continue;
            }

            capitals = new int[word.length()];
            counter = 0;
            prefix = '\0';
            suffix = "";

            if (!Character.isLetterOrDigit(word.charAt(0))) {
                prefix = word.charAt(0);
                word = word.substring(1);
            }
            for (int i = 0; i < word.length(); i++) {
                if (Character.isUpperCase(word.charAt(i))) capitals[counter++] = i;
                if (!Character.isLetterOrDigit(word.charAt(i)) && word.charAt(i) != '-') {
                    suffix = word.substring(i);
                    word = word.substring(0, i);
                    break;
                }
            }
            if (counter == word.length() && word.length() != 1) {
                result += (prefix + pigLatin(word.toLowerCase()) + suffix).toUpperCase();
            } else {
                word = pigLatin(word.toLowerCase());
                for (int i = 0; i < counter; i++) {
                    word = word.substring(0, capitals[i]) + Character.toUpperCase(word.charAt(capitals[i])) + word.substring(capitals[i] + 1);
                }
                result += prefix + word + suffix;
            }
            result += " ";
        }
        return result;
    }
}
