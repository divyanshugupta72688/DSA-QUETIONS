import java.util.*;

class Practise {

    // Reverse a String

    public void Reverse(char[] s) {
        int left = 0;
        int n = s.length;
        int right = n - 1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;

        }
    }

    // valid palindrome

    public boolean isvalid(char ch) {
        return (ch >= 'a' && ch <= 'z' ||
                ch >= 'A' && ch <= 'Z' ||
                ch >= '0' && ch <= '9');
    }

    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            while (left < right && !isvalid(s.charAt(left))) {
                left++;
            }
            while (left < right && !isvalid(s.charAt(right))) {
                right--;
            }
            if (s.charAt(left) != s.charAt(right)) {
                return false;

            }
            left++;
            right--;
        }
        return true;
    }

    // Rotate String

    public boolean Rotate(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        String str = s.concat(s);
        if (s.contains(goal)) {
            return true;
        }
        return false;
    }

    // REVERSE WORD IN A STRING

    public static String ReverseString(String s) {
        String[] words = s.trim().split("\\s+");
        StringBuilder ans = new StringBuilder();
        for (int i = words.length - 1; i <= 0; i++) {
            ans.append(words[i]);
            if (i != 0) {
                ans.append(" ");
            }
        }
        return ans.toString();
    }
    // LENGTH OF LAST WORD

    public int Length(String s) {
        String[] word = s.trim().split("\\s+");
        int n = word.length;
        return word[n - 1].length();
    }

    // Detect capital

    public boolean Detect(String s) {
        int Uppercase = 0;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isUpperCase(s.charAt(i))) {
                Uppercase++;
            }
        }
        return (Uppercase == s.length() ||
                Uppercase == 0 ||
                Uppercase == 1 && Character.isUpperCase(s.charAt(0)));

    }

    // MOST FREUQNET CHARCATER

    public static char Most(String s) {

        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int maxfreq = 0;
        char maxchar = 'z';
        for (char ch : map.keySet()) {
            if (maxfreq < map.get(ch)) {
                maxfreq = map.get(ch);
                maxchar = ch;
            } else if (maxfreq == map.get(ch) && maxchar > ch) {
                maxchar = ch;
            }
        }
        return maxchar;
    }

    // Valid Anagram

    public boolean Valid(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
            freq[t.charAt(i) - 'a']--;
        }

        for (int count : freq) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }

    // REMOVING ALL STARS FROM THE STRING

    public String Removing(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!stack.isEmpty() && ch == '*') {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        for (Character ch : stack) {
            sb.append(ch);
        }
        return sb.toString();
    }

    // REMOVING ALL OCCURANCE OF A STRING

    public String Remove(String sts , String word){
    
        while (sts.contains(word)) {
            int index = sts.indexOf(word);
           sts = sts.substring(0, index)+sts.substring(index+word.length());
        }
        return sts ;
    }
    
        // PERMURARAION HAI YA NAHI STRING ME 


        public boolean Permutaions(String s,String s2){
            char[] arr1 = s.toCharArray();
            Arrays.sort(arr1);
            for(int i = 0;i<s2.length()-s.length();i++){
                String sub = s.substring(i+s.length());
                char[]arr2 = sub.toCharArray();
                Arrays.sort(arr2);
                if (Arrays.equals(arr1, arr2)) {
                 return true;   
                }
            }
            return false;
        }


        // SUBSEQUENCES OF STRING


        public void getallindex(List<String>list,StringBuilder sb,String s,int index){
            if (index>s.length()) {
                list.add(sb.toString());
            }
            char ch = s.charAt(index);
            // include part

            sb.append(ch);
            getallindex(list, sb, s, index+1);

            // exclude part

            sb.deleteCharAt(sb.length()-1);
            getallindex(list, sb, s, index+1);
        }

        public List<String>PowerSet(String s){
            List<String>list = new ArrayList<>();
            StringBuilder sb = new StringBuilder();
            getallindex(list,sb,s,0);
            Collections.sort(list);
            return list;
        }

            

    }