package com.pawfectbuddy.e2e;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class ListingTest {
    private Playwright playwright;
    private Page page;

    @BeforeEach
    public void setUp() {
        playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
        page = browser.newPage();
    }

    @Test
    public void createListingWithValidInput() {
        login("test_usr", "pass123");
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Create adoption")).click();
        assertThat(page).hasURL("http://localhost:8080/adoption.xhtml");
        page.getByLabel("Title", new Page.GetByLabelOptions().setExact(true)).fill("test_adoption");
        page.getByLabel("How can we contact you?", new Page.GetByLabelOptions().setExact(true)).fill("+123456789");
        page.locator("select[id$=':animalType_input']").selectOption("dog");
        page.locator("select[id$=':location_input']").selectOption("Tel Aviv");
        page.getByLabel("Description", new Page.GetByLabelOptions().setExact(true)).fill("test_adoption");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Submit")).click();
        assertThat(page).hasURL("http://localhost:8080/redirect.xhtml");
    }

    private void login(String username, String password) {
        page.navigate("http://localhost:8080/login.xhtml");
        page.getByLabel("Username", new Page.GetByLabelOptions().setExact(true)).fill(username);
        page.getByLabel("Password", new Page.GetByLabelOptions().setExact(true)).fill(password);
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();
    }
}
