import miniprojekti.*
import miniprojekti.IO.*
import miniprojekti.Kontrolleri.*
import miniprojekti.Viite.*
import miniprojekti.console.*

description 'User can add an article reference'

scenario "user can add an article reference with scandic letters", {
    given 'article author, title, year, volume and journal are inserted', {
       io = new StubIO("article", "ref", "Joku media", "Seiska", "2011", "5", "Nykänen taas jurrissa", "", "", "quit")
       app = new Console(io, new Kontrolleri())
    }

    when 'article journal has scandic letters', {
       app.run()
    }

    then 'reference is added', {
       io.getPrints().shouldHave("Viite lisattiin onnistuneesti")
    }
}

scenario "user cannot add an article reference without author name", {
    given 'article title, year, volume and journal are inserted', {
       io = new StubIO("article", "ref", "", "Seiska", "2011", "5", "Nykänen taas jurrissa", "", "", "quit")
       app = new Console(io, new Kontrolleri())
    }

    when 'author field is left empty', {
       app.run()
    }

    then 'reference is not added', {
       io.getPrints().shouldHave("Tekij")
       io.getPrints().shouldNotHave("Viite lisattiin onnistuneesti")
    }
}

scenario "user cannot add an article reference without title", {
    given 'article author, year, volume and journal are inserted', {
       io = new StubIO("article", "ref", "Joku media", "", "2011", "5", "Nykänen taas jurrissa", "", "", "quit")
       app = new Console(io, new Kontrolleri())
    }

    when 'title field is left empty', {
       app.run()
    }

    then 'reference is not added', {
       io.getPrints().shouldHave("Artikkelin nimi ei saa olla")
       io.getPrints().shouldNotHave("Viite lisattiin onnistuneesti")
    }
}

scenario "year must have four numbers", {
    given 'three references with article author, title, year, volume and journal are inserted', {
       io = new StubIO("article", "ref", "Joku media", "Seiska", "201", "5", "Nykänen taas pierussa", "", "",
                       "article", "ref", "Joku media", "Seiska", "2011", "5", "Nykänen taas jurrissa", "", "",
                       "article", "ref", "Joku media", "Seiska", "20111", "5", "Nykänen taas humalassa", "", "",
                       "list", "quit")
       app = new Console(io, new Kontrolleri())
    }

    when 'the other references have 3 and 5 numbers', {
       app.run()
    }

    then 'reference with 4 numbers in year is added and the other with 3 and 5 numbers will not be added', {
       io.getPrints().shouldHave("Nykänen taas jurrissa")
       io.getPrints().shouldNotHave("Nykänen taas pierussa")
       io.getPrints().shouldNotHave("Nykänen taas humalassa")
    }
}

scenario "user cannot add an article reference without volume", {
    given 'article author, title, year and journal are inserted', {
       io = new StubIO("article", "ref", "Joku media", "Seiska", "2011", "", "Nykänen taas jurrissa", "", "", "quit")
       app = new Console(io, new Kontrolleri())
    }

    when 'volume field is left empty', {
       app.run()
    }

    then 'reference is not added', {
       io.getPrints().shouldHave("Numero ei saa olla")
       io.getPrints().shouldNotHave("Viite lisattiin onnistuneesti")
    }
}

scenario "user cannot add an article reference without journal", {
    given 'article author, title, year and volume are inserted', {
       io = new StubIO("article", "ref", "Joku media", "Seiska", "2011", "5", "", "", "", "quit")
       app = new Console(io, new Kontrolleri())
    }

    when 'journal field is left empty', {
       app.run()
    }

    then 'reference is not added', {
       io.getPrints().shouldHave("Julkaisu ei saa olla")
       io.getPrints().shouldNotHave("Viite lisattiin onnistuneesti")
    }
}