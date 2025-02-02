package com.app;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@SpringBootApplication
public class MealPlannerApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
    	//Dotenv dotenv = Dotenv.configure().load();
    	//System.out.println("JDBC_DATABASE_URL: " + dotenv.get("JDBC_DATABASE_URL"));
    	//System.out.println("JDBC_DATABASE_USERNAME: " + dotenv.get("JDBC_DATABASE_USERNAME"));
    	//System.out.println("JDBC_DATABASE_PASSWORD: " + dotenv.get("JDBC_DATABASE_PASSWORD"));
    	//System.setProperty("JDBC_DATABASE_URL", dotenv.get("JDBC_DATABASE_URL"));
    	//System.setProperty("JDBC_DATABASE_USERNAME", dotenv.get("JDBC_DATABASE_USERNAME"));
    	//System.setProperty("JDBC_DATABASE_PASSWORD", dotenv.get("JDBC_DATABASE_PASSWORD"));
    	SpringApplication.run(MealPlannerApplication.class, args);
    	//String projectDir = System.getProperty("user.dir");
        //File rootDir = new File(projectDir);
        //printDirectoryStructure(rootDir, 0);
    	
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(MealPlannerApplication.class);
    }
    
    @Bean 
    public DataSource dataSource() { 
    	DriverManagerDataSource dataSource = new DriverManagerDataSource(); 
    	dataSource.setDriverClassName("org.postgresql.Driver");
    	dataSource.setUrl("jdbc:postgresql://cd27da2sn4hj7h.cluster-czrs8kj4isg7.us-east-1.rds.amazonaws.com:5432/dbvk1rks20dsvk"); 
    	dataSource.setUsername("u2liisg25bhq4d"); 
    	dataSource.setPassword("p9edddddd0a8e58a51f16ce1fdd799a426f22a212104d984fbb7a1601fa7288b0"); 
    	return dataSource; 
    }
    
    /*public static void printDirectoryStructure(File dir, int depth) {
        if (dir.isDirectory()) {
            for (File file : dir.listFiles()) {
                for (int i = 0; i < depth; i++) {
                    System.out.print("    ");
                }
                System.out.println(file.getName());
                if (file.isDirectory()) {
                    printDirectoryStructure(file, depth + 1);
                }
            }
        }
    }*/
  
}
