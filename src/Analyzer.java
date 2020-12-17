import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class Analyzer {

    public static void doAnalysis(String input) {
        System.out.println("Input string: " + input);
        String regex = "SELECT|FROM|WHERE|GROUP|BY|ORDER|OR|AND|NOT|EXISTS|HAVING|JOIN|LEFT|RIGHT|INNER|BeginRA|EndRA|[A-Za-z][A-Za-z0-9]*|[0-9]+|'[^']*'|[+\\-/.=]";
        try {
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(input);
            while (matcher.find()) {
                System.out.println(Analyzer.getToken(matcher.group()) + "\t [" + matcher.group() + "]\t starting at " + matcher.start() + " and ending at " + (matcher.end() - 1));
            }
        } catch (PatternSyntaxException pse) {
            System.err.println("Incorrect regex expression: " + pse.getMessage());
            System.err.println("Description: " + pse.getDescription());
            System.err.println("Position: " + pse.getIndex());
            System.err.println("Incorrect template: " + pse.getPattern());
        }
        System.out.println();
    }

    public static String getToken(String value) {
        Pattern pattern;
        Matcher matcher;
        String regexKeyword = "CREATE|VARCHAR|SELECT|FROM|WHERE|GROUP|BY|ORDER|OR|AND|NOT|EXISTS|DROP|DIVIDE|HAVING|JOIN|LEFT|RIGHT|INNER|BeginRA|EndRA|TABLE|INSERT|INTO|VALUES|ALTER|ADD|UNION";
        pattern = Pattern.compile(regexKeyword);
        matcher = pattern.matcher(value);
        if (matcher.find()) {
            return "Keyword";
        }
        String regexId = "student|sessiya|stependiya|id|first_name|second_name|grp|test|ekz1|ekz2|ekz3|result";
        pattern = Pattern.compile(regexId);
        matcher = pattern.matcher(value);
        if (matcher.find()) {
            return "Ident";
        }
        String regexNum = "[0-9]+";
        pattern = Pattern.compile(regexNum);
        matcher = pattern.matcher(value);
        if (matcher.find()) {
            return "Number";
        }
        String regexType = "INTEGER|NUMERIC|VARCHAR";
        pattern = Pattern.compile(regexType);
        matcher = pattern.matcher(value);
        if (matcher.find()) {
            return "Type";
        }
        String regexOperator = "[-+*/=]";
        pattern = Pattern.compile(regexOperator);
        matcher = pattern.matcher(value);
        if (matcher.find()) {
            return "Oper";
        }
        return "Value";
    }

    public static String syntaxAnalysis(String command) {
        System.out.println("Input string: " + command);
        int i = 1;
        while (true) {
            String tmp = command;
            System.out.println("("+i+")"+command);
            i++;
            command = command.replace("<fb>,<fn>", "<fn>");
            if (!command.equals(tmp)) {
                continue;
            }
            command = command.replace("<fb>,<fn>", "<fn>");
            if (!command.equals(tmp)) {
                continue;
            }
            command = command.replace("<t>,<tpn>", "<tpn>");
            if (!command.equals(tmp)) {
                continue;
            }
            command = command.replace("<vb>,<values>", "<values>");
            if (!command.equals(tmp)) {
                continue;
            }
            command = command.replace("<fb>", "<fb>,<fn>");
            if (!command.equals(tmp)) {
                continue;
            }
            command = command.replace("<vb>", "<vb>,<values>");
            if (!command.equals(tmp)) {
                continue;
            }
            command = command.replace("<t>", "<t>,<tpn>");
            if (!command.equals(tmp)) {
                continue;
            }
            break;
        }
        while (true){
            String tmp = command;
            i++;
            command = command.replace("<fn>", "id");
            if (!command.equals(tmp)) {
                System.out.println("("+i+")"+command);
                continue;
            }
            command = command.replace("<tn>", "id");
            if (!command.equals(tmp)) {
                System.out.println("("+i+")"+command);
                continue;
            }
            command = command.replace("<values>", "num");
            if (!command.equals(tmp)) {
                System.out.println("("+i+")"+command);
                continue;
            }
            command = command.replace("<cn>", "id");
            if (!command.equals(tmp)) {
                System.out.println("("+i+")"+command);
                continue;
            }
            command = command.replace("<tpn>", "NUMERIC");
            if (!command.equals(tmp)) {
                System.out.println("("+i+")"+command);
                continue;
            }
            break;
        }
        System.out.println();
        return command;
    }
}
