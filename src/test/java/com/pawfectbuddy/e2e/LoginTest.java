package com.pawfectbuddy.e2e;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LoginTest {
    private Playwright playwright;
    private Page page;

    @BeforeEach
    public void setUp() {
        playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(true));
        page = browser.newPage();
    }

    @Test
    public void loginWithValidCredentials() {
        page.navigate("http://localhost:8080/login.xhtml");
        fillLoginForm("test_usr", "pass123");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();
        assertThat(page).hasURL("http://localhost:8080/profile.xhtml");
    }

    @Test
    public void loginWithInvalidUsername() {
        page.navigate("http://localhost:8080/login.xhtml");
        fillLoginForm("no_such_user", "pass123");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();
        assertThat(page).hasURL("http://localhost:8080/login.xhtml?error=true");
        page.navigate("http://localhost:8080/profile.xhtml");
        assertThat(page).hasURL("http://localhost:8080/login.xhtml");
    }

    @Test
    public void loginWithInvalidPassword() {
        page.navigate("http://localhost:8080/login.xhtml");
        fillLoginForm("test_usr", "invalid_password");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();
        assertThat(page).hasURL("http://localhost:8080/login.xhtml?error=true");
        page.navigate("http://localhost:8080/profile.xhtml");
        assertThat(page).hasURL("http://localhost:8080/login.xhtml");
    }

    @Test
    public void loginWithEmptyCredentials() {
        page.navigate("http://localhost:8080/login.xhtml");
        fillLoginForm("", "");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();
        assertThat(page.getByText("Username is required")).isVisible();
        assertThat(page.getByText("Password is required")).isVisible();
        assertThat(page).hasURL("http://localhost:8080/login.xhtml");
        page.navigate("http://localhost:8080/profile.xhtml");
        assertThat(page).hasURL("http://localhost:8080/login.xhtml");
    }

    private void fillLoginForm(String username, String password) {
        page.getByLabel("Username", new Page.GetByLabelOptions().setExact(true)).fill(username);
        page.getByLabel("Password", new Page.GetByLabelOptions().setExact(true)).fill(password);
    }

    @AfterEach
    public void tearDown() {
        if (playwright != null) {
            playwright.close();
        }
    }
}
