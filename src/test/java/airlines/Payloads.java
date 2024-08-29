package airlines;

import com.github.javafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;
import pojos.Airline;

import java.util.HashMap;
import java.util.Map;

public class Payloads {
    static Faker faker = new Faker();

    public static String getCreateAirlinePayloadFromString(String id,String name, String country, String logo, String slogan
    ,String head_Quaters, String webSite, String established ){

        String payload = "{\n" +
                "    \"id\":"+id+",\n" +
                "    \"name\": "+name+",\n" +
                "    \"country\": "+country+",\n" +
                "    \"logo\": "+logo+",\n" +
                "    \"slogan\": "+slogan+",\n" +
                "    \"head_quaters\": "+head_Quaters+",\n" +
                "    \"website\": "+webSite+",\n" +
                "    \"established\": "+established+",\n" +
                "}";

        return payload;
    }

 public static Map<String,Object> getCreateAirlinePayloadFromMap(String id,String name, String country, String logo, String slogan
    ,String head_Quaters, String webSite, String established ){

        Map<String, Object> payload = new HashMap<>();
payload.put("id", id);
payload.put("name", id);
payload.put("country", country);
payload.put("logo", logo);
payload.put("slogan", slogan);
payload.put("head_quaters", head_Quaters);
payload.put("website", webSite);
payload.put("established", established);
        return payload;
    }
    public static Map<String,Object> getCreateAirlinePayloadFromMap(){
Faker faker = new Faker();

        Map<String, Object> payload = new HashMap<>();
payload.put("id", faker.number().digits(10));
payload.put("name", faker.name().username());
payload.put("country", faker.address().country());
payload.put("logo", RandomStringUtils.randomAlphabetic(25));
payload.put("slogan", RandomStringUtils.randomAlphabetic(20));
payload.put("head_quaters", faker.address().cityName());
payload.put("website", "https://"+ RandomStringUtils.randomAlphabetic(10)+".com");
payload.put("established", faker.number().numberBetween(2000,2024));
        return payload;
    }
    public static Airline getCreateAirlinePayloadFromPojos() {
        return Airline.builder()
                .id(Integer.parseInt(faker.number().digits(6)))
                .name(faker.name().username())
                .country(faker.address().country())
                .logo(RandomStringUtils.randomAlphabetic(25))
                .slogan(RandomStringUtils.randomAlphabetic(20))
                .head_Quaters(faker.address().cityName())
                .webSite("https://"+ RandomStringUtils.randomAlphabetic(10)+".com")
                .established(String.valueOf(faker.number().numberBetween(2000,2024)))
                .build();
    }


}
