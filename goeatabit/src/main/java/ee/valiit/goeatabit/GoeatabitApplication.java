package ee.valiit.goeatabit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import javax.sql.DataSource;

@SpringBootApplication
public class GoeatabitApplication {

	public static void main(String[] args) {
		SpringApplication.run(GoeatabitApplication.class, args);
	}


	@Bean
	@Profile("h2")
	public DataSourceInitializer dataSourceInitializer(final DataSource dataSource) {
		DataSourceInitializer initializer = new DataSourceInitializer();
		initializer.setDataSource(dataSource);

		ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
		populator.addScript(new ClassPathResource("DatabaseH2/1_reset.sql"));
		populator.addScript(new ClassPathResource("DatabaseH2/2_create.sql"));
		populator.addScript(new ClassPathResource("DatabaseH2/3_import_role.sql"));
		populator.addScript(new ClassPathResource("DatabaseH2/4_import_district.sql"));
		populator.addScript(new ClassPathResource("DatabaseH2/5_import_user.sql"));
		populator.addScript(new ClassPathResource("DatabaseH2/6_import_image.sql"));
		populator.addScript(new ClassPathResource("DatabaseH2/7_import_contact.sql"));
		populator.addScript(new ClassPathResource("DatabaseH2/8_import_location.sql"));
		populator.addScript(new ClassPathResource("DatabaseH2/9_import_food_group.sql"));
		populator.addScript(new ClassPathResource("DatabaseH2/10_import_offer.sql"));

		initializer.setDatabasePopulator(populator);
		return initializer;
	}
}
