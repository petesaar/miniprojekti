import miniprojekti.*
import miniprojekti.IO.*
import miniprojekti.Kontrolleri.*
import miniprojekti.Viite.*
import miniprojekti.console.*

description 'User get a listing of references'

scenario "user can get a list of references", {
    given 'some successfully created references', {
       io = new StubIO("book", "ref", "A. Kivi", "Seitsemän veljestä", "1870", "pub", "", "", "",
                       "article", "ref", "Joku media", "Seiska", "2011", "5", "Nykänen taas jurrissa", "", "", 
                       "list", "quit")
       app = new Console(io, new Kontrolleri())
    }
 
    when 'a reference is added', {
      app.run()
    }

    then 'prints added references to the command line', {
      io.getPrints().shouldHave("Seitsemän veljestä")
      io.getPrints().shouldHave("Nykänen taas jurrissa")
      io.getPrints().shouldNotHave("Viitteen lisays epäonnistui")
    }
}

