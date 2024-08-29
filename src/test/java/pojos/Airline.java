package pojos;
import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Airline {
  static Faker faker = new Faker();

  private  int id = Integer.parseInt(faker.number().digits(6));
    private String name = faker.name().username();
    private String country = faker.address().country();
    private String logo = RandomStringUtils.randomAlphabetic(25);
    private String slogan = RandomStringUtils.randomAlphabetic(20);
    private String head_Quaters = faker.address().cityName();
    private String webSite = "https://"+ RandomStringUtils.randomAlphabetic(10)+".com";
    private String established = String.valueOf(faker.number().numberBetween(2000,2024));

}
