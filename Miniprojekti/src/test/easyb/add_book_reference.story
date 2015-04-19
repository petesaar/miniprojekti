import miniprojekti.*
import miniprojekti.IO.*
import miniprojekti.Kontrolleri.*
import miniprojekti.Viite.*
import miniprojekti.console.*

description 'User can add a book reference'

scenario "user can add a book reference with scandic letters", {
    given 'book author, title, year and publisher are inserted', {
       io = new StubIO("book", "ref", "A. Kivi", "Seitsemän veljestä", "1870", "pub", "", "", "", "quit")
       app = new Console(io, new Kontrolleri())
    }

    when 'book title has scandic letters', {
       app.run()
    }

    then 'reference is added', {
       io.getPrints().shouldHave("Viite lisattiin onnistuneesti")
    }
}

scenario "user cannot add a book reference without author name", {
    given 'book title, year and publisher are inserted', {
       io = new StubIO("book", "ref", "", "Seitsemän veljestä", "1870", "pub", "", "", "", "quit")
       app = new Console(io, new Kontrolleri())
    }

    when 'author name field is left empty', {
       app.run()
    }

    then 'reference is not added', {
       io.getPrints().shouldHave("Tekij")
       io.getPrints().shouldNotHave("Viite lisattiin onnistuneesti")
    }
}

scenario "user cannot add a book reference without title", {
    given 'book author, year and publisher are inserted', {
       io = new StubIO("book", "ref", "A. Kivi", "", "1870", "pub", "", "", "", "quit")
       app = new Console(io, new Kontrolleri())
    }

    when 'title field is left empty', {
       app.run()
    }

    then 'reference is not added', {
        io.getPrints().shouldHave("Teoksen nimi ei saa olla")
        io.getPrints().shouldNotHave("Viite lisattiin onnistuneesti")
    }
}

scenario "year must have four numbers", {
    given 'three references with book author, title, year and publisher are inserted', {
       io = new StubIO("book", "ref", "A. Kivi", "Seitsemän lammasta", "187", "pub", "", "", "",
                       "book", "ref", "A. Kivi", "Seitsemän veljestä", "1870", "pub", "", "", "",
                       "book", "ref", "A. Kivi", "Seitsemän kanaa", "18700", "pub", "", "", "",
                       "list", "quit")
       app = new Console(io, new Kontrolleri())
    }

    when 'the other references have 3 and 5 numbers', {
       app.run()
    }

    then 'reference with 4 numbers in year is added and the other with 3 and 5 numbers will not be added', {
       io.getPrints().shouldHave("Seitsemän veljestä")
       io.getPrints().shouldNotHave("Seitsemän lammasta")
       io.getPrints().shouldNotHave("Seitsemän kanaa")
    }
}

scenario "user cannot add a book reference without publisher", {
    given 'book author, title and year are inserted', {
       io = new StubIO("book", "ref", "A. Kivi", "Seitsemän veljestä", "1870", "", "", "", "", "quit")
       app = new Console(io, new Kontrolleri())
    }

    when 'publisher field is left empty', {
       app.run()
    }

    then 'reference is not added', {
       io.getPrints().shouldHave("Julkaisija ei saa olla")
       io.getPrints().shouldNotHave("Viite lisattiin onnistuneesti")
    }
}