import miniprojekti.*
import miniprojekti.IO.*
import miniprojekti.Kontrolleri.*
import miniprojekti.Viite.*
import miniprojekti.console.*

description 'User get a listing of references'

scenario "user can get a list of references", {
    given 'at least one reference with author, title, year and publisher', {
       io = new StubIO("newbook", "ref", "A. Kivi", "Seitsemän veljestä", "1870", "pub", "", "", "", "", "", "",
                       "listbooks")
       app = new Console(io, new Kontrolleri())
    }
 
    when 'a reference is added', {
      app.run()
    }

    then 'prints added references to the command line', {
      io.getPrints().shouldHave("Seitsemän veljestä")
      io.getPrints().shouldNotHave("Viitteen lisäys epäonnistui.")
    }
}

