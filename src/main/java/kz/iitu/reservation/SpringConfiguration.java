//package kz.iitu.reservation;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//
//import javax.sql.DataSource;
//
//
//@Configuration
//@ComponentScan("kz.iitu.reservation")
//@PropertySource("application.properties")
//public class SpringConfiguration {
//
//    @Value("${spring.datasource.driver-class-name}")
//    private String DB_DRIVER;
//
//    @Value("${spring.datasource.password}")
//    private String DB_PASSWORD;
//
//    @Value("${spring.datasource.url}")
//    private String DB_URL;
//
//    @Value("${spring.datasource.username}")
//    private String DB_USERNAME;
//
//    @Bean
//    public DataSource dataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName(DB_DRIVER);
//        dataSource.setUrl(DB_URL);
//        dataSource.setUsername(DB_USERNAME);
//        dataSource.setPassword(DB_PASSWORD);
//
//        return dataSource;
//    }
//
//    @Bean
//    public JdbcTemplate jdbcTemplate() {
//        return new JdbcTemplate(dataSource());
//    }
//}