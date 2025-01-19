package sample.adapter.primary.cmd;

import sample.application.domain.object.value.CalculationResult;
import sample.application.domain.port.primary.IService;
import sample.application.domain.port.secondary.RateRepositoryInterface;
import sample.application.service.UseCase01;
import sample.adapter.secondary.mock.MockRateRepo;

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

            RateRepositoryInterface repository;
            IService app;
            if (cmd.hasOption("r")) {
                String repositoryType = cmd.getOptionValue("r");
                switch (repositoryType) {
                    case "mock":
                        repository = new MockRateRepo();
                        break;
                    default:
                        repository = new MockRateRepo();
                        break;
                }
            } else {
                repository = new MockRateRepo();
            }

            if (cmd.hasOption("u")) {
                String useCaseType = cmd.getOptionValue("u");

                switch (useCaseType) {
                    case "case1":
                        app = new UseCase01(repository);
                        break;
                    default:
                        app = new UseCase01(repository);
                        break;
                }
            } else {
                app = new UseCase01(repository);
            }

            int input = Integer.parseInt(cmd.getOptionValue("i"));

            CalculationResult resultValue = app.calculation(input);
            System.out.println("result : " + resultValue.getRate());
        } catch (ParseException exp) {
            System.err.println("Parsing failed.  Reason: " + exp.getMessage());
        }
    }

}
