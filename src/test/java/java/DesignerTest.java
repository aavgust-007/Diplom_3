package java;

import locator.MainPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DesignerTest extends org.my.second.BaseUITest {

    @ValueSource(strings = {"Соусы", "Булки", "Начинки"})

    @ParameterizedTest
    @DisplayName("Проверка перехода по элементу Булки")
    public void goToRollsInputTest(String elementDeigner) {
        String actual = new MainPage(driver).open().
                enterRollsInput(elementDeigner);

        assertEquals("tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect", actual, "the exit button does not work");

    }
}

