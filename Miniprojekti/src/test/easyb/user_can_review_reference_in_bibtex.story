import miniprojekti.*
import miniprojekti.IO.*
import miniprojekti.Kontrolleri.*
import miniprojekti.Viite.*
import miniprojekti.console.*

description 'User can review a reference in bibtex format'

scenario "user can review a reference in bibtex format", {
    given 'a successfully created reference', {
       io = new StubIO("book", "ref", "A. Kivi", "Seitsemän veljestä", "1870", "pub", "", "", "", "bibtex", "quit")
       app = new Console(io, new Kontrolleri())
    }

    when 'a book reference has been made', {
       app.run()
    }

    then 'a reference is printed in bibtex format', {
       io.getPrints().shouldHave("@book{ref,")
       io.getPrints().shouldHave("author = {A. Kivi},")
       io.getPrints().shouldHave("title = {Seitsem\"{a}n veljest\"{a}},")
       io.getPrints().shouldHave("year = {1870},")
       io.getPrints().shouldHave("publisher = {pub},")
       io.getPrints().shouldHave("}")
    }
}