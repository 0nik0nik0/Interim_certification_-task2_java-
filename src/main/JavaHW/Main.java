import controller.ControllerToy;
import model.FileOperationToy;
import model.MapperToy;
import model.RepositoryToy;
import view.ViewToy;

import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Main {
    public static Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws Exception {
        LogManager.getLogManager().readConfiguration(Main.class.getResourceAsStream("logs/logging.properties"));
        logger.info("Main run");
        FileOperationToy fileOperationToys = new FileOperationToy("src/main/JavaHW/data/Toys.txt", logger);
        FileOperationToy fileOperationPrizeToys = new FileOperationToy("src/main/JavaHW/data/PrizeToys.txt", logger);
        FileOperationToy fileOperationGivenOutPrizeToys = new FileOperationToy("src/main/JavaHW/data/GivenOutPrizeToys.txt", logger);
        RepositoryToy repositoryToys = new RepositoryToy(fileOperationToys, new MapperToy());
        RepositoryToy repositoryPrizeToys = new RepositoryToy(fileOperationPrizeToys, new MapperToy());
        RepositoryToy repositoryGivenOutPrizeToys = new RepositoryToy(fileOperationGivenOutPrizeToys, new MapperToy());
        ControllerToy controllerToys = new ControllerToy(repositoryToys, logger);
        ControllerToy controllerPrizeToys = new ControllerToy(repositoryPrizeToys, logger);
        ControllerToy controllerGivenOutPrizeToy = new ControllerToy(repositoryGivenOutPrizeToys, logger);
        ViewToy view = new ViewToy(controllerToys, controllerPrizeToys, controllerGivenOutPrizeToy, logger);
        view.run();
    }
}
