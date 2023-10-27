import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.byText;

public class ServiceTest {
    @BeforeEach
    public  void be(){
        open("http://localhost:9999");
    }
    @Test
    void shouldTest() {
        $("[data-test-id=city] input").setValue("Казань");
        $("[data-test-id=name] input").setValue("Василий");
        $("[data-test-id=phone] input").setValue("+79270000000");
        $("[data-test-id=date] input").click();
//        $(".popup .calendar__day.popup_visible").shouldBe(visible).click();
                //.shouldBe(Condition.attribute("cursor",
               // "pointer"))

        $("[data-test-id=date] input").doubleClick().sendKeys("31.10.2023");//.setValue();
        $("[data-test-id=date] input").pressEscape();
        $("[data-test-id=agreement]").click();
        $(byText("Забронировать")).click();
        $("[data-test-id=notification]").shouldBe(not(hidden), Duration.ofSeconds(15));
    }

    @Test
    void shouldTFailCity() {
        $("[data-test-id=city] input").setValue("Казан");
        $("[data-test-id=name] input").setValue("Василий");
        $("[data-test-id=phone] input").setValue("+79270000000");
        $("[data-test-id=date] input").click();
//        $(".popup .calendar__day.popup_visible").shouldBe(visible).click();
        //.shouldBe(Condition.attribute("cursor",
        // "pointer"))

        $("[data-test-id=date] input").doubleClick().sendKeys("31.10.2023");//.setValue();
        $("[data-test-id=date] input").pressEscape();
        $("[data-test-id=agreement]").click();
        $(byText("Забронировать")).click();
        $("[data-test-id=city] .input__sub").shouldHave(exactText("Доставка в выбранный город недоступна"));
//        $("[data-test-id=notification]").shouldBe(not(hidden), Duration.ofSeconds(15));
    }
    @Test
    void shouldFailName() {
        $("[data-test-id=city] input").setValue("Казань");
        $("[data-test-id=name] input").setValue("Василий1");
        $("[data-test-id=phone] input").setValue("+79270000000");
        $("[data-test-id=date] input").click();
//        $(".popup .calendar__day.popup_visible").shouldBe(visible).click();
        //.shouldBe(Condition.attribute("cursor",
        // "pointer"))

        $("[data-test-id=date] input").doubleClick().sendKeys("31.10.2023");//.setValue();
        $("[data-test-id=date] input").pressEscape();
        $("[data-test-id=agreement]").click();
        $(byText("Забронировать")).click();
        $("[data-test-id=name] .input__sub").shouldHave(exactText("Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы."));
//        $("[data-test-id=notification]").shouldBe(not(hidden), Duration.ofSeconds(15));
    }

    @Test
    void shouldFailPhone() {
        $("[data-test-id=city] input").setValue("Казань");
        $("[data-test-id=name] input").setValue("Василий");
        $("[data-test-id=phone] input").setValue("+792700000100");
        $("[data-test-id=date] input").click();
//        $(".popup .calendar__day.popup_visible").shouldBe(visible).click();
        //.shouldBe(Condition.attribute("cursor",
        // "pointer"))

        $("[data-test-id=date] input").doubleClick().sendKeys("31.10.2023");//.setValue();
        $("[data-test-id=date] input").pressEscape();
        $("[data-test-id=agreement]").click();
        $(byText("Забронировать")).click();
        $("[data-test-id=phone] .input__sub").shouldHave(exactText("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678."));
//        $("[data-test-id=notification]").shouldBe(not(hidden), Duration.ofSeconds(15));
    }

    @Test
    void shouldFailAgreement() {
        $("[data-test-id=city] input").setValue("Казань");
        $("[data-test-id=name] input").setValue("Василий");
        $("[data-test-id=phone] input").setValue("+79270000000");
        $("[data-test-id=date] input").click();
//        $(".popup .calendar__day.popup_visible").shouldBe(visible).click();
        //.shouldBe(Condition.attribute("cursor",
        // "pointer"))

        $("[data-test-id=date] input").doubleClick().sendKeys("31.10.2023");//.setValue();
        $("[data-test-id=date] input").pressEscape();
//        $("[data-test-id=agreement]").click();
        $(byText("Забронировать")).click();
        $("[data-test-id=agreement].invalid_input").shouldBe();
//        $("[data-test-id=notification]").shouldBe(not(hidden), Duration.ofSeconds(15));
    }

    @Test
    void shouldFailDate() {
        $("[data-test-id=city] input").setValue("Казань");
        $("[data-test-id=name] input").setValue("Василий");
        $("[data-test-id=phone] input").setValue("+79270000000");
        $("[data-test-id=date] input").click();
//        $(".popup .calendar__day.popup_visible").shouldBe(visible).click();
        //.shouldBe(Condition.attribute("cursor",
        // "pointer"))

        $("[data-test-id=date] input").doubleClick().sendKeys("20.10.2023");//.setValue();
        $("[data-test-id=date] input").pressEscape();
        $("[data-test-id=agreement]").click();
        $(byText("Забронировать")).click();
        $("[data-test-id=date] .input__sub").shouldHave(exactText("Заказ на выбранную дату невозможен"));
//        $("[data-test-id=notification]").shouldBe(not(hidden), Duration.ofSeconds(15));
    }
}
