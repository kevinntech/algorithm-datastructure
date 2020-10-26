package algorithm.basic_ps.string_array;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddress {
    public static void main(String[] args) {
//        String[] emails = {"test.email+alex@leetcode.com",
//                "test.e.mail+bob.cathy@leetcode.com",
//                "testemail+david@lee.tcode.com"};

        String[] emails = {"testemail@leetcode.com",
                "testemail1@leetcode.com",
                "testemail+david@lee.tcode.com"};

        System.out.println(numUniqueEmails(emails));

    }

    private static int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();

        for (String email : emails) {
            int index = email.indexOf('@');
            String localName = email.substring(0, index);
            String domainName = email.substring(index);

            if (localName.contains("+")) {
                localName = localName.substring(0, localName.indexOf('+'));
            }

            localName = localName.replace(".", "");

            set.add(localName + domainName);
        }

        return set.size();
    }
}
