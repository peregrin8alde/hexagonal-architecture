package sample.adapter.primary.cmd;

import sample.application.domain.*;
import sample.application.*;
import sample.adapter.mock.*;

import org.apache.commons.cli.*;

public class UserCmd {

    public static void main(String[] args) {
        // https://commons.apache.org/proper/commons-cli/
        Options options = new Options();
        options.addOption(Option.builder("i")
            .argName("input")
            .required()
            .hasArg()
            .desc("入力データ")
            .build());
        
        options.addOption("u", true, "usecase");
        options.addOption("r", true, "repository");

        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp("UserCmd", options);

        CommandLineParser parser = new DefaultParser();
        try {
            CommandLine cmd = parser.parse(options, args);

            IRateRepository repository;
            IService app;
            if (cmd.hasOption("r")) {
                String repositoryType = cmd.getOptionValue("r");
                repository = new MockDB();
            } else {
                repository = new MockDB();
            }

            if (cmd.hasOption("u")) {
                String useCaseType = cmd.getOptionValue("u");
                app = new UseCase01(repository);
            } else {
                app = new UseCase01(repository);
            }

            int input = Integer.parseInt(cmd.getOptionValue("i"));
            
            ResultValue resultValue = app.calculation(input);
            System.out.println("result : " + resultValue.getData());
        }
        catch (ParseException exp) {
            System.err.println("Parsing failed.  Reason: " + exp.getMessage());
        }
    }

}
