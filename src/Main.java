public class Main {
    public static void main(String[] args) {
        Analyzer.doAnalysis(Analyzer.syntaxAnalysis("SELECT <fb>,<fb> FROM LEFT JOIN <tn> ON <fn>=<fn> ORDER BY <fn>"));
        Analyzer.doAnalysis(Analyzer.syntaxAnalysis("ALTER TABLE <tn> DROP <cn> <t>"));
        Analyzer.doAnalysis(Analyzer.syntaxAnalysis("INSERT INTO <tn> <fb> VALUES <vb>"));
        Analyzer.doAnalysis(Analyzer.syntaxAnalysis("SELECT <fb> FROM <tn> DIVIDE BY SELECT <fb> FROM <tn>"));
    }

}
