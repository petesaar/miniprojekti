import miniprojekti.*
import miniprojekti.IO.*
import miniprojekti.Kontrolleri.*
import miniprojekti.Viite.*
import miniprojekti.console.*

description 'User can save and reload references'

scenario "user can save a reference and reload it later", {
    given 'a successfully created reference', {
       io = new StubIO("book", "bibtexkey", "A. Kivi", "Seitsemän veljestä", "1870", "pub", "", "", "", 
                       "json", "quit")
       app = new Console(io, new Kontrolleri())
    }

    when 'a reference has been saved to the disk', {
       app.run()
    }

    then 'reference should be reloaded from the disk', {
       new Kontrolleri().listaaViitteet().size().shouldBeGreaterThan 0
    }
}