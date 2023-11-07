import javax.swing.plaf.nimbus.State;
import java.sql.*;

public class Main {

    public static void main(String[] args) {

       //************ First way ***************
        String jdbcURL = "jdbc:oracle:thin:@localhost:1521/xe";
        String username = "distraction";
        String password = "123abc";

        try(Connection connection = DriverManager.getConnection(jdbcURL, username, password)){
            if(connection!=null){
                System.out.println("Connected First Successfully.");
            }

            /*
            // *************** CREATE TABLE *********************
            //Create table query
            String createTableQuery = """
                         create table users(
                         id  number(3) primary key,
                         name varchar2(20),
                         email varchar2(20))""";

            Statement createTableStatement = connection.createStatement();

            if(createTableStatement.execute(createTableQuery)){
                System.out.println("Table Crated Successully.");
            }else{
                System.out.println("Table Creation Failed.");
            }
            */

            /*
            //************* INSERT *****************
            String insertQuery = """
                     INSERT ALL
                      INTO users(id, name, email) VALUES(2, 'Shyam', 'shyam@gmail.com')
                      INTO users(id, name, email) VALUES(3, 'Geeta', 'geeta@gmail.com')
                     SELECT * from dual
                    """;

            Statement statement = connection.createStatement();

            if(statement.execute(insertQuery)){
                System.out.println("INserted Successfully.");
            }else{
                System.out.println("Insertion Failed.");
            }
            */

            /*
            //*********** SELECT ********
            String selectQuery = """
                    SELECT * from users
                    """;

            Statement statement = connection.createStatement();

            ResultSet result = statement.executeQuery(selectQuery);

            System.out.println("REsults: ");
            while(result.next()){
                System.out.println("Id: " + result.getInt("id") + ", Name: " + result.getString("name") + ", Email: " +
                        result.getString("email"));
            }
            */

            /*
            // **************** BATCH *************
            Statement statement = connection.createStatement();

            connection.setAutoCommit(false);

            statement.addBatch("INSERT INTO users(id, name, email) VALUES(4, 'Sabina', 'Sabina@gmail.com')");
            statement.addBatch("INSERT INTO users(id, name, email) VALUES(5, 'Nabina', 'nabina@gmail.com')");

            int[] updateCount = statement.executeBatch();

            connection.commit();

            System.out.println(updateCount);

            */

            /*
            //************** PREPARED STATEMENTS *******************
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users(id, name, email)" +
                    "VALUES(?, ?, ?)");
            preparedStatement.setInt(1,6);
            preparedStatement.setString(2, "Anil");
            preparedStatement.setString(3,"anil@gmail.com" );

            System.out.println("Prepared Staement: " + preparedStatement);

            preparedStatement.execute();


             */

        }catch(SQLException ex){
            System.out.println("Error Occurred.");
            ex.printStackTrace();
        }
    }
}