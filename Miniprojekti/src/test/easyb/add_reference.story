import miniprojekti.*

description 'User can add a reference'

scenario "user can add a reference with scandic letters", {
    given 'book author, title and year are inserted', {
       io = new StubIO("", "Seitsemän veljestä", 1870, "Seitsemän veljestä") 
       String author, String title, String year, String booktitle)
       app = new App()
    }

    when 'book title has scandic letter', {
       app.app()
    }

    then 'reference is added', {
       io.getPrints().shouldHave("Seitsemän veljestä")
    }
}

scenario "user cannot add a reference without author name", {
    given 'Book author, title and year are inserted', {
       io = new StubIO("", "Seitsemän veljestä", 1870) 
       app = new App()
    }

    when 'author name field is left empty', {
       app.app()
    }

    then 'reference is not added', {
       io.getPrints().shouldHave("")
    }
}

scenario "user cannot add a reference without title", {
    given 'Book author, title and year are inserted', {
       io = new StubIO("Aleksis Kivi", "", 1870)
       app = new App()
    }

    when 'title field is left empty', {
       app.app()
    }

    then 'reference is not added', {
       io.getPrints().shouldHave("")
    }
}

scenario "year must have four numbers", {
    given 'two references wirh book author, title and year are inserted', {
       io = new StubIO("Aleksis Kivi", "Seitsemän veljestä", 1870)
       io2 = new StubIO("Aleksis Kivi", "Seitsemän veljestä", 11870) 
       app = new App()
    }

    when 'the other reference has year with 5 numbers', {
       app.app()
    }

    then 'reference with 4 numbers in year is added and the other with 5 numbers will not be added', {
       io.getPrints().shouldHave("Seitsemän veljestä")
       io2.getPrints().shouldHave("")
    }
}

scenario "tag field can be empty", {
    given 'Book author, title and year are inserted', {
       io = new StubIO("Aleksis Kivi", "Seitsemän veljestä", 1870)
       app = new App()
    }

    when 'tag field is empty', {
       app.app()
    }

    then 'reference with 4 numbers in year is added and the other with 5 numbers will not be added', {
       io.getPrints().shouldHave("Seitsemän veljestä")
    }
}
