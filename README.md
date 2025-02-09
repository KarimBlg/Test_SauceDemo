# Test_SauceDemo

# Commande pour lancer les tests Selenium : 
mvn test -Dtest="ClassTag" -Dgroups="TestTag"

# Commande pour lancer les tests Cucumber :
mvn test -D cucumber.plugin="html:target/rapport.html" 
mvn test -D cucumber.filter.tags="@TestTag"

