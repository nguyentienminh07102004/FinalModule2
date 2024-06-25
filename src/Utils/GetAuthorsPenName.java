package Utils;

public class GetAuthorsPenName {
    public static String getAuthorPenName(String name) {
        String[] names = name.split("\\s+");
        StringBuilder res = new StringBuilder();
        for(String s : names) {
            res.append(s.charAt(0));
        }
        return res.toString();
    }
}
