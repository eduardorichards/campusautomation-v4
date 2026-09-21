# campusautomation-v4

Task: **BDD TA Frameworks.** Adopt the previous WebDriver project (Page Objects, DriverManager, logging/highlighting listeners) to run its tests with Cucumber-JVM.

System under test: [EPAM Campus](https://campus.epam.com)

## Run

```bash
# All scenarios, headed Chrome
mvn clean test -Denv=local

# Only smoke, or headless (ci) on Firefox
mvn clean test -Denv=local -Dcucumber.filter.tags="@smoke"
mvn clean test -Denv=ci -Dbrowser=firefox
```

Report: `target/cucumber-reports/report.html`. Requires Java 17, Maven 3.x and Chrome or Firefox.

The `Jenkinsfile` exposes the same options as build parameters (`BROWSER`, `ENV`, `CUCUMBER_TAGS`).

## Bonus

`NavbarNavigationSelenideTest` (Selenide proof of concept from the previous task) is unchanged and runs separately: `mvn clean test -Dsuite.xml.file=testng-selenide.xml`.

*By Eduardo Richards*
