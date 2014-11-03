package lib;

/**
 * Created by Andrew on 02/11/2014.
 */
import java.sql.*;
import java.util.Date;


public class Keyspaces {

    private static Connection connect = null;
    private static Statement statement = null;
    private static PreparedStatement preparedStatement = null;
    private static ResultSet resultSet = null;
    public static void SetUpKeySpaces(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            //Maybe remove Login and password
            connect = DriverManager.getConnection("silva.computing.dundee.ac.uk:3306"
            + "user=14ac3u32&password=cab123);'");
            statement = connect.createStatement();
            resultSet = statement.executeQuery("CREATE  TABLE IF NOT EXISTS `14ac3d32`.`country` (\n" +
                    "  `nameOfCountry` VARCHAR(20) NOT NULL ,\n" +
                    "  `population` INT NOT NULL ,\n" +
                    "  `import` INT NULL ,\n" +
                    "  `export` INT NULL ,\n" +
                    "  `consumptionPerCapita` INT NULL ,\n" +
                    "  `taxrate` INT NULL ,\n" +
                    "  `production` INT NULL ,\n" +
                    "  PRIMARY KEY (`nameOfCountry`) )");

            statement = connect.createStatement();
            resultSet = statement.executeQuery("CREATE  TABLE IF NOT EXISTS `14ac3d32`.`competition` (\n" +
                    "  `CompetitionID` INT NOT NULL ,\n" +
                    "  `name` VARCHAR(50) NOT NULL ,\n" +
                    "  `marketShare` INT NOT NULL ,\n" +
                    "  `profit` INT NULL ,\n" +
                    "  `address` VARCHAR(255) NULL ,\n" +
                    "  `nameOfCountry` VARCHAR(255) NULL ,\n" +
                    "  PRIMARY KEY (`CompetitionID`) ,\n" +
                    "  CONSTRAINT `fk1`\n" +
                    "    FOREIGN KEY (`nameOfCountry` )\n" +
                    "    REFERENCES `14ac3d32`.`country` (`nameOfCountry` )\n" +
                    "    ON DELETE NO ACTION\n" +
                    "    ON UPDATE NO ACTION)");

            statement = connect.createStatement();
            resultSet = statement.executeQuery("CREATE  TABLE IF NOT EXISTS `14ac3d32`.`city` (\n" +
                    "  `cityId` INT NOT NULL ,\n" +
                    "  `cityPopulation` INT NOT NULL ,\n" +
                    "  `cityName` VARCHAR(50) NOT NULL ,\n" +
                    "  `lowerClassRatio` INT NULL ,\n" +
                    "  `middleClassRatio` INT NULL ,\n" +
                    "  `upperClassRatio` INT NULL ,\n" +
                    "  `nameOfCountry` VARCHAR(255) NOT NULL ,\n" +
                    "  PRIMARY KEY (`cityId`) ,\n" +
                    "  CONSTRAINT `fk1`\n" +
                    "    FOREIGN KEY (`nameOfCountry` )\n" +
                    "    REFERENCES `14ac3d32`.`country` (`nameOfCountry` )\n" +
                    "    ON DELETE NO ACTION\n" +
                    "    ON UPDATE NO ACTION)\n");

            statement = connect.createStatement();
            resultSet = statement.executeQuery("CREATE  TABLE IF NOT EXISTS `14ac3d32`.`potentialBranch` (\n" +
                    "  `pBranchID` INT NOT NULL ,\n" +
                    "  `leaseCost` INT NOT NULL ,\n" +
                    "  `projectedProfit` INT NOT NULL ,\n" +
                    "  `projectedExpenditure` INT NOT NULL ,\n" +
                    "  `cityId` INT NOT NULL ,\n" +
                    "  PRIMARY KEY (`pBranchID`) ,\n" +
                    "  CONSTRAINT `fk1`\n" +
                    "    FOREIGN KEY (`cityId` )\n" +
                    "    REFERENCES `14ac3d32`.`city` (`cityId` )\n" +
                    "    ON DELETE NO ACTION\n" +
                    "    ON UPDATE NO ACTION)");

            statement = connect.createStatement();
            resultSet = statement.executeQuery("CREATE  TABLE IF NOT EXISTS `14ac3d32`.`order` (\n" +
                    "  `orderId` INT NOT NULL ,\n" +
                    "  `dateOfPurchase` DATETIME NOT NULL ,\n" +
                    "  `orderPrice` INT NOT NULL ,\n" +
                    "  `products` VARCHAR(255) NOT NULL ,\n" +
                    "  PRIMARY KEY (`orderId`) )\n");

            statement = connect.createStatement();
            resultSet = statement.executeQuery("CREATE  TABLE IF NOT EXISTS `14ac3d32`.`branch_tea` (\n" +
                    "  `branchId` INT NOT NULL ,\n" +
                    "  `teaId` INT NOT NULL ,\n" +
                    "  `stockLevel` INT NULL ,\n" +
                    "  PRIMARY KEY (`branchId`, `teaId`) )");

            statement = connect.createStatement();
            resultSet = statement.executeQuery("CREATE  TABLE IF NOT EXISTS `14ac3d32`.`branch` (\n" +
                    "  `branchId` INT NOT NULL ,\n" +
                    "  `size` INT NULL ,\n" +
                    "  `address` VARCHAR(50) NOT NULL ,\n" +
                    "  `expenditure` INT NULL ,\n" +
                    "  `advertismentCosts` INT NULL ,\n" +
                    "  `leaseCost` INT NOT NULL ,\n" +
                    "  `revenue` INT NULL ,\n" +
                    "  `cityId` INT NOT NULL ,\n" +
                    "  PRIMARY KEY (`branchId`) ,\n" +
                    "  CONSTRAINT `fk1`\n" +
                    "    FOREIGN KEY (`branchId` )\n" +
                    "    REFERENCES `14ac3d32`.`branch_tea` (`branchId` )\n" +
                    "    ON DELETE NO ACTION\n" +
                    "    ON UPDATE NO ACTION,\n" +
                    "  CONSTRAINT `fk2`\n" +
                    "    FOREIGN KEY (`cityId` )\n" +
                    "    REFERENCES `14ac3d32`.`city` (`cityId` )\n" +
                    "    ON DELETE NO ACTION\n" +
                    "    ON UPDATE NO ACTION)");

            statement = connect.createStatement();
            resultSet = statement.executeQuery("CREATE  TABLE IF NOT EXISTS `14ac3d32`.`food` (\n" +
                    "  `foodId` INT NOT NULL ,\n" +
                    "  `price` INT NULL ,\n" +
                    "  `name` VARCHAR(50) NULL ,\n" +
                    "  PRIMARY KEY (`foodId`) ,\n" +
                    "  CONSTRAINT `fk1`\n" +
                    "    FOREIGN KEY (`foodId` )\n" +
                    "    REFERENCES `14ac3d32`.`branch` (`branchId` )\n" +
                    "    ON DELETE NO ACTION\n" +
                    "    ON UPDATE NO ACTION)");

            statement = connect.createStatement();
            resultSet = statement.executeQuery("CREATE  TABLE IF NOT EXISTS `14ac3d32`.`supplier` (\n" +
                    "  `supplierId` INT NOT NULL ,\n" +
                    "  `name` VARCHAR(50) NOT NULL ,\n" +
                    "  `manufacturerName` VARCHAR(50) NOT NULL ,\n" +
                    "  `farmerName` VARCHAR(50) NULL ,\n" +
                    "  `teaQUality` INT NOT NULL ,\n" +
                    "  `cRating` INT NULL ,\n" +
                    "  `address` VARCHAR(50) NULL ,\n" +
                    "  `deliveryTimes` INT NOT NULL ,\n" +
                    "  PRIMARY KEY (`supplierId`) )\n");

            statement = connect.createStatement();
            resultSet = statement.executeQuery("CREATE  TABLE IF NOT EXISTS `14ac3d32`.`tea` (\n" +
                    "  `teaId` INT NOT NULL ,\n" +
                    "  `teaName` VARCHAR(50) NOT NULL ,\n" +
                    "  `buyPrice` INT NOT NULL ,\n" +
                    "  `salePrice` INT NOT NULL ,\n" +
                    "  `typeOfTea` VARCHAR(20) NOT NULL ,\n" +
                    "  PRIMARY KEY (`teaId`) ,\n" +
                    "  CONSTRAINT `fk1`\n" +
                    "    FOREIGN KEY (`teaId` )\n" +
                    "    REFERENCES `14ac3d32`.`branch_tea` (`teaId` )\n" +
                    "    ON DELETE NO ACTION\n" +
                    "    ON UPDATE NO ACTION)\n");

            statement = connect.createStatement();
            resultSet = statement.executeQuery("CREATE  TABLE IF NOT EXISTS `14ac3d32`.`certified` (\n" +
                    "  `teaId` INT NOT NULL ,\n" +
                    "  `uk` BINARY NULL ,\n" +
                    "  `usa` BINARY NULL ,\n" +
                    "  `finland` BINARY NULL ,\n" +
                    "  `russia` BINARY NULL ,\n" +
                    "  `germany` BINARY NULL ,\n" +
                    "  `netherlands` BINARY NULL ,\n" +
                    "  `china` BINARY NULL ,\n" +
                    "  PRIMARY KEY (`teaId`) ,\n" +
                    "  CONSTRAINT `fk1`\n" +
                    "    FOREIGN KEY (`teaId` )\n" +
                    "    REFERENCES `14ac3d32`.`tea` (`teaId` )\n" +
                    "    ON DELETE NO ACTION\n" +
                    "    ON UPDATE NO ACTION)");

            statement = connect.createStatement();
            resultSet = statement.executeQuery("CREATE  TABLE IF NOT EXISTS `14ac3d32`.`naturalDisasters` (\n" +
                    "  `nameOfCountry` VARCHAR(20) NOT NULL ,\n" +
                    "  `tornado` INT(11) NULL ,\n" +
                    "  `tsunami` INT NULL ,\n" +
                    "  `volcanoEruptions` INT NULL ,\n" +
                    "  `flood` INT NULL ,\n" +
                    "  PRIMARY KEY (`nameOfCountry`) ,\n" +
                    "  CONSTRAINT `fk1`\n" +
                    "    FOREIGN KEY (`nameOfCountry` )\n" +
                    "    REFERENCES `14ac3d32`.`country` (`nameOfCountry` )\n" +
                    "    ON DELETE NO ACTION\n" +
                    "    ON UPDATE NO ACTION)");

            statement = connect.createStatement();
            resultSet = statement.executeQuery("CREATE  TABLE IF NOT EXISTS `14ac3d32`.`geoPolitical` (\n" +
                    "  `nameOfCountry` VARCHAR(20) NOT NULL ,\n" +
                    "  `embargo` INT NULL ,\n" +
                    "  `sanctions` INT NULL ,\n" +
                    "  `visa` INT NULL ,\n" +
                    "  `riot` INT NULL ,\n" +
                    "  PRIMARY KEY (`nameOfCountry`) ,\n" +
                    "  CONSTRAINT `fk1`\n" +
                    "    FOREIGN KEY (`nameOfCountry` )\n" +
                    "    REFERENCES `14ac3d32`.`country` (`nameOfCountry` )\n" +
                    "    ON DELETE NO ACTION\n" +
                    "    ON UPDATE NO ACTION)");

            statement = connect.createStatement();
            resultSet = statement.executeQuery("CREATE  TABLE IF NOT EXISTS `14ac3d32`.`customer` (\n" +
                    "  `customerId` INT NOT NULL ,\n" +
                    "  ‘loyaltyCardId’ INT NULL,\n" +
                    "  `firstName` VARCHAR(20) NOT NULL ,\n" +
                    "  `lastName` VARCHAR(20) NOT NULL ,\n" +
                    "  `address` VARCHAR(50) NOT NULL ,\n" +
                    "  `martialStatus` VARCHAR(20) NULL ,\n" +
                    "  `profession` VARCHAR(50) NULL ,\n" +
                    "  `gender` CHAR(1) NULL ,\n" +
                    "  PRIMARY KEY (`customerId`) ,\n" +
                    "  CONSTRAINT `fk1`\n" +
                    "    FOREIGN KEY (`customerId` )\n" +
                    "    REFERENCES `14ac3d32`.`order` (`orderId` )\n" +
                    "    ON DELETE NO ACTION\n" +
                    "    ON UPDATE NO ACTION)\n");

            statement = connect.createStatement();
            resultSet = statement.executeQuery("CREATE  TABLE IF NOT EXISTS `14ac3d32`.`loyaltyCard` (\n" +
                    "  `loyaltyCardID` INT NOT NULL ,\n" +
                    "  `avgSalePrice` INT NULL ,\n" +
                    "  `favouriteTea` VARCHAR(20) NULL ,\n" +
                    "  `favouriteSnack` VARCHAR(20) NULL ,\n" +
                    "  `bonusPoints`  INT NULL ,\n" +
                    "  `favouriteBranch` VARCHAR(50) NULL ,\n" +
                    "  PRIMARY KEY (`loyaltyCardID`) ,\n" +
                    "  CONSTRAINT `fk1`\n" +
                    "    FOREIGN KEY (`loyaltyCardID` )\n" +
                    "    REFERENCES `14ac3d32`.`customer` (`loyaltyCardId` )\n" +
                    "    ON DELETE NO ACTION\n" +
                    "    ON UPDATE NO ACTION)");

            statement = connect.createStatement();
            resultSet = statement.executeQuery("CREATE  TABLE IF NOT EXISTS `14ac3d32`.`staffMember` (\n" +
                    "  `staffId` INT NOT NULL ,\n" +
                    "  `firstName` VARCHAR(20) NOT NULL ,\n" +
                    "  `lastName` VARCHAR(20) NOT NULL ,\n" +
                    "  `salary` INT NULL ,\n" +
                    "  `position` VARCHAR(50) NOT NULL ,\n" +
                    "  `training` VARCHAR(255) NULL ,\n" +
                    "  `address` VARCHAR(50) NULL ,\n" +
                    "  `branchId` INT NOT NULL ,\n" +
                    "  PRIMARY KEY (`staffId`) ,\n" +
                    "  CONSTRAINT `fk1`\n" +
                    "    FOREIGN KEY (`branchId` )\n" +
                    "    REFERENCES `14ac3d32`.`branch` (`branchId` )\n" +
                    "    ON DELETE NO ACTION\n" +
                    "    ON UPDATE NO ACTION)\n");




        }
        catch(Exception e)
        {

        }

    }
}
