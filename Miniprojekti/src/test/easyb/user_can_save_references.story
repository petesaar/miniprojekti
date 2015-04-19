import miniprojekti.*
import miniprojekti.IO.*
import miniprojekti.Kontrolleri.*
import miniprojekti.Viite.*
import miniprojekti.console.*

description 'User can save a reference'

scenario "user can save a reference", {
    given 'a successfully created reference', {
       io = new StubIO("book", "ref", "A. Kivi", "Seitsemän veljestä", "1870", "pub", "", "", "", 
                       "save", "quit")
       app = new Console(io, new Kontrolleri())
    }

    when 'a reference has been made', {
       app.run()
    }

    then 'reference is saved to the disk', {
       io.getPrints().shouldHave("Viitteiden tallennus onnistui")
    }
}