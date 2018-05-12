package fresher.dxc.minifilesharing;


import fresher.dxc.minifilesharing.storage.StorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
@EnableConfigurationProperties(StorageProperties.class)

public class MiniFileSharingApplication {
	public static void main(String[] args) {
		SpringApplication.run(MiniFileSharingApplication.class, args);
	}
}
