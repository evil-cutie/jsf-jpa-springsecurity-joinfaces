package com.pawfectbuddy.e2e;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import java.util.UUID;
import org.junit.jupiter.api.*;

public class RegistrationTest {
    private Playwright playwright;
    private Page page;

    @BeforeEach
    public void setUp() {
        playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        page = browser.newPage();
    }

    @Test
    public void newUserCanRegisterWithValidDetails() {
        String id = UUID.randomUUID().toString().substring(0, 8);
        page.navigate("http://localhost:8080/registration.xhtml");
        fillRegistrationForm("test_" + id + "@example.test", "user_" + id, "12345", "12345");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Sign up")).click();
        assertThat(page).hasURL("http://localhost:8080/redirect.xhtml");
    }

    @Test
    public void newUserCantRegisterWithMismatchedPasswords() {
        String id = UUID.randomUUID().toString().substring(0, 8);
        page.navigate("http://localhost:8080/registration.xhtml");
        fillRegistrationForm("test_" + id + "@example.test", "user_" + id, "125", "12345");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Sign up")).click();
        assertThat(page.getByRole(AriaRole.ALERT).getByText("Passwords don't match")).isVisible();
        assertThat(page).hasURL("http://localhost:8080/registration.xhtml");
    }

    private void fillRegistrationForm(String email, String username, String password, String repeatPassword) {
        page.getByLabel("Email", new Page.GetByLabelOptions().setExact(true)).fill(email);
        page.getByLabel("Username", new Page.GetByLabelOptions().setExact(true)).fill(username);
        page.getByLabel("Password", new Page.GetByLabelOptions().setExact(true)).fill(password);
        page.getByLabel("Repeat password", new Page.GetByLabelOptions().setExact(true)).fill(repeatPassword);
    }

    @AfterEach
    public void tearDown() {
        if (playwright != null) {
            playwright.close();
        }
    }
}
