import miniprojekti.*
import miniprojekti.IO.*
import miniprojekti.Kontrolleri.*
import miniprojekti.Viite.*
import miniprojekti.console.*

description 'User can remove a reference from list of references by a bibtexkey'

scenario "bibtexkeys must be unique", {
    given 'two references with same bibtexkey', {
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
      io.getPrints().shouldNotHave("Nykänen taas jurrissa")
      io.getPrints().shouldHave("BibTexKey on jo")
    }
}

scenario "user can remove a reference from list of references by a bibtexkey", {
    given 'one reference with valid bibtexkey', {
       io = new StubIO("book", "indeksi", "A. Kivi", "Seitsemän veljestä", "1870", "pub", "", "", "",
                       "article", "ref2", "Joku media", "Seiska", "2011", "5", "Nykänen taas jurrissa", "", "", 
                       "delete ref2", "list", "quit")
       app = new Console(io, new Kontrolleri())
    }
 
    when 'a reference is added', {
      app.run()   
    }

    then 'prints added references to the command line', {
      io.getPrints().shouldHave("Seitsemän veljestä")
      io.getPrints().shouldNotHave("Nykänen taas jurrissa")
    }
}

