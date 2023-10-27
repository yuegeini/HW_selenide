import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.byText;

public class ServiceTest {
    @Test
    void shouldTest() throws InterruptedException {
        open("http://localhost:9999");
        $("[data-test-id=city] input").setValue("Казань");
        $("[data-test-id=name] input").setValue("Василий");
        $("[data-test-id=phone] input").setValue("+79270000000");
        $("[data-test-id=date] input").doubleClick().sendKeys("31.10.2023");//.setValue();
        $("[data-test-id=date] input").pressEscape();
        $("[data-test-id=agreement]").click();
        $(byText("Забронировать")).click();
//        $(".button__text:contains('Забронировать')").click();
//        Thread.sleep(10000);
//        Wait(15000).until(not(hidden), $("[data-test-id=notification]"));
        $("[data-test-id=notification]").shouldBe(not(hidden), Duration.ofSeconds(15));
    }

}
