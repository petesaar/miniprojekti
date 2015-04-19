import miniprojekti.*
import miniprojekti.IO.*
import miniprojekti.Kontrolleri.*
import miniprojekti.Viite.*
import miniprojekti.console.*

description 'User can add an inproceedings reference'

scenario "user can add an inproceedings reference with scandic letters", {
    given 'inproceedings author, title, year, volume and journal are inserted', {
       io = new StubIO("inproceedings", "ref", "Tommi", "Hölmö", "2011", "Otsikko", "", "", "", "", "", "quit")
       app = new Console(io, new Kontrolleri())
    }

    when 'inproceedings title has scandic letters', {
       app.run()
    }

    then 'reference is added', {
       io.getPrints().shouldHave("Viite lisattiin onnistuneesti")
    }
}

scenario "user cannot add an inproceedings reference without author name", {
    given 'inproceedings title, year and booktitle are inserted', {
       io = new StubIO("inproceedings", "ref", "", "Hölmö", "2011", "Otsikko", "", "", "", "", "", "quit")
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

scenario "user cannot add an inproceedings reference without title", {
    given 'inproceedings author, year and booktitle are inserted', {
       io = new StubIO("inproceedings", "ref", "Tommi", "", "2011", "Otsikko", "", "", "", "", "", "quit")
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
       io = new StubIO("inproceedings", "ref", "Tommi", "Hölmö", "201", "Otsikko1", "", "", "", "", "",
                       "inproceedings", "ref", "Tommi", "Hölmö", "2011", "Otsikko2", "", "", "", "", "",
                       "inproceedings", "ref", "Tommi", "Hölmö", "20111", "Otsikko3", "", "", "", "", "",
                       "list", "quit")
       app = new Console(io, new Kontrolleri())
    }

    when 'the other references have 3 and 5 numbers', {
       app.run()
    }

    then 'reference with 4 numbers in year is added and the other with 3 and 5 numbers will not be added', {
       io.getPrints().shouldHave("Otsikko2")
       io.getPrints().shouldNotHave("Otsikko1")
       io.getPrints().shouldNotHave("Otsikko3")
    }
}

scenario "user cannot add an inproceedings reference without booktitle", {
    given 'inproceedings author, title, year and journal are inserted', {
       io = new StubIO("inproceedings", "ref", "Tommi", "Hölmö", "2011", "", "", "", "", "", "", "quit")
       app = new Console(io, new Kontrolleri())
    }

    when 'booktitle field is left empty', {
       app.run()
    }

    then 'reference is not added', {
       io.getPrints().shouldHave("Kirjan nimi ei saa olla")
       io.getPrints().shouldNotHave("Viite lisattiin onnistuneesti")
    }
}